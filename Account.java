import java.util.Scanner;

public class Account {

	private String user;
	private String pass;
	private String[][] acct = {{"trock","1234abcd"},{"suchiha","sharingan"}};
	
	//User initialization 
	public Account(String user, String pass){ 
		this.user=user;
		this.pass=pass;
	}
	
	//verify pass word
	public boolean verifyPass() {
		if(user.equals(acct[0][0]) &&pass.equals(acct[0][1])){
			return true;
		}
		else
			return false;
	}

    if(verify.verifyPass())
        System.out.println("Welcome "+user);
        User users = new User();
        if(users.getUserID.equals("trock")){
            System.out.println("Would You Like To Add Or Remove A User?\n 1. Add A User\n 2. Remove A User");
            Scanner keyboard = new Scanner(System.in);
            if(keyboard.equals("1")){
                System.out.println("Add username:");
                Scanner user1 = new Scanner(System.in);
                users.addUser(user1);
            }
            else if(keyboard.equals("2")){
                System.out.println("Remove Username:");
                Scanner user2 = new Scanner(System.in);
                users.deleteUser(user2);
            }
        }
        
    else
        System.out.println("Incorrect log in information");)
}