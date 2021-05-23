package model;

/**
 * Veterinarian class
 * @author gajok
 */
public class Veterinarian {

	//---ATTRIBUTES
	private String idNumber;
	private String fullName;
	private String registerNumber;
	private int attendedPets;
	private String attendingNow;

	//---RELATIONS
	private Pet attends;

	//---CONSTRUCTOR
	/**
	 * Used to construct Veterinarian object.
	 * @param idNumber must be a String composed of numbers
	 * @param fullName must have name and surname included
	 * @param registerNumber must be a String which can combine letters and numbers
	 * @param attendedPets must be 0 when object is created
	 * @param attendingNow must be an empty String, later contains name of Pet being attended
	 * @param attends must start as null, later contains Pet being attended
	 */
	public Veterinarian(String idNumber, String fullName, String registerNumber, 
		int attendedPets, String attendingNow, Pet attends) {
		
		this.idNumber = idNumber;
		this.fullName = fullName;
		this.registerNumber = registerNumber;
		this.attendedPets = attendedPets;
		this.attendingNow = attendingNow;
		this.attends = attends;
	}
	

	//---GETTERS AND SETTERS
	/**
	 * Method to call a Veterinarians ID number.
	 * @return Veterinarian's ID number
	 */
	public String getIdNumber() {
		return idNumber;
	}
	/**
	 * Method to change a Veterinarians ID number.
	 * @param idNumber must exist and be a String composed of numbers
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	
	/**
	 * Method to call a Veterinarian's full name.
	 * @return Veterinarian's full name
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * Method to change a Veterinarian's full name.
	 * @param fullName must exist and be a String containing name and surname
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	/**
	 * Method to call a Veterinarian's register number.
	 * @return Veterinarian's register number
	 */
	public String getRegisterNumber() {
		return registerNumber;
	}
	/**
	 * Method to change a Veterinarian's register number.
	 * @param registerNumber must exist and can combine letters and numbers
	 */
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	

	/**
	 * Method to call a Veterinarian's attended Pets.
	 * @return Veterinarian's attended Pets
	 */
	public int getAttendedPets() {
		return attendedPets;
	}
	/**
	 * Method to change a Veterinarian's attended Pets.
	 * @param attendedPets must exist and be a number
	 */
	public void setAttendedPets(int attendedPets) {
		this.attendedPets = attendedPets;
	}
	
	
	/**
	 * Method to call the name of the Pet being attended by a Veterinarian.
	 * @return Name of pet being attended
	 */
	public String getAttendingNow() {
		return attendingNow;		
	}
	/**
	 * Method to change the name of the Pet being attended by a Veterinarian.
	 * @param attendingNow must exist and be a name, can have several words, can be null
	 */
	public void setAttendingNow(String attendingNow) {
		this.attendingNow = attendingNow;
	}
	
	
	/**
	 * Method to call the Pet being attended by a Veterinarian.
	 * @return Pet being attended by a Veterinarian
	 */
	public Pet getAttends() {
		return attends;
	}
	/**
	 * Method to change the Pet being attended by a Veterinarian.
	 * @param attends must exist, but can be null.
	 */
	public void setAttends(Pet attends) {
		this.attends = attends;
	}
	

	//---TO STRING
	@Override
	public String toString() {

		String out = 
			"\nName: " + getFullName() + 
			"\nID: " + getIdNumber() + 
			"\nUnique number: " + getRegisterNumber() + 
			"\nAttended pets: " + getAttendedPets() + 
			"\nAttending now: " + getAttendingNow() + "\n";

		return out;
	}
} 