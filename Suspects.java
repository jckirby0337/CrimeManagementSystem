import java.util.ArrayList;

public class Suspects {
	private static Suspects suspects;
	private ArrayList<Suspect> suspectList;
	
	private Suspects() {
		suspectList = DataLoader.getSuspects();
	}
	
	public static Suspects getInstance() {
		if(suspects == null) {
			suspects = new Suspects();
		}
		
		return suspects;
	}

	public boolean haveSuspect(String name) {
		for(Suspect suspect : suspectList) {
			if(suspect.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Suspect getUser(String name) {
		for(Suspect suspect : suspectList) {
			if(suspect.getName().equals(name)) {
				return suspect;
			}
		}
		
		return null;
	}
	
	public ArrayList<Suspect> getSuspects() {
		return suspectList;
	}
	
	public boolean addSuspect(String name, int age, char sex, String race, Boolean tattoos,
    String vehicle, String licensePlate, String address, Boolean bankAccount,
    Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
    String mentalState, String housingLocation, String educationLevel) {
		if(haveSuspect(name))return false;
		
		suspectList.add(new Suspect(name, age, sex, race, tattoos, vehicle, licensePlate, address, bankAccount, 
                                    creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, 
                                    educationLevel));
		return true;
	}
	
	public void saveSuspects() {
		DataWriter.saveSuspects();
	}
}