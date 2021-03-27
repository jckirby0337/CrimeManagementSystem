import java.util.ArrayList;
import java.util.UUID;
public class Suspects {
	private static Suspects suspects;
	private static ArrayList<Suspect> suspectList;
	
	private Suspects() {
		suspectList = DataLoader.getSuspects();
	}
	
	public static Suspects getInstance() {
		if(suspects == null) {
			suspects = new Suspects();
		}
		
		return suspects;
	}

	public boolean haveSuspect(String name) {
		for(Suspect suspect : suspectList) {
			if(suspect.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
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

	public Suspect getSuspect(UUID suspectID) {
		for(Suspect suspect : suspectList) {
			if(suspect.getSuspectID().equals(suspectID)) {
				return suspect;
			}
		}
		
		return null;
	}

	public Suspect getLastSuspect() {
		return suspectList.get(suspectList.size()-1);
	}
	
	public boolean addSuspect(String name, int age, String sex, String race, String phoneNumber, String height, String email, String tattoos,
    String vehicle, String licensePlate, String address, Boolean bankAccount,
    Boolean creditCard, Boolean armed, Boolean publicRisk, String nickNames,
    String mentalState, String housingLocation, String educationLevel, String hairColor, String clothing) {
		if(haveSuspect(name)) { System.out.println("Suspect with that name already exist"); return false;}
		
		suspectList.add(new Suspect(name, age, sex, race, phoneNumber, height, email, tattoos, vehicle, licensePlate, address, bankAccount, 
                                    creditCard, armed, publicRisk, nickNames, mentalState, housingLocation, 
                                    educationLevel, hairColor, clothing));
		return true;
	}
	
	public void saveSuspects() {
		for(Suspect suspect : suspectList) {
			if(suspect.getAge() == -1) {
				suspectList.remove(suspectList.indexOf(suspect));
			}
		}
		DataWriter.saveSuspects();
	}

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

    public static ArrayList<Suspect> search(String tattoo, int age){
		ArrayList<Suspect> matchSus = new ArrayList<Suspect>();
        System.out.println("The suspects matching the tattoo and age description: ");
        for(Suspect suspect : suspectList)
        {
			if(suspect.getTattoos().toLowerCase().contains(tattoo.toLowerCase()) && suspect.getAge()==age) {
                matchSus.add(suspect);
               	System.out.println(matchSus);
			}
		}
		return matchSus;
    }

    public static ArrayList<Suspect> search(String tattoo, int age, String hairC){
		ArrayList<Suspect> matchSus = new ArrayList<Suspect>();
        System.out.println("The suspects matching the tattoo, age, and hair description: ");
        for(Suspect suspect : suspectList)
        {
			if(suspect.getTattoos().toLowerCase().contains(tattoo.toLowerCase()) && suspect.getAge()==age && suspect.getHairColor().toLowerCase().contains(hairC.toLowerCase())) {
                matchSus.add(suspect);
               	System.out.println(matchSus);
			}
		}
		return matchSus;
	}
	public static ArrayList<Suspect> search(String tattoo, int age, String hairC, String hght){
	ArrayList<Suspect> matchSus = new ArrayList<Suspect>();
        System.out.println("The suspects matching the tattoo, age, hair, and height description: ");
        for(Suspect suspect : suspectList)
        {
			if(suspect.getTattoos().toLowerCase().contains(tattoo.toLowerCase()) && suspect.getAge()==age && suspect.getHairColor().toLowerCase().contains(hairC.toLowerCase()) 
			&& suspect.getHeight().equalsIgnoreCase(hght)) {
                matchSus.add(suspect);
               	System.out.println(matchSus);
			}
		}
		return matchSus;
	}
}