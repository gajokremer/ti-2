package model;

/**
 * Cat habitat class <br>
 * Subclass of Habitat
 * @author gajok
 */
public class CatHabitat extends Habitat{
	
	//---ATTRIBUTES
	private double height;
	private double maxWeight;
	
	//---RELATIONS
	//EMPTY

	//---CONSTRUCTOR
	/**
	 * 
	 * Used to construct CatHabitat.
	 * @param habitatId must be "C" and a number from 1 to 9
	 * @param length must be a number, and can have decimals
	 * @param width must a number, and can have decimals
	 * @param usage is the current usage of the habitat
	 * @param petInside can be a Pet or a SickPet, starts as null
	 * @param height must be a number, and can have decimals
	 * @param maxWeight must be a number and can have decimals
	 */
	public CatHabitat(String habitatId, double length, double width, Usage usage, Pet petInside, double height, double maxWeight) {
		
		super(habitatId, height, width, usage, petInside);
		this.setHeight(height);
		this.setMaxWeight(maxWeight);
	}
	
	
	//GETTERS AND SETTERS
	/**
	 * Method to call for an Habitat's height.
	 * @return Habitat's height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * Method to change an Habitat's height.
	 * @param height must be a number, can have decimals
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	
	/**
	 * Method call for an Habitat's max weight.
	 * @return Habitat's max weight
	 */
	public double getMaxWeight() {
		return maxWeight;
	}
	/**
	 * Method to change an Habitat's max weight.
	 * @param maxWeight must be a number and can have decimals
	 */
	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
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
			"\nHeight: " + getHeight() + 
			"\nMax weight: " + getMaxWeight();
		
		return out;
	}
}
