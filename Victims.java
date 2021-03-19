import java.util.ArrayList;
import java.util.UUID;
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

	public boolean haveVictim(String name) {
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
	
	public boolean addVictim(UUID victimID, String name, int age, char sex, String race, String details) {
		if(haveVictim(name))return false;
		
		victimList.add(new Victim(victimID, name, age, sex, race, details));
		return true;
	}
	
	public void saveVictims() {
		DataWriter.saveVictims();
	}

}
