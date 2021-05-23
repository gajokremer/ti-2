package model;

public class Plant {
	
	//ATTRIBUTES
	private String type;
	private int quantity;
	
	//RELATIONS
	
	//CONSTRUCTOR
	public Plant(String type, int quantity) {
		
		this.setType(type);
		this.setQuantity(quantity);
	}

	//GETTERS AND SETTERS
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
