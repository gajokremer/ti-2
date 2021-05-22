package model;

/**
 * PetCenter class
 * @author gajok
 */
public class PetCenter{

	//---ATTRIBUTES
	/**
	 * Max number of Pets that can be registered.
	 */
	public static final int MAX_PETS = 120;
	/**
	 * Max number of Veterinarians that can be registered.
	 */
	public static final int MAX_VETS = 7;
	
	private int totalPets;
	private int totalVets;
	private int totalOwners;
	private int totalAttended;

	//---RELATIONS
	private Pet [] pets;
	private Veterinarian [] veterinarians;
	private Owner [] owners;

	//CONSTRUCTOR
	/**
	 * Used to construct PetCenter object.
	 */
	public PetCenter() {

		pets = new Pet[MAX_PETS];
		veterinarians = new Veterinarian[MAX_VETS];
		owners = new Owner[MAX_PETS];
		totalPets = 0;
		totalVets = 0;
		totalOwners = 0;
	}
	

	//GETTERS AND SETTERS
	/**
	 * Method to call the total registered Pets.
	 * @return total attended Pets
	 */
	public int getTotalPets() {
		return totalPets;
	}
	/**
	 * Method to change the total registered Pets.
	 * @param totalPets must exist and be an integer, can be 0
	 */
	public void setTotalPets(int totalPets) {
		this.totalPets = totalPets;
	}
	
	
	/**
	 * Method to call the total Veterinarians.
	 * @return total Veterinarians
	 */
	public int getTotalVets() {
		return totalVets;
	}
	/**
	 * Method to change the total Veterinarians.
	 * @param totalVets must exist and be an integer, can be 0
	 */
	public void setTotalVets(int totalVets) {
		this.totalVets = totalVets;
	}
	
	
	/**
	 * Method to call the total Owners.
	 * @return total Owners
	 */
	public int getTotalOwners() {
		return totalOwners;
	}
	/**
	 * Method to change the total Owners.
	 * @param totalOwners must exist and be an integer, can be 0
	 */
	public void setTotalOwners(int totalOwners) {
		this.totalOwners = totalOwners;
	}
	
	
	/**
	 * Method to call the total attended Pets.
	 * @return total attended Pets
	 */
	public int getTotalAttended() {
		return totalAttended;
	}
	/**
	 * Method to change the total attended Pets.
	 * @param totalAttended must exist and be an integer, can be 0
	 */
	public void setTotalAttended(int totalAttended) {
		this.totalAttended = totalAttended;
	}


