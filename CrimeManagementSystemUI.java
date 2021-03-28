import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class CrimeManagementSystemUI {
    private static final String WELCOME_MESSAGE = "Welcome to the Crime Management System";
    private String[] mainMenuOptions = {"Create Account", "Login", "Find Case", "Add Crime", "Add Suspect not connected to a crime", "Search for Suspect", "Logout"};
    private String[] crimeMenuOptions = {"Add Suspect", "Add Victim", "Add Witness", "Go back to the Main Menu"};
    private String[] searchMenuOptions = {"By Tattoo", "By Tattoo and Age", "By Tattoo, Age, and Hair", "By Tattoo, Age, Hair, and Height", "Go back to the Main Menu"};
    private Scanner scanner;
    private CrimeManagementSystem system;
    
    CrimeManagementSystemUI() {
        scanner = new Scanner(System.in);
        system = new CrimeManagementSystem();
    }

    public void run() throws IOException {
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
                    search();
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

    private void displaySearchMenu() {
        System.out.println("\n************ Search Menu *************");
        for(int i=0; i< searchMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + searchMenuOptions[i]);
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
    
    private void findCase() throws IOException {
        int caseNumber = getFieldInt("Case Number (012): ");
        String crime = system.writeCrime(system.getCrime(caseNumber));
        System.out.println(crime);
        system.writeToFile("CrimeManagementSystem/crimeFiles/crimeFile.txt", crime);
    }

    private void addCrime() {
        System.out.println("Creating crime...");
        int caseNum = getFieldInt("Case Number (like 012, no spaces)");
        String crimeCommited = getField("Crime commited");
        String crimeLocation = getField("Crime location");
        String crimeDate = getField("Date crime occured");
        String criminal = getField("Suspect Name");
        boolean criminalInCustody = getFieldTF("Suspect in custody");
        int numberOfEvidence = getFieldInt("How many pieces of evidence do you have to add: ");
        ArrayList<String> evidence = new ArrayList<String>();
        for(int i = 1; i<numberOfEvidence; i++) {
            evidence.add(getField("Evidence: "));
        }
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
    private void search() throws IOException {
        boolean searchMore = true;
        while(searchMore) {
            displaySearchMenu();

            int userCommand = getUserCommand(searchMenuOptions.length);

            if(userCommand == -1) {
                System.out.println("Not a valid command");
                continue;
            }

            if(userCommand == searchMenuOptions.length -1) {
                break;
            }

            switch(userCommand) {
                case(0):
                    String tattoo = getField("Tattoo");
                    ArrayList<Suspect> foundSus = Suspects.search(tattoo);
                    if(getFieldTF("Would you like to download suspects")) {
                        system.writeToFile("CrimeManagementSystem/suspectFiles/suspectFile.txt", system.writeSuspects(foundSus));
                    }
                    break;
                case(1):
                    String tattoo1 = getField("Tattoo");
                    int age = getFieldAge("Age");
                    ArrayList<Suspect> foundSus1 = Suspects.search(tattoo1, age);
                    if(getFieldTF("Would you like to download suspects")) {
                        system.writeToFile("CrimeManagementSystem/suspectFiles/suspectFile.txt", system.writeSuspects(foundSus1));
                    }
                    break;
                case(2):
                    String tattoo2 = getField("Tattoo");
                    int age1 = getFieldAge("Age");
                    String hair = getFieldColor("Hair");
                    ArrayList<Suspect> foundSus2 = Suspects.search(tattoo2, age1, hair);
                    if(getFieldTF("Would you like to download suspects")) {
                        system.writeToFile("CrimeManagementSystem/suspectFiles/suspectFile.txt", system.writeSuspects(foundSus2));
                    }
                    break;
                case(3):
                    String tattoo3 = getField("Tattoo");
                    int age2 = getFieldAge("Age");
                    String hair1 = getFieldColor("Hair");
                    String height = getField("Height");
                    ArrayList<Suspect> foundSus3 = Suspects.search(tattoo3, age2, hair1, height);
                    if(getFieldTF("Would you like to download suspects")) {
                        system.writeToFile("CrimeManagementSystem/suspectFiles/suspectFile.txt", system.writeSuspects(foundSus3));
                    }
                    break;
                case(4):
                    searchMore = false;
                    break;
            }
        }
    }

    private void addSuspect(boolean isConnectedToCrime) {
        System.out.println("Creating suspect...");
        String name = getField("Name");
        int age =  getFieldAge("Age (only numbers)");
        String sex = getFieldChar("Sex (M / F)");
        String race = getField("Race");
        String phoneNumber = getField("Phone Number");
        String height = getFieldHeight("Height");
        String email = getField("Email");
        String tattoos = getField("Tattoos");
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
        String hairColor = getFieldColor("Hair color");
        String clothing = getField("Clothing");
        if(system.createSuspect(isConnectedToCrime, name, age, sex, race, phoneNumber, height, email, tattoos, vehicle, licensePlate, address, bankAccount, creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, educationLevel, hairColor, clothing)) {
            System.out.println("You have successfully created a suspect");
        }
    }

    private void addVictim() {
        System.out.println("Creating victim...");
        String name = getField("Name");
        int age = getFieldAge("Age (only numbers)");
        String sex = getFieldChar("Sex (M / F)");
        String race = getField("Race");
        String phoneNumber = getField("Phone Number");
        String height = getFieldHeight("Height");
        String email = getField("Email");
        String details = getField("Details");
        if(system.createVictim(name, age, sex, race, phoneNumber, height, email, details)) {
            System.out.println("You have successfully created a victim");
        }
    }

    public void addWitness() {
        System.out.println("Creting witness...");
        String name = getField("Name");
        int age = getFieldAge("Age (only numbers)");
        String sex = getFieldChar("Sex (M / F)");
        String race = getField("Race");
        String phoneNumber = getField("Phone Number");
        String height = getFieldHeight("Height");
        String email = getField("Email");
        String details = getField("Details");
        String story = getField("Story");
        boolean isDefending = getFieldTF("Is the witness defending (yes or no)");
        if(system.createWitness(name, age, sex, race, phoneNumber, height, email, details, story, isDefending)) {
            System.out.println("You have successfully created a witness");
        }
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

    private int getFieldAge(String prompt) {
        prompt += " (If they're a minor enter -1)";
        return getFieldInt(prompt);
    }


    private String getFieldChar(String prompt) {
        System.out.print(prompt + ": ");
        String temp = "" + scanner.next().charAt(0);
        scanner.nextLine();
        return temp;
    }

    public String getFieldColor(String prompt) {
        System.out.print(prompt + "(Black, Brunette, Blonde, Red): ");
        String userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("Black")) {
            return userInput;
        }
        else if(userInput.equalsIgnoreCase("Brunette")) {
            return userInput;
        }
        else if(userInput.equalsIgnoreCase("Blonde")) {
            return userInput;
        }
        else if(userInput.equalsIgnoreCase("Red")) {
            return userInput;
        }
        else {
            getFieldColor(prompt);
            return "";
        }
    }

    public String getFieldHeight(String prompt) {
        String height = "";
        System.out.println(prompt + " (Example 5\'10\"): ");
        System.out.println("Please enter the number of feet (Example 5):");
        int userInput = scanner.nextInt();
        scanner.nextLine();
        height += userInput + "\'";
        System.out.println("Please enter the inches (Example 10):");
        userInput = scanner.nextInt();
        scanner.nextLine();
        height += userInput + "\"";
        return height;
    }

    public static void main(String[] args) throws IOException {
		CrimeManagementSystemUI systemInterface = new CrimeManagementSystemUI();
		systemInterface.run();
	}
}
