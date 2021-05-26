package model;

public class CatHabitat extends Habitat{
	
	//ATTRIBUTES
	private double height;
	private double maxWeight;
	
	//RELATIONS

	//CONSTRUCTOR
	public CatHabitat(String habitatId, double leight, double width, Usage usage, Pet petInside, double height, double maxWeight) {
		
		super(habitatId, leight, width, usage, petInside);
		this.setHeight(height);
		this.setMaxWeight(maxWeight);
	}
	
	//GETTERS AND SETTERS
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
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
			"\nHeight: " + getHeight() + 
			"\nMax weight: " + getMaxWeight();
		
		return out;
	}
}
