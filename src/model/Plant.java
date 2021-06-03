package model;

/**
 * Plant class
 * @author gajok
 */
public class Plant {
	
	//---ATTRIBUTES
	private String type;
	private int quantity;
	
	//---RELATIONS
	//EMPTY
	
	//---CONSTRUCTOR
	/**
	 * Used to construct Plant object.
	 * @param type must be the name of a plant species
	 * @param quantity must be a number
	 */
	public Plant(String type, int quantity) {
		
		this.setType(type);
		this.setQuantity(quantity);
	}

	
	//---GETTERS AND SETTERS
	/**
	 * Method to call for a Plant's type.
	 * @return Plant's type
	 */
	public String getType() {
		return type;
	}
	/**
	 * Method to change a Plant's type.
	 * @param type must be the name of a plant species
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	/**
	 * Method to call for the quantity of Plants.
	 * @return quantity of Plants
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Method to change the quantity of Plants.
	 * @param quantity must be a number
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	//---TO STRING
	@Override
	public String toString() {
		
		String out = 
				"\nPlant type: " + getType() + 
				"\nPant quantity: " + getQuantity();
			
			return out;
	}
}
