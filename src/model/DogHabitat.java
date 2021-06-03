package model;

/**
 * Dog habitat class <br>
 * Subclass of Habitat
 * @author gajok
 */
public class DogHabitat extends Habitat{
	
	//ATTRIBUTES
	private int toys;
	
	//RELATIONS
	
	//CONSTRUCTOR
	/**
	 * Used to construct DogHabitat.
	 * @param habitatId must be "D" and a number from 1 to 9
	 * @param length must be a number, and can have decimals
	 * @param width must a number, and can have decimals
	 * @param usage is the current usage of the habitat
	 * @param petInside can be a Pet or a SickPet, starts as null
	 * @param toys must be a number
	 */
	public DogHabitat(String habitatId, double length, double width, Usage usage, Pet petInside, int toys) {
		
		super(habitatId, length, width, usage, petInside);
		this.setToys(toys);
	}
	
	
	//GETTERS AND SETTERS
	/**
	 * Method to call for an Habitat's available toys.
	 * @return Habitat's available toys
	 */
	public int getToys() {
		return toys;
	}
	/**
	 * Method to change an Habitat's available toys.
	 * @param toys must be a number	
	 */
	public void setToys(int toys) {
		this.toys = toys;
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
			
		out += "\nAvailable toys: " + getToys();
		
		return out;
	}
}
