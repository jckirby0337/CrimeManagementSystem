import java.util.ArrayList;

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

    public ArrayList<Crime> getCrime() {
        return crimeList;
    }

    public boolean addCrime(String crimeCommited, String crimeLocation, int crimeDate, String criminal, boolean criminalInCustody, String evidence, boolean isSolved) {
        if(haveCrime(criminal)) return false;

        crimeList.add(new Crime(crimeCommited, crimeLocation, crimeDate, criminal, criminalInCustody, evidence, isSolved));
        return true;
    }

    public void saveCrime() {
        DataWriter.saveCrimes();
    }
}
