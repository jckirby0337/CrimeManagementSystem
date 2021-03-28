import java.util.ArrayList;
/**
 * Creates the Users object
 * @author Team Coalition
 */
public class Users {
	private static Users users;
	private ArrayList<User> userList;

	/**
	 * Constructs the Users object with an arraylist of the type user
	 */
	private Users() {
		userList = DataLoader.getUsers();
	}

	/**
	 * Gets an instance of the Users object
	 * @return a new Users object
	 */
	public static Users getInstance() {
		if(users == null) {
			users = new Users();
		}
		
		return users;
	}

	/**
	 * Checks if the ArrayList has a User with the username and password provided
	 * @param userName of the user
	 * @param password of the user
	 * @return True if a user with the username and password exists, False if doesn't have a user with the username and password
	 */
	public boolean haveUser(String userName, String password) {
		for(User user : userList) {
			if(user.getUsername().equals(userName) && user.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Gets a user with the provided Username 
	 * @param userName of the user
	 * @return A user object that has the username
	 */
	public User getUser(String userName) {
		for(User user : userList) {
			if(user.getUsername().equals(userName)) {
				return user;
			}
		}
		
		return null;
	}

	/**
	 * Gets an arraylist of the type User 
	 * @return a new ArrayList of Users
	 */
	public ArrayList<User> getUsers() {
		return userList;
	}

	/**
	 * Adds a user to the Arraylist
	 * @param name of the user
	 * @param title of the user
	 * @param race of the user
	 * @param dob of the user 
	 * @param address of the user 
	 * @param password of the user 
	 * @param username of the user
	 * @return True if a user exists with the username and password, false if a user exists with the username and password
	 */
	public boolean addUser(String name, String title, String race, String dob, String address, String password, String username) {
		if(haveUser(username, password))return false;
		
		userList.add(new User(name, title, race, dob, address, password, username));
		return true;
	}
	/**
	 * Writes the Users to a file
	 */
	public void saveUsers() {
		DataWriter.saveUsers();
	}
}