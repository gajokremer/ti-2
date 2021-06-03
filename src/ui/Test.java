package ui;

import model.PetNursery;
import model.PetCenter;

import model.Aquarium;
import model.Cage;
import model.Usage;

import model.Priority;
import model.Status;

import model.SickPet;
import model.Veterinarian;
import model.Owner;

/**
 * Class to run tests
 * @author gajok
 */
public class Test {

	/**
	 * Method to create 4 Birds, from which one comes from PetCenter.
	 * @param nursery must exist
	 * @param center must exist
	 */
	public void createScenario1(PetNursery nursery, PetCenter center) {
		
		//BIRDS		
		nursery.addPet("Bird", "A", 1, null, "GK", "1000372548", "3107542161", "Cra 1", 2);
		
		nursery.addPet("Bird", "B", 2, null, "GK", "1000372548", "3107542161", "Cra 1", 3);
		
		nursery.addPet("Bird", "C", 3, null, "GK", "1000372548", "3107542161", "Cra 1", 4);
		
		Veterinarian aVeterinarian = null; 
		Owner anOwner = new Owner("GK", "1000372548", "3107542161", "Cra 1");
		
		SickPet aPet = new SickPet("Bird", "D", 4, null, "Vomit", Priority.YELLOW_3, Status.TRANSFER, anOwner, aVeterinarian);
		
		nursery.transferedPetAndOwner(aPet);
	}
}
