package model;

public class DogHabitat extends Habitat{
	
	//ATTRIBUTES
	private int toys;
	
	//RELATIONS
	
	//CONSTRUCTOR
	public DogHabitat(String habitatId, double length, double width, Usage usage, Pet petInside, int toys) {
		
		super(habitatId, length, width, usage, petInside);
		this.setToys(toys);
	}
	
	//GETTERS AND SETTERS
	public int getToys() {
		return toys;
	}

	public void setToys(int toys) {
		this.toys = toys;
	}
	
	//TO STRING
	@Override
	public String toString() {
		
		String out = 
			"\nHabitat ID: " + getHabitatId() + 
			"\nLength: " + getLength() + 
			"\nWidth: " + getWidth() + 
			"\nCurrent usage: " + getUsage();
			
		if(getPetInside() == null) {
			
			out += "\nPet inside: None"; 

		}else {
			
			out += "\nPet inside: " + getPetInside().getPetName();
		}
			
		out += "\nAvailable toys: " + getToys();
		
		return out;
	}
}
