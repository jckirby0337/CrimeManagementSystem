import java.util.Scanner;
public class Profile {
	Scanner input = new Scanner(System.in);
	public void run(){
		Account myProfile = getAccount();
		if(myProfile==null){
			return;
		}
		while(true){
			

		}
		// if(verify.verifyPass()){
		// 	System.out.println("Welcome "+ user);
		// 	if(user=="trock")
		// 	{

		// 	}
		// 	else if(user=="suchiha")
		// 	{

		// 	}

		// }
		// else{
		// 	System.out.println("Incorrect log-in info");
		// }
	
		// input.close();
	}

	public Account getAccount(){
		String user;
		String pass;
		 

		System.out.println("Welcome to Columbia PD\n\n" + "Please enter your username and password:\n" + "Username: ");
		user = input.nextLine();
		
		System.out.println("Password: ");
		pass = input.nextLine();
		
		if(Account.verifyPass(user,pass)){
			return new Account(user,pass);
		}
		else{
			return null;
		}
		// Account verify = new Account(user,pass);
		// return verify;
	}
	
	public void displayMenu(){
		Sys
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Profile myProfile = new Profile();
		myProfile.run();

	}
}