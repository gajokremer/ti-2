package model;

import java.util.ArrayList;

public class PetNursery {
	
	//RELATIONS
	private ArrayList <Pet> nurseryPets;
	private ArrayList <Owner> nurseryOwners;
	private Habitat [][] habitats;
//	private PetCenter nurseryToCenter;
	
	//CONSTRUCTOR
	public PetNursery() {
		
		nurseryPets = new ArrayList<Pet>();
		nurseryOwners = new ArrayList<Owner>();
		habitats = new Habitat[6][5];
		createAllHabitats();
	}


	//GETTERS AND SETTERS
	public ArrayList <Pet> getNurseryPets() {
		return nurseryPets;
	}

	public void setNurseryPets(ArrayList <Pet> nurseryPets) {
		this.nurseryPets = nurseryPets;
	}
	
	//METHODS	
	public void transferedPetAndOwner(Pet aPet, Owner anOwner) {
		
		nurseryPets.add(aPet);
		nurseryOwners.add(anOwner);
	}
	
	public void addPet(String species, String petName, int age, String breed, String ownerName, 
			String ownerId, String ownerPhone, String ownerAddress) {
		
		Priority priority = null;
		String symptoms = null;
		Status status = null;
		Veterinarian attendedBy = null;
		Owner ownedBy = null;
		
		if(ownerExists(ownerName) == false) {
			
			addOwner(ownerId, ownerName, ownerPhone, ownerAddress);
		}
		
		for(int i = 0; i < nurseryOwners.size(); i++) {
			
			if(nurseryOwners.get(i).getFullName().equalsIgnoreCase(ownerName)) {
				
				ownedBy = nurseryOwners.get(i);
			}
		}
		
		Pet aPet = new Pet(species, petName, age, breed, symptoms, priority, status, ownedBy, attendedBy);
		nurseryPets.add(new Pet(species, petName, age, breed, symptoms, priority, status, ownedBy, attendedBy));
		
		enterPetToHabitat(aPet);
	}
	
	public void createAllHabitats() {

		Pet aPet = null;
		
		dogHabitats(aPet);
		catHabitats(aPet);
		reptileHabitats(aPet);
		rabbitHabitats(aPet);
		birdHabitats(aPet);
	}
	
