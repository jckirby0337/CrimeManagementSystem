import java.util.ArrayList;
import java.util.UUID;

/**
 * Creates the crimes object that holds an arraylist of crimes
 * @author Team Coalition
 * 
 */
public class Crimes {
    private static Crimes crimes;
    private ArrayList<Crime> crimeList;

    private Crimes() {
        crimeList = DataLoader.getCrimes();
    }

    
    /** 
     * creates a new instance of crimes
     * @return Crimes
     */
    public static Crimes getInstance() {
        if(crimes == null) {
            crimes = new Crimes();
        }

        return crimes;
    }

    
    /** 
     * returns true if the name is connected to a crime
     * @param CriminalName
     * @return boolean
     */
    public boolean haveCrime(String CriminalName) {
        for(Crime crime : crimeList) {
            if(crime.getCriminal().equals(CriminalName)) {
                return true;
            }
        }
        return false;
    }

    
    /** 
     * returns true if the case number is already connected to a crime
     * @param caseNum
     * @return boolean
     */
    public boolean haveCaseNum(int caseNum) {
        for(Crime crime : crimeList) {
            if(crime.getCaseNum() == caseNum) {
                return true;
            }
        }
        return false;
    }


    
    /** 
     * returns a crime based off of its case number
     * @param caseNum
     * @return Crime
     */
    public Crime getCrime(int caseNum) {
        for(Crime crime : crimeList) {
            if(crime.getCaseNum() == caseNum) {
                return crime;
            }
        }

        return null;
    }


    
    /** 
     * returns the crimelist
     * @return ArrayList<Crime>
     */
    public ArrayList<Crime> getCrimes() {
        return crimeList;
    }

    
    /** 
     * Takes in parameters to create a crime and checks if a crime with that criminal already exist or if a crime with that case number had already been created then it doesn't create
     * the crime. If they are unique then it creates a new crime and adds it to the crimelist
     * @param caseNum
     * @param crimeID
     * @param suspectID
     * @param victimID
     * @param witnessID
     * @param crimeCommited
     * @param crimeLocation
     * @param crimeDate
     * @param criminal
     * @param criminalInCustody
     * @param evidence
     * @param isSolved
     * @return boolean
     */
    public boolean addCrime(int caseNum, UUID crimeID, ArrayList<Suspect> suspectID, ArrayList<Victim> victimID, ArrayList<Witness> witnessID, String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, ArrayList<String> evidence, boolean isSolved) {
        if(crimeList != null) {
            if(haveCrime(criminal)) { System.out.println("Crime already exist"); return false;}
            else if(haveCaseNum(caseNum)) { System.out.println("Case Number already exist"); return false;}

            crimeList.add(new Crime(caseNum, crimeID, suspectID, victimID, witnessID, crimeCommited, crimeLocation, crimeDate, criminal, criminalInCustody, evidence, isSolved));
            return true;
        }
        else {
            crimeList.add(new Crime(caseNum, crimeID, suspectID, victimID, witnessID, crimeCommited, crimeLocation, crimeDate, criminal, criminalInCustody, evidence, isSolved));
            return true;
        }
    }

    
    /** 
     * Takes in the parameters for a crime and checks if the crime already exist or if the case number already exist.
     * It then creates a crime with the given parameters
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
    public boolean addCrime(int caseNum, String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, ArrayList<String> evidence, boolean isSolved) {
        if(crimeList != null) {
            if(haveCrime(criminal)) { System.out.println("Crime already exist"); return false;}
            else if(haveCaseNum(caseNum)) { System.out.println("Case Number already exist"); return false;}
            
            crimeList.add(new Crime(caseNum, crimeCommited, crimeLocation, crimeDate, criminal, criminalInCustody, evidence, isSolved));
            return true;
        }
        else {
            crimeList.add(new Crime(caseNum, crimeCommited, crimeLocation, crimeDate, criminal, criminalInCustody, evidence, isSolved));
            return true;
        }
    }

    
    /** 
     * Takes in a crime UUID to identify the crime and a suspect object
     * It finds which crime matches the UUID and then adds the suspect to the crime
     * @param crimeID
     * @param suspect
     * @return boolean returns true if the crime gets added to the arraylist
     */
    public boolean addSuspectID(UUID crimeID, Suspect suspect) {
        for(Crime crime : crimeList) {
            if(crime.getCrimeID() == crimeID) {
                crimeList.get(crimeList.indexOf(crime)).setSuspectID(suspect);
                return true;
            }
        }

        return false;
    }

    
    /** 
     * Takes in a crime UUID to identify the crime and a victim object
     * It finds which crime matches the UUID and then adds the victim to the crime
     * @param crimeID
     * @param victim
     * @return boolean returns true if the crime gets added to the arraylist
     */
    public boolean addVictimID(UUID crimeID, Victim victim) {
        for(Crime crime : crimeList) {
            if(crime.getCrimeID() == crimeID) {
                crimeList.get(crimeList.indexOf(crime)).setVictimID(victim);
                return true;
            }
        }

        return false;
    }

    
    /** 
     * Takes in a crime UUID to identify the crime and a witness object
     * It finds which crime matches the UUID and then adds the witness to the crime
     * @param crimeID
     * @param witness
     * @return boolean returns true if the crime gets added to the arraylist
     */
    public boolean addWitnessID(UUID crimeID, Witness witness) {
        for(Crime crime : crimeList) {
            if(crime.getCrimeID() == crimeID) {
                crimeList.get(crimeList.indexOf(crime)).setWitnessID(witness);
                return true;
            }
        }

        return false;
    }

    /**
     * calls the saveCrimes method in datawriter which writes the crimes arraylist to the json file
     */
    public void saveCrime() {
        DataWriter.saveCrimes();
    }
}
