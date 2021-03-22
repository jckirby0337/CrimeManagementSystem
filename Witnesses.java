import java.util.ArrayList;
import java.util.UUID;
public class Witnesses {
    private static Witnesses witnesses;
	private ArrayList<Witness> witnessList;
	
	private Witnesses() {
		witnessList = DataLoader.getWitnesses();
	}
	
	public static Witnesses getInstance() {
		if(witnesses == null) {
			witnesses = new Witnesses();
		}
		
		return witnesses;
	}

	public boolean haveWitness(String name) {
		for(Witness witness : witnessList) {
			if(witness.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Witness getWitness(String name) {
		for(Witness witness : witnessList) {
			if(witness.getName().equals(name)) {
				return witness;
			}
		}
		
		return null;
	}
	
	public ArrayList<Witness> getWitnesses() {
		return witnessList;
	}
	
	public boolean addWitness(String name, int age, String sex, String race, String details, String story, boolean isDefending) {
		if(haveWitness(name))return false;
		
		witnessList.add(new Witness(name, age, sex, race, details, story, isDefending));
		return true;
	}
	
	public void saveWitnesses() {
		DataWriter.saveWitnesses();
	}

}
