package ui;

import java.util.Scanner;

import model.PetCenter;
import model.Priority;
import model.Status;

import model.PetNursery;
//import model.Aquarium;
//import model.Cage;
//import model.Usage;


/**
 * Main class
 * @author gajok
 */
public class Main {

	//---RELATIONS
	private PetCenter center;
	private PetNursery nursery;
	private Scanner sc;

	//---CONSTRUCTOR
	/**
	 * Used to construct Main object.
	 */
	public Main() {

		sc = new Scanner(System.in);
		center = new PetCenter();
		nursery = new PetNursery();
		center.setCenterToNursery(nursery);
	}

	
	//---MAIN
	/**
	 * Main method.
	 * @param args .
	 */
	public static void main(String [] args) {

		System.out.println("\n----------APPLICATION STARTS----------\n");

		Main principal = new Main();

		int option = 0;

		do{
			
			option = principal.mainMenu();
			principal.executeOption(option);

		}while (option != 0);
	}

	
	/**
	 * Method to initialize the Main menu.
	 * @return integer with option to be executed
	 */
	public int mainMenu() {
		
		int option = 0;
		
		System.out.println("\n\n--------MAIN MENU--------\n");
		
		System.out.println(
				"\nSelect an option:\n" + 
				"(1) to enter Pet Center\n" + 
				"(2) to enter Nursery zone" + 
				
				"\n(0) to exit");
		
		option = sc.nextInt();
		sc.nextLine();
		
		return option;
	}
	
	
	/**
	 * Method to execute the given option in Main menu.
	 * @param option must be an integer
	 */
	public void executeOption(int option) {
		
		int anOption;
		
		switch(option) {
			
		case 0:
			System.out.println("\n-----OPERATION ENDED-----\n");
			break;
	
		case 1:
			do {
				
				anOption = petCenterMenu();
				petCenterOption(anOption);
				
			}while (anOption != 0);
			break;
			
		case 2:			
			do {
				
				anOption = petNurseryMenu();
				petNurseryOption(anOption);
				
			}while (anOption != 0);
			break;
		}
	}
	
	
	/**
	 * Method to initialize the Pet Center menu.
	 * @return integer with option to be executed
	 */
	public int petCenterMenu() {

		int option = 0;

		System.out.println("\n\n-----PET CENTER MENU-----\n");

		System.out.println("---Total attended pets: " + center.getTotalAttended());

		System.out.println("---Pending for attendance: " + center.attentionPending());

		System.out.println("---Next in list: " + center.nextAttendant());

		System.out.println(
			"\nSelect an option:" + 
			"\n(1) to add a new Veterinarian" +
			"\n(2) to delete a Veterinarian" +  
			"\n(10) to print all Veterinarians\n" + 

			"\n(3) to register a new Pet" +
			"\n(4) to retire a Pet" +
			"\n(30) to print all Pets\n" +  
			
			"\n(5) to register an Owner" + 
			"\n(50) to print all Owners\n" + 

			"\n(6) to start a new consultation" + 
			"\n(7) to end a consultation\n" + 
			
			"\n(8) to close center and print reports\n" + 

			"\n(0) to return to Main Menu");
		
		/*
		 ---SECRET FUNCTIONS
		 (35) to delete a Pet
		 (55) to delete an Owner
		*/

		option = sc.nextInt();
		sc.nextLine();

		return option;
	}

	
	/**
	 * Method to execute the given option in Pet Center menu.
	 * @param option must be an integer
	 */
	public void petCenterOption(int option) {

		switch(option) {
			
		case 0:
			System.out.println("\n-----RETURN TO MAIN MENU-----\n");
			break;
			
		case 1:
			registerVeterinarian();
			break;

		case 2:
			deleteVeterinarian();
			break; 

		case 3:
			registerPet();
			break;
			
		case 4:
			retirePet();
			break;
			
		case 5:
			registerOwner();
			break;
			
		case 6:
			startConsultation();
			break;

		case 7:
			endConsultation();
			break;
			
		case 8:
			closingReports();
			break;

		case 10:
			System.out.print("\n---ALL VETERINARIANS---\n");
			System.out.println(center.printAllVeterinarians());
			break;

		case 30:
			System.out.print("\n---ALL PETS---\n");
			System.out.println(center.printAllPets());
			break;

		case 35:
			System.out.println("\n---HIDDEN FUNCTION---");
			System.out.println("\n---DELETE PET---\n");
			deletePet();
			break;
			
		case 50:
			System.out.print("\n---ALL OWNERS---\n");
			System.out.println(center.printAllOwners());
			break;
			
		case 55:
			System.out.println("\n---HIDDEN FUNCTION---");
			System.out.println("\n---DELETE OWNER---\n");
			deleteOwner();
			break;
		}
	}
	

