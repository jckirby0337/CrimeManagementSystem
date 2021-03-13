
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import CrimeManagementSystem.Offender;

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

    public static void saveOffenders() {
		Offenders offenders = Offenders.getInstance(); 
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
}
