package model;

/**
 * Pet Nursery class
 * @author gajok
 */
public class PetNursery {
	
	//---RELATIONS
	private Habitat [][] habitats;
	
	//---CONSTRUCTOR
	/**
	 * Used to construct PetNursery.
	 */
	public PetNursery() {
		
		habitats = new Habitat[6][5];
		createAllHabitats();
	}


	//---GETTERS AND SETTERS
	//EMPTY
	
	
	//---METHODS	
	/**
	 * Method that receives a Pet from the PetCenter.
	 * @param aPet must be a SickPet
	 * @param habitatType must be one of the two possible types of habitat for either birds of reptiles
	 */
	public void transferedPetAndOwner(SickPet aPet, String habitatType) {
		
		Usage usage = Usage.SICK;
		enterPetToHabitat(aPet, usage, habitatType);
	}
	
	
	/**
	 * Method to receive the information of the Pet and it's Owner.
	 * @param species must be an animal species
	 * @param petName must be a String, can contain more than one word
	 * @param age must be an integer
	 * @param breed if species is dog or cat, must be a String, else it's null
	 * @param habitatType must be one of the two possible types of habitat for either birds of reptiles
	 * @param ownerId must be a String composed of numbers
	 * @param ownerName must be a String with name and surname included
	 * @param ownerPhone must be a String with a phone number (10 digits)
	 * @param ownerAddress must contain an address (words, numbers, symbols)
	 * @param daysStaying must be a number
	 * @return message if pet was successfully added to the Nursery
	 */
	public String addPet(String species, String petName, int age, String breed, String habitatType, String ownerName, 
			String ownerId, String ownerPhone, String ownerAddress, int daysStaying) {
		
		String result = "";
		
		Owner anOwner = null;
		
		anOwner = new Owner(ownerId, ownerName, ownerPhone, ownerAddress);
		
		Pet aPet = new Pet(species, petName, age, breed, anOwner);
		
		aPet.setDaysStaying(daysStaying);
		
		Usage usage = Usage.HEALTHY;
		
		enterPetToHabitat(aPet, usage, habitatType);
		
		result += "\n--Pet successfully added";
		
		return result;
	}
	
	
	/**
	 * Method that calls all method to create the empty Habitats.
	 */
	public void createAllHabitats() {

		Pet aPet = null;
		
		catHabitats(aPet);
		dogHabitats(aPet);
		reptileHabitats(aPet);
		rabbitHabitats(aPet);
		birdHabitats(aPet);
	}
	
	
	/**
	 * Method to create all Cat Habitats.
	 * @param aPet must be null
	 */
	public void catHabitats(Pet aPet) {
		
		habitats[0][0] = new CatHabitat("C1", 100, 100, Usage.EMPTY, aPet, 100, 10);
		habitats[0][1] = new CatHabitat("C2", 100, 100, Usage.EMPTY, aPet, 100, 10);
		habitats[0][2] = new CatHabitat("C3", 100, 100, Usage.EMPTY, aPet, 100, 10);
		
		habitats[1][0] = new CatHabitat("C4", 100, 100, Usage.EMPTY, aPet, 100, 10);
		habitats[1][1] = new CatHabitat("C5", 100, 100, Usage.EMPTY, aPet, 100, 10);
		habitats[1][2] = new CatHabitat("C6", 100, 100, Usage.EMPTY, aPet, 100, 10);
		
		habitats[2][0] = new CatHabitat("C7", 100, 100, Usage.EMPTY, aPet, 100, 10);
		habitats[2][1] = new CatHabitat("C8", 100, 100, Usage.EMPTY, aPet, 100, 10);
		habitats[2][2] = new CatHabitat("C9", 100, 100, Usage.EMPTY, aPet, 100, 10);
	}
	
	
	/**
	 * Method to create all Dog Habitats.
	 * @param aPet must be null
	 */
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
	
	
	/**
	 * Method to create all Reptile Habitats.
	 * @param aPet must be null
	 */
	public void reptileHabitats(Pet aPet) {
		
		habitats[0][3] = new ReptileHabitat("Rp1", 150, 150, Usage.EMPTY, aPet, Aquarium.TERRESTRIAL, "Melamin");
		habitats[0][4] = new ReptileHabitat("Rp2", 150, 150, Usage.EMPTY, aPet, Aquarium.TERRESTRIAL, "Melamin");
		
		habitats[1][3] = new ReptileHabitat("Rp3", 150, 150, Usage.EMPTY, aPet, Aquarium.AMPHIBIAN, "Glass");
		habitats[1][4] = new ReptileHabitat("Rp4", 150, 150, Usage.EMPTY, aPet, Aquarium.AMPHIBIAN, "Glass");
	}
	
	
	/**
	 * Method to create all Rabbit Habitats.
	 * @param aPet must be null
	 */
	public void rabbitHabitats(Pet aPet) {
		
		Plant aPlant = new Plant("Petunia", 10);
		
		habitats[2][3] = new RabbitHabitat("Rb1", 100, 100, Usage.EMPTY, aPet, aPlant);
		habitats[2][4] = new RabbitHabitat("Rb2", 100, 100, Usage.EMPTY, aPet, aPlant);
		
		habitats[3][3] = new RabbitHabitat("Rb3", 100, 100, Usage.EMPTY, aPet, aPlant);
		habitats[3][4] = new RabbitHabitat("Rb4", 100, 100, Usage.EMPTY, aPet, aPlant);
	}
	
	
	/**
	 * Method to create all Bird Habitats.
	 * @param aPet must be null
	 */
	public void birdHabitats(Pet aPet) {
		
		habitats[4][3] = new BirdHabitat("B1", 50, 50, Usage.EMPTY, aPet, Cage.HUNG);
		habitats[4][4] = new BirdHabitat("B2", 50, 50, Usage.EMPTY, aPet, Cage.HUNG);
		
		habitats[5][3] = new BirdHabitat("B3", 50, 50, Usage.EMPTY, aPet, Cage.GROUNDED);
		habitats[5][4] = new BirdHabitat("B4", 50, 50, Usage.EMPTY, aPet, Cage.GROUNDED);
	}
	
	
	/**
	 * Method to turn String into a value of Aquarium.
	 * @param habitatType must be either "Amphibian" or "Terrestrial"
	 * @return respective value of Aquarium
	 */
	public Aquarium valueOfAquarium(String habitatType) {
		
		Aquarium aquarium = null;
		
		if(habitatType != null) {
			
			if(habitatType.equalsIgnoreCase("Amphibian") || habitatType.equalsIgnoreCase("Terrestrial")) {
				
				aquarium = Aquarium.valueOf(habitatType.toUpperCase());
			}
		}
		
		return aquarium;
	}
	
	
	/**
	 * Method to turn String into value of Cage.
	 * @param habitatType must be either "Hung" or "Grounded"
	 * @return respective value of Cage
	 */
	public Cage valueOfCage(String habitatType) {
		
		Cage cage = null;
		
		if(habitatType != null) {
			
			if(habitatType.equalsIgnoreCase("Hung") || habitatType.equalsIgnoreCase("Grounded")) {
				
				cage = Cage.valueOf(habitatType.toUpperCase());
			}
		}
		
		return cage;
	}


