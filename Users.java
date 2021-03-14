import java.util.ArrayList;

public class Users {
	private static Users users;
	private ArrayList<User> userList;
	
	private Users() {
		userList = DataLoader.getUsers();
	}
	
	public static Users getInstance() {
		if(users == null) {
			users = new Users();
		}
		
		return users;
	}

	public boolean haveUser(String userName) {
		for(User user : userList) {
			if(user.getUsername().equals(userName)) {
				return true;
			}
		}
		
		return false;
	}
	
	public User getUser(String userName) {
		for(User user : userList) {
			if(user.getUsername().equals(userName)) {
				return user;
			}
		}
		
		return null;
	}
	
	public ArrayList<User> getUsers() {
		return userList;
	}
	
	public boolean addUser(String userID, String name, String title, String race, String dob, String address, String password, String username) {
		if(haveUser(username))return false;
		
		userList.add(new User(userID, name, title, race, dob, address, password, username));
		return true;
	}
	
	public void saveUsers() {
		DataWriter.saveUsers();
	}
}