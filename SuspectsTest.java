import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SuspectsTest {
    private Suspects suspects = Suspects.getInstance();
	private ArrayList<Suspect> suspectList = suspects.getSuspects();

    @BeforeEach
    public void setup() {
        suspectList.clear();
        suspectList.add(new Suspect("Mike",22,"Male","Asian","803-123-4567","5'7\"","mike@email.sc.edu","Sword"
        ,"Toyota","CBD 420", "123 Sunflower Dr", false
        ,false, false, false, "Bloodhound"
        ,"Stable","Columbia","Bachelors Degree","Black","Red cardigan","N/A",true));
        suspectList.add(new Suspect("Jessica",25,"Female","White","803-124-4567","5'4\"","jess@email.sc.edu","Sword"
        ,"N/A","N/A", "124 Sunflower Dr", true
        ,true, true, true, "N/A"
        ,"Bipolar","Columbia","Bachelors Degree","Black","Jean skirts","N/A",true));
    }
    @AfterEach
	public void tearDown() {
		Suspects.getInstance().getSuspects().clear();
		DataWriter.saveSuspects();
	}
    
	@Test
	void testHaveSuspectsValidFirstItem() {
		boolean hasMike = suspects.haveSuspect("Mike");
		assertTrue(hasMike);
	}
	
	@Test
	void testHaveSuspectsValidLastItem() {
		boolean hasJessica = suspects.haveSuspect("Jessica");
		assertTrue(hasJessica);
	}

    @Test
	void testHaveSuspectsInValid() {
		boolean hasDianna = suspects.haveSuspect("Dianna");
		assertFalse(hasDianna);
	}

    @Test
	void testHaveSuspectsEmpty() {
		boolean hasEmpty = suspects.haveSuspect("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveSuspectsNull() {
		boolean hasNull = suspects.haveSuspect(null);
		assertFalse(hasNull);
	}
	
    @Test
    void testSearch(){
        ArrayList<Suspect> search = suspects.search("Sword");
        ArrayList<Suspect> search2 = suspects.search("Sword",25);
        ArrayList<Suspect> search3 = suspects.search(25,"Black", "5'4\"");
        
    }
}
