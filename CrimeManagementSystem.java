import java.util.UUID;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Creates a crimeManagementSystem object that holds the objects that represent the arraylist of the different objects like suspect etc.
 * @author Team Coalition
 * 
 */
public class CrimeManagementSystem {
    private Crimes crimes;
    private Suspects suspects;
    private Users users;
    private Victims victims;
    private Witnesses witnesses;
    private User currentUser;
    private UUID currentCrimeID;
    private Suspect currentSuspect;
    private Victim currentVictim;
    private Witness currentWitness;


    /**
     * Defualt constructor for crimeManagementSystem that loads in the json files for the arraylist of objects
     */
    public CrimeManagementSystem() {
        crimes = Crimes.getInstance();
        suspects = Suspects.getInstance();
        users = Users.getInstance();
        victims = Victims.getInstance();
        witnesses = Witnesses.getInstance();
    }

    
    /** 
     * Creates a new user object and adds it to the user arraylist
     * @param name
     * @param title
     * @param race
     * @param dob
     * @param address
     * @param password
     * @param username
     * @return boolean
     */
    public boolean createAccount(String name, String title, String race, String dob, String address, String password, String username) {
        return users.addUser(name, title, race, dob, address, password, username);
    }

    
    /** 
     * Checks if there's a user with the given username and password if there is then it sets the user to the current user
     * @param username
     * @param password
     * @return boolean
     */
    public boolean login(String username, String password) {
        if(!users.haveUser(username, password))return false;

        currentUser = users.getUser(username);
        return true;
    }

    
    /** 
     * Checks if the certain User exist that has the given username and password
     * @param username
     * @param password
     * @return boolean
     */
    public boolean userCheck(String username, String password) {
        if(users.haveUser(username, password))return false;
        return true;
    }

    
    /** 
     * Returns the currrent User object
     * @return User
     */
    public User getCurrentUser() {
        return currentUser;
    }

    
    /** 
     * returns the current crime UUID
     * @return UUID
     */
    public UUID getCurrentCrime() {
        return currentCrimeID;
    }

    
    /** 
     * Returns the crime for the given case number
     * @param caseNum
     * @return Crime
     */
    public Crime getCrime(int caseNum) {
        return crimes.getCrime(caseNum);
    }

    
    /** 
     * Creates a new crime object and adds it to the crime arraylist
     * @param caseNum
     * @param crimeCommited
     * @param crimeLocation
     * @param crimeDate
     * @param criminal
     * @param criminalInCustody
     * @param evidence
     * @param isSolved
     * @return boolean
     */
    public boolean createCrime(int caseNum, String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, ArrayList<String> evidence, boolean isSolved) {
        if(crimes.addCrime(caseNum, crimeCommited, crimeLocation, crimeDate, criminal, criminalInCustody, evidence, isSolved)) {
            currentCrimeID = crimes.getCrime(caseNum).getCrimeID();
            return true;
        }
        return false;
    }

    
    /** 
     * Creates a suspects and adds it to the suspect arraylist and if the prameter isConnectedToCrime is true then it adds the suspect into the current crime.
     * @param isConnectedToCrime
     * @param name
     * @param age
     * @param sex
     * @param race
     * @param phoneNumber
     * @param height
     * @param email
     * @param tattoos
     * @param vehicle
     * @param licensePlate
     * @param address
     * @param bankAccount
     * @param creditCard
     * @param armed
     * @param publicRisk
     * @param nickNames
     * @param mentalState
     * @param housingLocation
     * @param educationLevel
     * @param hairColor
     * @param clothing
     * @param conviction
     * @param isInPrison
     * @return boolean
     */
    public boolean createSuspect(boolean isConnectedToCrime, String name, int age, String sex, String race, String phoneNumber, String height, String email, 
    String tattoos, String vehicle, String licensePlate, String address, boolean bankAccount,
    boolean creditCard, boolean armed, Boolean publicRisk, String nickNames,
    String mentalState, String housingLocation, String educationLevel, String hairColor, String clothing, String conviction, boolean isInPrison) {
        if(isConnectedToCrime && suspects.addSuspect(name, age, sex, race, phoneNumber, height, email, tattoos, vehicle, licensePlate, address, bankAccount, 
        creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, 
        educationLevel, hairColor, clothing, conviction, isInPrison)) {
            currentSuspect = suspects.getLastSuspect();
            return crimes.addSuspectID(currentCrimeID, currentSuspect);
        }
        else if(suspects.addSuspect(name, age, sex, race, phoneNumber, height, email, tattoos, vehicle, licensePlate, address, bankAccount, 
        creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, 
        educationLevel, hairColor, clothing, conviction, isInPrison)) { return true;}

        return false;
    }

    
    /** 
     * Creates a new victim object and adds it to the connected crime and the victim arraylist
     * @param name
     * @param age
     * @param sex
     * @param race
     * @param phoneNumber
     * @param height
     * @param email
     * @param details
     * @return boolean
     */
    public boolean createVictim(String name, int age, String sex, String race, String phoneNumber, String height, String email, String details) {
        if(victims.addVictim(name, age, sex, race, phoneNumber, height, email, details)) {
            currentVictim = victims.getLastVictim();
            return crimes.addVictimID(currentCrimeID, currentVictim);
        }
        return false;
    }

    
    /** 
     * Creates a new witness object and adds it to the connected crime and the witness arraylist
     * @param name
     * @param age
     * @param sex
     * @param race
     * @param phoneNumber
     * @param height
     * @param email
     * @param details
     * @param story
     * @param isDefending
     * @return boolean
     */
    public boolean createWitness(String name, int age, String sex, String race, String phoneNumber, String height, String email, String details, String story, boolean isDefending) {
        if(witnesses.addWitness(name, age, sex, race, phoneNumber, height, email, details, story, isDefending)) {
            currentWitness = witnesses.getLastWitness();
            return crimes.addWitnessID(currentCrimeID, currentWitness);
        }
        return false;
    }

    
    /** 
     * Writes the crime to a string and the connected arraylist if they're not null. This includes suspects, victims, and witnesses that are connected to the crime.
     * @param crime
     * @return String
     */
    public String writeCrime(Crime crime) {
        String text = "";
        if(crime != null) {
            text += crime.print();
            if(crime.getSuspectID() != null) {
                for(Suspect suspect : crime.getSuspectID()) {
                    text += "\n" + suspect.print();
                }
            }
            if(crime.getVictimID() != null) {
                for(Victim victim : crime.getVictimID()) {
                    text += "\n" + victim.print();
                }
            }
            if(crime.getWitnessID() != null) {
                for(Witness witness : crime.getWitnessID()) {
                    text += "\n" + witness.print();
                }
            }
        }
        return text;
    }

    
    /** 
     * Writes a suspects arraylist to a string and then returns the string
     * @param foundSus
     * @return String
     */
    public String writeSuspects(ArrayList<Suspect> foundSus) {
        String suspects = "";
        if(foundSus != null) {
            for(Suspect sus : foundSus) {
                suspects += sus.print();
            }
        }
        return suspects;
    }

    
    /** 
     * Takes in a filename and a string and overwrites the string to the given file if it exist and creates a new file if it doesn't exist
     * @param fileName
     * @param text
     * @throws IOException
     */
    public void writeToFile(String fileName, String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        writer.write(text);
        writer.close();
    }

    /**
     * Saves the Arraylist of users, crimes, suspects, victims, and witnesses to their json files
     * 
     */
    public void logout() {
        users.saveUsers();
        crimes.saveCrime();
        suspects.saveSuspects();
        victims.saveVictims();
        witnesses.saveWitnesses();
    }
}
