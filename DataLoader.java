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
				int crimeID = ((Long)crimeJSON.get(CRIME_ID)).intValue();
                int offenderID = ((Long)crimeJSON.get(OFFENDER_ID)).intValue();
				String crimeCommitted = (String)crimeJSON.get(CRIME_COMMITTED);
				String crimeLocation = (String)crimeJSON.get(CRIME_LOCATION);
				String crimeDate = (String)crimeJSON.get(CRIME_DATE);
                String criminal = (String)crimeJSON.get(CRIMINAL);
                boolean criminalCustody = (boolean)crimeJSON.get(CRIMINAL_CUSTODY);
                String evidence = (String)crimeJSON.get(EVIDENCE);
                boolean solved = (boolean)crimeJSON.get(SOLVED);
				
				crimes.add(new Crime(crimeID, offenderID, crimeCommitted, crimeLocation, crimeLocation, crimeDate, criminal, criminalCustody, evidence, solved));
			}
			
			return crimes;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static ArrayList<Suspect> getSuspects() {
		ArrayList<Suspect> suspects = new ArrayList<Suspect>();
		
		try {
			FileReader reader = new FileReader(SUSPECT_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray suspectsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < suspectsJSON.size(); i++) {
				JSONObject suspectJSON = (JSONObject)suspectsJSON.get(i);
				int crimeID = ((Long)suspectJSON.get(SUSPECT_CRIME_ID)).intValue();
                int suspectID = ((Long)suspectJSON.get(SUSPECT_ID)).intValue();
				int victimID = ((Long)suspectJSON.get(SUSPECT_VICTIM_ID)).intValue();
				String name = (String)suspectJSON.get(SUSPECT_NAME);
				int age = ((Long)suspectJSON.get(SUSPECT_AGE)).intValue();
				char sex = (char)suspectJSON.get(SUSPECT_SEX);
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

				suspects.add(new Suspect(crimeID, suspectID, victimID, name, age, sex, race, tattoos, vehicle, licensePlate, address, bankAccount,
			 	creditCard, armed, publicRisk, nicknames, mentalState, housingLocation, educationLevel));
			}
			
			return suspects;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static ArrayList<Offender> getOffenders() {
		ArrayList<Offender> offenders = new ArrayList<Offender>();
		
		try {
			FileReader reader = new FileReader(OFFENDER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray offendersJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < offendersJSON.size(); i++) {
				JSONObject offenderJSON = (JSONObject)offendersJSON.get(i);
				int offenderID = ((Long)offenderJSON.get(OFFENDER_OFFENDER_ID)).intValue();
				int victimID = ((Long)offenderJSON.get(OFFENDER_VICTIM_ID)).intValue();
				String name = (String)offenderJSON.get(SUSPECT_NAME);
                boolean tattoos = (boolean)offenderJSON.get(OFFENDER_TATTOOS);
				String vehicle = (String)offenderJSON.get(SUSPECT_VEHICLE);
				String licensePlate = (String)offenderJSON.get(OFFENDER_LICENSE_PLATE);
				int crimeLevel = ((Long)offenderJSON.get(OFFENDER_CRIME_LEVEL)).intValue();
				String address = (String)offenderJSON.get(OFFENDER_ADDRESS);
				boolean bankAccount = (boolean)offenderJSON.get(OFFENDER_BANK_ACCOUNT);
                boolean creditCard = (boolean)offenderJSON.get(OFFENDER_CREDIT_CARD);
				boolean armed = (boolean)offenderJSON.get(OFFENDER_ARMED);
				boolean publicRisk = (boolean)offenderJSON.get(OFFENDER_PUBLIC_RISK);
				String nicknames = (String)offenderJSON.get(OFFENDER_NICKNAMES);
				String mentalState = (String)offenderJSON.get(OFFENDER_MENTAL_STATE);
				String housingLocation = (String)offenderJSON.get(OFFENDER_HOUSING_LOCATIONS);
				String educationLevel = (String)offenderJSON.get(OFFENDER_EDUCATION_LEVEL);

				offenders.add(new Offender(offenderID, victimID, name, tattoos, vehicle, licensePlate, crimeLevel, 
				address, bankAccount, creditCard, armed, publicRisk, nicknames, mentalState, housingLocation, educationLevel));
			}
			
			return offenders;
			
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
				String userID = (String)userJSON.get(USER_USER_ID);
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

	public static void main(String[] args) {
		ArrayList<User> users = DataLoader.getUsers();
		for(User user: users) {
			System.out.println(user);
		}
		

		System.out.println(UUID.randomUUID());
	}
}