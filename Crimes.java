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
     * @return Crimes
     */
    public static Crimes getInstance() {
        if(crimes == null) {
            crimes = new Crimes();
        }

        return crimes;
    }

    
    /** 
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
     * @return ArrayList<Crime>
     */
    public ArrayList<Crime> getCrimes() {
        return crimeList;
    }

    
    /** 
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
     * 
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
