import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Creates the crimeManagementSystemUI that takes in all user input and functions as the front end UI
 * @author Team Coalition
 * 
 */
public class CrimeManagementSystemUI {
    private static final String WELCOME_MESSAGE = "Welcome to the Crime Management System";
    private String[] mainMenuOptions = {"Create Account", "Login", "Find Case", "Add Crime", "Add Suspect not connected to a crime", "Search for Suspect", "Logout"};
    private String[] crimeMenuOptions = {"Add Suspect", "Add Victim", "Add Witness", "Go back to the Main Menu"};
    private String[] searchMenuOptions = {"By Tattoo", "By Tattoo and Age", "By Age, and Hair", "By Age, Hair, and Height", "Go back to the Main Menu"};
    private Scanner scanner;
    private CrimeManagementSystem system;
    
    /**
     * default constructor which creates a scanner and system which is a crimeManagementSystem object
     */
    CrimeManagementSystemUI() {
        scanner = new Scanner(System.in);
        system = new CrimeManagementSystem();
    }

    
    /** 
     * Prints the welcome message and then enters a while loop and displays the main menu and takes in a user command it then applys the user command to the correct method wanted
     * through a switch statement and the while loop exits whenever it hits a break
     * @throws IOException
     */
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

    /**
     * Each of these display menus are the same expect for the arrays they user and then the given menu accesses the array that holds the options and prints out the options
     */
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

    
    /** 
     * Takes in the user input as a string and parses the string for an int which then is checked to fit the number of commands available
     * @param numCommands
     * @return int
     */
    private int getUserCommand(int numCommands) {
        System.out.print("What would you like to do?: ");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;

        if(command >= 0 && command <= numCommands -1) return command;

        return -1;
    }

