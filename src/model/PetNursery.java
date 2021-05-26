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
	}


	//GETTERS AND SETTERS
	public ArrayList <Pet> getTransferedPets() {
		return nurseryPets;
	}

	public void setTransferedPets(ArrayList <Pet> nurseryPets) {
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
		String attendedById = null;
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
		
		Pet aPet = new Pet(species, petName, age, breed, symptoms, priority, status, ownedBy, attendedById, attendedBy);
		nurseryPets.add(new Pet(species, petName, age, breed, symptoms, priority, status, ownedBy, attendedById, attendedBy));
		
		enterPetToHabitat(aPet);
	}
	
	public void newDogHabitat(String habitatId, double length, double width, Usage usage, int toys) {
		
		Pet aPet = null;
		
		boolean empty = false;
		
		for(int i = 0; i < habitats.length && !empty; i++) {
			
			for(int j = 0; j < habitats[i].length && !empty; j++) {
				
				if(habitats[i][j] == null) {
					
					habitats[i][j] = new DogHabitat(habitatId, length, width, usage, aPet, toys);
					empty = true;
				}
			}
		}
	}
	
	public void newCatHabitat(String habitatId, double length, double width, Usage usage, double height, double maxWeight) {

		Pet aPet = null;
		
		boolean empty = false;
		
		for(int i = 0; i < habitats.length && !empty; i++) {
			
			for(int j = 0; j < habitats[i].length && !empty; j++) {
				
				if(habitats[i][j] == null) {
					
					habitats[i][j] = new CatHabitat(habitatId, length, width, usage, aPet, height, maxWeight);
					empty = true;
				}
			}
		}
	}
	
	public void newBirdHabitat(String habitatId, double length, double width, Usage usage, Cage cage) {
		
		Pet aPet = null;
		
		boolean empty = false;
		
		for(int i = 0; i < habitats.length && !empty; i++) {
			
			for(int j = 0; j < habitats[i].length && !empty; j++) {
				
				if(habitats[i][j] == null) {
					
					habitats[i][j] = new BirdHabitat(habitatId, length, width, usage, aPet, cage);
					empty = true;
				}
			}
		}
	}
	
	public void newRabbitHabitat(String habitatId, double length, double width, Usage usage, String plantType, int quantity) {
		
		Plant aPlant = new Plant(plantType, quantity);
		
		Pet aPet = null;
		
		boolean empty = false;
		
		for(int i = 0; i < habitats.length && !empty; i++) {
			
			for(int j = 0; j < habitats[i].length && !empty; j++) {
				
				if(habitats[i][j] == null) {
					
					habitats[i][j] = new RabbitHabitat(habitatId, length, width, usage, aPet, aPlant);
					empty = true;
				}
			}
		}
	}
	
	public void newReptileHabitat(String habitatId, double length, double width, Usage usage, Aquarium aquarium, String material) {
		
		Pet aPet = null;
		
		boolean empty = false;
		
		for(int i = 0; i < habitats.length && !empty; i++) {
			
			for(int j = 0; j < habitats[i].length && !empty; j++) {
				
				if(habitats[i][j] == null) {
					
					habitats[i][j] = new ReptileHabitat(habitatId, length, width, usage, aPet, aquarium, material);
					empty = true;
				}
			}
		}
	}
	
	
	public boolean habitatExists() {
		
		boolean exists = false;
		
		
		
		return exists;
	}
	
	public void enterPetToHabitat(Pet aPet) {
		
		boolean empty = false;
		
		for(int i = 0; i < habitats.length && !empty; i++) {
			
			for(int j = 0; j < habitats[i].length; j++) {
				
				if(habitats[i][j] != null) {
					
					habitats[i][j].setPetInside(aPet);
					empty = true;
				}
			}
		}
		
//		switch(aPet.getSpecies()) {
//		
//		case "Dog":
//			break;
//		}
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
	
	
	public String printMatrix() {
		
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
