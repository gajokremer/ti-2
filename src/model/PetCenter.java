package model;

public class PetCenter{

	//attributes
	public static final int MAX_PETS = 120;
	public static final int MAX_VETS = 7;
	private int totalPets;
	private int totalVets;
	private int totalOwners;
	private int totalAttended;

	//relations
	private Pet [] pets;
	private Veterinarian [] veterinarians;
	private Owner [] owners;

	//constructor
	public PetCenter() {

		pets = new Pet[MAX_PETS];
		veterinarians = new Veterinarian[MAX_VETS];
		owners = new Owner[MAX_PETS];
		totalPets = 0;
		totalVets = 0;
	}

	//getters and setters
	public int getTotalPets() {
		return totalPets;
	}
	public void setTotalPets(int totalPets) {
		this.totalPets = totalPets;
	}

	public int getTotalVets() {
		return totalVets;
	}
	public void setTotalVets(int totalVets) {
		this.totalVets = totalVets;
	}
	
	public int getTotalOwners() {
		return totalOwners;
	}
	public void setTotalOwners(int totalOwners) {
		this.totalOwners = totalOwners;
	}
	
	public int getTotalAttended() {
		return totalAttended;
	}
	public void setTotalAttended(int totalAttended) {
		this.totalAttended = totalAttended;
	}


	//methods
	public void addVeterinarian(String idNumber, String fullName, String registerNumber, int attendedPets, String attendingNow) {

		Pet attends = null;

		if(totalVets < MAX_VETS) {

			boolean empty = false;
			int i;

			for(i = 0; i < MAX_VETS && !empty; i++) {

				if(veterinarians[i] == null) {

					veterinarians[i] = new Veterinarian(idNumber, fullName, registerNumber, attendedPets, attendingNow, attends);
					totalVets++;
					empty = true;
				}
			}

		}else{

			System.out.println("Veterinarian spaces are full\n" + 
				"Delete one to proceed");
		}

	}

	public void eraseVeterinarian(String idNumber) {

		if(pets.length == 0) {

			for(int i = 0; i < veterinarians.length; i++) {

				if(veterinarians[i] != null) {

					if(idNumber.equals(veterinarians[i].getIdNumber())) {

						veterinarians[i] = null;
						totalVets--;
					}	
				}
			}
			
		}else{

			System.out.println("\nERROR: There are still registered pets");
		}
	}

	public void printAllVeterinarians() {

		if(totalVets != 0) {

			for(int i = 0; i < veterinarians.length; i++) {

				if(veterinarians[i] != null) {

					System.out.println("\nVeterinarian " + i);
					System.out.println(veterinarians[i].toString());
				}
			}

		}else{

			System.out.println("\nERROR: No Veterinarians registered");
		}
	}

	public void addPet(String species, String petName, int age, String breed, 
		String symptoms, Priority priority, Status status, String ownerName, String ownerId, String ownerPhone, String ownerAddress,
		String attendedById) {

		Owner ownedBy = null;
			
		if(totalOwners != 0) {
			
			if(ownerExists(ownerName) == true) {
				
				boolean sameName = false;
				int i = 0;
				
				for(i = 0; i < MAX_PETS && !sameName; i++) {
					
					if(owners[i] != null) {
						
						if(owners[i].getFullName().equalsIgnoreCase(ownerName)) {
							
							ownedBy = owners[i];
							sameName = true;
						}
					}
				}
			}
			
			if(ownerExists(ownerName) == false) {
				
				addOwner(ownerId, ownerName, ownerPhone, ownerAddress);
				
				boolean sameName = false;
				int i = 0;
				
				for(i = 0; i < MAX_PETS && !sameName; i++) {
					
					if(owners[i] != null) {
						
						if(owners[i].getFullName().equalsIgnoreCase(ownerName)) {
							
							ownedBy = owners[i];
							sameName = true;
						}
					}
				}
			}
			
			
		}
		
		if(totalOwners == 0) {
			
			addOwner(ownerId, ownerName, ownerPhone, ownerAddress);
			
			boolean sameName = false;
			int i = 0;
			
			for(i = 0; i < MAX_PETS && !sameName; i++) {
				
				if(owners[i] != null) {
					
					if(owners[i].getFullName().equalsIgnoreCase(ownerName)) {
						
						ownedBy = owners[i];
						sameName = true;
					}
				}
			}
		}
		
		Veterinarian attendedBy = null;

		if(totalPets < MAX_PETS) {

			boolean empty = false;
			int i;

			for(i = 0; i < MAX_PETS && !empty; i++) {

				if(pets[i] == null) {

					pets[i] = new Pet(species, petName, age, breed, symptoms, priority, status, ownedBy, attendedById, attendedBy);
					totalPets++;
					empty = true;
				}
			}

		}else{

			System.out.println("Pet spaces are full" + 
				"\nDelete one to proceed");
		}
	}
	