    /**
     * Takes in user input for username and password and if userCheck returns false then it takes in the rest of the input needed to create a user
     */
    private void createAccount() {
        while(true) {
            String username = getField("Username");
            String password = getField("Password");
            if(!system.userCheck(username, password)) {
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

    /**
     * Takes in the user input for their username and password and checks if a user exist with the given username and password and then sets the current user equal to the crimeManagementSystems current user and then prints a welcome message with the users name
     * 
     */
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
    
    
    /** 
     * Takes in the user input of what the case number of the case they want to find
     * It then calls the get crime method from crimeManagementSystem class that will search through the arraylist
     * of crimes in order to find the given crime with that case number
     * after it finds and prints the crime then it ask the user if they would like to write the crime to a file
     * @throws IOException
     */
    private void findCase() throws IOException {
        int caseNumber = getFieldInt("Case Number (012): ");
        String crime = system.writeCrime(system.getCrime(caseNumber));
        System.out.println(crime);
        system.writeToFile("CrimeManagementSystem/crimeFiles/crimeFile.txt", crime);
    }

    /**
     * Takes in user input for the values of a crime and then calls the 
     * crimeManagementSystem method to create a crime
     * It then asks the user if they would like to add suspects, victims, or witnesses to the crime
     * if the user selects yes then it takes them into the crime menu where they can select to add suspects, victims, and witnesses to the crime
     */
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
    
    /** 
     * Gives the user a menu options to search for a suspect with given parameters
     * It then calls the correct search method from suspects class with the parameters
     * after it asks if you would like to save the suspects to a file
     * @throws IOException
     */
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
                    int age = getFieldInt("Age");
                    ArrayList<Suspect> foundSus1 = Suspects.search(tattoo1, age);
                    if(getFieldTF("Would you like to download suspects")) {
                        system.writeToFile("CrimeManagementSystem/suspectFiles/suspectFile.txt", system.writeSuspects(foundSus1));
                    }
                    break;
                case(2):
                    int age1 = getFieldInt("Age");
                    String hair = getFieldColor("Hair");
                    ArrayList<Suspect> foundSus2 = Suspects.search(age1, hair);
                    if(getFieldTF("Would you like to download suspects")) {
                        system.writeToFile("CrimeManagementSystem/suspectFiles/suspectFile.txt", system.writeSuspects(foundSus2));
                    }
                    break;
                case(3):
                    int age2 = getFieldInt("Age");
                    String hair1 = getFieldColor("Hair");
                    String height = getField("Height");
                    ArrayList<Suspect> foundSus3 = Suspects.search(age2, hair1, height);
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

    
    /** 
     * Takes in a boolean which represents if the suspect will be connected to a crime and then
     * Takes in user input for the values of a suspect and then calls the 
     * crimeManagementSystem method to create a suspect
     * @param isConnectedToCrime
     */
    private void addSuspect(boolean isConnectedToCrime) {
        System.out.println("Creating suspect...");
        String name = getField("Name");
        int age =  getFieldInt("Age (only numbers)");
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
        String convicton = getField("Conviction");
        boolean isInPrison = getFieldTF("Is in prison");
        if(system.createSuspect(isConnectedToCrime, name, age, sex, race, phoneNumber, height, email, tattoos, vehicle, licensePlate, address, bankAccount, creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, educationLevel, hairColor, clothing, convicton, isInPrison)) {
            System.out.println("You have successfully created a suspect");
        }
    }

    /**
     * Takes in user input for the values of a victim and then calls the 
     * crimeManagementSystem method to create a victim
     * 
     */
    private void addVictim() {
        System.out.println("Creating victim...");
        String name = getField("Name");
        int age = getFieldInt("Age (only numbers)");
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
    /**
     * Takes in user input for the values of a witness and then calls the 
     * crimeManagementSystem method to create a witness
     * 
     */
    public void addWitness() {
        System.out.println("Creting witness...");
        String name = getField("Name");
        int age = getFieldInt("Age (only numbers)");
        String sex = getFieldChar("Sex (M / F)");
        String race = getField("Race");
        String phoneNumber = getField("Phone Number");
        String height = getFieldHeight("Height");
        String email = getField("Email");
        String details = getField("Details");
        String story = getField("Story");
        boolean isDefending = getFieldTF("Is the witness defending");
        if(system.createWitness(name, age, sex, race, phoneNumber, height, email, details, story, isDefending)) {
            System.out.println("You have successfully created a witness");
        }
    }

    
    /** Takes in the prompt and prints it and takes in a string from the user
     * @param prompt
     * @return String
     */
    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    
    /** 
     * Takes in the prompt and prints it with yes or no added to it and takes the users input as yes or no and applies true
     * if the user selects yes and false if the user selected no
     * @param prompt
     * @return boolean
     */
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

    
    /** 
     * Takes in the prompt and prints it and takes in a int value
     * @param prompt
     * @return int
     */
    private int getFieldInt(String prompt) {
        System.out.print(prompt + ": ");
        int temp = scanner.nextInt();
        scanner.nextLine();
        return temp;
    }


    
    /** 
     * Takes in the prompt and prints it and takes in a char value
     * @param prompt
     * @return String
     */
    private String getFieldChar(String prompt) {
        System.out.print(prompt + ": ");
        String temp = "" + scanner.next().charAt(0);
        scanner.nextLine();
        return temp;
    }

    
    /** 
     * Takes in the prompt for hair color and checks to make sure the user input is one of the avaiable hair colors
     * if not then it recurisively repeats until they give a corret hair color
     * @param prompt
     * @return String
     */
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

    
    /** 
     * Takes in the prompt for the given data which would be height and then takes in the first int 
     * representing the amount of feet in height and then a second that represent the amount of inches in height
     * @param prompt
     * @return String
     */
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

    
    /** 
     * Creates a new crimeManagementSystemUI and then calls the run method on it which starts the UI
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
		CrimeManagementSystemUI systemInterface = new CrimeManagementSystemUI();
		systemInterface.run();
	}
}
