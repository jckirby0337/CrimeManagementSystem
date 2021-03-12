package CrimeManagementSystem;
import java.util.ArrayList;
public class User {
    
    private String name;
    private String title;
    private String race;
    private String dob;
    private String address;
    private int password;
    private String username;
    private ArrayList<User> users;

    public User(String name, String title, String race, String dob, String address, int password, String username) {
        this.name = name;
        this.title = title;
        this.race = race;
        this.dob = dob;
        this.address = address;
        this.password = password;
        this.username = username;
    }

    public void addUser(User user) {
        if(users.contains(user)) {
            System.out.print("Error User Already Exist");
        }
        else {
            users.add(user);
        }
    }

    public void editUser(User user) {
        int index = users.indexOf(user);
        if(index != -1) {
            deleteUser(users.get(index));
            users.add(index, user);
        }
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

}
