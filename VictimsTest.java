import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VictimsTest {
	private Victims victims = Victims.getInstance();
	private ArrayList<Victim> victimsList = victims.getVictims();
	
	@BeforeEach
	public void setup() {
		victimsList.clear();
		victimsList.add(new Victim("Vin Diesel", 45, "male", "White", "unknown", "5' 11\"", "vindiesel@email.sc.edu", "was robbed by Captain Price" ));
		victimsList.add(new Victim("Tommy Lahren", 27, "male", "white", "864-373-4609", "6' 4\"", "tLahren@email.sc.edu", "Skywalker was trespassing on Lahren's property"));
		DataWriter.saveVictims();
	}
	
	@AfterEach
	public void tearDown() {
	 Victims.getInstance().getVictims().clear();
		DataWriter.saveVictims();
	}
	
	
	@Test
	void testHaveVictimValidFirstItem() {
		boolean hasDiesel = victims.haveVictim("Vin Diesel");
		assertTrue(hasDiesel);
	}
	
	@Test
	void testHaveVictimValidLastItem() {
		boolean hasTommy = victims.haveVictim("Tommy Lahren");
		assertTrue(hasTommy);
	}
	
	@Test
	void testHaveVictimInValid() {
		boolean hasLebron = victims.haveVictim("Lebron James");
		assertFalse(hasLebron);
	}
	
	@Test
	void testHaveVictimEmpty() {
		boolean hasEmpty = victims.haveVictim("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveVictimNull() {
		boolean hasNull = victims.haveVictim(null);
		assertFalse(hasNull);
	}
}