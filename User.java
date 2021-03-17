import java.util.UUID;
public class User {
    
    private UUID userID;
    private String name;
    private String title;
    private String race;
    private String dob;
    private String address;
    private String password;
    private String username;

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