	//---METHODS
	/**
	 * Method to create a Veterinarian in the first empty space of veterinarians array.
	 * @param idNumber must be a String composed of numbers
	 * @param fullName must have name and surname included
	 * @param registerNumber must be a String which can combine letters and numbers
	 * @param attendedPets must be 0
	 * @param attendingNow must be null
	 * @return String with result of procedure
	 */
	public String addVeterinarian(String idNumber, String fullName, String registerNumber, int attendedPets, String attendingNow) {

		String result = "";
		Pet attends = null;

		if(totalVets < MAX_VETS) {

			boolean empty = false;
			int i;

			for(i = 0; i < MAX_VETS && !empty; i++) {

				if(veterinarians[i] == null) {

					veterinarians[i] = new Veterinarian(idNumber, fullName, registerNumber, attendedPets, attendingNow, attends);
					totalVets++;
					empty = true;
					
					result = "\n--Veterinarian added successfully";
				}
			}

		}else{

			result = "Veterinarian spaces are full" + 
				"\nDelete one to proceed";
		}
		
		return result;
	}

	
	/**
	 * Method to erase a Veterinarian from the veterinarians array.
	 * @param idNumber must be a String composed of numbers
	 * @return String with result of procedure
	 */
	public String eraseVeterinarian(String idNumber) {
		
		String result = "";

		if(pets.length == 0) {

			for(int i = 0; i < veterinarians.length; i++) {

				if(veterinarians[i] != null) {

					if(idNumber.equals(veterinarians[i].getIdNumber())) {

						veterinarians[i] = null;
						totalVets--;
						
						result = "\n--Veterinarian deleted successfully";
					}	
				}
			}
			
		}else{

			result = "\nERROR: There are still registered pets";
		}
		
		return result;
	}

	
	/**
	 * Method to show all Veterinarians in the veterinarians array.
	 * @return String with all veterinarians
	 */
	public String printAllVeterinarians() {
		
		String result = "";

		if(totalVets != 0) {

			for(int i = 0; i < veterinarians.length; i++) {

				if(veterinarians[i] != null) {

					result += "\nVeterinarians " + i + veterinarians[i].toString();					
				}
			}

		}else{

			result = "\nERROR: No Veterinarians registered";
		}
		
		return result;
	}

	
	/**
	 * Method to create a Pet in the first empty space of pets arrays, and then assign it's owner. <br>
	 * If the owner doesn't exist, the user must create it.
	 * @param species must be an animal species
	 * @param petName must be a String, can contain more than one word
	 * @param age must be an integer
	 * @param breed if species is dog or cat, must be a String, else it's null
	 * @param symptoms must be a String, can be as long as the user needs
	 * @param priority must be one of five Priority options
	 * @param status must be "Waiting" when created, the can be changed to one of five Status options
	 * @param ownerName must be a String with name and surname included
	 * @param ownerId must be a String composed of numbers
	 * @param ownerPhone must be a String with a phone number (10 digits)
	 * @param ownerAddress must contain an address (words, numbers, symbols)
	 * @param attendedById must start as null, then will show ID of Veterinarian who attended the Pet
	 * @return String with result of procedure
	 */
	public String addPet(String species, String petName, int age, String breed, 
		String symptoms, Priority priority, Status status, String ownerName, String ownerId, 
		String ownerPhone, String ownerAddress, String attendedById) {
		
		String result = "";

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
					
					result = "\n--Pet added successfully";
				}
			}

		}else{

			result = "Pet spaces are full" + 
				"\nDelete one to proceed";
		}
		
		return result;
	}
	
	
	/**
	 * Method to verify if a Pet's name already exists.
	 * @param petName must be a String, can contain more than one word
	 * @return true if name exists, false if it doesn't
	 */
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
	
	
	/**
	 * Changes a Pet's status to "Unattended".
	 * @param petName must be a String, can contain more than one word
	 */
	public void retireThisPet(String petName) {
		
		for(int i = 0; i < pets.length; i++) {
			
			if(pets[i] != null) {
				
				if(petName.equalsIgnoreCase(pets[i].getPetName())) {
					
					if(pets[i].getStatus() == Status.WAITING) {
						
						pets[i].setStatus(Status.UNATTENDED);	
					}
				}
			}
		}
	}
	
	
	/**
	 * <b> Hidden function. </b> <br>
	 * Method to erase a Pet from the pets array.
	 * @param petName must be a String, can contain more than one word
	 */
	public void erasePet(String petName) {
	
		for(int i = 0; i < pets.length; i++) {
	
			if(pets[i] != null) {
	
				if(petName.equalsIgnoreCase(pets[i].getPetName())) {
	
					if(pets[i].getStatus() == Status.WAITING) {
	
						pets[i] = null;
						totalPets--;
					}
				}	
			}
		}
	}
	
	
	/**
	 * Method to show all Pets in the pets array.
	 * @return String with all Pets
	 */
	public String printAllPets() {
		
		String result = "";

		if(totalPets != 0) {

			for(int i = 0; i < veterinarians.length; i++) {

				if(pets[i] != null) {

					result += "\nPets " + i + pets[i].toString();		
				}
			}

		}else{

			result = "\nERROR: No Pets registered";
		}
		
		return result;
	}
	
	
	/**
	 * Method to create an Owner in the first empty space of owners array.
	 * @param idNumber must be a String composed of numbers
	 * @param fullName must be a String with name and surname included
	 * @param phone must be a String with a phone number (10 digits)
	 * @param address must contain an address (words, numbers, symbols)
	 * @return String with result of procedure
	 */
	public String addOwner(String idNumber, String fullName, String phone, String address) {

		String result = "";
		
		boolean empty = false;
		int i;

		for(i = 0; i < MAX_PETS && !empty; i++) {

			if(owners[i] == null) {

				owners[i] = new Owner(idNumber, fullName, phone, address);
				totalOwners++;
				empty = true;
				
				result = "\n--Owner added successfully";
			}
		}
		
		return result;
	}
	
	
	/**
	 * Method to verify if the Owner given by the user already exists.
	 * @param ownerName must be a String with name and surname included
	 * @return true if the Owner already exists, false if it doesn't
	 */
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

	
	/**
	 * Method to verify if an Owner's name already exists.
	 * @param fullName must be a String with name and surname included
	 * @return true if name exists, false if it doesn't
	 */
	public boolean repeatedOwner(String fullName) {
		
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
	
	
	/**
	 * <b> Hidden function. </b> <br>
	 * Method to erase an Owner form the owners array.
	 * @param fullName must be a String with name and surname included
	 */
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

	
	/**
	 * Method to show all Owners in owners array.
	 * @return String with all Owners
	 */
	public String printAllOwners() {
		
		String result = "";

		if(totalOwners != 0) {

			for(int i = 0; i < owners.length; i++) {

				if(owners[i] != null) {

					result += "\nOwners " + i + owners[i].toString();
				}
			}

		}else{

			result = "\nERROR: No Owners registered";
		}
		
		return result;
	}

	
	/**
	 * Method to start a new consultation.
	 * Assigns to the Veterinarian the Pet being attended, and to the Pet the Veterinarian that attended it.
	 * @param petName must be a String, can contain more than one word
	 * @param idNumber must be a String composed of numbers
	 * @param status must be "Consulting" by default
	 * @return String with result of procedure
	 */
	public String newConsultation(String petName, String idNumber, Status status) {
		
		String result = "";

		if(totalVets != 0) {

			Pet aPet = null;
			Veterinarian aVeterinarian = null;
			
			boolean sameId = false;
			boolean samePetName = false;
			int i;


			for(i = 0; i < pets.length && !samePetName; i++) {
				
				if(pets[i] != null) {
					
					if(pets[i].getPetName().equalsIgnoreCase(petName)) {
						
						if(pets[i].getStatus() == Status.WAITING) {							
							
							aPet = pets[i];
							samePetName = true;
						}
					}
				}
			}


			for(i = 0; i < veterinarians.length && !sameId; i++) {
				
				if(veterinarians[i] != null) {
					
					if(veterinarians[i].getIdNumber().equals(idNumber)) {
						
						aVeterinarian = veterinarians[i];
						sameId = true;
					}
				}
			}


			sameId = false;
			samePetName = false;

			for(i = 0; i < veterinarians.length && !sameId; i++) {
				
				if(veterinarians[i] != null) {	
					
					if(veterinarians[i].getIdNumber().equals(idNumber)) {
						
						if(veterinarians[i].getAttends() != null) {
							
							result = "\nERROR: Veterinarian is attending a pet";
						}
						
						if(veterinarians[i].getAttends() == null) {
							
							veterinarians[i].setAttendedPets(veterinarians[i].getAttendedPets() + 1);
							veterinarians[i].setAttendingNow(petName);
							veterinarians[i].setAttends(aPet);
							sameId = true;
						}
						
					}else {
						
						result = "\nERROR: ID number does not correspond to any veterinarian";

					}
					
//					if(!veterinarians[i].getIdNumber().equals(idNumber)) {
//						
//						result = "\nERROR: ID number does not correspond to any veterinarian";
//					}
				}
			}

			for(i = 0; i < pets.length && !samePetName && sameId; i++) {
				
				if(pets[i] != null) {
					
					if(pets[i].getPetName().equalsIgnoreCase(petName)) {

//						if(pets[i].getStatus() != Status.WAITING){
//							
//							result = "\nERROR: Pet does not have waiting status";
//						}
						
						if(pets[i].getStatus() == Status.WAITING) {
							
							if(pets[i].getAttendedBy() == null) {
								
								
								pets[i].setAttendedById(idNumber);
								pets[i].setAttendedBy(aVeterinarian);
								pets[i].setStatus(status);
								totalAttended++;
								samePetName = true;
								
							}else {
								
								result = "\nERROR: Pet has already been attended";
							}
						}else {
							
							result = "\nERROR: Pet does not have waiting status";
						}
					}
					
//					if(pets[i].getStatus() != Status.WAITING) {
//						
//						result = "\nERROR: Pet does not have waiting status";
//					}
				}
			}

			
		} else{

			result = "\nERROR: There are no Veterinarians";
		}

		return result;
	}
	
	
	/**
	 * Method to end a consultation. <br>
	 * Assigns to the Veterinarian the Pet being attended as null.
	 * @param petName must be a String, can contain more than one word
	 * @param idNumber must be a String which can combine letters and numbers
	 * @param status must be one of these three: "Transfer", "Authorized", "Unattended"
	 * @return String with result of procedure
	 */
	public String finishConsultation(String petName, String idNumber, Status status) {
		
		String result = "";

		boolean sameId = false;
		int i;

		for(i = 0; i < veterinarians.length && !sameId; i++) {

			if(veterinarians[i].getIdNumber().equals(idNumber)) {
				
				if(veterinarians[i].getAttends() != null) {
					
					veterinarians[i].setAttends(null);
					veterinarians[i].setAttendingNow(null);
					sameId = true;
					
				}else {
				
					result = "\nERROR: Veterinarian is not attending a pet";
				}
			}
		}

		boolean samePetName = false;

		for(i = 0; i < pets.length && !samePetName; i++) {

			if(pets[i].getPetName().equalsIgnoreCase(petName)) {
				
				if(pets[i].getStatus() == Status.CONSULTING) {
					
					pets[i].setStatus(status);				
					samePetName = true;
					
				}else {
					
					result = "\nEROOR: Pet is not in consultation";
				}
			}
		}
		
		return result;
	}

	
	/**
	 * Method to print the number of pets pending for attendance.
	 * @return number of pets pending of attendance
	 */
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

	
	/**
	 * Method to print the next pet to be attended. <br>
	 * Must prioritize Priority over arrival order.
	 * @return name of next Pet to be attended
	 */
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
						}
					}
				}
			}
			
			for(i = 0; i < pets.length && !highest; i++) {
				
				if(pets[i] != null) {

					if(pets[i].getStatus() == Status.WAITING) {
						
						if(pets[i].getPriority() == Priority.ORANGE_2) {
							
							next = pets[i].getPetName();
							highest = true;
						}
					}
				}
			}
			
			for(i = 0; i < pets.length && !highest; i++) {
				
				if(pets[i] != null) {

					if(pets[i].getStatus() == Status.WAITING) {
						
						if(pets[i].getPriority() == Priority.YELLOW_3) {
							
							next = pets[i].getPetName();
							highest = true;
						}
					}
				}
			}
			
			for(i = 0; i < pets.length && !highest; i++) {
				
				if(pets[i] != null) {

					if(pets[i].getStatus() == Status.WAITING) {
						
						if(pets[i].getPriority() == Priority.GREEN_4) {
							
							next = pets[i].getPetName();
							highest = true;
						}
					}
				}
			}
			
			for(i = 0; i < pets.length && !highest; i++) {
				
				if(pets[i] != null) {

					if(pets[i].getStatus() == Status.WAITING) {
						
						if(pets[i].getPriority() == Priority.BLUE_5) {
							
							next = pets[i].getPetName();
							highest = true;
						}
					}
				}
			}
		}

		return next;
	}
	
	
	/**
	 * Method to show the name of the Veterinarian that attended the most pets.
	 * @return the name of the Veterinarian that attended the most pets
	 */
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
	
	
	/**
	 * Method to show quantity of pets attended per each Priority.
	 * @return String with number of attended pets pet each priority
	 */
	public String petsPerPriority() {
		
		String result = "";
		
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
			
			result = "\nPets attended per priority " + 
					"\n- Priority 1: " + red + 
					"\n- Priority 2: " + orange + 
					"\n- Priority 3: " + yellow + 
					"\n- Priority 4: " + green + 
					"\n- Priority 5: " + blue;
			
		}else {
			
			result = "\nERROR: There are no pets registered";
		}
		
		return result;
	}
	
	
	/**
	 * Method to show the percentage of unattended pets.
	 * @return double with percentage of unattended pets
	 */
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
			
			percentage = (unattendedPets*100)/totalPets;
		}
		
		if(totalPets == 0) {
			
			percentage = 0;
		}
		
		return percentage;
	}
	
	
	/**
	 * Method to erase all Pets and Owners the arrays.
	 */
	public void resetPetsandOwners() {
		
		if(totalPets != 0) {
			
			totalPets = 0;
			
			for(int i = 0; i < pets.length; i++) {
				
				pets[i] = null;
			}
			
			setTotalAttended(0);
		}
		
		if(totalOwners != 0) {
			
			totalOwners = 0;
			
			for(int i = 0; i < pets.length; i++) {
				
				owners[i] = null;
			}
		}
	}
}