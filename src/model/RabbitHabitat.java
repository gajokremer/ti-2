package model;

/**
 * Rabbit habitat class <br>
 * Subclass of Habitat
 * @author gajok
 */
public class RabbitHabitat extends Habitat{
	
	//---ATTRIBUTES
	
	//---RELATIONS
	private Plant plant;
	
	//---CONSTRUCTOR
	/**
	 * Used to construct RabbitHabitat.
	 * @param habitatId must be "Rb" and a number from 1 to 4
	 * @param length must be a number, and can have decimals
	 * @param width must a number, and can have decimals
	 * @param usage is the current usage of the habitat
	 * @param petInside can be a Pet or a SickPet, starts as null
	 * @param plant must be a Plant type and have a quantity
	 */
	public RabbitHabitat(String habitatId, double length, double width, Usage usage, Pet petInside, Plant plant) {
		
		super(habitatId, length, width, usage, petInside);
		this.setPlant(plant);
	}


	//---GETTERS AND SETTERS
	/**
	 * Method to call for the Plant inside an Habitat.
	 * @return Plant inside an Habitat
	 */
	public Plant getPlant() {
		return plant;
	}
	/**
	 * Method to change the Plant inside an Habitat.
	 * @param plant must be a Plant type and have a quantity
	 */
	public void setPlant(Plant plant) {
		this.plant = plant;
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
					
		out += getPlant().toString();
		
		return out;
	}
}
