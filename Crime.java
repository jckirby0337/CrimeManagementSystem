import java.util.UUID;
import java.util.ArrayList;
public class Crime {
	private int caseNum;
	private UUID crimeID;
	private ArrayList<Suspect> suspectID = new ArrayList<Suspect>();
	private ArrayList<Victim> victimID = new ArrayList<Victim>();
	private ArrayList<Witness> witnessID = new ArrayList<Witness>();
	private String crimeCommited;
	private String crimeLocation;
	private String crimeDate;
	private String criminal;
	private boolean criminalInCustody;
	private ArrayList<String> evidence = new ArrayList<String>();
	private boolean isSolved;
	
	public Crime(int caseNum, String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, ArrayList<String> evidence, boolean isSolved) {
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
	public Crime(int caseNum, UUID crimeID, ArrayList<Suspect> suspectID, ArrayList<Victim> victimID, ArrayList<Witness> witnessID, String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, ArrayList<String> evidence, boolean isSolved) {
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

	public ArrayList<String> getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence.add(evidence);
	}

	public boolean isSolved() {
		return isSolved;
	}
	
	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

	private String evidenceToString(){
		String ev = "";
		for(int i = 0; i<evidence.size(); i++) {
			ev += "\nEvidence " + i + ": " + evidence.get(i);
		}
		return ev;
	}
	
	public String print() {
		String print = "\n************ Crime *************" + "\nCase Number: " + caseNum + "\nCrime Commited: " + crimeCommited + "\nLocation of Crime: " + crimeLocation + "\nDate Crime Occured: " + crimeDate
		+ "\nCriminal Name: " + criminal + "\nCriminal is in Custody: " + criminalInCustody + evidenceToString() + "\nIs the Crime Solved: " + isSolved;
		return print;
	}
}
