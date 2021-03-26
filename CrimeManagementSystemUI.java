import java.util.Scanner;
import java.util.UUID;

public class CrimeManagementSystemUI {
    private static final String WELCOME_MESSAGE = "Welcome to the Crime Management System";
    private String[] mainMenuOptions = {"Create Account", "Login", "Find Case", "Add Crime", "Add Suspect not connected to a crime", "Edit Crime", "Edit suspect", "Logout"};
    private String[] crimeMenuOptions = {"Add Suspect", "Add Victim", "Add Witness", "Go back to the Main Menu"};
    private Scanner scanner;
    private CrimeManagementSystem system;
    
    CrimeManagementSystemUI() {
        scanner = new Scanner(System.in);
        system = new CrimeManagementSystem();
    }

    public void run() {
        System.out.println(WELCOME_MESSAGE);

        while(true) {
            displayMainMenu();

            int userCommand = getUserCommand(mainMenuOptions.length);

            if(userCommand == -1) {
                System.out.println("Not a valid command");
                continue;
            }

            if(userCommand == mainMenuOptions.length -1) {
                system.logout();
                break;
            }

            switch(userCommand) {
                case(0):
                    createAccount();
                    break;
                case(1):
                    login();
                    break;
                case(2):
                    findCase();
                    break;
                case(3):
                    addCrime();
                    break;
                case(4):
                    addSuspect(false);
                    break;
                case(5):
                    editCrime();
                    break;
                case(6):
                    editSuspect();
                    break;
            }
        }
    }