	/**
	 * Method used to ask the user for a Veterinarian's information.
	 */
	public void registerVeterinarian() {

		System.out.println("\n---NEW VETERINARIAN---");

		String idNumber, fullName, registerNumber;
		int attendedPets = 0;

		System.out.print("Input full name: ");
		fullName = sc.nextLine();

		System.out.print("Input ID: ");
		idNumber = sc.nextLine();

		System.out.print("Input unique register number: ");
		registerNumber = sc.nextLine();

		System.out.println(center.addVeterinarian(idNumber, fullName, registerNumber, attendedPets));
	}

	
	/**
	 * Method to ask for the ID of the Veterinarian to be deleted.
	 */
	public void deleteVeterinarian() {

		System.out.println("\n---DELETE VETERINARIAN---");

		System.out.print("\nInput ID number of the veterinarian to be deleted: ");
		String idNumber = sc.nextLine();

		System.out.println(center.eraseVeterinarian(idNumber));
	}
	
	
	/**
	 * Method to ask for the Information of a Pet.
	 */
	public void registerPet() {
		
		System.out.println("\n---REGISTER PET---");

		String species, petName, breed, symptoms;
		int age;
		Priority priority = null;
		Status status;
		String temp;

		System.out.print("Input species: ");
		species = sc.nextLine();

		System.out.print("Input Pet name: ");
		petName = sc.nextLine();
		
		if(center.repeatedPet(petName) == true) {
			
			do {
				
				System.out.println("\nPet name already exists, input a new one");
				System.out.print("Input Pet name: ");
				petName = sc.nextLine();
				
			} while(center.repeatedPet(petName) == true);
		}

		System.out.print("Input age: ");
		age = sc.nextInt();

		if(species.equalsIgnoreCase("Dog") || species.equalsIgnoreCase("Cat")) {

			sc.nextLine();
			System.out.print("Input breed: ");
			breed = sc.nextLine();

		}else{

			breed = null;
			sc.nextLine();
		}

		System.out.print("Input symptoms: ");
		symptoms = sc.nextLine();

		System.out.print("Input priority level: ");
		temp = sc.nextLine();

		status = Status.WAITING;


		if(temp.equalsIgnoreCase("Red") || temp.equals("1")) {

			priority = Priority.RED_1;
		}

		if(temp.equalsIgnoreCase("Orange") || temp.equals("2")) {

			priority = Priority.ORANGE_2;
		}

		if(temp.equalsIgnoreCase("Yellow") || temp.equals("3")) {

			priority = Priority.YELLOW_3;
		}

		if(temp.equalsIgnoreCase("Green") || temp.equals("4")) {

			priority = Priority.GREEN_4;
		}

		if(temp.equalsIgnoreCase("Blue") || temp.equals("5")) {

			priority = Priority.BLUE_5;
		}
		
		System.out.print("Input owner's name: ");
		String ownerName = sc.nextLine();
		
		String ownerId = null;
		String ownerPhone = null;
		String ownerAddress = null;
		
		if(center.getTotalOwners() == 0 || center.ownerExists(ownerName) == false) {
			
			System.out.println("\n---This owner doesn't exist, create it");
			
			System.out.print("Input ID: ");
			ownerId = sc.nextLine();

			System.out.print("Input phone number: ");
			ownerPhone = sc.nextLine();

			System.out.print("Input adress: ");
			ownerAddress = sc.nextLine();
		}
		
		System.out.println(center.addPet(species, petName, age, breed, symptoms, priority, status,
				ownerName, ownerId, ownerPhone, ownerAddress));
	}
	
