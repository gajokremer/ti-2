package model;

public abstract class Habitat {

	//ATTRIBUTES
	private String habitatId;
	private double length;
	private double width;
	private Usage usage;
	
	//RELATIONS
	
	//CONSTRUCTOR
	public Habitat(String habitatId, double length, double width, Usage usage) {
		
		this.setHabitatId(habitatId);
		this.setLength(length);
		this.setWidth(width);
		this.setUsage(usage);
	}

	//GETTERS AND SETTERS
	public String getHabitatId() {
		return habitatId;
	}

	public void setHabitatId(String habitatId) {
		this.habitatId = habitatId;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public Usage getUsage() {
		return usage;
	}

	public void setUsage(Usage usage) {
		this.usage = usage;
	}
	
	//TO STRING
	@Override
	public String toString() {
		
		String out = 
			"\nHabitatId: " + getHabitatId() + 
			"\nLength: " + getLength() + 
			"\nWidth: " + getWidth() + 
			"\nCurrent usage: " + getUsage();
		
		return out;
	}
}