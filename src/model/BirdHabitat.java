package model;

public class BirdHabitat extends Habitat {
	
	//ATTRIBUTES
	private Cage cage;
	
	//RELATIONS
	
	//CONSTRUCTOR
	public BirdHabitat(String habitatId, double length, double width, Usage usage, Pet petInside, Cage cage) {
		
		super(habitatId, length, width, usage, petInside);
		this.setCage(cage);
	}

	//GETTERS AND SETTERS
	public Cage getCage() {
		return cage;
	}

	public void setCage(Cage cage) {
		this.cage = cage;
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
		
		out +=
			"\nCage type: " + getCage();
		
		return out;
	}
}