	/**
	 * Method to check if there's an available Habitat for a pet depending on the species.
	 * @param species must be an animal species
	 * @param habitatType must be one of the two possible types of habitat for either birds of reptiles
	 * @return true if there's an available space, false if not
	 */
	public boolean habitatAvailable(String species, String habitatType) {
		
		Aquarium aquarium = valueOfAquarium(habitatType);
		Cage cage = valueOfCage(habitatType);
		
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
			
			
			if(aquarium == Aquarium.TERRESTRIAL) {
				
				for(int i = 0; i < 1 && !available; i++) {
					
					for(int j = 3; j < 5 && !available; j++) {
						
						if(habitats[i][j].getPetInside() == null) {
							
							available = true;
						}
					}
				}
			}
			
			if(aquarium == Aquarium.AMPHIBIAN) {
				
				for(int i = 1; i < 2 && !available; i++) {
					
					for(int j = 3; j < 5 && !available; j++) {
						
						if(habitats[i][j].getPetInside() == null) {
							
							available = true;
						}
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
			
			if(cage == Cage.HUNG) {
				
				for(int i = 4; i < 5 && !available; i++) {
					
					for(int j = 3; j < 5 && !available; j++) {
						
						if(habitats[i][j].getPetInside() == null) {
							
							available = true;
						}
					}
				}
			}
			
			if(cage == Cage.GROUNDED) {
				
				for(int i = 5; i < 6 && !available; i++) {
					
					for(int j = 3; j < 5 && !available; j++) {
						
						if(habitats[i][j].getPetInside() == null) {
							
							available = true;
						}
					}
				}
			}
			
			break;
		}
		
		return available;
	}
	
	
	/**
	 * Method to enter a Pet to an Habitat.
	 * @param aPet must exist and have an Owner
	 * @param usage must be either "Healthy", or "Sick" if it comes from PetCenter
	 * @param habitatType must be one of the two possible types of habitat for either birds of reptiles
	 * @return message notifying Pet has successfully entered the Habitat
	 */
	public String enterPetToHabitat(Pet aPet, Usage usage, String habitatType) {
		
		String result = "";
		
		Aquarium aquarium = valueOfAquarium(habitatType);
		Cage cage = valueOfCage(habitatType);
		
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
			
			if(aquarium == Aquarium.TERRESTRIAL) {
				
				for(int i = 0; i < 1 && !empty; i++) {
					
					for(int j = 3; j < 5 && !empty; j++) {
						
						if(habitats[i][j].getPetInside() == null) {
							
							habitats[i][j].setPetInside(aPet);
							habitats[i][j].setUsage(usage);
							result += "\n--Pet successfully entered habitat: " + habitats[i][j].getHabitatId();
							empty = true;
						}
					}
				}
			}
			
			if(aquarium == Aquarium.AMPHIBIAN) {
				
				for(int i = 1; i < 2 && !empty; i++) {
					
					for(int j = 3; j < 5 && !empty; j++) {
						
						if(habitats[i][j].getPetInside() == null) {
							
							habitats[i][j].setPetInside(aPet);
							habitats[i][j].setUsage(usage);
							result += "\n--Pet successfully entered habitat: " + habitats[i][j].getHabitatId();
							empty = true;
						}
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
			
			if(cage == Cage.HUNG) {
				
				for(int i = 4; i < 5 && !empty; i++) {
					
					for(int j = 3; j < 5 && !empty; j++) {
						
						if(habitats[i][j].getPetInside() == null) {
							
							habitats[i][j].setPetInside(aPet);
							habitats[i][j].setUsage(usage);
							result += "\n--Pet successfully entered habitat: " + habitats[i][j].getHabitatId();
							empty = true;
						}
					}
				}
			}
			
			if(cage == Cage.GROUNDED) {
				
				for(int i = 5; i < 6 && !empty; i++) {
					
					for(int j = 3; j < 5 && !empty; j++) {
						
						if(habitats[i][j].getPetInside() == null) {
							
							habitats[i][j].setPetInside(aPet);
							habitats[i][j].setUsage(usage);
							result += "\n--Pet successfully entered habitat: " + habitats[i][j].getHabitatId();
							empty = true;
						}
					}
				}
			}
			
			break;
		}
				
		return result;
	}
	
	
	/**
	 * Method to pick up a Pet from the Nursery.
	 * @param petName must be a String, can contain more than one word
	 * @param daysPassed must be an integer and represents the days passed
	 * @return result of operation
	 */
	public String retirePet(String petName, int daysPassed) {
		
		String result = "";
		
		boolean sameName = false;
		
		for(int i = 0; i < habitats.length && !sameName; i++) {
			
			for(int j = 0; j < habitats[i].length && !sameName; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					if(habitats[i][j].getPetInside().getPetName().equalsIgnoreCase(petName)) {
						
						if(habitats[i][j].getUsage() == Usage.HEALTHY) {
							
							int overtime = daysPassed - habitats[i][j].getPetInside().getDaysStaying();
							
							habitats[i][j].setPetInside(null);
							habitats[i][j].setUsage(Usage.EMPTY);
							
							if(overtime > 0) {
								
								result += "\n---Overtime: " + overtime + " days";
							}
							
							result += "\n---Pet successfully picked up";
							result += "\n---Habitat " + habitats[i][j].getHabitatId() + " is now available";
							sameName = true;						
						}
						
						if(habitats[i][j].getUsage() == Usage.SICK) {
							
							result += "\n---Pet is hospitalized and can't be picked up yet";
						}
					}
				}
			}
		}
		
		return result;
	}
	
	
	/**
	 * <b> Secret function. </b> <br>
	 * Method to print all Pets inside the Habitats.
	 * @return String with all Pets inside the Habitats
	 */
	public String printAllPets() {
		
		String result = "";
		
		for(int i = 0; i < habitats.length; i++) {
			
			for(int j = 0; j < habitats[i].length; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					result += habitats[i][j].getPetInside().toString() + "\n";
				}
			}
		}
		
		return result;
	}
	
	
	/**
	 * Method to check if an Owner exists.
	 * @param ownerName must be a String with name and surname included
	 * @return true if owner is found, false if not
	 */
	public boolean ownerExists(String ownerName) {
		
		boolean isThere = false;
		
		for(int i = 0; i < habitats.length && !isThere; i++) {
			
			for(int j = 0; j < habitats[i].length && !isThere; j++) {
								
				if(habitats[i][j].getPetInside() != null) {
					
					if(habitats[i][j].getPetInside().getOwnedBy().getFullName().equalsIgnoreCase(ownerName)) {
						
						isThere = true;
						
					}
				}
			}
		}
		
		return isThere;
	}
	
	/**
	 * Method to find an Owner and return it.
	 * @param ownerName must be a String with name and surname included
	 * @return Owner that has this name
	 */
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
	
	
	/**
	 * <b> Secret function. </b> <br>
	 * Method to print all Owners of the Pets inside the Habitats
	 * @return String with all the Owners
	 */
	public String printAllOwners() {
		
		String result = "";
		
		for(int i = 0; i < habitats.length; i++) {
			
			for(int j = 0; j < habitats[i].length; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					result += habitats[i][j].getPetInside().getOwnedBy().toString() + "\n";
				}
			}
		}
		
		return result;
	}
	
	
	/**
	 * Method to print all Habitats in a matrix format, including their current usage.
	 * @return String with Habitats Matrix
	 */
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
	
	
	/**
	 * Method to get information about a specific Pet.
	 * @param petName must be a String, can contain more than one word
	 * @return String with the Pet's information
	 */
	public String petInfo(String petName) {
		
		String result = "";
		
		boolean samePetName = false;
		
		for(int i = 0; i < habitats.length && !samePetName; i++) {
			
			for(int j = 0; j < habitats[i].length && !samePetName; j++) {
				
				if(habitats[i][j].getPetInside() != null) {
					
					if(habitats[i][j].getPetInside().getPetName().equalsIgnoreCase(petName)) {
						
						result += 
							"\nPet name: " + petName + 
							"\nLocation: " + habitats[i][j].getHabitatId() + 
							"\nStatus: " + habitats[i][j].getUsage();
						
						if(habitats[i][j].getUsage() != Usage.SICK) {
							
							result += "\nDays staying: " + habitats[i][j].getPetInside().getDaysStaying();
						
						}else {
							
							result += "\nDays staying: Undefined";
						}
						
						samePetName = true;
						
					}
				}
			}
		}
		
		return result;
	}
	
	
	/**
	 * Method to get info on a specific Habitat.
	 * @param habitatId must be a letter and a number
	 * @return Habitat's info
	 */
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
	
	
	/**
	 * Method to calculate the occupation percentage of the Cat Habitats.
	 * @return percentage of occupation
	 */
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
		
		percentage = (count * 100) / 9;
		
		return percentage;
	}
	
	
	/**
	 * Method to calculate the occupation percentage of the Dog Habitats.
	 * @return percentage of occupation
	 */
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
		
