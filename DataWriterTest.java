import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
	private Users users = Users.getInstance();
	private ArrayList<User> userList = users.getUsers();

    private Crimes crimes = Crimes.getInstance();
	private ArrayList<Crime> crimeList = crimes.getCrimes();

    private Suspects suspects = Suspects.getInstance();
	private ArrayList<Suspect> suspectList = suspects.getSuspects();

    private Victims victims = Victims.getInstance();
	private ArrayList<Victim> victimList = victims.getVictims();

    private Witnesses witnesses = Witnesses.getInstance();
	private ArrayList<Witness> witnessList = witnesses.getWitnesses();

	
	@BeforeEach
	public void setup() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();

        Crimes.getInstance().getCrimes().clear();
		DataWriter.saveCrimes();

        Suspects.getInstance().getSuspects().clear();
		DataWriter.saveSuspects();

        Victims.getInstance().getVictims().clear();
		DataWriter.saveVictims();

        Witnesses.getInstance().getWitnesses().clear();
		DataWriter.saveWitnesses();
	}
	
	@AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();

        Crimes.getInstance().getCrimes().clear();
		DataWriter.saveCrimes();

        Suspects.getInstance().getSuspects().clear();
		DataWriter.saveSuspects();

        Victims.getInstance().getVictims().clear();
		DataWriter.saveVictims();
        
        Witnesses.getInstance().getWitnesses().clear();
		DataWriter.saveWitnesses();
	}
	
	//user test
	@Test
	void testWritingZeroUsers() {
		userList = DataLoader.getUsers();
		assertEquals(0, userList.size());
	}

	@Test
	void testWritingOneUser() {
		userList.add(new User("Amy", "Lord", "White" , "01/02/01", "Lakeland", "pwd", "asmith"));
		DataWriter.saveUsers();
		assertEquals("asmith", DataLoader.getUsers().get(0).getUsername());
	}
	
	@Test
	void testWritingFiveUsers() {
		userList.add(new User("Amy", "Lord", "White" , "01/02/01", "Lakeland", "pwd", "asmith"));
		userList.add(new User("Amy", "Lord", "White" , "01/02/01", "Lakeland", "pwd", "bsmith"));
		userList.add(new User("Amy", "Lord", "White" , "01/02/01", "Lakeland", "pwd", "csmith"));
		userList.add(new User("Amy", "Lord", "White" , "01/02/01", "Lakeland", "pwd", "dsmith"));
		userList.add(new User("Amy", "Lord", "White" , "01/02/01", "Lakeland", "pwd", "esmith"));
		DataWriter.saveUsers();
		assertEquals("esmith", DataLoader.getUsers().get(4).getUsername());
	}
	
	@Test
	void testWritingEmptyUser() {
		userList.add(new User("", "", "", "", "", "", ""));
		DataWriter.saveUsers();
		assertEquals("", DataLoader.getUsers().get(0).getUsername());
	}
	
	@Test
	void testWritingNullUser() {
		userList.add(new User("", "", "", "", "", "", null));
		DataWriter.saveUsers();
		assertEquals(null, DataLoader.getUsers().get(0).getUsername());
	}
	
    //crime test
    @Test
	void testWritingZeroCrimes() {
		crimeList = DataLoader.getCrimes();
		assertEquals(0, crimeList.size());
	}

	@Test
	void testWritingOneCrime() {
		crimeList.add(new Crime(1, "Arson", "Maple Street", "2/14/17","Amy", false, new ArrayList<String>(), false));
		DataWriter.saveCrimes();
		assertEquals("Amy", DataLoader.getCrimes().get(0).getCriminal());
	}
	
	@Test
	void testWritingFiveCrimes() {
		crimeList.add(new Crime(1, "Arson", "Maple Street", "2/14/17","Amy", false, new ArrayList<String>(), false));
		crimeList.add(new Crime(1, "Arson", "Maple Street", "2/14/17","Bmy", false, new ArrayList<String>(), false));
		crimeList.add(new Crime(1, "Arson", "Maple Street", "2/14/17","Cmy", false, new ArrayList<String>(), false));
		crimeList.add(new Crime(1, "Arson", "Maple Street", "2/14/17","Dmy", false, new ArrayList<String>(), false));
		crimeList.add(new Crime(1, "Arson", "Maple Street", "2/14/17","Emy", false, new ArrayList<String>(), false));
		DataWriter.saveCrimes();
		assertEquals("Emy", DataLoader.getCrimes().get(4).getCriminal());
	}
	
	@Test
	void testWritingEmptyCrime() {
		crimeList.add(new Crime(0, "", "", "", "", false, new ArrayList<String>(), false));
		DataWriter.saveCrimes();
		assertEquals("", DataLoader.getCrimes().get(0).getCriminal());
	}
	
	@Test
	void testWritingNullCrime() {
		crimeList.add(new Crime(0, "", "", "", null, false, new ArrayList<String>(), false));
		DataWriter.saveCrimes();
		assertEquals(null, DataLoader.getCrimes().get(0).getCriminal());
	}
	
    //suspect test
    @Test
	void testWritingZeroSuspects() {
		suspectList = DataLoader.getSuspects();
		assertEquals(0, suspectList.size());
	}

	@Test
	void testWritingOneSuspect() {
		suspectList.add(new Suspect("Walter White", 54, "Male", "White", "unknown", "6' 0\"", "wwhite@email.sc.edu", "none", "Pontiac Aztek", "09QSBN", "308 Negra Arroyo Lane", true, true, true, true, "Heisenburg", "Narcissistic", "Albuquerque, New Mexico", "College Graduate", "none", "khakis", "none", false));
		DataWriter.saveSuspects();
		assertEquals("Walter White", DataLoader.getSuspects().get(0).getName());
	}
	
	@Test
	void testWritingFiveSuspects() {
		suspectList.add(new Suspect("aWalter White", 54, "Male", "White", "unknown", "6' 0\"", "wwhite@email.sc.edu", "none", "Pontiac Aztek", "09QSBN", "308 Negra Arroyo Lane", true, true, true, true, "Heisenburg", "Narcissistic", "Albuquerque, New Mexico", "College Graduate", "none", "khakis", "none", false));
		suspectList.add(new Suspect("bWalter White", 54, "Male", "White", "unknown", "6' 0\"", "wwhite@email.sc.edu", "none", "Pontiac Aztek", "09QSBN", "308 Negra Arroyo Lane", true, true, true, true, "Heisenburg", "Narcissistic", "Albuquerque, New Mexico", "College Graduate", "none", "khakis", "none", false));
		suspectList.add(new Suspect("cWalter White", 54, "Male", "White", "unknown", "6' 0\"", "wwhite@email.sc.edu", "none", "Pontiac Aztek", "09QSBN", "308 Negra Arroyo Lane", true, true, true, true, "Heisenburg", "Narcissistic", "Albuquerque, New Mexico", "College Graduate", "none", "khakis", "none", false));
		suspectList.add(new Suspect("dWalter White", 54, "Male", "White", "unknown", "6' 0\"", "wwhite@email.sc.edu", "none", "Pontiac Aztek", "09QSBN", "308 Negra Arroyo Lane", true, true, true, true, "Heisenburg", "Narcissistic", "Albuquerque, New Mexico", "College Graduate", "none", "khakis", "none", false));
		suspectList.add(new Suspect("eWalter White", 54, "Male", "White", "unknown", "6' 0\"", "wwhite@email.sc.edu", "none", "Pontiac Aztek", "09QSBN", "308 Negra Arroyo Lane", true, true, true, true, "Heisenburg", "Narcissistic", "Albuquerque, New Mexico", "College Graduate", "none", "khakis", "none", false));
		DataWriter.saveSuspects();
		assertEquals("eWalter White", DataLoader.getSuspects().get(4).getName());
	}
	
	@Test
	void testWritingEmptySuspect() {
		suspectList.add(new Suspect("", 0, "", "", "", "", "", "", "", "", "", false, false, false, false, "", "", "", "", "", "", "", false));
		DataWriter.saveSuspects();
		assertEquals("", DataLoader.getSuspects().get(0).getName());
	}
	
	@Test
	void testWritingNullSuspect() {
		suspectList.add(new Suspect(null, 0, null, null, null, null, null, null, null, null, null, false, false, false, false, null, null, null, null, null, null, null, false));
		DataWriter.saveSuspects();
		assertEquals(null, DataLoader.getSuspects().get(0).getName());
	}
	
    //Victim test
    @Test
	void testWritingZeroVictims() {
		victimList = DataLoader.getVictims();
		assertEquals(0, victimList.size());
	}

	@Test
	void testWritingOneVictim() {
		victimList.add(new Victim("Vin Diesel", 45, "male", "White", "unknown", "5'11\"", "vindiesel@email.sc.edu", "was robbed by Captain Price"));
		DataWriter.saveVictims();
		assertEquals("Vin Diesel", DataLoader.getVictims().get(0).getName());
	}
	
	@Test
	void testWritingFiveVictims() {
		victimList.add(new Victim("aVin Diesel", 45, "male", "White", "unknown", "5'11\"", "vindiesel@email.sc.edu", "was robbed by Captain Price"));
		victimList.add(new Victim("bVin Diesel", 45, "male", "White", "unknown", "5' 11\"", "vindiesel@email.sc.edu", "was robbed by Captain Price"));
		victimList.add(new Victim("cVin Diesel", 45, "male", "White", "unknown", "5' 11\"", "vindiesel@email.sc.edu", "was robbed by Captain Price"));
		victimList.add(new Victim("dVin Diesel", 45, "male", "White", "unknown", "5' 11\"", "vindiesel@email.sc.edu", "was robbed by Captain Price"));
		victimList.add(new Victim("eVin Diesel", 45, "male", "White", "unknown", "5' 11\"", "vindiesel@email.sc.edu", "was robbed by Captain Price"));
		DataWriter.saveVictims();
		assertEquals("eVin Diesel", DataLoader.getVictims().get(4).getName());
	}
	
	@Test
	void testWritingEmptyVictim() {
		victimList.add(new Victim("", 0, "", "", "", "", "", ""));
		DataWriter.saveVictims();
		assertEquals("", DataLoader.getVictims().get(0).getName());
	}
	
	@Test
	void testWritingNullVictims() {
		victimList.add(new Victim(null, 0, null, null, null, null, null, null));
		DataWriter.saveVictims();
		assertEquals(null, DataLoader.getVictims().get(0).getName());
	}
	
    //Witness test
    @Test
	void testWritingZeroWitnesses() {
		witnessList = DataLoader.getWitnesses();
		assertEquals(0, witnessList.size());
	}

	@Test
	void testWritingOneWitness() {
		witnessList.add(new Witness("ajohn smith", 20, "Male", "white", "803-454-3344", "6'3\"", "jsmith@email.sc.edu","was at the scene of the crime", "saw the man stealing the bike from the bike rack out front of the store", false));
		DataWriter.saveWitnesses();
		assertEquals("ajohn smith", DataLoader.getWitnesses().get(0).getName());
	}
	
	@Test
	void testWritingFiveWitnesses() {
		witnessList.add(new Witness("ajohn smith", 20, "Male", "white", "803-454-3344", "6'3\"", "jsmith@email.sc.edu","was at the scene of the crime", "saw the man stealing the bike from the bike rack out front of the store", false));
		witnessList.add(new Witness("bjohn smith", 20, "Male", "white", "803-454-3344", "6'3\"", "jsmith@email.sc.edu","was at the scene of the crime", "saw the man stealing the bike from the bike rack out front of the store", false));
		witnessList.add(new Witness("cjohn smith", 20, "Male", "white", "803-454-3344", "6'3\"", "jsmith@email.sc.edu","was at the scene of the crime", "saw the man stealing the bike from the bike rack out front of the store", false));
		witnessList.add(new Witness("djohn smith", 20, "Male", "white", "803-454-3344", "6'3\"", "jsmith@email.sc.edu","was at the scene of the crime", "saw the man stealing the bike from the bike rack out front of the store", false));
		witnessList.add(new Witness("ejohn smith", 20, "Male", "white", "803-454-3344", "6'3\"", "jsmith@email.sc.edu","was at the scene of the crime", "saw the man stealing the bike from the bike rack out front of the store", false));
		DataWriter.saveWitnesses();
		assertEquals("ejohn smith", DataLoader.getWitnesses().get(4).getName());
	}
	
	@Test
	void testWritingEmptyWitness() {
		witnessList.add(new Witness("", 0, "", "", "", "", "","", "", false));
		DataWriter.saveWitnesses();
		assertEquals("", DataLoader.getWitnesses().get(0).getName());
	}
	
	@Test
	void testWritingNullWitness() {
		witnessList.add(new Witness(null, 0, null, null, null, null, null, null, null, false));
		DataWriter.saveWitnesses();
		assertEquals(null, DataLoader.getWitnesses().get(0).getName());
	}
	
}