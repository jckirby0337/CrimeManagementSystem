import java.util.Scanner;
public class Profile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		String user;
		String pass;
		
		 
		System.out.println("Welcome to Columbia PD\n\n" + "Please enter your username and password:\n" + "Username: ");
		user = input.nextLine();
		
		System.out.println("Password: ");
		pass = input.nextLine();
		
		Account verify = new Account(user,pass); 
		
		if(verify.verifyPass())
			System.out.println("Welcome "+user);
		else
			System.out.println("Incorrect log in information");
	
	
}
}