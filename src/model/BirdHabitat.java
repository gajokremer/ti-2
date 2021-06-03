package model;

/**
 * Bird habitat class
 * Subclass of Habitat
 * @author gajok
 */
public class BirdHabitat extends Habitat {
	
	//---ATTRIBUTES
	private Cage cage;
	
	//RELATIONS
	
	//---CONSTRUCTOR
	/**
	 * Used to construct Bird habitat
	 * @param habitatId must be "B" and a number
	 * @param length must be a double
	 * @param width must a double
	 * @param usage is the current usage of the habitat
	 * @param petInside the pet inside the habitat, starts as null
	 * @param cage is the type of cage, either hung or grounded
	 */
	public BirdHabitat(String habitatId, double length, double width, Usage usage, Pet petInside, Cage cage) {
		
		super(habitatId, length, width, usage, petInside);
		this.setCage(cage);
	}

	//---GETTERS AND SETTERS
	/**
	 * Method to call the habitat's Cage type
	 * @return habitat's Cage type
	 */
	public Cage getCage() {
		return cage;
	}

	/**
	 * Method to change the habitat's Cage type
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
