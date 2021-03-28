import java.util.ArrayList;
import java.util.UUID;
/**
 * Creates a Witnesses object that creates a new ArrayList of witnesses 
 * @author Team Coalition
 */
public class Witnesses {
    private static Witnesses witnesses;
	private ArrayList<Witness> witnessList;

	/**
	 * Creates the Witnesses object which has an arraylist of witnesses
	 */
	private Witnesses() {
		witnessList = DataLoader.getWitnesses();
	}

	/**
	 * Gets an instance of Witnesses and creates the Witnesses
	 * @return Witnesses
	 */
	public static Witnesses getInstance() {
		if(witnesses == null) {
			witnesses = new Witnesses();
		}
		
		return witnesses;
	}

	/**
	 * Takes in the name of a witness and checks the arraylist of witnesses for that name
	 * @param name of the witness
	 * @return True if arraylist has the name, false if arraylist doesn't have the name
	 */
	public boolean haveWitness(String name) {
		for(Witness witness : witnessList) {
			if(witness.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Gets each witness with the provided name from the arraylist
	 * @param name of the witness
	 * @return Witness object with the provided name
	 */
	public Witness getWitness(String name) {
		for(Witness witness : witnessList) {
			if(witness.getName().equals(name)) {
				return witness;
			}
		}
		
		return null;
	}

	/**
	 * Gets each witness with the provided witnessID from the arraylist
	 * @param witnessID UUID of the witness
	 * @return Witness object with the provided ID 
	 */
	public Witness getWitness(UUID witnessID) {
		for(Witness witness : witnessList) {
			if(witness.getWitnessID().equals(witnessID)) {
				return witness;
			}
		}
		
		return null;
	}

	/**
	 * Gets the last Witness in the arraylist
	 * @return Witness object at the end of the arraylist
	 */
	public Witness getLastWitness() {
		return witnessList.get(witnessList.size()-1);
	}

	/**
	 * Gets the Witnesses and puts them in a list 
	 * @return a list of the witnesses
	 */
	public ArrayList<Witness> getWitnesses() {
		return witnessList;
	}

	/**
	 * 
	 * @param name name of the witness
	 * @param age age of the witness
	 * @param sex sex of the witness
	 * @param race race of the witness
	 * @param phoneNumber phoneNumber of the witness
	 * @param height height of the witness
	 * @param email email of the witness
	 * @param details extra description of the witness
	 * @param story story provided by the witness
	 * @param isDefending if the witness was defending themselves or another
	 * @return Boolean true if the witness name doesn't exist, Boolean false if the witness name does exist 
	 */
	public boolean addWitness(String name, int age, String sex, String race, String phoneNumber, String height, String email, String details, String story, boolean isDefending) {
		if(haveWitness(name))return false;
		
		witnessList.add(new Witness(name, age, sex, race, phoneNumber, height, email, details, story, isDefending));
		return true;
	}

	/**
	 * Saves the witnesses and writes it to a file
	 */
	public void saveWitnesses() {
		DataWriter.saveWitnesses();
	}

}
