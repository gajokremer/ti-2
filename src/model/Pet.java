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
	
	//---RELATIONS
	private Owner ownedBy;
	
	//---CONSTRUCTOR
	/**
	 * Used to construct Pet object.
	 * @param species must be an animal species
	 * @param petName must be a String, can contain more than one word
	 * @param age must be an integer
	 * @param breed if species is dog or cat, must be a String, else it's null
	 * @param ownedBy must exist, if not program will ask user to create it
	 */
	public Pet(String species, String petName, int age, String breed, Owner ownedBy) {
		
		this.setSpecies(species);
		this.setPetName(petName);
		this.setAge(age);
		this.setBreed(breed);
		this.setOwnedBy(ownedBy);
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
	

	//---TO STRING
	@Override
	public String toString() {
		
		String out = 
				"\nSpecies: " + getSpecies() + 
				"\nName: " + getPetName() + 
				"\nAge: " + getAge() + 
				"\nBreed: " + getBreed() +
				"\nOwner: " + getOwnedBy().getFullName(); 
			
			return out;
	}
}
