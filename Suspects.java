import java.util.ArrayList;
import java.util.UUID;
/**
 * Creates the Suspects Object
 * @author Team Coalition 
 */
public class Suspects {
	private static Suspects suspects;
	private static ArrayList<Suspect> suspectList;
	/**
	 * Constructs the Suspects Object with an arrayList of type Suspect
	 */
	private Suspects() {
		suspectList = DataLoader.getSuspects();
	}

	/**
	 * Gets an instance of the Suspects Object
	 * @return a new instance of the Suspects object
	 */
	public static Suspects getInstance() {
		if(suspects == null) {
			suspects = new Suspects();
		}
		
		return suspects;
	}

	/**
	 * Checks if the Arraylist has a suspect with the provided name
	 * @param name of the suspect
	 * @return True if the arraylist has a suspect with the provided name, False if the arraylsit doesnt have the suspect with the name
	 */
	public boolean haveSuspect(String name) {
		for(Suspect suspect : suspectList) {
			if(suspect.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Gets a Suspect Object with the name
	 * @param name of the Suspect 
	 * @return a Suspect Object with the name
	 */
	public Suspect getSuspect(String name) {
		for(Suspect suspect : suspectList) {
			if(suspect.getName().equals(name)) {
				return suspect;
			}
		}
		
		return null;
	}
	
	public ArrayList<Suspect> getSuspects() {
		return suspectList;
	}

	/**
	 * Searchs the suspect arraylist by UUID and if a suspect is found with that UUID then it returns the suspect
	 * @param suspectID
	 * @return Suspect
	 */
	public Suspect getSuspect(UUID suspectID) {
		for(Suspect suspect : suspectList) {
			if(suspect.getSuspectID().equals(suspectID)) {
				return suspect;
			}
		}
		
		return null;
	}

	/**
	 * returns the last suspects in the arraylist
	 * @return suspect
	 */
	public Suspect getLastSuspect() {
		return suspectList.get(suspectList.size()-1);
	}
	
	/**
	 * Adds a suspect by the parameters given and returns false if the suspect already exist or returns true if the suspect does not already exist
	 * @param name
	 * @param age
	 * @param sex
	 * @param race
	 * @param phoneNumber
	 * @param height
	 * @param email
	 * @param tattoos
	 * @param vehicle
	 * @param licensePlate
	 * @param address
	 * @param bankAccount
	 * @param creditCard
	 * @param armed
	 * @param publicRisk
	 * @param nickNames
	 * @param mentalState
	 * @param housingLocation
	 * @param educationLevel
	 * @param hairColor
	 * @param clothing
	 * @param conviction
	 * @param isInPrison
	 * @return boolean
	 */
	public boolean addSuspect(String name, int age, String sex, String race, String phoneNumber, String height, String email, String tattoos,
    String vehicle, String licensePlate, String address, Boolean bankAccount,
    Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
    String mentalState, String housingLocation, String educationLevel, String hairColor, String clothing, String conviction, boolean isInPrison) {
		if(haveSuspect(name)) { 
			System.out.println("Suspect with that name already exist");
			return false;
		}
		
		suspectList.add(new Suspect(name, age, sex, race, phoneNumber, height, email, tattoos, vehicle, licensePlate, address, bankAccount, 
                                    creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, 
                                    educationLevel, hairColor, clothing, conviction, isInPrison));
		return true;
	}
	
	/**
	 * Calls the save suspects method in datawriter to save the suspects
	 */
	public void saveSuspects() {
		DataWriter.saveSuspects();
	}

	/**
	 * Finds a suspects with a matching tattoo to the parameter
	 * @param tattoo
	 * @return ArrayList<Suspect>
	 */
	public static ArrayList<Suspect> search(String tattoo) {
        ArrayList<Suspect> matchSus = new ArrayList<Suspect>();
        System.out.println("The suspects matching the description: ");
        for(Suspect suspect : suspectList)
        {
			if(suspect.getTattoos().toLowerCase().contains(tattoo.toLowerCase())) {
                matchSus.add(suspect);
               	System.out.println(suspect.print());
			}
		}
		return matchSus;
    }

	/**
	 * Finds a suspects with a matching tattoo and age to the parameters
	 * @param tattoo
	 * @param age
	 * @return ArrayList<Suspect>
	 */
    public static ArrayList<Suspect> search(String tattoo, int age){
		ArrayList<Suspect> matchSus = new ArrayList<Suspect>();
        System.out.println("The suspects matching the tattoo and age description: ");
        for(Suspect suspect : suspectList)
        {
			if(suspect.getTattoos().toLowerCase().contains(tattoo.toLowerCase()) && suspect.getAge()==age) {
                matchSus.add(suspect);
               	System.out.println(suspect.print());
			}
		}
		return matchSus;
    }

	/**
	 * Finds suspects with a matching age and hair to the parameters
	 * @param age
	 * @param hairC
	 * @return ArrayList<Suspect>
	 */
    public static ArrayList<Suspect> search(int age, String hairC){
		ArrayList<Suspect> matchSus = new ArrayList<Suspect>();
        System.out.println("The suspects matching the tattoo, age, and hair description: ");
        for(Suspect suspect : suspectList)
        {
			if(suspect.getAge()==age && suspect.getHairColor().toLowerCase().contains(hairC.toLowerCase())) {
                matchSus.add(suspect);
               	System.out.println(suspect.print());
			}
		}
		return matchSus;
	}

	/**
	 * Finds suspects with a matching age, hair, and height to the parameters
	 * @param age
	 * @param hairC
	 * @param hght
	 * @return ArrayList<Suspect>
	 */
	public static ArrayList<Suspect> search(int age, String hairC, String hght){
	ArrayList<Suspect> matchSus = new ArrayList<Suspect>();
        System.out.println("The suspects matching the age, hair, and height description: ");
        for(Suspect suspect : suspectList)
        {
			if(suspect.getAge()==age && suspect.getHairColor().toLowerCase().contains(hairC.toLowerCase()) 
			&& suspect.getHeight().equalsIgnoreCase(hght)) {
                matchSus.add(suspect);
               	System.out.println(suspect.print());
			}
		}
		return matchSus;
	}
}