	/**
	 * Method to retire a Pet from the center.
	 */
	public void retirePet() {
		
		System.out.println("\n---RETIRE PET---");
		
		String petName = null;
		
		System.out.print("\nInput name of pet to be retired: ");
		petName = sc.nextLine();
		
		center.retireThisPet(petName);		
	}
	
	
	/**
	 * Method to ask for the information of an Owner.
	 */
	public void registerOwner() {
		
		System.out.println("\n---OWNER DATA---");

		String idNumber, fullName, phone, address;
	
		System.out.print("Input full name: ");
		fullName = sc.nextLine();
		
		if(center.repeatedOwner(fullName) == true) {
			
			do {
				
				System.out.println("\nOwner name already exists, input a new one");
				System.out.print("Input full name: ");
				fullName = sc.nextLine();
				
			}while(center.repeatedOwner(fullName) == true);
		}
		
		System.out.print("Input ID: ");
		idNumber = sc.nextLine();

		System.out.print("Input phone number: ");
		phone = sc.nextLine();

		System.out.print("Input adress: ");
		address = sc.nextLine();

		System.out.println(center.addOwner(idNumber, fullName, phone, address));
	}

	
	/**
	 * <b> Hidden function. </b> <br>
	 * Method to ask for the name of the Pet to be deleted.
	 */
	public void deletePet() {

		System.out.println("\n---DELETE PET---");

		//center.printAllPets();

		System.out.print("\nInput name of pet to be deleted: ");
		String petName = sc.nextLine();

		center.erasePet(petName);
	}
	
	
	/**
	 * <b> Hidden function. </b> <br>
	 * Method to ask for the name of the Owner to be deleted.
	 */
	public void deleteOwner() {
		
		System.out.println("\n---DELETE OWNER---");
		
		System.out.print("\nInput name of owner to be deleted: ");
		String fullName = sc.nextLine();
		
		center.eraseOwner(fullName);
	}
	
	
	/**
	 * Method to start a consultation via a Pet's name and the Veterinarians ID.
	 */
	public void startConsultation() {

		System.out.println("\n---NEW CONSULTATION---");

		String petName, idNumber;
		Status status;

		System.out.print("Input Pet name: ");
		petName = sc.nextLine();

		System.out.print("Input Veterinarian's ID: ");
		idNumber = sc.nextLine();

		status = Status.CONSULTING;

		System.out.println(center.newConsultation(petName, idNumber, status));
	}

