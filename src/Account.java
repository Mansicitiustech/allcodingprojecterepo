import java.util.ArrayList;

public class Account {
private String accName;
private String uuid;
private User accHolder;
private ArrayList<Transaction> transactions;
private double balance;

public Account(String accName, User accHolder, Bank theBank) {
	super();
	this.accName = accName;

	this.accHolder = accHolder;
	this.transactions = new ArrayList<Transaction>();
	this.uuid=theBank.getNewAcccountUUID();

	//accHolder.addAccount(this);
	//theBank.addAccount(this);
	// TODO Auto-generated constructor stub
}


public String getUuid() {
	return uuid;
}

public void setUuid(String uuid) {
	this.uuid = uuid;
}

public String getAccName() {
	return accName;
}

public User getAccHolder() {
	return accHolder;
}

public ArrayList<Transaction> getTransactions() {
	return transactions;
}

public double getBalance() {
	
	for(Transaction t:this.transactions) {
		double balance=0;
		 balance += t.getAmount();
	}
	return balance;
}


public String summaryLine() {
	// get balance
	double balance2 = this.getBalance();
	if(balance2>=0) {
		return String.format("%s : $%,02f : %s  ",balance2,this.uuid,this.accName);
	}
	else {return String.format("%s : $%,02f : %s  ",balance2,this.uuid,this.accName);}

	
}


public void printTransactionHistory() {
	// TODO Auto-generated method stub
	System.out.printf("transaction history for account ",this.uuid);
	for(int i=this.transactions.size();i>=0;i--) {
		System.out.println(this.transactions.get(i).getSummaryLine());
	}
	System.out.println();
}


public void addTransaction(double amount, String memo) {
	// create new transaction object and add it to our list
	Transaction newTransaction=new Transaction(amount,memo,this);
	this.transactions.add(newTransaction);
}


}
