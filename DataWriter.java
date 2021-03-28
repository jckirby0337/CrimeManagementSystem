
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    public static void saveCrimes() {
		Crimes crimes = Crimes.getInstance(); 
		ArrayList<Crime> crimeList = crimes.getCrimes();
		JSONArray jsonCrimes = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< crimeList.size(); i++) {
			jsonCrimes.add(getCrimeJSON(crimeList.get(i)));
		}
    
		
		//Write JSON file
        try (FileWriter file = new FileWriter(CRIME_FILE_NAME)) {
 
            file.write(jsonCrimes.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	} 

    public static void saveSuspects() {
		Suspects suspects = Suspects.getInstance(); 
		ArrayList<Suspect> suspectList = suspects.getSuspects();
		JSONArray jsonSuspects = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< suspectList.size(); i++) {
			jsonSuspects.add(getSuspectJSON(suspectList.get(i)));
		}
    
		
		//Write JSON file
        try (FileWriter file = new FileWriter(SUSPECT_FILE_NAME)) {
 
            file.write(jsonSuspects.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    public static void saveUsers() {
		Users users = Users.getInstance(); 
		ArrayList<User> userList = users.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJSON(userList.get(i)));
		}
    
		
		//Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void saveVictims() {
		Victims victims = Victims.getInstance();
		ArrayList<Victim> victimList = victims.getVictims();
		JSONArray jsonVictims = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< victimList.size(); i++) {
			jsonVictims.add(getVictimJSON(victimList.get(i)));
		}
    
		
		//Write JSON file
        try (FileWriter file = new FileWriter(VICTIM_FILE_NAME)) {
 
            file.write(jsonVictims.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void saveWitnesses() {
		Witnesses witnesses = Witnesses.getInstance();
		ArrayList<Witness> witnessList = witnesses.getWitnesses();
		JSONArray jsonWitnesses = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< witnessList.size(); i++) {
			jsonWitnesses.add(getWitnessJSON(witnessList.get(i)));
		}
    
		
		//Write JSON file
        try (FileWriter file = new FileWriter(WITNESS_FILE_NAME)) {
 
            file.write(jsonWitnesses.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static JSONObject getCrimeJSON(Crime crime) {
		JSONObject crimeDetails = new JSONObject();
		crimeDetails.put(CASE_NUMBER, crime.getCaseNum());
		crimeDetails.put(CRIME_ID, crime.getCrimeID().toString());
		crimeDetails.put(CRIME_SUSPECT_ID, getSuspectIDArray(crime.getSuspectID()));
		crimeDetails.put(CRIME_VICTIM_ID, getVictimIDArray(crime.getVictimID()));
		crimeDetails.put(CRIME_WITNESS_ID, getWitnessIDArray(crime.getWitnessID()));
        crimeDetails.put(CRIME_COMMITTED, crime.getCrimeCommited());
        crimeDetails.put(CRIME_LOCATION, crime.getCrimeLocation());
        crimeDetails.put(CRIME_DATE, crime.getCrimeDate());
        crimeDetails.put(CRIMINAL, crime.getCriminal());
        crimeDetails.put(CRIMINAL_CUSTODY, crime.isCriminalInCustody());
		crimeDetails.put(EVIDENCE, getEvidenceArray(crime.getEvidence()));
        crimeDetails.put(SOLVED, crime.isSolved());
        return crimeDetails;
	}

	public static JSONArray getEvidenceArray(ArrayList<String> evidences) {
		JSONArray evidence = new JSONArray();
		for(String evi : evidences) {
			evidence.add(evi);
		}
		return evidence;
	}

	public static JSONArray getSuspectIDArray(ArrayList<Suspect> suspects) {
		JSONArray suspectIDs = new JSONArray();
		for(Suspect suspect : suspects) {
			suspectIDs.add(suspect.getSuspectID().toString());
		}
		return suspectIDs;
	}

	public static JSONArray getVictimIDArray(ArrayList<Victim> victims) {
		JSONArray victimIDs = new JSONArray();
		for(Victim victim : victims) {
			victimIDs.add(victim.getVictimID().toString());
		}
		return victimIDs;
	}

	public static JSONArray getWitnessIDArray(ArrayList<Witness> witnesses) {
		JSONArray witnessIDs = new JSONArray();
		for(Witness witness : witnesses) {
			witnessIDs.add(witness.getWitnessID().toString());
		}
		return witnessIDs;
	}

	public static JSONObject getSuspectJSON(Suspect suspect) {
		JSONObject suspectDetails = new JSONObject();
        suspectDetails.put(SUSPECT_ID, suspect.getSuspectID().toString());
        suspectDetails.put(SUSPECT_NAME, suspect.getName());
        suspectDetails.put(SUSPECT_AGE, suspect.getAge());
        suspectDetails.put(SUSPECT_SEX, suspect.getSex());
        suspectDetails.put(SUSPECT_RACE, suspect.getRace());
		suspectDetails.put(SUSPECT_PHONE_NUMBER, suspect.getPhoneNumber());
		suspectDetails.put(SUSPECT_HEIGHT, suspect.getHeight());
		suspectDetails.put(SUSPECT_EMAIL, suspect.getEmail());	
		suspectDetails.put(SUSPECT_TATTOOS, suspect.getTattoos());
        suspectDetails.put(SUSPECT_VEHICLE, suspect.getVehicle());
		suspectDetails.put(SUSPECT_LICENSE_PLATE, suspect.getLicensePlate());
		suspectDetails.put(SUSPECT_ADDRESS, suspect.getAddress());
		suspectDetails.put(SUSPECT_BANK_ACCOUNT, suspect.hasBankAccount());
		suspectDetails.put(SUSPECT_CREDIT_CARD, suspect.hasCreditCard());
		suspectDetails.put(SUSPECT_ARMED, suspect.isArmed());
		suspectDetails.put(SUSPECT_PUBLIC_RISK, suspect.publicRisk());
		suspectDetails.put(SUSPECT_NICKNAMES, suspect.getNicknames());
		suspectDetails.put(SUSPECT_MENTAL_STATE, suspect.getMentalState());
		suspectDetails.put(SUSPECT_HOUSE_LOCATION, suspect.getHousingLocation());
		suspectDetails.put(SUSPECT_EDUCATION_LEVEL, suspect.getEducationLevel());
		suspectDetails.put(SUSPECT_HAIR_COLOR, suspect.getHairColor());
		suspectDetails.put(SUSPECT_CLOTHING, suspect.getClothing());
		suspectDetails.put(SUSPECT_CONVICTION, suspect.getConviction());
		suspectDetails.put(SUSPECT_IS_IN_PRISON, suspect.getIsInPrison());
        return suspectDetails;
	}

    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_USER_ID, user.getUserID().toString());
		userDetails.put(USER_NAME, user.getName());
		userDetails.put(USER_TITLE, user.getTitle());
		userDetails.put(USER_RACE, user.getRace());
		userDetails.put(USER_DATE_OF_BIRTH, user.getDOB());
		userDetails.put(USER_ADDRESS, user.getAddress());
		userDetails.put(USER_USER_PASSWORD, user.getPassword());
		userDetails.put(USER_USERNAME, user.getUsername());
        return userDetails;
	}

	public static JSONObject getVictimJSON(Victim victim) {
		JSONObject victimDetails = new JSONObject();
		victimDetails.put(VICTIM_ID, victim.getVictimID().toString());
		victimDetails.put(VICTIM_AGE, victim.getAge());
		victimDetails.put(VICTIM_SEX, victim.getSex());
		victimDetails.put(VICTIM_RACE, victim.getRace());
		victimDetails.put(VICTIM_NAME, victim.getName());
		victimDetails.put(VICTIM_PHONE_NUMBER, victim.getPhoneNumber());
		victimDetails.put(VICTIM_HEIGHT, victim.getHeight());
		victimDetails.put(VICTIM_EMAIL, victim.getEmail());	
		victimDetails.put(VICTIM_DETAILS, victim.getDetails());
		return victimDetails;
	}

	public static JSONObject getWitnessJSON(Witness witness) {
		JSONObject witnessDetails = new JSONObject();
		witnessDetails.put(WITNESS_ID, witness.getWitnessID().toString());
		witnessDetails.put(WITNESS_AGE, witness.getAge());
		witnessDetails.put(WITNESS_SEX, witness.getSex());
		witnessDetails.put(WITNESS_RACE, witness.getRace());
		witnessDetails.put(WITNESS_NAME, witness.getName());
		witnessDetails.put(WITNESS_PHONE_NUMBER, witness.getPhoneNumber());
		witnessDetails.put(WITNESS_HEIGHT, witness.getHeight());
		witnessDetails.put(WITNESS_EMAIL, witness.getEmail());	
		witnessDetails.put(WITNESS_DETAILS, witness.getDetails());
		witnessDetails.put(WITNESS_STORY, witness.getStory());
		witnessDetails.put(WITNESS_ISDEFENDING, witness.getIsDefening());

		return witnessDetails;
	}
}
