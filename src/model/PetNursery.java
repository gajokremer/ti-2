package model;

import java.util.ArrayList;

public class PetNursery {
	
	//RELATIONS
	private ArrayList <Pet> nurseryPets;
	private ArrayList <Owner> nurseryOwners;
	private Habitat [][] habitats;
	private PetCenter nurseryToCenter;
	
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
