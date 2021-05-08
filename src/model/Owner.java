package model;

public class Owner{

	//attributes
	private String idNumber;
	private String fullName;                                                         
	private String phone;
	private String address;

	//relations
	//EMPTY

	//constructor
	public Owner(String idNumber, String fullName, String phone, String address) {
		
		this.idNumber = idNumber;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
	}

	//getters and setters
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//to String
	@Override
	public String toString() {

		String out = "Name: " + getFullName() + 
			"\nID: " + getIdNumber() + 
			"\nPhone: " + getPhone() + 
			"\nAddress: " + getAddress();

		return out;
	}
}