package model;

//import java.util.ArrayList;

/**
 * Pet Nursery class
 * @author gajok
 */
public class PetNursery {
	
	//---RELATIONS
//	private ArrayList <Pet> nurseryPets;
//	private ArrayList <Owner> nurseryOwners;
	private Habitat [][] habitats;
	
	//---CONSTRUCTOR
	public PetNursery() {
		
//		nurseryPets = new ArrayList<Pet>();
//		nurseryOwners = new ArrayList<Owner>();
		habitats = new Habitat[6][5];
		createAllHabitats();
	}


	//---GETTERS AND SETTERS
//	public ArrayList <Pet> getNurseryPets() {
//		return nurseryPets;
//	}
//
//	public void setNurseryPets(ArrayList <Pet> nurseryPets) {
//		this.nurseryPets = nurseryPets;
//	}
	
	//---METHODS	
	public void transferedPetAndOwner(Pet aPet) {
		
//		nurseryPets.add(aPet);
//		nurseryOwners.add(anOwner);
		Usage usage = Usage.SICK;
		enterPetToHabitat(aPet, usage);
		
	}
	
	public String addPet(String species, String petName, int age, String breed, String ownerName, 
			String ownerId, String ownerPhone, String ownerAddress) {
		
		String result = "";
		
//		Owner ownedBy = null;
//		
//		if(ownerExists(ownerName) == false) {
//			
//			addOwner(ownerId, ownerName, ownerPhone, ownerAddress);
//		}
//		
//		for(int i = 0; i < nurseryOwners.size(); i++) {
//			
//			if(nurseryOwners.get(i).getFullName().equalsIgnoreCase(ownerName)) {
//				
//				ownedBy = nurseryOwners.get(i);
//			}
//		}
//		
//		if(habitatAvailable(species) == true) {
//			
//			Pet aPet = new Pet(species, petName, age, breed, ownedBy);
//			nurseryPets.add(aPet);
//			
//			result = enterPetToHabitat(aPet);
//			
//		}else {
//			
//			result = "\nERROR: There are no spaces available"; 
//		}
		
		Owner anOwner = null;
		
		anOwner = new Owner(ownerId, ownerName, ownerPhone, ownerAddress);
		
		Pet aPet = new Pet(species, petName, age, breed, anOwner);
		
		result += "\n--Pet successfully added";
		
		Usage usage = Usage.HEALTHY;
		
		enterPetToHabitat(aPet, usage);
		
		return result;
	}
	
	public void createAllHabitats() {

		Pet aPet = null;
		
		catHabitats(aPet);
		dogHabitats(aPet);
		reptileHabitats(aPet);
		rabbitHabitats(aPet);
		birdHabitats(aPet);
	}
	
