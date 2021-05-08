package model;

public class Veterinarian{

	//attributes
	private String idNumber;
	private String fullName;
	private String registerNumber;
	private int attendedPets;
	private String attendingNow;

	//relations
	private Pet attends;

	//constructor
	public Veterinarian(String idNumber, String fullName, String registerNumber, 
		int attendedPets, String attendingNow, Pet attends) {
		
		this.idNumber = idNumber;
		this.fullName = fullName;
		this.registerNumber = registerNumber;
		this.attendedPets = attendedPets;
		//this.attendingNow = attendingNow;
		this.attends = attends;
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

	public String getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public int getAttendedPets() {
		return attendedPets;
	}
	public void setAttendedPets(int attendedPets) {
		this.attendedPets = attendedPets;
	}

	public String getAttendingNow() {
		return attendingNow;		
	}
	public void setAttendingNow(String attendingNow) {
		this.attendingNow = attendingNow;
	}

	public Pet getAttends() {
		return attends;
	}
	public void setAttends(Pet attends) {
		this.attends = attends;
	}

	//to String
	@Override
	public String toString() {

		String out = "Name: " + getFullName() + 
			"\nID: " + getIdNumber() + 
			"\nAttended pets: " + getAttendedPets() + 
			"\nAttending now: " + getAttendingNow();

		return out;
	}
} 