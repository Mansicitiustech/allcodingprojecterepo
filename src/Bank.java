import java.util.ArrayList;
import java.util.Random;

public class Bank {
private String name;
private ArrayList<User> users;
private ArrayList<Account> accounts;

//create new bank object with empty user and empty account

public Bank(String name) {
	this.name=name;
	this.accounts=new ArrayList<Account>();
	this.users=new ArrayList<User>();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public ArrayList<User> getUsers() {
	return users;
}
public ArrayList<Account> getAccounts() {
	return accounts;
}
public String getNewUserUUID() {
	Random rdm=new Random();
	String uuid;
	int length=6;
	boolean nonUniqueuuid=false;
	do {
		uuid="";
		for(int c=0;c<length;c++) {
			uuid+=((Integer)rdm.nextInt(10)).toString();
		}
		for(User u:this.users) {
			if(uuid.compareTo(u.getUuid())==0) {
				nonUniqueuuid=true;	
				break;
			}
		}
		
	}
	while(nonUniqueuuid);
	
	return uuid;
	
	
}
public String getNewAcccountUUID() {
	Random rdm=new Random();
	String uuid;
	int length=6;
	boolean nonUniqueuuid=false;
	do {
		uuid="";
		for(int c=0;c<length;c++) {
			uuid+=((Integer)rdm.nextInt(10)).toString();
		}
		for(Account a:this.accounts) {
			if(uuid.compareTo(a.getUuid())==0) {
				nonUniqueuuid=true;	
				break;
			}
		}
		
	}
	while(nonUniqueuuid);
	
	return uuid;

}
public void addAccount(Account account) {
	// TODO Auto-generated method stub
	this.accounts.add(account);
}

public User addUser(String firstName, String lastName, String pin) {
	User newUser = new User(firstName, lastName, pin, this);

	this.users.add(newUser);
	//create saving account for the user and add to user and bank
	Account newAccount = new Account("saving user ", newUser, this);
	newUser.addAccount(newAccount);
	this.addAccount(newAccount);
	return newUser;



}

public User userLogin(String uuid,String pin) {
	for(User u:this.users) {
		if((u.getUuid().compareTo(uuid)==0) && (u.validatePin(pin))) {
			return u;
		}
	}
	return null;
}
}
