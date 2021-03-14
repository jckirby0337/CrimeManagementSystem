import java.util.ArrayList;

public class Offenders {
	private static Offenders offenders;
	private ArrayList<Offender> offenderList;
	
	private Offenders() {
		offenderList = DataLoader.getOffenders();
	}
	
	public static Offenders getInstance() {
		if(offenders == null) {
			offenders = new Offenders();
		}
		
		return offenders;
	}

	public boolean haveOffender(String name) {
		for(Offender offender : offenderList) {
			if(offender.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Offender getOffender(String name) {
		for(Offender offender : offenderList) {
			if(offender.getName().equals(name)) {
				return offender;
			}
		}
		
		return null;
	}
	
	public ArrayList<Offender> getOffenders() {
		return offenderList;
	}
	
	public boolean addOffender(String name, int age, char sex, String race, boolean tattoos, int crimeId, int offenderID, String vehicle, String licensePlate, int crimeLevels, 
    String address, boolean bankAccount, boolean creditCard, boolean armed, boolean publicRisk,
    String nicknames, String mentalState, String housingLocations, String educationLevel, ArrayList<String> family) {
		if(haveOffender(name))return false;
		
		offenderList.add(new Offender(name, age, sex, race, tattoos, crimeId, offenderID, vehicle, licensePlate, crimeLevels, 
        address, bankAccount, creditCard, armed, publicRisk,
        nicknames, mentalState, housingLocations, educationLevel, family));
		return true;
	}
	
	public void saveOffender() {
		DataWriter.saveOffenders();
	}
}