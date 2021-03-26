import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	public static ArrayList<Crime> getCrimes() {
		ArrayList<Crime> crimes = new ArrayList<Crime>();
		
		try {
			FileReader reader = new FileReader(CRIME_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray crimesJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < crimesJSON.size(); i++) {
				JSONObject crimeJSON = (JSONObject)crimesJSON.get(i);
				int caseNum = ((Long)crimeJSON.get(CASE_NUMBER)).intValue();
				UUID crimeID = UUID.fromString((String)crimeJSON.get(CRIME_ID));
				ArrayList<Suspect> suspectID = getSuspectsbyID((JSONArray)crimeJSON.get(CRIME_SUSPECT_ID));
				ArrayList<Victim> victimID = getVictimsbyID((JSONArray)crimeJSON.get(CRIME_VICTIM_ID));
				ArrayList<Witness> witnessID = getWitnessesbyID((JSONArray)crimeJSON.get(CRIME_WITNESS_ID));
				/*UUID suspectID = UUID.fromString((String)crimeJSON.get(CRIME_SUSPECT_ID));
				UUID victimID = UUID.fromString((String)crimeJSON.get(CRIME_VICTIM_ID));
				UUID witnessID = UUID.fromString((String)crimeJSON.get(CRIME_WITNESS_ID));
				Witness witness = Witnesses.getInstance().getWitness()*/
				String crimeCommitted = (String)crimeJSON.get(CRIME_COMMITTED);
				String crimeLocation = (String)crimeJSON.get(CRIME_LOCATION);
				String crimeDate = (String)crimeJSON.get(CRIME_DATE);
                String criminal = (String)crimeJSON.get(CRIMINAL);
                boolean criminalCustody = (boolean)crimeJSON.get(CRIMINAL_CUSTODY);
                ArrayList<String> evidence = getEvidence((JSONArray)crimeJSON.get(EVIDENCE));
                boolean solved = (boolean)crimeJSON.get(SOLVED);
				
				crimes.add(new Crime(caseNum, crimeID, suspectID, victimID, witnessID, crimeCommitted, crimeLocation, crimeDate, criminal, criminalCustody, evidence, solved));
			}
			
			return crimes;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private static ArrayList<String> getEvidence(JSONArray evidence) {
		ArrayList<String> evidences = new ArrayList<String>();
		for(int i=0; i<evidence.size(); i++) {
			evidences.add((String)evidences.get(i));
		}
		return evidences;
	}

	private static ArrayList<Suspect> getSuspectsbyID(JSONArray suspectIDs) {
		ArrayList<Suspect> suspects = new ArrayList<Suspect>();
		for(int i=0; i<suspectIDs.size(); i++) {
			UUID suspectID = UUID.fromString((String)suspectIDs.get(i));
			Suspect suspect = Suspects.getInstance().getSuspect(suspectID);
			suspects.add(suspect);
		}
		return suspects;
	}

	private static ArrayList<Victim> getVictimsbyID(JSONArray victimIDs) {
		ArrayList<Victim> victims = new ArrayList<Victim>();
		for(int i=0; i<victimIDs.size(); i++) {
			UUID victimID = UUID.fromString((String)victimIDs.get(i));
			Victim victim = Victims.getInstance().getVictim(victimID);
			victims.add(victim);
		}
		return victims;
	}

	private static ArrayList<Witness> getWitnessesbyID(JSONArray witnessIDs) {
		ArrayList<Witness> witnesses = new ArrayList<Witness>();
		for(int i=0; i<witnessIDs.size(); i++) {
			UUID witnessID = UUID.fromString((String)witnessIDs.get(i));
			Witness witness = Witnesses.getInstance().getWitness(witnessID);
			witnesses.add(witness);
		}
		return witnesses;
	}

	public static ArrayList<Suspect> getSuspects() {
		ArrayList<Suspect> suspects = new ArrayList<Suspect>();
		
		try {
			FileReader reader = new FileReader(SUSPECT_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray suspectsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < suspectsJSON.size(); i++) {
				JSONObject suspectJSON = (JSONObject)suspectsJSON.get(i);
                UUID suspectID = UUID.fromString((String)suspectJSON.get(SUSPECT_ID));
				String name = (String)suspectJSON.get(SUSPECT_NAME);
				int age = ((Long)suspectJSON.get(SUSPECT_AGE)).intValue();
				String sex = (String)suspectJSON.get(SUSPECT_SEX);
				String race = (String)suspectJSON.get(SUSPECT_RACE);
                boolean tattoos = (boolean)suspectJSON.get(SUSPECT_TATTOOS);
				String vehicle = (String)suspectJSON.get(SUSPECT_VEHICLE);
				String licensePlate = (String)suspectJSON.get(SUSPECT_LICENSE_PLATE);
				String address = (String)suspectJSON.get(SUSPECT_ADDRESS);
				boolean bankAccount = (boolean)suspectJSON.get(SUSPECT_BANK_ACCOUNT);
                boolean creditCard = (boolean)suspectJSON.get(SUSPECT_CREDIT_CARD);
				boolean armed = (boolean)suspectJSON.get(SUSPECT_ARMED);
				boolean publicRisk = (boolean)suspectJSON.get(SUSPECT_PUBLIC_RISK);
				String nicknames = (String)suspectJSON.get(SUSPECT_NICKNAMES);
				String mentalState = (String)suspectJSON.get(SUSPECT_MENTAL_STATE);
				String housingLocation = (String)suspectJSON.get(SUSPECT_HOUSE_LOCATION);
				String educationLevel = (String)suspectJSON.get(SUSPECT_EDUCATION_LEVEL);

				suspects.add(new Suspect(suspectID, name, age, sex, race, tattoos, vehicle, licensePlate, address, bankAccount,
			 	creditCard, armed, publicRisk, nicknames, mentalState, housingLocation, educationLevel));
			}
			
			return suspects;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static ArrayList<Victim> getVictims() {
		ArrayList<Victim> victims = new ArrayList<Victim>();
		
		try {
			FileReader reader = new FileReader(VICTIM_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray victimsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < victimsJSON.size(); i++) {
				JSONObject victimJSON = (JSONObject)victimsJSON.get(i);
				String name = (String)victimJSON.get(VICTIM_NAME);
				int age = ((Long)victimJSON.get(VICTIM_AGE)).intValue();
				String sex = (String)victimJSON.get(VICTIM_SEX);
				String race = (String)victimJSON.get(VICTIM_RACE);
				String details = (String)victimJSON.get(VICTIM_DETAILS);
				UUID victimID = UUID.fromString((String)victimJSON.get(VICTIM_ID));
				
				victims.add(new Victim(victimID, name, age, sex, race, details));
			}
			
			return victims;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < usersJSON.size(); i++) {
				JSONObject userJSON = (JSONObject)usersJSON.get(i);
				UUID userID = UUID.fromString((String)userJSON.get(USER_USER_ID));
				String name = (String)userJSON.get(USER_NAME);
				String title = (String)userJSON.get(USER_TITLE);
				String race = (String)userJSON.get(USER_RACE);
                String dob = (String)userJSON.get(USER_DATE_OF_BIRTH);
                String address = (String)userJSON.get(USER_ADDRESS);
                String password = (String)userJSON.get(USER_USER_PASSWORD);
                String username = (String)userJSON.get(USER_USERNAME);
				
				users.add(new User(userID, name, title, race, dob, address, password, username));
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}

	public static ArrayList<Witness> getWitnesses() {
		ArrayList<Witness> witnesses = new ArrayList<Witness>();
		
		try {
			FileReader reader = new FileReader(WITNESS_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray witnessesJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < witnessesJSON.size(); i++) {
				JSONObject witnessJSON = (JSONObject)witnessesJSON.get(i);
				UUID witnessesID = UUID.fromString((String)witnessJSON.get(WITNESS_ID));
				String name = (String)witnessJSON.get(WITNESS_NAME);
				int age = ((Long)witnessJSON.get(WITNESS_AGE)).intValue();
				String sex = (String)witnessJSON.get(WITNESS_SEX);
				String race = (String)witnessJSON.get(WITNESS_RACE);
				String details = (String)witnessJSON.get(WITNESS_DETAILS);
				String story = (String)witnessJSON.get(WITNESS_STORY);
				boolean isDefending = (boolean)witnessJSON.get(WITNESS_ISDEFENDING);
				
				witnesses.add(new Witness(witnessesID, name, age, sex, race, details, story, isDefending));
			}
			
			return witnesses;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/*public static void main(String[] args) {
		ArrayList<User> users = DataLoader.getUsers();
		for(User user: users) {
			System.out.println(user);
		}
		

		System.out.println(UUID.randomUUID());
	}
	*/
}