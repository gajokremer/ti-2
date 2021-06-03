package model;

/**
 * Habitat class
 * @author gajok
 */
public abstract class Habitat {

	//---ATTRIBUTES
	private String habitatId;
	private double length;
	private double width;
	private Usage usage;
	private Pet petInside;
	
	//---RELATIONS
	//EMPTY
	
	//CONSTRUCTOR
	/**
	 * Used to construct Habitat.
	 * @param habitatId must be a letter and a number
	 * @param length must be a number, and can have decimals
	 * @param width must a number, and can have decimals
	 * @param usage is the current usage of the habitat
	 * @param petInside can be a Pet or a SickPet, starts as null
	 */
	public Habitat(String habitatId, double length, double width, Usage usage, Pet petInside) {
		
		this.setHabitatId(habitatId);
		this.setLength(length);
		this.setWidth(width);
		this.setUsage(usage);
		this.setPetInside(petInside);
	}

	
	//---GETTERS AND SETTERS
	/**
	 * Method to call for an Habitat's ID.
	 * @return Habitat's ID
	 */
	public String getHabitatId() {
		return habitatId;
	}
	/**
	 * Method to change an Habitat's ID.
	 * @param habitatId must be a letter and a number
	 */
	public void setHabitatId(String habitatId) {
		this.habitatId = habitatId;
	}

	
	/**
	 * Method to call for an Habitat's length.
	 * @return Habitat's length
	 */
	public double getLength() {
		return length;
	}
	/**
	 * Method to change an Habitat's length.
	 * @param length must be a number, and can have decimals
	 */
	public void setLength(double length) {
		this.length = length;
	}

	
	/**
	 * Method to call for an Habitat's width.
	 * @return Habitat's width
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * Method to change an Habitat's width.
	 * @param width must a number, and can have decimals
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	
	/**
	 * Method to call for an Habitat's Usage.
	 * @return Habitat's Usage
	 */
	public Usage getUsage() {
		return usage;
	}
	/**
	 * Method to change an Habitat's Usage.
	 * @param usage is the current usage of the habitat
	 */
	public void setUsage(Usage usage) {
		this.usage = usage;
	}
	
	
	/**
	 * Method to call for the Pet inside an Habitat.
	 * @return Pet inside an Habitat
	 */
	public Pet getPetInside() {
		return petInside;
	}
	/**
	 * Method to change the Pet inside an Habitat.
	 * @param petInside can be a Pet or a SickPet, starts as null
	 */
	public void setPetInside(Pet petInside) {
		this.petInside = petInside;
	}
	
	
	//---TO STRING
	@Override
	public String toString() {
		
		String out = 
			"\nHabitat ID: " + getHabitatId() + 
			"\nLength: " + getLength() + 
			"\nWidth: " + getWidth() + 
			"\nCurrent usage: " + getUsage() + 
			"\nPet inside: " + petInside.getPetName();
		
		return out;
	}

}