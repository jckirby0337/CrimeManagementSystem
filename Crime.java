import java.util.UUID;
public class Crime {
	private int caseNum;
	private UUID crimeID;
	private UUID suspectID;
	private UUID victimID;
	private UUID witnessID;
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
		this.suspectID = UUID.randomUUID();
		this.victimID = UUID.randomUUID();
		this.witnessID = UUID.randomUUID();
		this.crimeCommited = crimeCommited;
		this.crimeLocation = crimeLocation;
		this.crimeDate = crimeDate;
		this.criminal = criminal;
		this.criminalInCustody = criminalInCustody;
		this.evidence = evidence;
		this.isSolved = isSolved;
	}
	public Crime(int caseNum, UUID crimeID, UUID suspectID, UUID victimID, UUID witnessID, String crimeCommited, String crimeLocation, String crimeDate, String criminal, boolean criminalInCustody, String evidence, boolean isSolved) {
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

	public UUID getSuspectID() {
		return this.suspectID;
	}

	public void setSuspectID(UUID suspectID) {
		this.suspectID = suspectID;
	}

	public UUID getVictimID() {
		return this.victimID;
	}

	public void setVictimID(UUID victimID) {
		this.victimID = victimID;
	}
	public void setWitnessID(UUID witnessID) {
		this.witnessID = witnessID;
	}

	public UUID getWitnessID() {
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
	
	public void print() {
		System.out.println("Case Number: " + caseNum);
		System.out.println("Crime Commited: " + crimeCommited);
		System.out.println("Location of Crime: " + crimeLocation);
		System.out.println("Date Crime Occured: " + crimeDate);
		System.out.println("Criminal Name: " + criminal);
		System.out.println("Criminal is in Custody: " + criminalInCustody);
		System.out.println("Evidence: " + evidence);
		System.out.println("Is the Crime Solved: " + isSolved);
	}
}
