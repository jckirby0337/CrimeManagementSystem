
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

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
	public static JSONObject getCrimeJSON(Crime crime) {
		JSONObject crimeDetails = new JSONObject();
		crimeDetails.put(CASE_NUMBER, crime.getCaseNum());
		crimeDetails.put(CRIME_ID, crime.getCrimeID().toString());
		crimeDetails.put(CRIME_SUSPECT_ID, crime.getSuspectID().toString());
		crimeDetails.put(CRIME_VICTIM_ID, crime.getVictimID().toString());
        crimeDetails.put(CRIME_COMMITTED, crime.getCrimeCommited());
        crimeDetails.put(CRIME_LOCATION, crime.getCrimeLocation());
        crimeDetails.put(CRIME_DATE, crime.getCrimeDate());
        crimeDetails.put(CRIMINAL, crime.getCriminal());
        crimeDetails.put(CRIMINAL_CUSTODY, crime.isCriminalInCustody());
		crimeDetails.put(EVIDENCE, crime.getEvidence());
        crimeDetails.put(SOLVED, crime.isSolved());
        return crimeDetails;
	}

	public static JSONObject getSuspectJSON(Suspect suspect) {
		JSONObject suspectDetails = new JSONObject();
        suspectDetails.put(SUSPECT_ID, suspect.getSuspectID().toString());
        suspectDetails.put(SUSPECT_NAME, suspect.getName());
        suspectDetails.put(SUSPECT_AGE, suspect.getAge());
        suspectDetails.put(SUSPECT_SEX, suspect.getSex());
        suspectDetails.put(SUSPECT_RACE, suspect.getRace());
		suspectDetails.put(SUSPECT_TATTOOS, suspect.hasTattoos());
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
        return suspectDetails;
	}

    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_USER_ID, user.getUserID().toString());
		userDetails.put(USER_NAME, user.getUsername());
		userDetails.put(USER_USER_PASSWORD, user.getPassword());
		userDetails.put(USER_TITLE, user.getTitle());
		userDetails.put(USER_RACE, user.getRace());
		userDetails.put(USER_DATE_OF_BIRTH, user.getDOB());
		userDetails.put(USER_ADDRESS, user.getAddress());
        return userDetails;
	}

	public static JSONObject getVictimJSON(Victim victim) {
		JSONObject victimDetails = new JSONObject();
		victimDetails.put(VICTIM_ID, victim.getVictimID().toString());
		victimDetails.put(VICTIM_AGE, victim.getAge());
		victimDetails.put(VICTIM_SEX, victim.getSex());
		victimDetails.put(VICTIM_RACE, victim.getRace());
		victimDetails.put(VICTIM_NAME, victim.getName());
	}

	public static void main(String[] args) {
		DataWriter.saveUsers();

	}
}
