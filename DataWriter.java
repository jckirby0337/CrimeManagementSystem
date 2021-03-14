
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import CrimeManagementSystem.Crime;
import CrimeManagementSystem.Offender;
public class DataWriter extends DataConstants {

    public static void saveCrimes() {
		Crime crimes = crimes.getInstance(); 
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
		Suspect suspects = suspects.getInstance(); 
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

    public static void saveOffenders() {
		Offender offenders = offenders.getInstance(); 
		ArrayList<Offender> offenderList = offenders.getOffenders();
		JSONArray jsonOffenders = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< offenderList.size(); i++) {
			jsonOffenders.add(getOffenderJSON(offenderList.get(i))); 
		}
    
		
		//Write JSON file
        try (FileWriter file = new FileWriter(OFFENDER_FILE_NAME)) {
 
            file.write(jsonOffenders.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    public static void saveUsers() {
		User users = users.getInstance(); 
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
	public static JSONObject getCrimeJSON(Crime crime) {
		JSONObject crimeDetails = new JSONObject();
		crimeDetails.put(CRIME_ID, crime.getId().toString());
        crimeDetails.put(OFFENDER_ID, offender.getId().toString());
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
		suspectDetails.put(SUSPECT_CRIME_ID_, crime.getId().toString());
        suspectDetails.put(SUSPECT_ID, offender.getId().toString());
        suspectDetails.put(SUSPECT_VICTIM_ID, crime.getCrimeCommited());
        suspectDetails.put(SUSPECT_NAME, crime.getCrimeLocation());
        suspectDetails.put(CRIME_DATE, crime.getCrimeDate());
        suspectDetails.put(CRIMINAL, crime.getCriminal());
        suspectDetails.put(CRIMINAL_CUSTODY, crime.isCriminalInCustody());
		suspectDetails.put(EVIDENCE, crime.getEvidence());
        suspectDetails.put(SOLVED, crime.isSolved());
        return suspectDetails;
	}

    public static JSONObject getOffenderJSON(Offender offender) {
		JSONObject offenderDetails = new JSONObject();
		offenderDetails.put(CRIME_ID, crime.getId().toString());
        offenderDetails.put(OFFENDER_ID, offender.getId().toString());
        offenderDetails.put(CRIME_COMMITTED, crime.getCrimeCommited());
        offenderDetails.put(CRIME_LOCATION, crime.getCrimeLocation());
        offenderDetails.put(CRIME_DATE, crime.getCrimeDate());
        offenderDetails.put(CRIMINAL, crime.getCriminal());
        offenderDetails.put(CRIMINAL_CUSTODY, crime.isCriminalInCustody());
		offenderDetails.put(EVIDENCE, crime.getEvidence());
        offenderDetails.put(SOLVED, crime.isSolved());
        return offenderDetails;
	}

    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_USER_ID, user.getId().toString());
		userDetails.put(USER_NAME, user.getUsername());
		userDetails.put(USER_USER_PASSWORD, user.getPassword());
		userDetails.put(USER_TITLE, user.getTitle());
		userDetails.put(USER_RACE, user.getRace());
		userDetails.put(USER_DATE_OF_BIRTH, user.getDateOfBirth());
		userDetails.put(USER_ADDRESS, user.getAddress());
		/*userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_AGE, user.getAge());
		userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
        */
        return userDetails;
	}
}
