package model;

public class BirdHabitat extends Habitat {
	
	//ATTRIBUTES
	private Cage cage;
	
	//RELATIONS
	
	//CONSTRUCTOR
	public BirdHabitat(String habitatId, double length, double width, Usage usage, Cage cage) {
		
		super(habitatId, length, width, usage);
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
			"\nHabitatId: " + getHabitatId() + 
			"\nLength: " + getLength() + 
			"\nWidth: " + getWidth() + 
			"\nCurrent usage: " + getUsage() + 
			"\nCage type :" + getCage();
		
		return out;
	}
}
