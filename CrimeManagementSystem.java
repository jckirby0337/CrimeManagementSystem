import java.util.UUID;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
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



    public CrimeManagementSystem() {
        crimes = Crimes.getInstance();
        suspects = Suspects.getInstance();
        users = Users.getInstance();
        victims = Victims.getInstance();
        witnesses = Witnesses.getInstance();
    }

    public boolean createAccount(String name, String title, String race, String dob, String address, String password, String username) {
        return users.addUser(name, title, race, dob, address, password, username);
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

    public Crime getCrime(int caseNum) {
        return crimes.getCrime(caseNum);
    }

    public boolean createCrime(int caseNum, String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, ArrayList<String> evidence, boolean isSolved) {
        if(crimes.addCrime(caseNum, crimeCommited, crimeLocation, crimeDate, criminal, criminalInCustody, evidence, isSolved)) {
            currentCrimeID = crimes.getCrime(caseNum).getCrimeID();
            return true;
        }
        return false;
    }

    public boolean createSuspect(boolean isConnectedToCrime, String name, int age, String sex, String race, String phoneNumber, String height, String email, 
    String tattoos, String vehicle, String licensePlate, String address, Boolean bankAccount,
    Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
    String mentalState, String housingLocation, String educationLevel, String hairColor, String clothing) {
        if(suspects.addSuspect(name, age, sex, race, phoneNumber, height, email, tattoos, vehicle, licensePlate, address, bankAccount, 
        creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, 
        educationLevel, hairColor, clothing) && isConnectedToCrime) {
            currentSuspect = suspects.getLastSuspect();
            return crimes.addSuspectID(currentCrimeID, currentSuspect);
        }
        else if(suspects.addSuspect(name, age, sex, race, phoneNumber, height, email, tattoos, vehicle, licensePlate, address, bankAccount, 
        creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, 
        educationLevel, hairColor, clothing)) return true;

        return false;
    }

    public boolean createVictim(String name, int age, String sex, String race, String phoneNumber, String height, String email, String details) {
        if(victims.addVictim(name, age, sex, race, phoneNumber, height, email, details)) {
            currentVictim = victims.getLastVictim();
            return crimes.addVictimID(currentCrimeID, currentVictim);
        }
        return false;
    }

    public boolean createWitness(String name, int age, String sex, String race, String phoneNumber, String height, String email, String details, String story, boolean isDefending) {
        if(witnesses.addWitness(name, age, sex, race, phoneNumber, height, email, details, story, isDefending)) {
            currentWitness = witnesses.getLastWitness();
            return crimes.addWitnessID(currentCrimeID, currentWitness);
        }
        return false;
    }

    public String writeCrime(Crime crime) {
        String text = "";
        if(crime != null) {
            text += crime.print();
            if(crime.getSuspectID() != null) {
                for(Suspect suspect : crime.getSuspectID()) {
                    text += "\n" + suspect.print();
                }
            }
            else if(crime.getVictimID() != null) {
                for(Victim victim : crime.getVictimID()) {
                    text += "\n" + victim.print();
                }
            }
            else if(crime.getWitnessID() != null) {
                for(Witness witness : crime.getWitnessID()) {
                    text += "\n" + witness.print();
                }
            }
        }
        return text;
    }

    public String writeSuspects(ArrayList<Suspect> foundSus) {
        String suspects = "";
        if(foundSus != null) {
            for(Suspect sus : foundSus) {
                suspects += sus.print();
            }
        }
        return suspects;
    }

    public void writeToFile(String fileName, String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        writer.write(text);
        writer.close();
    }

    public void logout() {
        users.saveUsers();
        crimes.saveCrime();
        suspects.saveSuspects();
        victims.saveVictims();
        witnesses.saveWitnesses();
    }
}
