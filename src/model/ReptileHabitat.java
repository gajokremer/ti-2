package model;

/**
 * Reptile habitat class <br>
 * Subclass of Habitat
 * @author gajok
 */
public class ReptileHabitat extends Habitat {

	//---ATTRIBUTES
	private Aquarium aquarium;
	private String material;
	
	//---RELATIONS
	//EMPTY
	
	//---CONSTRUCTOR
	/**
	 * Used to construct ReptileHabitat
	 * @param habitatId must be "Rp" and a number from 1 to 4
	 * @param length must be a number, and can have decimals
	 * @param width must a number, and can have decimals
	 * @param usage is the current usage of the habitat
	 * @param petInside can be a Pet or a SickPet, starts as null
	 * @param aquarium must be either "Amphibian" or "Terrestrial"
	 * @param material is the material of the aquarium
	 */
	public ReptileHabitat(String habitatId, double length, double width, Usage usage, Pet petInside, 
			Aquarium aquarium, String material) {
		
		super(habitatId, length, width, usage, petInside);
		this.setAquarium(aquarium);
		this.setMaterial(material);
	}

	//---GETTERS AND SETTERS
	/**
	 * Method to call for the type of an Aquarium.
	 * @return type of Aquarium
	 */
	public Aquarium getAquarium() {
		return aquarium;
	}
	/**
	 * Method to change the type of an Aquarium.
	 * @param aquarium must be either "Amphibian" or "Terrestrial"
	 */
	public void setAquarium(Aquarium aquarium) {
		this.aquarium = aquarium;
	}
	
	
	/**
	 * Method to call for the material of an Aquarium.
	 * @return material of Aquarium
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * Method to change the material of an Aquarium.
	 * @param material is the material of the aquarium
	 */
	public void setMaterial(String material) {
		this.material = material;
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
			"\nAquarium type: " + getAquarium() + 
			"\nMaterial: " + getMaterial();
		
		return out;
	}
}
