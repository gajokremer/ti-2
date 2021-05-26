package model;

public class ReptileHabitat extends Habitat {

	//ATTRIBUTES
	private Aquarium aquarium;
	private String material;
	
	//RELATIONS
	
	//CONSTRUCTOR
	public ReptileHabitat(String habitatId, double length, double width, Usage usage, Pet petInside, 
			Aquarium aquarium, String material) {
		
		super(habitatId, length, width, usage, petInside);
		this.setAquarium(aquarium);
		this.setMaterial(material);
	}

	//GETTERS AND SETTERS
	public Aquarium getAquarium() {
		return aquarium;
	}

	public void setAquarium(Aquarium aquarium) {
		this.aquarium = aquarium;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	//TO STRING
	@Override
	public String toString() {
		
		String out = 
			"\nHabitat ID: " + getHabitatId() + 
			"\nLength: " + getLength() + 
			"\nWidth: " + getWidth() + 
			"\nCurrent usage: " + getUsage() + 
			"\nPet inside: " + getPetInside().getPetName() + 
			"\nAquarium type: " + getAquarium() + 
			"\nMaterial: " + getMaterial();
		
		return out;
	}
}
