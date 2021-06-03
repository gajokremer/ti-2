package model;

/**
 * Bird habitat class <br>
 * Subclass of Habitat
 * @author gajok
 */
public class BirdHabitat extends Habitat {
	
	//---ATTRIBUTES
	private Cage cage;
	
	//RELATIONS
	//EMPTY
	
	//---CONSTRUCTOR
	/**
	 * Used to construct BirdHabitat.
	 * @param habitatId must be "B" and a number from 1 to 4
	 * @param length must be a number, and can have decimals
	 * @param width must a number, and can have decimals
	 * @param usage is the current usage of the habitat
	 * @param petInside can be a Pet or a SickPet, starts as null
	 * @param cage is the type of cage, either ""HUNG" or "GROUNDED"
	 */
	public BirdHabitat(String habitatId, double length, double width, Usage usage, Pet petInside, Cage cage) {
		
		super(habitatId, length, width, usage, petInside);
		this.setCage(cage);
	}

	
	//---GETTERS AND SETTERS
	/**
	 * Method to call for an Habitat's Cage type.
	 * @return habitat's Cage type
	 */
	public Cage getCage() {
		return cage;
	}
	/**
	 * Method to change an Habitat's Cage type.
	 * @param cage must exist
	 */
	public void setCage(Cage cage) {
		this.cage = cage;
	}
	
	
	//---TO STRING
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
