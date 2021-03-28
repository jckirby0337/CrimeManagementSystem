import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

/**
 * Loads in json files into arraylist of the given object list
 * @author Team Coalition
 * 
 */
public class DataLoader extends DataConstants{
	
	/** 
	 * Reads the crime json and takes in the parameters to then make a crime object and add it to the crimelist arraylist
	 * @return ArrayList<Crime>
	 */
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

	
	/** 
	 * Reads the evidence json array in the json file and converts it to an arraylist of strings which it returns
	 * @param evidence
	 * @return ArrayList<String>
	 */
	private static ArrayList<String> getEvidence(JSONArray evidence) {
		ArrayList<String> evidences = new ArrayList<String>();
		for(int i=0; i<evidence.size(); i++) {
			evidences.add((String)evidence.get(i));
		}
		return evidences;
	}

	
	/** 
	 * Gets suspects from the suspects arraylist by their UUID and adds them to an arraylist of suspects in the crime object
	 * @param suspectIDs
	 * @return ArrayList<Suspect>
	 */
	private static ArrayList<Suspect> getSuspectsbyID(JSONArray suspectIDs) {
		ArrayList<Suspect> suspects = new ArrayList<Suspect>();
		for(int i=0; i<suspectIDs.size(); i++) {
			UUID suspectID = UUID.fromString((String)suspectIDs.get(i));
			Suspect suspect = Suspects.getInstance().getSuspect(suspectID);
			suspects.add(suspect);
		}
		return suspects;
	}

	
	/** 
	 * Gets victims from the victims arraylist by their UUID and adds them to an arraylist of victims in the crime object
	 * @param victimIDs
	 * @return ArrayList<Victim>
	 */
	private static ArrayList<Victim> getVictimsbyID(JSONArray victimIDs) {
		ArrayList<Victim> victims = new ArrayList<Victim>();
		for(int i=0; i<victimIDs.size(); i++) {
			UUID victimID = UUID.fromString((String)victimIDs.get(i));
			Victim victim = Victims.getInstance().getVictim(victimID);
			victims.add(victim);
		}
		return victims;
	}

	
	/** 
	 * Gets witnesses from the witnesses arraylist by their UUID and adds them to an arraylist of witnesses in the crime object
	 * @param witnessIDs
	 * @return ArrayList<Witness>
	 */
	private static ArrayList<Witness> getWitnessesbyID(JSONArray witnessIDs) {
		ArrayList<Witness> witnesses = new ArrayList<Witness>();
		for(int i=0; i<witnessIDs.size(); i++) {
			UUID witnessID = UUID.fromString((String)witnessIDs.get(i));
			Witness witness = Witnesses.getInstance().getWitness(witnessID);
			witnesses.add(witness);
		}
		return witnesses;
	}

	
	/** 
	 * Reads the suspect json file and adds the suspects to an arraylist of suspect
	 * @return ArrayList<Suspect>
	 */
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
				String phoneNumber = (String)suspectJSON.get(SUSPECT_PHONE_NUMBER);
				String height = (String)suspectJSON.get(SUSPECT_HEIGHT);
				String email = (String)suspectJSON.get(SUSPECT_EMAIL);
				String tattoos = (String)suspectJSON.get(SUSPECT_TATTOOS);
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
				String hairColor = (String)suspectJSON.get(SUSPECT_HAIR_COLOR);
				String clothing = (String)suspectJSON.get(SUSPECT_CLOTHING);
				String conviction = (String)suspectJSON.get(SUSPECT_CONVICTION);
				boolean isInPrison = (boolean)suspectJSON.get(SUSPECT_IS_IN_PRISON);

				suspects.add(new Suspect(suspectID, name, age, sex, race, phoneNumber, height, email, tattoos, vehicle, licensePlate, address, bankAccount,
			 	creditCard, armed, publicRisk, nicknames, mentalState, housingLocation, educationLevel, hairColor, clothing, conviction, isInPrison));
			}
			
			return suspects;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/** 
	 * Reads the victim json file and adds the victims to an arraylist of victim
	 * @return ArrayList<Victim>
	 */
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
				String phoneNumber = (String)victimJSON.get(VICTIM_PHONE_NUMBER);
				String height = (String)victimJSON.get(VICTIM_HEIGHT);
				String email = (String)victimJSON.get(VICTIM_EMAIL);
				String details = (String)victimJSON.get(VICTIM_DETAILS);
				UUID victimID = UUID.fromString((String)victimJSON.get(VICTIM_ID));
				
				victims.add(new Victim(victimID, name, age, sex, race, phoneNumber, height, email, details));
			}
			
			return victims;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/** 
	 * Reads the user json file and adds the users to an arraylist of user
	 * @return ArrayList<User>
	 */
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

	
	/** 
	 * Reads the witness json file and adds the witnesses to an arraylist of witness
	 * @return ArrayList<Witness>
	 */
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
				String phoneNumber = (String)witnessJSON.get(WITNESS_PHONE_NUMBER);
				String height = (String)witnessJSON.get(WITNESS_HEIGHT);
				String email = (String)witnessJSON.get(WITNESS_EMAIL);
				String details = (String)witnessJSON.get(WITNESS_DETAILS);
				String story = (String)witnessJSON.get(WITNESS_STORY);
				boolean isDefending = (boolean)witnessJSON.get(WITNESS_ISDEFENDING);
				
				witnesses.add(new Witness(witnessesID, name, age, sex, race, phoneNumber, height, email, details, story, isDefending));
			}
			
			return witnesses;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}