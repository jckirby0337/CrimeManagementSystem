import java.util.ArrayList;
import java.util.UUID;

public class Crimes {
    private static Crimes crimes;
    private ArrayList<Crime> crimeList;

    private Crimes() {
        crimeList = DataLoader.getCrimes();
    }

    public static Crimes getInstance() {
        if(crimes == null) {
            crimes = new Crimes();
        }

        return crimes;
    }

    public boolean haveCrime(String CriminalName) {
        for(Crime crime : crimeList) {
            if(crime.getCriminal().equals(CriminalName)) {
                return true;
            }
        }
        return false;
    }

    public Crime getCrime(String CriminalName) {
        for(Crime crime : crimeList) {
            if(crime.getCriminal().equals(CriminalName)) {
                return crime;
            }
        }

        return null;
    }

    public ArrayList<Crime> getCrimes() {
        return crimeList;
    }

    public boolean addCrime(int caseNum, UUID crimeID, UUID suspectID, UUID victimID, String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, String evidence, boolean isSolved) {
        if(haveCrime(criminal)) return false;

        crimeList.add(new Crime(caseNum, crimeID, suspectID, victimID, crimeCommited, crimeLocation, crimeDate, criminal, criminalInCustody, evidence, isSolved));
        return true;
    }

    public void saveCrime() {
        DataWriter.saveCrimes();
    }
}