	/**
	 * Method to end a consultation via a Pet's name and the Veterinarians ID. <br>
	 * Asks user for new pet Status
	 */
	public void endConsultation() {

		System.out.println("\n---END CONSULTATION---");

		String petName, idNumber;
		String newStatus;

		System.out.print("Input Pet name: ");
		petName = sc.nextLine();
		
		System.out.print("Input Veterinarian's ID: ");
		idNumber = sc.nextLine();

		System.out.print("Input new pet status: ");
		newStatus = sc.nextLine();
		
		Status status = Status.valueOf(newStatus.toUpperCase());

		System.out.println(center.finishConsultation(petName, idNumber, status));
	}
	
	
	/**
	 * Method to close the center and show the reports.
	 */
	public void closingReports() {
		
		System.out.println("\n---CLOSING REPORTS---");
		
		if(center.attentionPending() == 0) {
			
			System.out.println("\nHighest attendor: " + center.mostAttended());
			center.petsPerPriority();
			System.out.println("\nPercentage of unattended pets: " + center.unattendedPercentage() + "%");
			center.resetPetsandOwners();
			
		}else {
			
			System.out.println("\nERROR: Center can't be closed. There are still pending pets");
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * Method to initialize the Nursery menu.
	 * @return integer with option to be executed
	 */
	public int petNurseryMenu() {
		
		int option = 0;
		
		System.out.println("\n\n-----NURSERY MENU-----\n");
		
		System.out.println(
				"\nSelect an option:" + 
		
				"\n(-1) for scenario" + 
				"\n(1) to register a new Pet\n" + 
				
				"\n(2) to print all Nursery Pets" + 
				"\n(3) to print all Nursery Owners\n" + 
				
				"\n(4) to find a Pet's location" + 
				"\n(5) to show a specific Habitat's info\n" +
				
				"\n(6) to print all Habitats matrix" + 
				"\n(7) to print all Habitats in list format\n" +
				
				"\n(8) to print Habitat ocuppation reports\n" + 
		
				"\n(0) to return to Main Menu");
		
		option = sc.nextInt();
		sc.nextLine();
		
		return option;
	}
	
	
	/**
	 * Method to execute the given option in Nursery menu.
	 * @param option must be an integer
	 */
	public void petNurseryOption(int option) {
		
		switch(option) {
		
		case 0:
			System.out.println("\n-----RETURN TO MAIN MENU-----\n");
			break;
			
		case -1:
			createNurseryScenario();
			break;
			
		case 1:
			registerPetToNursery();
			break;
			
		case 2:
			System.out.print("\n---ALL PETS---\n");
			System.out.println(nursery.printAllPets());
			break;
			
		case 3:
			System.out.print("\n---ALL OWNERS---\n");
			System.out.println(nursery.printAllOwners());
			break;
			
		case 4:
			findPet();
			break;
			
		case 5:
			showHabitat();
			break;
			
		case 6:
			System.out.print("\n---HABITATS MATRIX---\n");
			System.out.println(nursery.printHabitatsMatrix());
			break;
			
		case 7:
			System.out.print("\n---HABITATS LIST---\n");
			System.out.println(nursery.printHabitatsList());
			break;
			
		case 8:
			System.out.print("\n---HABITAT OCCUPATION REPORTS---\n");
			
			System.out.println("\n---Cat habitats: " + nursery.catOccupation() + "%");
			System.out.println("---Dog habitats: " + nursery.dogOccupation() + "%");
			System.out.println("---Reptile habitats: " + nursery.reptileOccupation() + "%");
			System.out.println("---Rabbit habitats: " + nursery.rabbitOccupation() + "%");
			System.out.println("---Bird habitats: " + nursery.birdOccupation() + "%");
			
			System.out.println("\n---Total occupation: " + nursery.totalOccupation() + "%");
			
			System.out.println("\n---Healthy pets: " + nursery.percentageHealthy() + "%");
			System.out.println("\n---Sick pets: " + nursery.percentageSick() + "%");
			break;
		}
	}
	
	
	/**
//	 * Method to transfer a Pet to Nursery
//	 */
//	public void petToNursery() {
//	
//		System.out.println("\n---TRANSFER PET TO NURSERY---");
//		
//		String petName;
//		
//		System.out.print("Input Pet name: ");
//		petName = sc.nextLine();
//		
//		center.transferToNursery(petName);
//	}
	
	public void registerPetToNursery() {
		
		System.out.println("\n---REGISTER PET---");

		String species, petName, breed; 
		int age;
		
		System.out.print("Input species: ");
		species = sc.nextLine();

		System.out.print("Input Pet name: ");
		petName = sc.nextLine();
		
		System.out.print("Input age: ");
		age = sc.nextInt();
		
		if(species.equalsIgnoreCase("Dog") || species.equalsIgnoreCase("Cat")) {

			sc.nextLine();
			System.out.print("Input breed: ");
			breed = sc.nextLine();

		}else{

			breed = null;
			sc.nextLine();
		}
		
		String ownerId = null;
		String ownerPhone = null;
		String ownerAddress = null;
		
		System.out.print("Input owner's name: ");
		String ownerName = sc.nextLine();
		
		if(nursery.ownerExists(ownerName) == false) {
			
			System.out.println("\n---This owner doesn't exist, create it");
			
			System.out.print("Input ID: ");
			ownerId = sc.nextLine();

			System.out.print("Input phone number: ");
			ownerPhone = sc.nextLine();

			System.out.print("Input adress: ");
			ownerAddress = sc.nextLine();
		}
		
		
		System.out.println(nursery.addPet(species, petName, age, breed, ownerName, ownerId, ownerPhone, ownerAddress));
	}
	
	public void findPet() {
		
		System.out.println("\n---FIND PET---");
		
		String petName;
		
		System.out.print("Input Pet name: ");
		petName = sc.nextLine();
		
		System.out.println(nursery.petLocation(petName));
	}
	
	public void showHabitat() {
		
		System.out.println("\n---FIND HABITAT---");
		
		String habitatId;
		
		System.out.print("Input habitat ID: ");
		habitatId = sc.nextLine();
				
		System.out.println(nursery.habitatInfo(habitatId));
	}
	
	
	
	
	public  void createNurseryScenario() {
		
		Test scenario = new Test();
		scenario.createScenario1(nursery, center);
	}
}