	public void catHabitats(Pet aPet) {
		
		habitats[0][0] = new CatHabitat("C1", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[0][1] = new CatHabitat("C2", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[0][2] = new CatHabitat("C3", 100, 100, Usage.EMPTY, aPet, 100, 5);
		
		habitats[1][0] = new CatHabitat("C4", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[1][1] = new CatHabitat("C5", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[1][2] = new CatHabitat("C6", 100, 100, Usage.EMPTY, aPet, 100, 5);
		
		habitats[2][0] = new CatHabitat("C7", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[2][1] = new CatHabitat("C8", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[2][2] = new CatHabitat("C9", 100, 100, Usage.EMPTY, aPet, 100, 5);
	}
	
	public void dogHabitats(Pet aPet) {
		
		habitats[3][0] = new DogHabitat("D1", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[3][1] = new DogHabitat("D2", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[3][2] = new DogHabitat("D3", 200, 200, Usage.EMPTY, aPet, 5);
		
		habitats[4][0] = new DogHabitat("D4", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[4][1] = new DogHabitat("D5", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[4][2] = new DogHabitat("D6", 200, 200, Usage.EMPTY, aPet, 5);
		
		habitats[5][0] = new DogHabitat("D7", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[5][1] = new DogHabitat("D8", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[5][2] = new DogHabitat("D9", 200, 200, Usage.EMPTY, aPet, 5);
	}
	
	public void reptileHabitats(Pet aPet) {
		
		habitats[0][3] = new ReptileHabitat("Rp1", 150, 150, Usage.EMPTY, aPet, Aquarium.TERRESTRIAL, "Melamin");
		habitats[0][4] = new ReptileHabitat("Rp2", 150, 150, Usage.EMPTY, aPet, Aquarium.TERRESTRIAL, "Melamin");
		
		habitats[1][3] = new ReptileHabitat("Rp3", 150, 150, Usage.EMPTY, aPet, Aquarium.AMPHIBIAN, "Glass");
		habitats[1][4] = new ReptileHabitat("Rp4", 150, 150, Usage.EMPTY, aPet, Aquarium.AMPHIBIAN, "Glass");
	}
	
	public void rabbitHabitats(Pet aPet) {
		
		Plant aPlant = new Plant("Petunia", 10);
		
		habitats[2][3] = new RabbitHabitat("Rb1", 100, 100, Usage.EMPTY, aPet, aPlant);
		habitats[2][4] = new RabbitHabitat("Rb2", 100, 100, Usage.EMPTY, aPet, aPlant);
		
		habitats[3][3] = new RabbitHabitat("Rb3", 100, 100, Usage.EMPTY, aPet, aPlant);
		habitats[3][4] = new RabbitHabitat("Rb4", 100, 100, Usage.EMPTY, aPet, aPlant);
	}
	
	public void birdHabitats(Pet aPet) {
		
		habitats[4][3] = new BirdHabitat("B1", 50, 50, Usage.EMPTY, aPet, Cage.HUNG);
		habitats[4][4] = new BirdHabitat("B2", 50, 50, Usage.EMPTY, aPet, Cage.HUNG);
		
		habitats[5][3] = new BirdHabitat("B3", 50, 50, Usage.EMPTY, aPet, Cage.GROUNDED);
		habitats[5][4] = new BirdHabitat("B4", 50, 50, Usage.EMPTY, aPet, Cage.GROUNDED);
	}

	
	public boolean habitatAvailable(String species) {
		
		boolean available = false;
		
		species = species.toUpperCase();
		
		switch(species) {
		
		case "CAT":
			
			for(int i = 0; i < 3 && !available; i++) {
			
				for(int j = 0; j < 3 && !available; j++) {
					
					if(habitats[i][j].getPetInside() == null) {
						
						available = true;
					}
				}
			}
			
			break;
			
		case "DOG":
			
			for(int i = 3; i < 6 && !available; i++) {
				
				for(int j = 0; j < 3 && !available; j++) {
					
					if(habitats[i][j].getPetInside() == null) {
						
						available = true;
					}
				}
			}
			
			break;
			
		case "REPTILE":
			
			for(int i = 0; i < 2 && !available; i++) {
				
				for(int j = 3; j < 5 && !available; j++) {
					
					if(habitats[i][j].getPetInside() == null) {
						
						available = true;
					}
				}
			}
			
			break;
			
		case "RABBIT":
			
			for(int i = 2; i < 4 && !available; i++) {
				
				for(int j = 3; j < 5 && !available; j++) {
					
					if(habitats[i][j].getPetInside() == null) {
						
						available = true;
					}
				}
			}
			
			break;
			
		case "BIRD":
			
			for(int i = 4; i < 6 && !available; i++) {
				
				for(int j = 3; j < 5 && !available; j++) {
					
					if(habitats[i][j].getPetInside() == null) {
						
						available = true;
					}
				}
			}
			
			break;
		}
		
		return available;
	}
	
	
	public String enterPetToHabitat(Pet aPet, Usage usage) {
		
		String result = "";
		
		boolean empty = false;
		
		switch(aPet.getSpecies().toUpperCase()) {
		
		case "CAT":
			
			for(int i = 0; i < 3 && !empty; i++) {
			
				for(int j = 0; j < 3 && !empty; j++) {
					
					if(habitats[i][j].getPetInside() == null) {
						
						habitats[i][j].setPetInside(aPet);
						habitats[i][j].setUsage(usage);
						result += "\n--Pet successfully entered habitat: " + habitats[i][j].getHabitatId();
						empty = true;
					}
				}
			}
			
			break;
			
		case "DOG":
			
			for(int i = 3; i < 6 && !empty; i++) {
				
				for(int j = 0; j < 3 && !empty; j++) {
					
					if(habitats[i][j].getPetInside() == null) {
						
						habitats[i][j].setPetInside(aPet);
						habitats[i][j].setUsage(usage);
						result += "\n--Pet successfully entered habitat: " + habitats[i][j].getHabitatId();
						empty = true;
					}
				}
			}
			
			break;
			
		case "REPTILE":
			
			for(int i = 0; i < 2 && !empty; i++) {
				
				for(int j = 3; j < 5 && !empty; j++) {
					
					if(habitats[i][j].getPetInside() == null) {
						
						habitats[i][j].setPetInside(aPet);
						habitats[i][j].setUsage(usage);
						result += "\n--Pet successfully entered habitat: " + habitats[i][j].getHabitatId();
						empty = true;
					}
				}
			}
			
			break;
			
		case "RABBIT":
			
			for(int i = 2; i < 4 && !empty; i++) {
				
				for(int j = 3; j < 5 && !empty; j++) {
					
					if(habitats[i][j].getPetInside() == null) {
						
						habitats[i][j].setPetInside(aPet);
						habitats[i][j].setUsage(usage);
						result += "\n--Pet successfully entered habitat: " + habitats[i][j].getHabitatId();
						empty = true;
					}
				}
			}
			
			break;
			
		case "BIRD":
			
			for(int i = 4; i < 6 && !empty; i++) {
				
				for(int j = 3; j < 5 && !empty; j++) {
					
					if(habitats[i][j].getPetInside() == null) {
						
						habitats[i][j].setPetInside(aPet);
						habitats[i][j].setUsage(usage);
						result += "\n--Pet successfully entered habitat: " + habitats[i][j].getHabitatId();
						empty = true;
					}
				}
			}
			
			break;
		}
				
		return result;
	}
	
	
	public String printAllPets() {
		
		String result = "";
		
//		for(int i = 0; i < nurseryPets.size(); i++) {
//			
//			result +=  nurseryPets.get(i).toString() + "\n";
//		}
		
		for(int i = 0; i < habitats.length; i++) {
			
			for(int j = 0; j < habitats[i].length; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					result += habitats[i][j].getPetInside().toString() + "\n";
				}
			}
		}
		
		return result;
	}
	
//	public void addOwner(String idNumber, String fullName, String phone, String address) {
//
////		String result = "";
//		
//		nurseryOwners.add(new Owner(idNumber, fullName, phone, address));
//
////		return result;
//	}
	
	public boolean ownerExists(String ownerName) {
		
		boolean isThere = false;
		
//		int i = 0;
//				
//		for(i = 0; i < nurseryOwners.size() && !isThere; i++) {
//			
//			if(nurseryOwners.get(i).getFullName().equalsIgnoreCase(ownerName)) {
//				
//				isThere = true;
//			}
//		}
		
		System.out.println("\n---GOT INSIDE FOR");
		
		for(int i = 0; i < habitats.length && !isThere; i++) {
			
			System.out.println("\n---STEP 1");
			
			for(int j = 0; j < habitats[i].length && !isThere; j++) {
								
				System.out.println("\n---STEP 2");
				
				if(habitats[i][j].getPetInside() != null) {
					
					System.out.println("\n---STEP 3");
					
					System.out.println("\n-Parameter: " + ownerName);
					System.out.println("\n-Full Name: " + habitats[i][j].getPetInside().getOwnedBy().getFullName());
					System.out.println("\nOwned By: " + habitats[i][j].getPetInside().getOwnedBy().toString());
					
					if(habitats[i][j].getPetInside().getOwnedBy().getFullName().equalsIgnoreCase(ownerName)) {
						
						System.out.println("---FOUND IT!");
						
						isThere = true;
						
					}else {
						
						System.out.println("\n---NO STEP 4");
					}
				}
			}
		}
		
		return isThere;
	}
	
	public Owner findOwner(String ownerName) {
		
		Owner anOwner = null;
		
		for(int i = 0; i < habitats.length; i++) {
			
			for(int j = 0; j < habitats[i].length; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					if(habitats[i][j].getPetInside().getOwnedBy().getFullName().equalsIgnoreCase(ownerName)) {
						
						
						anOwner = habitats[i][j].getPetInside().getOwnedBy();
					}
				}
			}
		}
		
		return anOwner;
	}
	
	public String printAllOwners() {
		
		String result = "";
		
//		for(int i = 0; i < nurseryOwners.size(); i++) {
//			
//			result += nurseryOwners.get(i).toString() + "\n";
//		}
		
		for(int i = 0; i < habitats.length; i++) {
			
			for(int j = 0; j < habitats[i].length; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					result += habitats[i][j].getPetInside().getOwnedBy().toString() + "\n";
				}
			}
		}
		
		return result;
	}
	
	public String petLocation(String petName) {
		
		String result = "";
		
		boolean samePetName = false;
		
		for(int i = 0; i < habitats.length && !samePetName; i++) {
			
			for(int j = 0; j < habitats[i].length && !samePetName; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					if(habitats[i][j].getPetInside().getPetName().equalsIgnoreCase(petName)) {
						
						result += "\n--" + petName + " is " + habitats[i][j].getUsage() + 
								" and is located in habitat " + habitats[i][j].getHabitatId();
						samePetName = true;
						
					}
				}
			}
		}
		
		return result;
	}
	
	
	public String printHabitatsList() {
		
		String result = "";
		
		for(int i = 0; i < habitats.length; i++) {
			
			for(int j = 0; j < habitats[i].length; j++) {
				
				if(habitats[i][j] != null) {
					
					result += habitats[i][j].toString() + "\n";
				}
			}
		}
		
		return result;
	}
	
	public String printHabitatsMatrix() {
		
		String result = "";
		
		result += 
			"\nE = Empty" + 
			"\nH = Occupied Healthy" + 
			"\nS = Occupied Sick\n\n";
		
		String usage = "";
		
		for (int i = 0; i < habitats.length; i++ ) {
			
			for (int j = 0; j < habitats[i].length; j++) {
				
				switch(habitats[i][j].getUsage()) {
				
				case EMPTY:
					usage = "(E)";
					break;
					
				case HEALTHY:
					usage = "(H)";
					break;
					
				case SICK:
					usage = "(S)";
					break;
				}
				
				result += "- " + habitats[i][j].getHabitatId() + usage + " -";
			}
			
			result += "\n\n";
		}
		
		return result;
	}
	
	public String habitatInfo(String habitatId) {
		
		String result = "";
		
		boolean sameId = false;
		
		for(int i = 0; i < habitats.length && !sameId; i++) {
			
			for(int j = 0; j < habitats[i].length && !sameId; j++) {
				
				if(habitats[i][j].getHabitatId().equalsIgnoreCase(habitatId)) {
					
					result += habitats[i][j].toString();
					sameId = true;
				}
			}
		}
		
		return result;		
	}
	
	public double catOccupation() {
		
		double percentage = 0;
		int count = 0;
		
		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < 3; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					count++;
				}
			}
		}
		
		percentage = (count*100)/9;
		
		return percentage;
	}
	
	public double dogOccupation() {
		
		double percentage = 0;
		int count = 0;
		
		for(int i = 3; i < 6; i++) {
			
			for(int j = 0; j < 3; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					count++;
				}
			}
		}
		
		percentage = (count*100)/9;
		
		return percentage;
	}
	
	public double reptileOccupation() {
		
		double percentage = 0;
		int count = 0;
		
		for(int i = 0; i < 2; i++) {
			
			for(int j = 3; j < 5; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					count++;
				}
			}
		}
		
		percentage = (count*100)/4;
		
		return percentage;
	}
	
	public double rabbitOccupation() {
		
		double percentage = 0;
		int count = 0;
		
		for(int i = 2; i < 4; i++) {
			
			for(int j = 3; j < 5; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					count++;
				}
			}
		}
		
		percentage = (count*100)/4;
		
		return percentage;
	}
	
	
	public double birdOccupation() {
		
		double percentage = 0;
		int count = 0;
		
		for(int i = 4; i < 6; i++) {
			
			for(int j = 3; j < 5; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					count++;
				}
			}
		}
		
		percentage = (count*100)/4;
		
		return percentage;
	}
	
	public double totalOccupation() {
		
		double percentage = 0;
		int count = 0;
		
		for(int i = 0; i < habitats.length; i++) {
			
			for(int j = 0; j < habitats[i].length; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					count++;
				}
			}
		}
		
		percentage = (count*100)/30;
		
		return percentage;
	}
	
