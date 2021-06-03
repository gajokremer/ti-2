package model;

/**
 * Sick Pet class
 * Pet subclass
 * @author gajok
 */
public class SickPet extends Pet {
 
	//---ATTRIBUTES
	private String symptoms;
	private Priority priority;
	private Status status;

	//---RELATIONS
	private Veterinarian attendedBy;

	//---CONSTRUCTOR
	/**
	 * Used to construct Pet object.
	 * @param species must be an animal species
	 * @param petName must be a String, can contain more than one word
	 * @param age must be an integer
	 * @param breed if species is dog or cat, must be a String, else it's null
	 * @param symptoms must be a String, can be as long as the user needs
	 * @param priority must be one of five Priority options
	 * @param status must be "Waiting" when created, the can be changed to one of five Status options
	 * @param ownedBy must exist, if not program will ask user to create it
	 * @param attendedBy must start as null, then will store the Veterinarian who attended the Pet
	 */
	public SickPet(String species, String petName, int age, String breed, String symptoms, 
		Priority priority, Status status, Owner ownedBy, Veterinarian attendedBy) {

		super(species, petName, age, breed, ownedBy);
		this.setSymptoms(symptoms);
		this.setPriority(priority);
		this.setStatus(status);
		this.setAttendedBy(attendedBy);
	}


	//---GETTERS AND SETTERS	
	/**
	 * Method to call a Pet's symptoms.
	 * @return Pet's symptoms
	 */
	public String getSymptoms() {
		return symptoms;
	}
	/**
	 * Method to change a Pet's symptoms.
	 * @param symptoms must exist and can be as long as user needs
	 */
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	
	/**
	 * Method to call a Pet's Priority.
	 * @return Pet's priority
	 */
	public Priority getPriority() {
		return priority;
	}
	/**
	 * Method to change a Pet's Priority.
	 * @param priority must exist and be one of five Priority options
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	
	/**
	 * Method to get a Pet's status.
	 * @return Pet's status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * Method to change a Pet's Status.
	 * @param status must exist and be one of five Status options
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
//	/**
//	 * Method to call a Pet's Owner.
//	 * @return Pet's owner
//	 */
//	public Owner getOwnedBy() {
//		return ownedBy;
//	}
//	/**
//	 * Method to change a Pet's Owner.
//	 * @param ownedBy must exist, but can be null
//	 */
//	public void setOwnedBy(Owner ownedBy) {
//		this.ownedBy = ownedBy;
//	}

	
	/**
	 * Method to call the Veterinarian that attended a Pet.
	 * @return Veterinarian that attended a Pet
	 */
	public Veterinarian getAttendedBy() {
		return attendedBy;
	}
	/**
	 * Method to change the Veterinarian that attended a Pet.
	 * @param attendedBy must exist, but can be null
	 */
	public void setAttendedBy(Veterinarian attendedBy) {
		this.attendedBy = attendedBy;
	}
	

	//---TO STRING
	@Override
	public String toString() {

		String out = 
			"\nSpecies: " + getSpecies() + 
			"\nName: " + getPetName() + 
			"\nAge: " + getAge() + 
			"\nBreed: " + getBreed() +
			"\nSymptoms: " + getSymptoms() + 
			"\nPriority: " + getPriority() + 
			"\nStatus: " + getStatus() +
			"\nOwner: " + getOwnedBy().getFullName(); 
		
		if(getAttendedBy() != null) {
			
			out += "\nAttended by: " + getAttendedBy().getIdNumber();
			
		}else {
			
			out += "\nAttended by: None";
		}
		
		return out;
	}
}