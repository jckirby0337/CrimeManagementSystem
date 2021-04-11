import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsersTest {
	private Users users = Users.getInstance();
	private ArrayList<User> userList = users.getUsers();
	
	@BeforeEach
	public void setup() {
		userList.clear();
		userList.add(new User("Amy", "Lord", "White" , "01/02/01", "Lakeland", "pwd", "asmith"));
		userList.add(new User("Bob", "Cop", "White" , "01/02/01", "Dentsville", "pwd", "bwhite"));
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	
	@Test
	void testHaveUserValidFirstItem() {
		boolean hasAmy = users.haveUser("asmith", "pwd");
		assertTrue(hasAmy);
	}
	
	@Test
	void testHaveUserValidLastItem() {
		boolean hasBob = users.haveUser("bwhite", "pwd");
		assertTrue(hasBob);
	}
	
	@Test
	void testHaveUserInValid() {
		boolean hasJoe = users.haveUser("jsmith", "123");
		assertFalse(hasJoe);
	}
	
	@Test
	void testHaveUserEmpty() {
		boolean hasEmpty = users.haveUser("", "");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveUserNull() {
		boolean hasNull = users.haveUser(null, null);
		assertFalse(hasNull);
	}
}