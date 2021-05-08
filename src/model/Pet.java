package model;

public class Pet{

	//attributes
	private String species;
	private String petName;
	private int age;
	private String breed;
	private String symptoms;
	private String attendedById;

	//relations
	private Priority priority;
	private Status status;
	private Owner ownedBy;
	private Veterinarian attendedBy;

	//constructor
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

	//getters and setters
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}

	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Owner getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(Owner ownedBy) {
		this.ownedBy = ownedBy;
	}

	public Veterinarian getAttendedBy() {
		return attendedBy;
	}
	public void setAttendedBy(Veterinarian attendedBy) {
		this.attendedBy = attendedBy;
	}

	public String getAttendedById() {
		return attendedById;
	}
	public void setAttendedById(String attendedById) {
		this.attendedById = attendedById;
	}

	//to String
	@Override
	public String toString() {

		String out = "Species: " + getSpecies() + 
			"\nName: " + getPetName() + 
			"\nAge: " + getAge() + 
			"\nBreed: " + getBreed() +
			"\nSymptoms: " + getSymptoms() + 
			"\nPriority: " + getPriority() + 
			"\nStatus: " + getStatus() + 
			"\nOwner: " + ownedBy.getFullName() + 
			"\nAttended by: " + getAttendedById();

		return out;
	}
}