package CrimeManagementSystem;
public class Crime {

	private String crimeCommited;
	private String crimeLocation;
	private int crimeDate;
	private String criminal;
	private boolean criminalInCustody;
	private String evidence;
	private boolean isSolved;
	
	//Setters and getters
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
	public int getCrimeDate() {
		return crimeDate;
	}
	public void setCrimeDate(int crimeDate) {
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
	
	
}