    private void displayMainMenu() {
		System.out.println("\n************ Main Menu *************");
		for(int i=0; i< mainMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + mainMenuOptions[i]);
		}
		System.out.println("\n");
	}
    private void displayCrimeMenu() {
        System.out.println("\n************ Crime Menu *************");
        for(int i=0; i< crimeMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + crimeMenuOptions[i]);
		}
		System.out.println("\n");
    }

    private int getUserCommand(int numCommands) {
        System.out.print("What would you like to do?: ");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;

        if(command >= 0 && command <= numCommands -1) return command;

        return -1;
    }

    private void createAccount() {
        while(true) {
            String username = getField("Username");
            String password = getField("Password");
            if(system.userCheck(username, password)) {
                String name = getField("Name");
                String title = getField("Title");
                String race = getField("Race");
                String dob = getField("dob (mm/dd/yyyy)");
                String address = getField("Address");
                if(system.createAccount(name, title, race, dob, address, password, username)) {
                    System.out.println("You have successfully created an account");
                } 
                break;
            }
            else {
                System.out.println("Sorry an account with that username and password already exists");
            }
        }
    }

    private void login() {
        String username = getField("Username");
        String password = getField("Password");

        if(system.login(username, password)) {
            User currentUser = system.getCurrentUser();
            System.out.println("Welcome " + currentUser.getName() + "!");
        } else {
            System.out.println("Sorry, invalid username or password");
        }
    }
    
    private void findCase() {
        int caseNumber = getFieldInt("Case Number (012): ");
        Crime crime = system.getCrime(caseNumber);
        if(crime != null) {
            System.out.println(crime.print());
            if(crime.getSuspectID() != null) {
                for(Suspect suspect : crime.getSuspectID()) {
                    System.out.println(suspect.print());
                }
            }
            else if(crime.getVictimID() != null) {
                for(Victim victim : crime.getVictimID()) {
                    System.out.println(victim.print());
                }
            }
            else if(crime.getWitnessID() != null) {
                for(Witness witness : crime.getWitnessID()) {
                    System.out.println(witness.print());
                }
            }
        }
    }

    private void addCrime() {
        System.out.println("Creating crime...");
        int caseNum = getFieldInt("Case Number (like 012, no spaces)");
        String crimeCommited = getField("Crime commited");
        String crimeLocation = getField("Crime location");
        String crimeDate = getField("Date crime occured");
        String criminal = getField("Suspect Name");
        boolean criminalInCustody = getFieldTF("Suspect in custody");
        String evidence = getField("Evidence");
        boolean isSolved = getFieldTF("Is the crime solved");
        
        if(system.createCrime(caseNum, crimeCommited, crimeLocation, crimeDate, criminal, criminalInCustody, evidence, isSolved)) {
            System.out.println("You have successfully created a crime");
        }
        boolean addMore = getFieldTF("Would you like to add a suspect, victim or witness");
        if(addMore){
            while(addMore) {
                displayCrimeMenu();

                int userCommand = getUserCommand(crimeMenuOptions.length);

                if(userCommand == -1) {
                    System.out.println("Not a valid command");
                    continue;
                }

                if(userCommand == crimeMenuOptions.length -1) {
                    break;
                }

                switch(userCommand) {
                    case(0):
                        addSuspect(true);
                        break;
                    case(1):
                        addVictim();
                        break;
                    case(2):
                        addWitness();
                        break;
                    case(3):
                        addMore = false;
                        break;
                }
            }
        }
    }

    private void addSuspect(boolean isConnectedToCrime) {
        System.out.println("Creating suspect...");
        String name = getField("Name");
        int age =  getFieldInt("Age (only numbers)");
        String sex = getFieldChar("Sex (M / F)");
        String race = getField("Race");
        boolean tattoos = getFieldTF("Tattoos");
        String vehicle = getField("Vehicle");
        String licensePlate = getField("License plate (ALH 833)");
        String address = getField("Address");
        boolean bankAccount = getFieldTF("Bank Account");
        boolean creditCard = getFieldTF("Credit card ");
        boolean armed = getFieldTF("Armed");
        boolean publicRisk = getFieldTF("Public risk");
        String nickNames = getField("Nicknames");
        String mentalState = getField("Mental state");
        String housingLocation = getField("Housing location");
        String educationLevel = getField("Education level");
        if(system.createSuspect(isConnectedToCrime, name, age, sex, race, tattoos, vehicle, licensePlate, address, bankAccount, creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, educationLevel)) {
            System.out.println("You have successfully created a suspect");
        }
    }

    private void addVictim() {
        System.out.println("Creating victim...");
        String name = getField("Name");
        int age = getFieldInt("Age (only numbers)");
        String sex = getFieldChar("Sex (M / F)");
        String race = getField("Race");
        String details = getField("Details");
        if(system.createVictim(name, age, sex, race, details)) {
            System.out.println("You have successfully created a victim");
        }
    }

    public void addWitness() {
        System.out.println("Creting witness...");
        String name = getField("Name");
        int age = getFieldInt("Age (only numbers)");
        String sex = getFieldChar("Sex (M / F)");
        String race = getField("Race");
        String details = getField("Details");
        String story = getField("Story");
        boolean isDefending = getFieldTF("Is the witness defending (yes or no)");
        if(system.createWitness(name, age, sex, race, details, story, isDefending)) {
            System.out.println("You have successfully created a witness");
        }
    }

    private void editCrime() {

    }

    private void editSuspect() {

    }

    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    private boolean getFieldTF(String prompt) {
        System.out.print(prompt + " (yes or no): ");
        String userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("yes")) {
            return true;
        }
        else if(userInput.equalsIgnoreCase("no")) {
            return false;
        }
        else {
            System.out.println("Answer did not match yes or no, please enter yes or no.");
            getFieldTF(prompt);
            return false;
        }
    }

    private int getFieldInt(String prompt) {
        System.out.print(prompt + ": ");
        int temp = scanner.nextInt();
        scanner.nextLine();
        return temp;
    }
    private String getFieldChar(String prompt) {
        System.out.print(prompt + ": ");
        String temp = "" + scanner.next().charAt(0);
        scanner.nextLine();
        return temp;
    }

    public static void main(String[] args) {
		CrimeManagementSystemUI systemInterface = new CrimeManagementSystemUI();
		systemInterface.run();
	}
}
