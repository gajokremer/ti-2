package model;

/**
 * Owner class
 * @author gajok
 */
public class Owner {

	//---ATTRIBUTES
	private String idNumber;
	private String fullName;   
	private String phone;
	private String address;

	//---RELATIONS
	//EMPTY

	//---CONSTRUCTOR
	/**
	 * Used to construct Owner object.
	 * @param idNumber must be a String composed of numbers
	 * @param fullName must be a String with name and surname included
	 * @param phone must be a String with a phone number (10 digits)
	 * @param address must contain an address (words, numbers, symbols)
	 */
	public Owner(String idNumber, String fullName, String phone, String address) {
		
		this.idNumber = idNumber;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
	}
	

	//---GETTERS AND SETTER
	/**
	 * Method to call for an Owner's ID number.
	 * @return Owner's ID number
	 */
	public String getIdNumber() {
		return idNumber;
	}
	/**
	 * Method to change an Owner's ID number.
	 * @param idNumber must exist and be a String composed of numbers
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	
	/**
	 * Method to call for an Owner's full name.
	 * @return Owner's full name
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * Method to change an Owner's full name.
	 * @param fullName must exist and be a String containing name and surname
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	

	/**
	 * Method to call for an Owner's phone number.
	 * @return Owner's phone number
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Method to change an Owner's phone number.
	 * @param phone must exist and be a String of a phone number (10 numbers)
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	/**
	 * Method to call for an Owner's address.
	 * @return Owner's address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Method to change an Onwer's address.
	 * @param address must exist and can contain words, numbers, and/or symbols
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	

	//---TO STRING
	@Override
	public String toString() {

		String out = 
			"\nName: " + getFullName() + 
			"\nID: " + getIdNumber() + 
			"\nPhone: " + getPhone() + 
			"\nAddress: " + getAddress();

		return out;
	}
}