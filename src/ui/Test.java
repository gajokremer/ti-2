package ui;

import model.PetNursery;
import model.PetCenter;

import model.Aquarium;
import model.Cage;
import model.Usage;

import model.Priority;
import model.Status;

public class Test {

	public void createScenario1(PetNursery nursery) {
		
		//BIRDS		
		nursery.addPet("Bird", "A", 1, null, "GK", "1000372548", "3107542161", "Cra 1");
		
		nursery.addPet("Bird", "B", 2, null, "GK", "1000372548", "3107542161", "Cra 1");
		
		nursery.addPet("Bird", "C", 3, null, "GK", "1000372548", "3107542161", "Cra 1");
		
		nursery.addPet("Bird", "D", 4, null, "GK", "1000372548", "3107542161", "Cra 1");
	}
}
