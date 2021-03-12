package CrimeManagementSystem;
public class Account {

	private String user;
	private String pass;
	private String[][] acct = {{"Jack","overwatch"},{"Suzan","apex"}};
	
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
}