	public boolean repeatedPet(String petName) {
		
		boolean repeated = false;
		int i = 0;
		
		if(totalPets != 0) {
			
			for(i = 0; i < pets.length && !repeated; i++) {
				
				if(pets[i] != null) {
					
					if(pets[i].getPetName().equalsIgnoreCase(petName)) {
						
						repeated = true;
					}	
				}
			}
		}
		
		return repeated;
	}
	
	public void erasePet(String petName) {
	
		for(int i = 0; i < pets.length; i++) {
	
			if(pets[i] != null) {
	
				if(petName.equals(pets[i].getPetName())) {
	
					if(pets[i].getStatus() == Status.WAITING) {
	
						pets[i] = null;
						totalPets--;
					}
				}	
			}
		}
	}
	
	public void printAllPets() {

		if(totalPets != 0) {

			for(int i = 0; i < veterinarians.length; i++) {

				if(pets[i] != null) {

					System.out.println("\nPet " + i);
					System.out.println(pets[i].toString());
				}
			}

		}else{

			System.out.println("\nERROR: No Pets registered");
		}
	}
	
	public void addOwner(String idNumber, String fullName, String phone, String address) {

		boolean empty = false;
		int i;

		for(i = 0; i < MAX_PETS && !empty; i++) {

			if(owners[i] == null) {

				owners[i] = new Owner(idNumber, fullName, phone, address);
				totalOwners++;
				empty = true;
			}
		}
	}
	
	public boolean ownerExists(String ownerName) {
		
		boolean isThere = false;
		int i = 0;
		
		if(totalOwners != 0) {
			
			for(i = 0; i < owners.length && !isThere; i++) {
				
				if(owners[i] != null) {
					
					if(owners[i].getFullName().equalsIgnoreCase(ownerName)) {
						
						isThere = true;
					}
				}
			}
		}
		
		return isThere;
	}

	public boolean repetatedOwner(String fullName) {
		
		boolean repeated = false;
		int i = 0;
		
		if(totalOwners != 0) {
			
			for(i = 0; i < owners.length && !repeated; i++) {
				
				if(owners[i] != null) {
					
					if(owners[i].getFullName().equalsIgnoreCase(fullName)) {
						
						repeated = true;
					}	
				}
			}
		}
		
		return repeated;
	}
	
	public void eraseOwner(String fullName) {
		
		for(int i = 0; i < owners.length; i++) {

			if(owners[i] != null) {

				if(fullName.equals(owners[i].getFullName())) {

					owners[i] = null;
					totalOwners--;
				}	
			}
		}
	}

	

	public void printAllOwners() {

		if(totalOwners != 0) {

			for(int i = 0; i < owners.length; i++) {

				if(owners[i] != null) {

					System.out.println("\nOwner " + i);
					System.out.println(owners[i].toString());
				}
			}

		}else{

			System.out.println("\nERROR: No Owners registered");
		}
	}

	public void newConsultation(String petName, String idNumber, Status status) {

		if(totalVets != 0) {

			Pet aPet = null;
			Veterinarian aVeterinarian = null;
			
			boolean sameId = false;
			boolean samePetName = false;
			int i;


			for(i = 0; i < pets.length && !samePetName; i++) {

				if(pets[i].getPetName().equalsIgnoreCase(petName)) {

					aPet = pets[i];
					samePetName = true;
				}
			}


			for(i = 0; i < veterinarians.length && !sameId; i++) {

				if(veterinarians[i].getIdNumber().equals(idNumber)) {

					aVeterinarian = veterinarians[i];
					sameId = true;
				}
			}


			sameId = false;
			samePetName = false;

			for(i = 0; i < veterinarians.length && !sameId; i++) {

				if(veterinarians[i].getIdNumber().equals(idNumber) && veterinarians[i].getAttends() == null) {

					veterinarians[i].setAttendedPets(veterinarians[i].getAttendedPets() + 1);
					veterinarians[i].setAttendingNow(petName);
					veterinarians[i].setAttends(aPet);
					sameId = true;

				}else if(!veterinarians[i].getIdNumber().equals(idNumber)) {

					System.out.println("\nERROR: ID number does not correspond to any veterinaries");

				}else if(veterinarians[i].getAttends() != null) {

					System.out.println("\nERROR: Veterinarian is attending a pet");
				}
			}

			for(i = 0; i < pets.length && !samePetName; i++) {

				if(pets[i].getPetName().equalsIgnoreCase(petName) && pets[i].getStatus() == Status.WAITING) {

					pets[i].setAttendedById(idNumber);
					pets[i].setAttendedBy(aVeterinarian);
					pets[i].setStatus(status);
					totalAttended++;
					samePetName = true;

				}else if(pets[i].getStatus() != Status.WAITING) {

					System.out.println("\nERROR: Pet does not have waiting status");
				}
			}

		} else{

			System.out.println("\nERROR: There are no Veterinarians");
		}

	}

