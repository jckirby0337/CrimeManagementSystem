import java.util.UUID;
public class CrimeManagementSystem {
    private Crimes crimes;
    private Suspects suspects;
    private Users users;
    private Victims victims;
    private User currentUser;
    private UUID currentCrimeID;
    private UUID currentSuspectID;
    private UUID currentVictimID;



    public CrimeManagementSystem() {
        crimes = Crimes.getInstance();
        suspects = Suspects.getInstance();
        users = Users.getInstance();
        victims = Victims.getInstance();
    }

    public boolean createAccount(String name, String title, String race, String dob, String address, String password, String username) {
        return users.addUser(username, title, race, dob, address, password, username);
    }

    public boolean login(String username, String password) {
        if(!users.haveUser(username, password))return false;

        currentUser = users.getUser(username);
        return true;
    }

    public boolean userCheck(String username, String password) {
        if(users.haveUser(username, password))return false;
        return true;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public UUID getCurrentCrime() {
        return currentCrimeID;
    }

    public boolean createCrime(int caseNum, String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, String evidence, boolean isSolved) {
        if(crimes.addCrime(caseNum, crimeCommited, crimeLocation, crimeDate, criminal, criminalInCustody, evidence, isSolved)) {
            currentCrimeID = crimes.getCrime(caseNum).getCrimeID();
            return true;
        }
        return false;
    }

    public boolean createSuspect(boolean isConnectedToCrime, String name, int age, char sex, String race, Boolean tattoos,
    String vehicle, String licensePlate, String address, Boolean bankAccount,
    Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
    String mentalState, String housingLocation, String educationLevel) {
        if(suspects.addSuspect(name, age, sex, race, tattoos, vehicle, licensePlate, address, bankAccount, 
        creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, 
        educationLevel) && isConnectedToCrime) {
            currentSuspectID = suspects.getSuspect(name).getSuspectID();
            crimes.addSuspectID(currentCrimeID, currentSuspectID);
            return true;
        }
        else if(suspects.addSuspect(name, age, sex, race, tattoos, vehicle, licensePlate, address, bankAccount, 
        creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, 
        educationLevel)) return true;

        return false;
    }

    public void logout() {
        users.saveUsers();
        crimes.saveCrime();
    }
}
