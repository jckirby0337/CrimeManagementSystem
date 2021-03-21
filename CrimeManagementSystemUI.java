import java.util.Scanner;

public class CrimeManagementSystemUI {
    private static final String WELCOME_MESSAGE = "Welcome to the Crime Management System";
    private String[] mainMenuOptions = {"Create Account", "Login", "Find Case", "Add Crime", "Add Offender", "Edit Crime", "Edit Offender"};
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
                    addSuspect();
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
    
    private void getCase() {
        String caseNumber = getField("Case Number");
    }

    private void addCrime() {
        
    }
    
    private void addSuspect() {

    }

    private void editCrime() {

    }

   private void editSuspect() {

    }

    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
		CrimeManagementSystemUI systemInterface = new CrimeManagementSystemUI();
		systemInterface.run();
	}
}