	public void finishConsultation(String petName, String idNumber, String status) {

		boolean sameId = false;
		int i;

		for(i = 0; i < veterinarians.length && !sameId; i++) {

			if(veterinarians[i].getIdNumber().equals(idNumber)) {

				veterinarians[i].setAttends(null);
				veterinarians[i].setAttendingNow(null);
				sameId = true;
			}
		}

		boolean samePetName = false;

		for(i = 0; i < pets.length && !samePetName; i++) {

			if(pets[i].getPetName().equalsIgnoreCase(petName)) {

				if(status.equalsIgnoreCase("Transfer")) {

					pets[i].setStatus(Status.TRANSFER);
				}

				if(status.equalsIgnoreCase("Authorized")) {

					pets[i].setStatus(Status.AUTHORIZED);
				}

				if(status.equalsIgnoreCase("Unattended")) {

					pets[i].setStatus(Status.UNATTENDED);
				}

				samePetName = true;
			}
		}
	}

	public int attentionPending() {

		int pendingPets = 0;
		int i;

		if(totalPets != 0) {

			for(i = 0; i < pets.length; i++) {

				if(pets[i] != null && pets[i].getStatus() == Status.WAITING) {

					pendingPets++;
				}
			}
		}

		return pendingPets;
	}

	public String nextAttendant() {

		String next = null;

		boolean highest = false;
		int i;

		if(totalPets != 0) {

			for(i = 0; i < pets.length && !highest; i++) {

				if(pets[i] != null) {

					if(pets[i].getStatus() == Status.WAITING) {

						if(pets[i].getPriority() == Priority.RED_1) {

							next = pets[i].getPetName();
							highest = true;

						}else if(pets[i].getPriority() == Priority.ORANGE_2) {

							next = pets[i].getPetName();
							highest = true;

						}else if(pets[i].getPriority() == Priority.YELLOW_3) {

							next = pets[i].getPetName();
							highest = true;
	                                                                  
						}else if(pets[i].getPriority() == Priority.GREEN_4) {

							next = pets[i].getPetName();
							highest = true;

						}else if(pets[i].getPriority() == Priority.BLUE_5) {

							next = pets[i].getPetName();
							highest = true;
						}
					}
				}
			}
		}

		return next;
	}
	
	public String mostAttended() {
		
		int highest = 0;
		String topVeterinarian = null;
		
		if(totalVets != 0) {
			
			for(int i = 0; i < veterinarians.length; i++) {
				
				if(veterinarians[i] != null) {
					
					if(veterinarians[i].getAttendedPets() > highest) {
						
						topVeterinarian = veterinarians[i].getFullName();
					}
				}
			}
		}
		
		return topVeterinarian;
	}
		
	public void petsPerPriority() {
		
		int red = 0;
		int orange = 0;
		int yellow = 0;
		int green = 0;
		int blue = 0;
		
		if(totalPets != 0) {
			
			for(int i = 0; i < pets.length; i++) {
				
				if(pets[i] != null) {
					
					if(pets[i].getPriority() == Priority.RED_1) {
						
						red++;
					}
					
					if(pets[i].getPriority() == Priority.ORANGE_2) {
						
						orange++;
					}
					
					if(pets[i].getPriority() == Priority.YELLOW_3) {
						
						yellow++;
					}
					
					if(pets[i].getPriority() == Priority.GREEN_4) {
						
						green++;
					}
					
					if(pets[i].getPriority() == Priority.BLUE_5) {
						
						blue++;
					}	
				}
			}
			
			System.out.println("\nPets attended per priority " + 
					"\n- Priority 1: " + red + 
					"\n- Priority 2: " + orange + 
					"\n- Priority 3: " + yellow + 
					"\n- Priority 4: " + green + 
					"\n- Priority 5: " + blue);
			
		}else {
			
			System.out.println("\nERROR: There are no pets registered");
		}
	}
	
	public double unattendedPercentage() {
		
		double percentage = 0;		
		int unattendedPets = 0;
		
		if(totalPets != 0) {
			
			for(int i = 0; i < pets.length; i++) {
				
				if(pets[i] != null) {
					
					if(pets[i].getStatus() == Status.UNATTENDED) {
						
						unattendedPets++;
					}	
				}
			}
		}
		
		if(totalPets != 0) {
			
			percentage = (unattendedPets*100)/totalPets;
		}
		
		return percentage;
	}
	
	public void resetPets() {
		
		if(totalPets != 0) {
			
			totalPets = 0;
			
			for(int i = 0; i < pets.length; i++) {
				
				pets[i] = null;
			}
			
			setTotalAttended(0);
		}
	}
}