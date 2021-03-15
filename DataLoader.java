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
                int suspectID = ((Long)suspectJSON.get(OFFENDER_ID)).intValue();
				int victimID = ((Long)suspectJSON.get(OFFENDER_ID)).intValue();
				String suspectName = (String)suspectJSON.get(CRIME_COMMITTED);
				int name = ((Long)suspectJSON.get(OFFENDER_ID)).intValue();
				String crimeLocation = (String)suspectJSON.get(CRIME_LOCATION);
				String crimeDate = (String)suspectJSON.get(CRIME_DATE);
                String criminal = (String)suspectJSON.get(CRIMINAL);
                boolean criminalCustody = (boolean)suspectJSON.get(CRIMINAL_CUSTODY);
                String evidence = (String)suspectJSON.get(EVIDENCE);
                boolean solved = (boolean)suspectJSON.get(SOLVED);
				
				crimes.add(new Crime(crimeID, offenderID, crimeCommitted, crimeLocation, crimeLocation, crimeDate, criminal, criminalCustody, evidence, solved));
			}
			
			return crimes;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}