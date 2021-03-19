import java.util.ArrayList;
public class Victims {
    private static Victims victims;
	private ArrayList<Victim> victimList;
	
	private Victims() {
		victimList = DataLoader.getVictims();
	}
	
	public static Victims getInstance() {
		if(victims == null) {
			victims = new Victims();
		}
		
		return victims;
	}

	public boolean havevictim(String name) {
		for(Victim victim : victimList) {
			if(victim.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Victim getUser(String name) {
		for(Victim victim : victimList) {
			if(victim.getName().equals(name)) {
				return victim;
			}
		}
		
		return null;
	}
	
	public ArrayList<Victim> getVictims() {
		return victimList;
	}
	
	public boolean addVictim(String name, int age, char sex, String race, Boolean tattoos,
    String vehicle, String licensePlate, String address, Boolean bankAccount,
    Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
    String mentalState, String housingLocation, String educationLevel) {
		if(haveVictim(name))return false;
		
		victimList.add(new Victim(name, age, sex, race, tattoos, vehicle, licensePlate, address, bankAccount, 
                                    creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, 
                                    educationLevel));
		return true;
	}
	
	public void saveVictims() {
		DataWriter.saveVictims();
	}

}
