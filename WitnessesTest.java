import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WitnessesTest {
	private Witnesses witnesses = Witnesses.getInstance();
	private ArrayList<Witness> witnessList = witnesses.getWitnesses();
	
	@BeforeEach
	public void setup() {
		witnessList.clear();
		witnessList.add(new Witness("john smith", 20, "Male", "white", "803-454-3344", "6\' 3\"", "jsmith@email.sc.edu","was at the scene of the crime", "saw the man stealing the bike from the bike rack out front of the store", false ));
		witnessList.add(new Witness("betty white", 23, "female", "white", "803-333-3544", "5\' 2\"", "bwhite@email.sc.edu", "was in the grocery store", "saw someone stealing tvs", false));
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		Witnesses.getInstance().getWitnesses().clear();
		DataWriter.saveWitnesses();
	}
	
	
	@Test
	void testHaveWitnessValidFirstItem() {
		boolean hasJohn = witnesses.haveWitness("john smith");
		assertTrue(hasJohn);
	}
	
	@Test
	void testHaveWitnessValidLastItem() {
		boolean hasBetty = witnesses.haveWitness("betty white");
		assertTrue(hasBetty);
	}
	
	@Test
	void testHaveWitnessInValid() {
		boolean hasLebron = witnesses.haveWitness("lebron james");
		assertFalse(hasLebron);
	}
	
	@Test
	void testHaveWitnessEmpty() {
		boolean hasEmpty = witnesses.haveWitness("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveWitnessNull() {
		boolean hasNull = witnesses.haveWitness(null);
		assertFalse(hasNull);
	}
}