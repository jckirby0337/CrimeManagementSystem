import java.util.UUID;
import java.util.ArrayList;
public class Crime {
	private int caseNum;
	private UUID crimeID;
	/*private UUID suspectID;
	private UUID victimID;
	private UUID witnessID;*/
	private ArrayList<Suspect> suspectID = new ArrayList<Suspect>();
	private ArrayList<Victim> victimID = new ArrayList<Victim>();
	private ArrayList<Witness> witnessID = new ArrayList<Witness>();
	private String crimeCommited;
	private String crimeLocation;
	private String crimeDate;
	private String criminal;
	private boolean criminalInCustody;
	private String evidence;
	private boolean isSolved;
	
	public Crime(String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, String evidence, boolean isSolved) {
		this.crimeID = UUID.randomUUID();
		this.crimeCommited = crimeCommited;
		this.crimeLocation = crimeLocation;
		this.crimeDate = crimeDate;
		this.criminal = criminal;
		this.criminalInCustody = criminalInCustody;
		this.evidence = evidence;
		this.isSolved = isSolved;
	}
	public Crime(int caseNum, String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, String evidence, boolean isSolved) {
		this.caseNum = caseNum;
		this.crimeID = UUID.randomUUID();
		this.crimeCommited = crimeCommited;
		this.crimeLocation = crimeLocation;
		this.crimeDate = crimeDate;
		this.criminal = criminal;
		this.criminalInCustody = criminalInCustody;
		this.evidence = evidence;
		this.isSolved = isSolved;
	}
	public Crime(int caseNum, UUID crimeID, ArrayList<Suspect> suspectID, ArrayList<Victim> victimID, ArrayList<Witness> witnessID, String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, String evidence, boolean isSolved) {
		this.caseNum = caseNum;
		this.crimeID = crimeID;
		this.suspectID = suspectID;
		this.victimID = victimID;
		this.witnessID = witnessID;
		this.crimeCommited = crimeCommited;
		this.crimeLocation = crimeLocation;
		this.crimeDate = crimeDate;
		this.criminal = criminal;
		this.criminalInCustody = criminalInCustody;
		this.evidence = evidence;
		this.isSolved = isSolved;
	}

	//Setters and getters
	public int getCaseNum() {
		return this.caseNum;
	}

	public void setCaseNum(int caseNum) {
		this.caseNum = caseNum;
	}

	public UUID getCrimeID() {
		return this.crimeID;
	}

	public void setCrimeID(UUID crimeID) {
		this.crimeID = crimeID;
	}

	public ArrayList<Suspect> getSuspectID() {
		return this.suspectID;
	}

	public void setSuspectID(Suspect suspectID) {
		this.suspectID.add(suspectID);
	}

	public ArrayList<Victim> getVictimID() {
		return this.victimID;
	}

	public void setVictimID(Victim victimID) {
		this.victimID.add(victimID);
	}
	public void setWitnessID(Witness witnessID) {
		this.witnessID.add(witnessID);
	}

	public ArrayList<Witness> getWitnessID() {
		return witnessID;
	}

	public String getCrimeCommited() {
		return crimeCommited;
	}

	public void setCrimeCommited(String crimeCommited) {
		this.crimeCommited = crimeCommited;
	}

	public String getCrimeLocation() {
		return crimeLocation;
	}

	public void setCrimeLocation(String crimeLocation) {
		this.crimeLocation = crimeLocation;
	}

	public String getCrimeDate() {
		return crimeDate;
	}

	public void setCrimeDate(String crimeDate) {
		this.crimeDate = crimeDate;
	}

    public String getCriminal() {
        return criminal;
    }

	public void setCriminal(String criminal) {
		this.criminal = criminal;
	}

	public boolean isCriminalInCustody() {
		return criminalInCustody;
	}

	public void setCriminalInCustody(boolean criminalInCustody) {
		this.criminalInCustody = criminalInCustody;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public boolean isSolved() {
		return isSolved;
	}
	
	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}
	
	public String print() {
		String print = "\n************ Crime *************" + "Case Number: " + caseNum + "Crime Commited: " + crimeCommited + "Location of Crime: " + crimeLocation + "Date Crime Occured: " + crimeDate
		+ "Criminal Name: " + criminal + "Criminal is in Custody: " + criminalInCustody + "Evidence: " + evidence + "Is the Crime Solved: " + isSolved;
		return print;
	}
}
