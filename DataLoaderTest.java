import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {
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
		userList.clear();
        crimeList.clear();
        suspectList.clear();
        victimList.clear();
        witnessList.clear();
		userList.add(new User("Amy", "Lord", "White" , "01/02/01", "Lakeland", "pwd", "asmith"));
		userList.add(new User("Bob", "Cop", "White" , "01/02/01", "Dentsville", "pwd", "bwhite"));
        crimeList.add(new Crime(1, "trespassing", "LaVergne, TN", "9/1/2015", "Luke Skywalker", false, new ArrayList<String>(), true ));
        crimeList.add(new Crime(2, "robbery", "Greer, SC", "3/23/2021", "Captain Price", true, new ArrayList<String>(), true));
        suspectList.add(new Suspect("Noneya Business", 34, "Male", "Pacific Islander", "999-999-9999", "5' 10\"", "noneyabusiness@email.sc.edu","turtle", "toyota camry", "BMT828", "ABC 123 Drive", true, true, true, true, "Anonymous", "Insane in the brain", "ABC 123 Drive Greer, SC", "College Graduate", "Brown", "Champion hoodie", "20 years in prison", true));
        suspectList.add(new Suspect("Walter White", 54, "Male", "White", "unknown", "6' 0\"", "wwhite@email.sc.edu", "none", "Pontiac Aztek", "09QSBN", "308 Negra Arroyo Lane", true, true, true, true, "Heisenburg", "Narcissistic", "Albuquerque, New Mexico", "College Graduate", "none", "khakis", "none", false));
        victimList.add(new Victim("Vin Diesel", 45, "male", "White", "unknown", "5' 11\"", "vindiesel@email.sc.edu", "was robbed by Captain Price"));
        victimList.add(new Victim("Tommy Lahren", 27, "male", "white", "864-373-4609", "6' 4\"", "tLahren@email.sc.edu", "Skywalker was trespassing on Lahren's property"));
        witnessList.add(new Witness("john smith", 20, "Male", "white", "803-454-3344", "6\' 3\"", "jsmith@email.sc.edu","was at the scene of the crime", "saw the man stealing the bike from the bike rack out front of the store", false ));
		witnessList.add(new Witness("betty white", 23, "female", "white", "803-333-3544", "5\' 2\"", "bwhite@email.sc.edu", "was in the grocery store", "saw someone stealing tvs", false));
		DataWriter.saveUsers();
        DataWriter.saveCrimes();
        DataWriter.saveSuspects();
        DataWriter.saveVictims();
        DataWriter.saveWitnesses();
	}
	
	@AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
        Crimes.getInstance().getCrimes().clear();
        Suspects.getInstance().getSuspects().clear();
        Victims.getInstance().getVictims().clear();
        Witnesses.getInstance().getWitnesses().clear();
		DataWriter.saveUsers();
        DataWriter.saveCrimes();
        DataWriter.saveSuspects();
        DataWriter.saveVictims();
        DataWriter.saveWitnesses();
	}
	
	
	@Test
	void testGetUsersSize() {
		userList = DataLoader.getUsers();
		assertEquals(2, userList.size());
	}

	@Test
	void testGetUsersSizeZero() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
		assertEquals(0, userList.size());
	}
	
	@Test
	void testGetUserFirstUserName() {
		userList = DataLoader.getUsers();
		assertEquals("Amy", userList.get(0).getName());
	}
    @Test
	void testGetCrimesSize() {
		crimeList = DataLoader.getCrimes();
		assertEquals(2, crimeList.size());
	}

	@Test
	void testGetCrimesSizeZero() {
		Crimes.getInstance().getCrimes().clear();
		DataWriter.saveCrimes();
		assertEquals(0, crimeList.size());
	}
	
	@Test
	void testGetCrimeIDFirstCrimeID() {
		crimeList = DataLoader.getCrimes();
		assertEquals(1, crimeList.get(0).getCaseNum());
	}
    @Test
	void testGetSuspectsSize() {
		suspectList = DataLoader.getSuspects();
		assertEquals(2, suspectList.size());
	}

	@Test
	void testGetSuspectsSizeZero() {
		Suspects.getInstance().getSuspects().clear();
		DataWriter.saveSuspects();
		assertEquals(0, suspectList.size());
	}
	
	@Test
	void testGetSuspectFirstSuspectName() {
		suspectList = DataLoader.getSuspects();
		assertEquals("Noneya Business", suspectList.get(0).getName());
	}
    @Test
	void testGetVictimsSize() {
		victimList = DataLoader.getVictims();
		assertEquals(2, victimList.size());
	}

	@Test
	void testGetVictimsSizeZero() {
		Victims.getInstance().getVictims().clear();
		DataWriter.saveVictims();
		assertEquals(0, victimList.size());
	}
	
	@Test
	void testGetVictimFirstVictimName() {
		victimList = DataLoader.getVictims();
		assertEquals("Vin Diesel", victimList.get(0).getName());
	}
    @Test
	void testGetWitnessesSize() {
		witnessList = DataLoader.getWitnesses();
		assertEquals(2, witnessList.size());
	}

	@Test
	void testGetWitnessesSizeZero() {
		Witnesses.getInstance().getWitnesses().clear();
		DataWriter.saveWitnesses();
		assertEquals(0, witnessList.size());
	}
	
	@Test
	void testGetWitnessFirstWitnessName() {
		witnessList = DataLoader.getWitnesses();
		assertEquals("john smith", witnessList.get(0).getName());
	}
    
}