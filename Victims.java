import java.util.ArrayList;
import java.util.UUID;
/**
 * Creates the Object Victims
 * @author Team Coalition
 */
public class Victims {
    private static Victims victims;
	private ArrayList<Victim> victimList;
	
	/**
	 * Constructs the Victims Object with an Arraylist of type Victim
	 */
	private Victims() {
		victimList = DataLoader.getVictims();
	}

	/**
	 * Gets an instance of the Victims object 
	 * @return a new instance of the Victims Object
	 */
	public static Victims getInstance() {
		if(victims == null) {
			victims = new Victims();
		}
		
		return victims;
	}

	/**
	 * Checks if the ArrayList of Victims has a Victim with the provided name
	 * @param name of the victim
	 * @return True if the arraylist has the victim, False if the arraylist doesnt have the victim
	 */
	public boolean haveVictim(String name) {
		for(Victim victim : victimList) {
			if(victim.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Gets the victim with the provided name in the arraylist
	 * @param name of the victim
	 * @return the victim with the name
	 */
	public Victim getVictim(String name) {
		for(Victim victim : victimList) {
			if(victim.getName().equals(name)) {
				return victim;
			}
		}
		
		return null;
	}

	/**
	 * Gets the victim with the provided id in the arraylist
	 * @param victimID of the victim
	 * @return the victim with the id
	 */
	public Victim getVictim(UUID victimID) {
		for(Victim victim : victimList) {
			if(victim.getVictimID().equals(victimID)) {
				return victim;
			}
		}
		
		return null;
	}

	/**
	 * Gets the last Victim in the arraylist
	 * @return Victim at the end 
	 */
	public Victim getLastVictim() {
		return victimList.get(victimList.size()-1);
	}

	/**
	 * Gets an arrayList of victims 
	 * @return an arraylist of victims 
	 */
	public ArrayList<Victim> getVictims() {
		return victimList;
	}

	/**
	 * Adds a victim to the arraylist
	 * @param name of the victim
	 * @param age of the victim
	 * @param sex of the victim
	 * @param race of the victim
	 * @param phoneNumber of the victim
	 * @param height of the victim
	 * @param email of the victim
	 * @param details of the victim
	 * @return True if a victim with the name doesn't exist, False if there already exists a victim with the name
	 */
	public boolean addVictim(String name, int age, String sex, String race, String phoneNumber, String height, String email, String details) {
		if(haveVictim(name))return false;
		
		victimList.add(new Victim(name, age, sex, race, phoneNumber, height, email, details));
		return true;
	}

	/**
	 * Writes the victim to a file  
	 */
	public void saveVictims() {
		DataWriter.saveVictims();
	}

}
