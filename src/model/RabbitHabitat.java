package model;

public class RabbitHabitat extends Habitat{
	
	//ATTRIBUTES
	
	//RELATIONS
	private Plant plant;
	
	//CONSTRUCTOR
	public RabbitHabitat(String habitatId, double length, double width, Usage usage, Pet petInside, Plant plant) {
		
		super(habitatId, length, width, usage, petInside);
		this.setPlant(plant);
	}

	//GETTERS AND SETTERS
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	
	//TO STRING
	@Override
	public String toString() {
		
		String out = 
			"\nHabitat ID: " + getHabitatId() + 
			"\nLength: " + getLength() + 
			"\nWidth: " + getWidth() + 
			"\nCurrent usage: " + getUsage() + 
			"\nPet inside: " + getPetInside().getPetName() + 
			getPlant().toString();
		
		return out;
	}
}
