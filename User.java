import java.util.UUID;
/**
 * Creates the User object
 * @author Team Coalition
 */
public class User {
    
    private UUID userID;
    private String name;
    private String title;
    private String race;
    private String dob;
    private String address;
    private String password;
    private String username;
   /** Constructs a User object with the parameters:
     * @param name of the user
	 * @param title of the user
	 * @param race of the user
	 * @param dob of the user 
	 * @param address of the user 
	 * @param password of the user 
	 * @param username of the user
	 */
    public User(String name, String title, String race, String dob, String address, String password, String username) {
        this.userID = UUID.randomUUID();
        this.name = name;
        this.title = title;
        this.race = race;
        this.dob = dob;
        this.address = address;
        this.password = password;
        this.username = username;
    }

    /** Constructs a User object with the parameters:
     * @param userID of the user
     * @param name of the user
	 * @param title of the user
	 * @param race of the user
	 * @param dob of the user 
	 * @param address of the user 
	 * @param password of the user 
	 * @param username of the user
	 */
    public User(UUID userID, String name, String title, String race, String dob, String address, String password, String username) {
        this.userID = userID;
        this.name = name;
        this.title = title;
        this.race = race;
        this.dob = dob;
        this.address = address;
        this.password = password;
        this.username = username;
    }

    public UUID getUserID() {
        return userID;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getTitle() {
        return title;
    }
    public String getRace() {
        return race;
    }
    public String getDOB() {
        return dob;
    }
    public String getAddress() {
        return address;
    }
    public String toString() {
        return name;
    }
}
