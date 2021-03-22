import java.util.UUID;
public class CrimeManagementSystem {
    private Crimes crimes;
    private Suspects suspects;
    private Users users;
    private Victims victims;
    private Witnesses witnesses;
    private User currentUser;

    public CrimeManagementSystem() {
        crimes = Crimes.getInstance();
        suspects = Suspects.getInstance();
        users = Users.getInstance();
        victims = Victims.getInstance();
    }

    public boolean createAccount(String name, String title, String race, String dob, String address, String password, String username) {
        return users.addUser(username, title, race, dob, address, password, username);
    }

    public boolean createCrime(int caseNum, UUID crimeID, UUID suspectID, UUID victimID, UUID witnessID, String crimeCommited, String crimeLocation, 
                            String crimeDate, String criminal, boolean criminalInCustody, String evidence, boolean isSolved) {
        
        return crimes.addCrime(caseNum, crimeID, suspectID, victimID, witnessID, crimeCommited, crimeLocation, crimeDate, criminal, criminalInCustody, 
        evidence, isSolved);
    }

    public boolean createSuspect(String name, int age, char sex, String race, Boolean tattoos,String vehicle, String licensePlate, String address, 
                                Boolean bankAccount, Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,String mentalState, 
                                String housingLocation, String educationLevel) {
        
        return suspects.addSuspect(name, age, sex, race, tattoos, vehicle, licensePlate, address, bankAccount, creditCard, armed, 
        publicRisk, nickNames, mentalState, housingLocation, educationLevel);
    }

    public boolean createVictim(String name, int age, char sex, String race, String details) {
        return victims.addVictim(name, age, sex, race, details);
    }
    
    public boolean createWitness(String name, int age, char sex, String race, String details, String story, boolean isDefending) {
        return witnesses.addWitness(name, age, sex, race, details, story, isDefending);

    }

    public boolean login(String username, String password) {
        if(!users.haveUser(username, password))return false;

        currentUser = users.getUser(username);
        return true;
    }
    public Sus

    public boolean userCheck(String username, String password) {
        if(users.haveUser(username, password))return false;
        return true;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        users.saveUsers();
    }
}
