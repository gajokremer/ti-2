package model;

/**
 * Pet class
 * @author gajok
 */
public class Pet {

	//---ATTRIBUTES
	private String species;
	private String petName;
	private int age;
	private String breed;
	private String symptoms;
	private String attendedById;
	private Priority priority;
	private Status status;

	//---RELATIONS
	private Owner ownedBy;
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
	 * @param attendedById must start as null, then will show ID of Veterinarian who attended the Pet
	 * @param attendedBy must start as null, then will store the Veterinarian who attended the Pet
	 */
	public Pet(String species, String petName, int age, String breed, String symptoms, 
		Priority priority, Status status, Owner ownedBy, String attendedById, Veterinarian attendedBy) {

		this.species = species;
		this.petName = petName;
		this.age = age;
		this.breed = breed;
		this.symptoms = symptoms;
		this.priority = priority;
		this.status = status;
		this.ownedBy = ownedBy;
		this.attendedById = attendedById;
		this.attendedBy = attendedBy;
	}
	

	//---GETTERS AND SETTERS
	/**
	 * Method to call a Pet's species.
	 * @return Pet's species
	 */
	public String getSpecies() {
		return species;
	}
	/**
	 * Method to change a Pet's species.
	 * @param species must exist and be a String containing a species name
	 */
	public void setSpecies(String species) {
		this.species = species;
	}
	
	
	/**
	 * Method to call a Pet's name.
	 * @return Pet's name
	 */
	public String getPetName() {
		return petName;
	}
	/**
	 * Method to change a Pet's name.
	 * @param petName must exist and be a String which can have more than one word
	 */
	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	
	/**
	 * Method to get a Pet's age.
	 * @return Pet's age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * Method to set a Pet's age.
	 * @param age must exist and be an integer
	 */
	public void setAge(int age) {
		this.age = age;
	}

	
	/**
	 * Method to call a Pet's breed.
	 * @return Pet's breed
	 */
	public String getBreed() {
		return breed;
	}
	/**
	 * Method to change a Pet's breed.
	 * @param breed must exist and be a String which can have more than one word
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}

	
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
	
	
	/**
	 * Method to call a Pet's Owner.
	 * @return Pet's owner
	 */
	public Owner getOwnedBy() {
		return ownedBy;
	}
	/**
	 * Method to change a Pet's Owner.
	 * @param ownedBy must exist, but can be null
	 */
	public void setOwnedBy(Owner ownedBy) {
		this.ownedBy = ownedBy;
	}

	
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
	
	/**
	 * Method to call the ID of the Veterinarian that attended a Pet.
	 * @return ID of the Veterinarian that attended a Pet
	 */
	public String getAttendedById() {
		return attendedById;
	}
	/**
	 * Method to call the ID of the Veterinarian that attended a Pet.
	 * @param attendedById must exist as a String composed of numbers, but can be null
	 */
	public void setAttendedById(String attendedById) {
		this.attendedById = attendedById;
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
			"\nOwner: " + ownedBy.getFullName() + 
			"\nAttended by: " + getAttendedById() + "\n";

		return out;
	}
}