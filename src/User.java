import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
	private String firstName;
	private String uuid;
	private String lastName;
	private byte pinHash[];// store pin info
private String pin;
	private ArrayList<Account> accounts;

	public User(String firstName,String lastName,String pin ,Bank theBank) {
		super();
		this.firstName = firstName;

		this.lastName = lastName;
		
		//store pin mds rather than original value
	/*	try {
			MessageDigest md = MessageDigest.getInstance("MDS");
			this.pinHash = md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.err.println("error caught,NoSuchAlgorithmException");
			System.exit(1);
			e.printStackTrace();
		}*/

		// get unique universal id for the user
		this.uuid = theBank.getNewUserUUID();
		this.accounts = new ArrayList<Account>();

		System.out.printf("new user %s %s with ID %s created  \n",lastName,firstName,this.uuid);
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public byte[] getPinHash() {
		return pinHash;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		this.accounts.add(account);
	}

	public boolean validatePin(String pin2) {
		try {
			MessageDigest msg= MessageDigest.getInstance("MSD");
					return MessageDigest.isEqual(msg.digest(pin2.getBytes()), pinHash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.err.println("error occur");
			System.exit(1);
			e.printStackTrace();
		}
		return false;
	}

	public void printAccountSummary() {
		System.out.printf("account summary",this.firstName);
		for(int a=0;a<this.accounts.size();a++) {
			System.out.printf(this.accounts.get(a).summaryLine(),a+1);
		}
	}

	public int numAccounts() {
		// TODO Auto-generated method stub
		return this.accounts.size();
	}

	public void printAccountTransactionHistory(int theAccount) {
		// TODO Auto-generated method stub
		this.accounts.get(theAccount).printTransactionHistory();
		
	}

	public String getAccountUUID(int accIdx) {
		// TODO Auto-generated method stub
		return this.accounts.get(accIdx).getUuid();
	}
	

	
	public void addAccountTransaction(int accIdx, double amount, String memo) {
		// TODO Auto-generated method stub
		this.accounts.get(accIdx).addTransaction(amount,memo);
	}

	public double getAccountBalance(int fromAcc) {
		return this.accounts.get(fromAcc).getBalance();
		// TODO Auto-generated method stub
		
	}

	
	

}
