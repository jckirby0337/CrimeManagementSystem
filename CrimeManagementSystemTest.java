import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrimeManagementSystemTest {
	private CrimeManagementSystem crimeManagementSystem = new CrimeManagementSystem();
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
	public void testCreateValidAccount() {
		crimeManagementSystem.createAccount("Dave Chapelle", "comedian", "Black", "08/24/1973","Yellow Springs, OH", "thegreatest", "theRealDaveChapelle");
		crimeManagementSystem.login("theRealDaveChapelle", "thegreatest");
		User myUser = crimeManagementSystem.getCurrentUser();
		assertFalse(crimeManagementSystem.userCheck(myUser.getUsername(), myUser.getPassword()));
	}
	
	@Test
	public void testCreateSaved() {
		crimeManagementSystem.createAccount("Steve Chapelle", "comedian", "White", "08/24/1974","Yellow Springs, KY", "thebest", "theRealSteveChapelle");
		crimeManagementSystem.logout();
		crimeManagementSystem = new CrimeManagementSystem();
		crimeManagementSystem.login("theRealSteveChapelle", "thebest");
		User currentUser = crimeManagementSystem.getCurrentUser();
		assertTrue(crimeManagementSystem.userCheck(currentUser.getUsername(), currentUser.getPassword()));
    }
	
	@Test
	public void testCreateAccountDuplicateUserName() {
		crimeManagementSystem.createAccount("Bill Burr", "comedian", "White", "08/24/1974","Yellow Springs, KY", "thebest", "theRealSteveChapelle");
		boolean isCreated = crimeManagementSystem.createAccount("Steve Chapelle", "comedian", "White", "08/24/1974","Yellow Springs, KY", "thebest", "theRealSteveChapelle");
		assertFalse(isCreated);
	}

    @Test
	public void testCreateAccountEmptyUserName() {
		boolean isCreated = crimeManagementSystem.createAccount("", "", "", "", "", "", "");
		assertFalse(isCreated);
	}
	
	@Test
	public void testCreateAccountNullUserName() {
		boolean isCreated = crimeManagementSystem.createAccount("", "", "","","","",null);
		assertFalse(isCreated);
	}
    @Test
	public void testCreateValidCrime() {
        crimeManagementSystem.createCrime(1, "murder", "Columbia, SC",  "08/24/1990", "Dave Chapelle", false, new ArrayList<String>(),false);
		crimeManagementSystem.login("theRealDaveChapelle", "thegreatest");
		Crime myCrime = crimeManagementSystem.getCrime(1);
        assertEquals("Dave Chapelle", myCrime.getCriminal());
    }
	
	@Test
	public void testCreateCrimeSaved() {
		crimeManagementSystem.createCrime(1, "murder", "Columbia, SC",  "08/24/1990", "Dave Chapelle", false, new ArrayList<String>(),false);
		crimeManagementSystem.logout();
		crimeManagementSystem = new CrimeManagementSystem();
		crimeManagementSystem.login("theRealSteveChapelle", "thebest");
		Crime myCrime = crimeManagementSystem.getCrime(1);
		assertEquals("Dave Chapelle", myCrime.getCriminal());
    }
	
	@Test
	public void testCreateCrimeDuplicateID() {
        crimeManagementSystem.createCrime(1, "murder", "Columbia, SC",  "08/24/1990", "Dave Chapelle", false, new ArrayList<String>(),false);
        boolean isCreated = crimeManagementSystem.createCrime(1, "murder", "Columbia, SC",  "08/24/1990", "Dave Chapelle", false, new ArrayList<String>(),false);
		assertFalse(isCreated);
	}
	
	@Test
	public void testCreateCrimeInvalidCaseNumber() {
		boolean isCreated = crimeManagementSystem.createCrime(-1, "", "", "", "", false, null, false);
		assertFalse(isCreated);
	}
	
	@Test
	public void testCreateCrimeDecimalCaseNumber() {
		boolean isCreated = crimeManagementSystem.createCrime(1/4, "", "","","",false, new ArrayList<String>(), false);
		assertFalse(isCreated);
	}
    @Test
	public void testCreateValidSuspect() {
        crimeManagementSystem.createSuspect(false,"Alan Jackson", 45, "male", "white", "000-123-4567","5'10\"", "ajackson@email.sc.edu", "bear", "Honda Civic", "123ABC", "632 Park Avenue", true, true, true, false, "country boy", "happy", "Nashville, TN", "High School", "Blonde", "Jeans", "none", false);
		crimeManagementSystem.login("theRealDaveChapelle", "thegreatest");
		Suspect mySuspect = suspects.getSuspect("Alan Jackson");
        assertTrue(mySuspect.equals(suspects.getSuspect("Alan Jackson")));
    }
	
	@Test
	public void testCreateSuspectSaved() {
		crimeManagementSystem.createSuspect(false,"Alan Jackson", 45, "male", "white", "000-123-4567","5'10\"", "ajackson@email.sc.edu", "bear", "Honda Civic", "123ABC", "632 Park Avenue", true, true, true, false, "country boy", "happy", "Nashville, TN", "High School", "Blonde", "Jeans", "none", false);
		crimeManagementSystem.logout();
		crimeManagementSystem = new CrimeManagementSystem();
		crimeManagementSystem.login("theRealSteveChapelle", "thebest");
		Suspect mySuspect = suspects.getSuspect("Alan Jackson");
		assertEquals("Alan Jackson", mySuspect.getName());
    }

    @Test
	public void testCreateSuspectEmptyName() {
		boolean isCreated = crimeManagementSystem.createSuspect(false,"", 0, "", "", "", "", "", "", "", "", "",false,false,false,false,"", "", "","","","", "",false);
		assertFalse(isCreated);
	}
	
	@Test
	public void testCreateNullSuspect() {
		boolean isCreated = crimeManagementSystem.createSuspect(false,"", 0, "", "", "", "", "", "", "", "", "",false,false,false,false,"", "", "","","","", "",false);
		assertFalse(isCreated);
	}
    @Test
	public void testCreateValidVictim() {
        crimeManagementSystem.createVictim("Sarah Black", 24, "Female", "White", "803-898-7766", "5' 9\"", "sblack@email.sc.edu","Murdered by Dave Chapelle");
		crimeManagementSystem.login("theRealDaveChapelle", "thegreatest");
		Victim myVictim = victims.getVictim("Sarah Black");
        assertTrue(myVictim.equals(victims.getVictim("Sarah Black")));
    }
	
	@Test
	public void testCreateVictimSaved() {
		crimeManagementSystem.createVictim("Sarah Black", 24, "Female", "White", "803-898-7766", "5' 9\"", "sblack@email.sc.edu","Murdered by Dave Chapelle");
		crimeManagementSystem.logout();
		crimeManagementSystem = new CrimeManagementSystem();
		crimeManagementSystem.login("theRealSteveChapelle", "thebest");
		Victim myVictim = victims.getVictim("Sarah Black");
		assertEquals("Sarah Black", myVictim.getName());
    }
    @Test
	public void testCreateVictimEmptyName() {
		boolean isCreated = crimeManagementSystem.createVictim("", 0, "", "", "", "", "", "");
		assertFalse(isCreated);
	}
	
	@Test
	public void testCreateNullVictim() {
		boolean isCreated = crimeManagementSystem.createVictim(null,0, "", "","","","","");
		assertFalse(isCreated);
	}
    @Test
	public void testCreateValidWitness() {
        crimeManagementSystem.createWitness("jane doe", 28, "Female", "white", "803-454-3264", "5\' 6\"", "jdoe@email.sc.edu", "was at the scene of the crime", "Witnessed the murder of Sarah Black",false);
		crimeManagementSystem.login("theRealDaveChapelle", "thegreatest");
		Witness myWitness = witnesses.getWitness("jane doe");
        assertTrue(myWitness.equals(witnesses.getWitness("jane doe")));
    }
	
	@Test
	public void testCreateWitnessSaved() {
		crimeManagementSystem.createWitness("jane doe", 28, "Female", "white", "803-454-3264", "5\' 6\"", "jdoe@email.sc.edu", "was at the scene of the crime", "Witnessed the murder of Sarah Black",false);
		crimeManagementSystem.logout();
		crimeManagementSystem = new CrimeManagementSystem();
		crimeManagementSystem.login("theRealSteveChapelle", "thebest");
		Witness myWitness = witnesses.getWitness("jane doe");
		assertEquals("jane doe", myWitness.getName());
    }
    @Test
	public void testCreateWitnessEmptyName() {
		boolean isCreated = crimeManagementSystem.createWitness("", 0, "", "", "", "", "", "", "", false);
		assertFalse(isCreated);
	}
	
	@Test
	public void testCreateNullWitness() {
		boolean isCreated = crimeManagementSystem.createWitness(null, 0, "","","","","","","",false);
		assertFalse(isCreated);
	}
}