	public double percentageHealthy() {
		
		double percentage = 0;
		int count = 0;
		
		for(int i = 0; i < habitats.length; i++) {
			
			for(int j = 0; j < habitats[i].length; j++) {
				
				if(habitats[i][j].getUsage() == Usage.HEALTHY) {
					
					count++;
				}
			}
		}
		
		percentage = (count*100)/30;
		
		return percentage;
	}
	
	public double percentageSick() {
		
		double percentage = 0;
		int count = 0;
		
		for(int i = 0; i < habitats.length; i++) {
			
			for(int j = 0; j < habitats[i].length; j++) {
				
				if(habitats[i][j].getUsage() == Usage.SICK) {
					
					count++;
				}
			}
		}
		
		percentage = (count*100)/30;
		
		return percentage;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void copyOfPets(Pet [] pets) {
//		
//		for(int i = 0; i < pets.length; i++) {
//			
//			if(pets[i] != null) {
//				
//				if(pets[i].getStatus() == Status.TRANSFER) {
//					
//					nurseryPets.add(pets[i]);
//				}
//			}
//		}
//		
//		for(int i = 0; i < nurseryPets.size(); i++) {
//			
//			System.out.println(nurseryPets.get(i).toString());
//		}
//	}
//	
//	public void copyOfPets2(Pet [] pets) {
//		
//		Pet [] petsCopy = new Pet[120];
//		
//		boolean copied = false;
//		
//		for(int i = 0; i < pets.length; i++) {
//			
//			if(pets[i] != null) {
//				
//				if(pets[i].getStatus() == Status.TRANSFER) {
//					
//					for(int j =0; j < petsCopy.length && !copied; j++) {
//						
//						if(petsCopy[j] == null) {
//							
//							petsCopy[j] = pets[i];
//							copied = true;
//						}
//					}
//				}
//			}
//		}
//		
//		for(int i = 0; i < petsCopy.length; i++) {
//			
//			if(petsCopy[i] != null) {
//				
//				System.out.println("\nPets " + i);				
//				System.out.println(petsCopy[i].toString());
//			}
//		}
//	}
}
