package model;

public class DogHabitat extends Habitat{
	
	//ATTRIBUTES
	private int toys;
	
	//RELATIONS
	
	//CONSTRUCTOR
	public DogHabitat(String habitatId, double length, double width, Usage usage, int toys) {
		
		super(habitatId, length, width, usage);
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
			"\nHabitatId: " + getHabitatId() + 
			"\nLength: " + getLength() + 
			"\nWidth: " + getWidth() + 
			"\nCurrent usage: " + getUsage() + 
			"\nAvailable toys: " + getToys();
		
		return out;
	}
}
