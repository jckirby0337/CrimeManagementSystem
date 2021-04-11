import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrimesTest {
	private Crimes crimes = Crimes.getInstance();
	private ArrayList<Crime> crimeList = crimes.getCrimes();
	
	@BeforeEach
	public void setup() {
		crimeList.clear();
		crimeList.add(new Crime(1, "Arson", "Maple Street", "2/14/17","Amy", false, null, false));
		crimeList.add(new Crime(2, "Murder", "Snap Lane", "2/7/18", "Bob", true, null, false));
		DataWriter.saveCrimes();
	}
	
	@AfterEach
	public void tearDown() {
		Crimes.getInstance().getCrimes().clear();
		DataWriter.saveCrimes();
	}
	
	
	@Test
	void testHaveCrimeValidFirstItem() {
		boolean hasAmy = crimes.haveCrime("Amy");
		assertTrue(hasAmy);
	}
	
	@Test
	void testHaveCrimeValidLastItem() {
		boolean hasBob = crimes.haveCrime("Bob");
		assertTrue(hasBob);
	}
	
	@Test
	void testHaveCrimeInValid() {
		boolean hasJoe = crimes.haveCrime("Joe");
		assertFalse(hasJoe);
	}
	
	@Test
	void testHaveCrimeEmpty() {
		boolean hasEmpty = crimes.haveCrime("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveCrimeNull() {
		boolean hasNull = crimes.haveCrime(null);
		assertFalse(hasNull);
	}
}