	public void dogHabitats(Pet aPet) {
		
		habitats[0][0] = new DogHabitat("D1", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[0][1] = new DogHabitat("D2", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[0][2] = new DogHabitat("D3", 200, 200, Usage.EMPTY, aPet, 5);
		
		habitats[1][0] = new DogHabitat("D4", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[1][1] = new DogHabitat("D5", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[1][2] = new DogHabitat("D6", 200, 200, Usage.EMPTY, aPet, 5);
		
		habitats[2][0] = new DogHabitat("D7", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[2][1] = new DogHabitat("D8", 200, 200, Usage.EMPTY, aPet, 5);
		habitats[2][2] = new DogHabitat("D9", 200, 200, Usage.EMPTY, aPet, 5);
	}
	
	public void catHabitats(Pet aPet) {
		
		habitats[3][0] = new CatHabitat("C1", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[3][1] = new CatHabitat("C2", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[3][2] = new CatHabitat("C3", 100, 100, Usage.EMPTY, aPet, 100, 5);
		
		habitats[4][0] = new CatHabitat("C4", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[4][1] = new CatHabitat("C5", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[4][2] = new CatHabitat("C6", 100, 100, Usage.EMPTY, aPet, 100, 5);
		
		habitats[5][0] = new CatHabitat("C7", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[5][1] = new CatHabitat("C8", 100, 100, Usage.EMPTY, aPet, 100, 5);
		habitats[5][2] = new CatHabitat("C9", 100, 100, Usage.EMPTY, aPet, 100, 5);
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

	
//	public void newDogHabitat(String habitatId, double length, double width, Usage usage, int toys) {
//		
//		Pet aPet = null;
//		
//		boolean empty = false;
//		
//		for(int i = 0; i < habitats.length && !empty; i++) {
//			
//			for(int j = 0; j < habitats[i].length && !empty; j++) {
//				
//				if(habitats[i][j] == null) {
//					
//					habitats[i][j] = new DogHabitat(habitatId, length, width, usage, aPet, toys);
//					empty = true;
//				}
//			}
//		}
//	}
//	
//	public void newCatHabitat(String habitatId, double length, double width, Usage usage, double height, double maxWeight) {
//
//		Pet aPet = null;
//		
//		boolean empty = false;
//		
//		for(int i = 0; i < habitats.length && !empty; i++) {
//			
//			for(int j = 0; j < habitats[i].length && !empty; j++) {
//				
//				if(habitats[i][j] == null) {
//					
//					habitats[i][j] = new CatHabitat(habitatId, length, width, usage, aPet, height, maxWeight);
//					empty = true;
//				}
//			}
//		}
//	}
//	
//	public void newBirdHabitat(String habitatId, double length, double width, Usage usage, Cage cage) {
//		
//		Pet aPet = null;
//		
//		boolean empty = false;
//		
//		for(int i = 0; i < habitats.length && !empty; i++) {
//			
//			for(int j = 0; j < habitats[i].length && !empty; j++) {
//				
//				if(habitats[i][j] == null) {
//					
//					habitats[i][j] = new BirdHabitat(habitatId, length, width, usage, aPet, cage);
//					empty = true;
//				}
//			}
//		}
//	}
//	
//	public void newRabbitHabitat(String habitatId, double length, double width, Usage usage, String plantType, int quantity) {
//		
//		Plant aPlant = new Plant(plantType, quantity);
//		
//		Pet aPet = null;
//		
//		boolean empty = false;
//		
//		for(int i = 0; i < habitats.length && !empty; i++) {
//			
//			for(int j = 0; j < habitats[i].length && !empty; j++) {
//				
//				if(habitats[i][j] == null) {
//					
//					habitats[i][j] = new RabbitHabitat(habitatId, length, width, usage, aPet, aPlant);
//					empty = true;
//				}
//			}
//		}
//	}
//	
//	public void newReptileHabitat(String habitatId, double length, double width, Usage usage, Aquarium aquarium, String material) {
//		
//		Pet aPet = null;
//		
//		boolean empty = false;
//		
//		for(int i = 0; i < habitats.length && !empty; i++) {
//			
//			for(int j = 0; j < habitats[i].length && !empty; j++) {
//				
//				if(habitats[i][j] == null) {
//					
//					habitats[i][j] = new ReptileHabitat(habitatId, length, width, usage, aPet, aquarium, material);
//					empty = true;
//				}
//			}
//		}
//	}
	
	
	public boolean habitatAvailable(String species) {
		
		boolean available = false;
		
		species = species.toUpperCase();
		
		switch(species) {
		
		case "DOG":
			
			for(int i = 0; i < 3 && !available; i++) {
			
				for(int j = 0; j < 3 && !available; j++) {
					
					if(habitats[i][j].getPetInside() == null) {
						
						available = true;
					}
				}
			}
			
			break;
			
		case "CAT":
			
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
		
//		String[] parts;
//		
//		switch(species) {
//		
//		case "DOG":
//			
//			for(int i = 0; i < habitats.length && !available; i++) {
//				
//				for(int j = 0; j < habitats[0].length && !available; j++) {
//			
//					parts = habitats[i][j].getHabitatId().split("");
//					
//					if(parts[0].equalsIgnoreCase("D")) {
//						
//						if(habitats[i][j].getPetInside() == null) {
//							
//							available = true;
//						}
//					}
//				}
//			}
//			
//			break;
//			
//		case "CAT":
//			
//			for(int i = 0; i < habitats.length && !available; i++) {
//				
//				for(int j = 0; j < habitats[0].length && !available; j++) {
//			
//					parts = habitats[i][j].getHabitatId().split("");
//					
//					if(parts[0].equalsIgnoreCase("C")) {
//						
//						if(habitats[i][j].getPetInside() == null) {
//							
//							available = true;
//						}
//					}
//				}
//			}
//			
//			break;
//			
//		case "BIRD":
//			
//			for(int i = 0; i < habitats.length && !available; i++) {
//				
//				for(int j = 0; j < habitats[0].length && !available; j++) {
//			
//					parts = habitats[i][j].getHabitatId().split("");
//					
//					if(parts[0].equalsIgnoreCase("B")) {
//						
//						if(habitats[i][j].getPetInside() == null) {
//							
//							available = true;
//						}
//					}
//				}
//			}
//			
//			break;
//			
//		case "RABBIT":
//			
//			for(int i = 0; i < habitats.length && !available; i++) {
//				
//				for(int j = 0; j < habitats[0].length && !available; j++) {
//			
//					parts = habitats[i][j].getHabitatId().split("");
//					
//					if(parts[0].equalsIgnoreCase("R")) {
//						
//						if(parts[1].equalsIgnoreCase("a")) {
//							
//							if(habitats[i][j].getPetInside() == null) {
//								
//								available = true;
//							}
//						}
//					}
//				}
//			}
//			
//			break;
//			
//		case "REPTILE":
//			
//			for(int i = 0; i < habitats.length && !available; i++) {
//				
//				for(int j = 0; j < habitats[0].length && !available; j++) {
//			
//					parts = habitats[i][j].getHabitatId().split("");
//					
//					if(parts[0].equalsIgnoreCase("R")) {
//						
//						if(parts[1].equalsIgnoreCase("p")) {
//							
//							if(habitats[i][j].getPetInside() == null) {
//								
//								available = true;
//							}
//						}
//					}
//				}
//			}
//			
//			break;
//		}
		
		return available;
	}
	
	public String enterPetToHabitat(Pet aPet) {
		
		String result = "";
		
		boolean empty = false;
		
		for(int i = 0; i < habitats.length && !empty; i++) {
			
			for(int j = 0; j < habitats[i].length; j++) {
				
				if(habitatAvailable(aPet.getSpecies()) == true) {
					
					result = "\n--Pet successfully interned\n";
					habitats[i][j].setPetInside(aPet);
					empty = true;
					
				}else {
					
					result = "\nERROR: No available habitats";
				}
			}
		}
		
		return result;
	}
	
	
	public String printAllPets() {
		
		String result = "";
		
		for(int i = 0; i < nurseryPets.size(); i++) {
			
			result += nurseryPets.get(i).toString();
		}
		
		return result;
	}
	
	public void addOwner(String idNumber, String fullName, String phone, String address) {

//		String result = "";
		
		nurseryOwners.add(new Owner(idNumber, fullName, phone, address));

//		return result;
	}
	
	public boolean ownerExists(String ownerName) {
		
		boolean isThere = false;
		int i = 0;
				
		for(i = 0; i < nurseryOwners.size() && !isThere; i++) {
			
			if(nurseryOwners.get(i).getFullName().equalsIgnoreCase(ownerName)) {
				
				isThere = true;
			}
		}
		return isThere;
	}
	
	public String printAllOwners() {
		
		String result = "";
		
		for(int i = 0; i < nurseryOwners.size(); i++) {
			
			result += nurseryOwners.get(i).toString();
		}
		
		return result;
	}
	
	
	public String printHabitats() {
		
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
	
	public String printMatrix() {
		
		String result = "\n";
		
		String usage = "";
		
		for (int i = 0; i < habitats.length; i++ ) {
			
			for (int j = 0; j < habitats[0].length; j++) {
				
				switch(habitats[i][j].getUsage()) {
				
				case EMPTY:
					usage = "E";
					break;
					
				case HEALTHY:
					usage = "H";
					break;
					
				case SICK:
					usage = "S";
					break;
				}
				
				result += " - " + habitats[i][j].getHabitatId() + usage;
			}
			
			result += "\n\n";
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void copyOfPets(Pet [] pets) {
		
		for(int i = 0; i < pets.length; i++) {
			
			if(pets[i] != null) {
				
				if(pets[i].getStatus() == Status.TRANSFER) {
					
					nurseryPets.add(pets[i]);
				}
			}
		}
		
		for(int i = 0; i < nurseryPets.size(); i++) {
			
			System.out.println(nurseryPets.get(i).toString());
		}
	}
	
	public void copyOfPets2(Pet [] pets) {
		
		Pet [] petsCopy = new Pet[120];
		
		boolean copied = false;
		
		for(int i = 0; i < pets.length; i++) {
			
			if(pets[i] != null) {
				
				if(pets[i].getStatus() == Status.TRANSFER) {
					
					for(int j =0; j < petsCopy.length && !copied; j++) {
						
						if(petsCopy[j] == null) {
							
							petsCopy[j] = pets[i];
							copied = true;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < petsCopy.length; i++) {
			
			if(petsCopy[i] != null) {
				
				System.out.println("\nPets " + i);				
				System.out.println(petsCopy[i].toString());
			}
		}
	}
}
