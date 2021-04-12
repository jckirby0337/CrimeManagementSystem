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
		displayMenu();
	}
	
	public void displayMenu(){
		System.out.println("Welcome "+user);
		if(user=="trock")
		{
			System.out.println("These are your menu options:\n");
			System.out.println("1. Add User\n"+"2. Remove User"+"3. Get Password of User");
			Scanner admin = new Scanner(System.in);
			Users acc = new Users();
			if(admin.equals("1")){
				\
				String[] inputDet = new String[8];
				String[] info = {"User ID: ","Name: ","Title: ","Race: ","DOB: ", "Address: ","Password: ","Username: " };
				System.out.println("Please fill out information of the new user.");
				for(int i = 0;i<8;i++){
					Scanner newUser = new Scanner(System.in);
					System.out.print(info[i]);
					inputDet[i] = newUser.nextLine;
				}
				acc.addUser(inputDet[0],inputDet[1],inputDet[2],inputDet[3],inputDet[4],inputDet[5],inputDet[6],inputDet[7]);
			}
			else if(admin.equals("2"))
			{

			}
			else if(admin.equals("3"))
			{
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Profile myProfile = new Profile();
		myProfile.run();

	}
}