		percentage = (count * 100) / 9;
		
		return percentage;
	}
	
	
	/**
	 * Method to calculate the occupation percentage of the Reptile Habitats.
	 * @return percentage of occupation
	 */
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
		
		percentage = (count * 100) / 4;
		
		return percentage;
	}
	
	
	/**
	 * Method to calculate the occupation percentage of the Rabbit Habitats.
	 * @return percentage of occupation
	 */
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
		
		percentage = (count * 100) / 4;
		
		return percentage;
	}
	
	
	/**
	 * Method to calculate the occupation percentage of the Bird Habitats.
	 * @return percentage of occupation
	 */
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
		
		percentage = (count * 100) / 4;
		
		return percentage;
	}
	
	
	/**
	 * Method to calculate the total occupation percentage of Habitats.
	 * @return percentage of occupation of all Habitats
	 */
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
		
		percentage = (count * 100) / 30;
		
		return percentage;
	}
	
	
	/**
	 * Method to calculate the percentage of Healthy Pets.
	 * @return percentage of Healthy Pets
	 */
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
		
		percentage = (count * 100) / 30;
		
		return percentage;
	}
	
	
	/**
	 * Method to calculate the percentage of Sick Pets.
	 * @return percentage of Sick Pets
	 */
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
		
		percentage = (count * 100) / 30;
		
		return percentage;
	}
}
