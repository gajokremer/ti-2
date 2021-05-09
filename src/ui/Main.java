package ui;

import java.util.Scanner;

import model.PetCenter;
import model.Priority;
import model.Status;


/**
 * Main class
 * @author gajok
 */
public class Main{

	//---RELATIONS
	private PetCenter center;
	private Scanner sc;

	//---CONSTRUCTOR
	/**
	 * Used to construct Main object.
	 */
	public Main() {

		sc = new Scanner(System.in);
		center = new PetCenter();
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
	 * Method to initialize the main menu.
	 * @return integer with option to be executed
	 */
	public int mainMenu() {

		int option = 0;

		System.out.println("\n\n-----MAIN MENU-----\n");

		System.out.println("---Total attended pets: " + center.getTotalAttended());

		System.out.println("---Pending for attendance: " + center.attentionPending());

		System.out.println("---Next in list: " + center.nextAttendant());

		System.out.println(
			"\nSelect an option:\n" + 
			"(1) to add a new Veterinarian\n" +
			"(2) to delete a Veterinarian\n" +  
			"(10) to print all Veterinarians\n" + 

			"\n(3) to register a new Pet\n" +
			"(4) to delete a Pet\n" +
			"(30) to print all Pets\n" +  
			
			"\n(5) to register an Owner\n" + 
			"(6) to delete an Owner\n" + 
			"(50) to print all Owners\n" + 

			"\n(7) to start a new consultation\n" + 
			"(8) to end a consultation\n" + 
			
			"\n(9) to close center and print reports\n" + 

			"\n(0) to exit");

		option = sc.nextInt();
		sc.nextLine();

		return option;
	}

	
	/**
	 * Method to execute the given operation.
	 * @param operation must be an integer
	 */
	public void executeOption(int operation) {

		switch(operation) {
			
			case 0:
				System.out.println("\n-----OPERATION ENDED-----\n");
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
				deletePet();
				break;
				
			case 5:
				registerOwner();
				break;
				
			case 6:
				deleteOwner();
				break;

			case 7:
				startConsultation();
				break;

			case 8:
				endConsultation();
				break;
				
			case 9:
				closingReports();
				break;

			case 10:
				System.out.print("\n---ALL VETERINARIANS---\n");
				center.printAllVeterinarians();
				break;

			case 30:
				System.out.print("\n---ALL PETS---\n");
				center.printAllPets();
				break;

			case 50:
				System.out.print("\n---ALL OWNERS---\n");
				center.printAllOwners();
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

		String attendingNow = null;

		center.addVeterinarian(idNumber, fullName, registerNumber, attendedPets, attendingNow);
	}

	
	/**
	 * Method to ask for the ID of the Veterinarian to be deleted.
	 */
	public void deleteVeterinarian() {

		System.out.println("\n---DELETE VETERINARIAN---");

		//center.printAllVeterinarians();

		System.out.print("\nInput ID number of the veterinarian to be deleted: ");
		String idNumber = sc.nextLine();

		center.eraseVeterinarian(idNumber);
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
		String attendedById;
		String temp;

		System.out.print("Input species: ");
		species = sc.nextLine();

		System.out.print("Input name: ");
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

		attendedById = null;

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
		
		center.addPet(species, petName, age, breed, symptoms, priority, status, ownerName, ownerId, ownerPhone, ownerAddress, attendedById);
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

		center.addOwner(idNumber, fullName, phone, address);
	}

	
	/**
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

		center.newConsultation(petName, idNumber, status);
	}

	/**
	 * Method to end a consultation via a Pet's name and the Veterinarians ID. <br>
	 * Asks user for new pet Status
	 */
	public void endConsultation() {

		System.out.println("\n---END CONSULTATION---");

		String petName, idNumber;
		String status;

		System.out.print("Input Pet name: ");
		petName = sc.nextLine();
		
		System.out.print("Input Veterinarian's ID: ");
		idNumber = sc.nextLine();

		System.out.print("Input new pet status: ");
		status = sc.nextLine();

		center.finishConsultation(petName, idNumber, status);
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
			center.resetPets();
			
		}else {
			
			System.out.println("\nERROR: there are still pending pets");
		}
	}
}