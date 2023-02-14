import java.util.Date;

public class Transaction {
private double amount;
private Date timeStamp;
private Account inAccount;
private String memo;
public Transaction(double amount, Account inAccount) {
	super();
	this.amount = amount;
	this.timeStamp = new Date();
	this.inAccount = inAccount;
	this.memo="";
}
public Transaction(double amount, String memo,Account inAccount) {
	
	this(amount,inAccount);
	this.memo = memo;
}

public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Date getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(Date timeStamp) {
	this.timeStamp = timeStamp;
}
public Account getInAccount() {
	return inAccount;
}
public void setInAccount(Account inAccount) {
	this.inAccount = inAccount;
}
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}
public String getSummaryLine() {
	// TODO Auto-generated method stub
	
	if(this.amount>=0) {
		return String.format("%s:$%.02f;%s", this.timeStamp.toString(),this.amount,this.memo);
	}
	return  String.format("%s:$%.02f;%s", this.timeStamp.toString(),this.amount,this.memo);
}



}
