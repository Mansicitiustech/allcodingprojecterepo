import java.util.Scanner;

public class Atm {

	public static void main(String[] args) {
		
	
Scanner scanner=new Scanner(System.in);

Bank bank=new Bank("IDBI");
//add user which also creates saving account
User accountUser=bank.addUser("ruhi", "tomar", "1234abcd");
	Account account=new Account("saving", accountUser, bank);
	accountUser.addAccount(account);
	bank.addAccount(account);
	
	User mainUser;
	while(true) {
		//stay to login untill successfull login
		mainUser=Atm.mainMenuPrompt(bank,scanner);
		//stay in main menu untill user quites
		Atm.printMenu(mainUser,scanner);
	}
}

public static void printMenu(User mainUser, Scanner scanner) {
		
		
		// print summary of user account
	
		mainUser.printAccountSummary();
		//init 
		int choice;
		
		//user menu
	do{
	System.out.printf("wellcome what do you want",mainUser.getFirstName());	
	System.out.println("  1>  show transaction history");
	System.out.println(" 2>  withdraw");
	System.out.println("  3> transffer");
	System.out.println(" 4>   Deposite");
	System.out.println("  5>  Quit");
	
	System.out.println();
	System.out.println("enter choice");
	choice=scanner.nextInt();
	
	if(choice<1 || choice>5) {
		System.out.println("invalid choice,please enter valid choice");}
	}while(choice<1 || choice>5);
	
	//process choice
	switch(choice) {
	
	case 1:
		Atm.showTransactionHistory(mainUser,scanner);
		break;
	
	case 2:
		Atm.withdrawFunds(mainUser,scanner);
		break;
		
	case 3:
		Atm.transfferFunds(mainUser,scanner);
		break;
	case 4:
		Atm.depositeFunds(mainUser,scanner);
		break;
		
	}
	if(choice!=5) {
		Atm.printMenu(mainUser, scanner);
	}
	
	}

	private static void transfferFunds(User mainUser, Scanner scanner) {
int fromAcc;
int toAcc;
double amount;
double accBalance;

//transfre from account
do {
	System.out.println("enter number (1-%d)of account from you want transffer"+"transffer from");
fromAcc=scanner.nextInt()-1;
	if(fromAcc<0 || fromAcc>= mainUser.numAccounts()) {
		System.out.println("invalid account details please try again");
	}
}while(fromAcc<0 || fromAcc>= mainUser.numAccounts());
	

//transfre to account
do {
	System.out.println("enter number of account, you want transffer"+"transffer to");
	toAcc=scanner.nextInt()-1;
	if(toAcc<0 || toAcc>= mainUser.numAccounts()) {
		System.out.println("invalid account details please try again");
	}
}while(toAcc<0 || toAcc>= mainUser.numAccounts());
	 accBalance=mainUser.getAccountBalance(fromAcc);
//get the amount to transffer

do {
	 amount = scanner.nextDouble();
	if(amount<0) {
		System.out.println("invalid amount please enter valid amount");
	}
	else if(amount>accBalance) {
		System.out.println("amount should not be greater than account balance ,please enter valid amount");
	}
}while(amount<0||amount>accBalance);
	mainUser.addAccountTransaction(fromAcc,-1*amount,String.format("transfer amount into ", mainUser.getAccountUUID(toAcc)));
	mainUser.addAccountTransaction(toAcc,amount,String.format("transfer amount from ", mainUser.getAccountUUID(fromAcc)));
	
}



	private static void showTransactionHistory(User mainUser, Scanner scanner) {
		int theAccount;
		do {
System.out.printf("which transaction (1-%d)you want to see",mainUser.numAccounts());
int numAccounts = mainUser.numAccounts();
 theAccount = scanner.nextInt()-1;
 if(theAccount<0||  theAccount>=numAccounts) {
	 System.out.println("invalid account details");
 }
	
		}while(theAccount<0||  theAccount >=mainUser.numAccounts());
		mainUser.printAccountTransactionHistory(theAccount);
	}
	
	public static void withdrawFunds(User mainUser,Scanner scanner) {
		int fromAcc;
	String memo;
		double amount;
		double accBalance;

		//transfre from account
		do {
			System.out.println("enter number of account from you want transffer"+"transffer from");
		fromAcc=scanner.nextInt()-1;
			if(fromAcc<0 || fromAcc>= mainUser.numAccounts()) {
				System.out.println("invalid account details please try again");
			}
		}while(fromAcc<0 || fromAcc>= mainUser.numAccounts());
			
		 accBalance=mainUser.getAccountBalance(fromAcc);
		//get the amount to transffer

		do {
			 amount = scanner.nextDouble();
			if(amount<0) {
				System.out.println("invalid amount please enter valid amount");
			}
			else if(amount>accBalance) {
				System.out.println("amount should not be greater than account balance ,please enter valid amount"+accBalance);
			}
		}while(amount<0||amount>accBalance);
		
		//rest previous input
		scanner.nextLine();
		
		System.out.println("enter memo");
		memo=scanner.nextLine();
		
		// do withdraw
		mainUser.addAccountTransaction(fromAcc, -1*amount, memo);
	}
	private static void depositeFunds(User mainUser, Scanner scanner) {
		// TODO Auto-generated method stub
		int toAcc;
		String memo;
			double amount;
			double accBalance;

			//transfre from account
			do {
				System.out.printf("enter number of account from you want transffer"+"transffer from",mainUser.numAccounts());
			toAcc=scanner.nextInt()-1;
				if(toAcc<0 || toAcc>= mainUser.numAccounts()) {
					System.out.println("invalid account details please try again");
				}
			}while(toAcc<0 || toAcc>= mainUser.numAccounts());
				
			 accBalance=mainUser.getAccountBalance(toAcc);
			//get the amount to transffer

			do {
				 amount = scanner.nextDouble();
				if(amount<0) {
					System.out.println("invalid amount please enter valid amount");
				}
				else if(amount>accBalance) {
					System.out.println("amount should not be greater than account balance ,please enter valid amount"+accBalance);
				}
			}while(amount<0||amount>accBalance);
			
			//rest previous input
			scanner.nextLine();
			
			System.out.println("enter memo");
			memo=scanner.nextLine();
			
			// do withdraw
			mainUser.addAccountTransaction(toAcc, amount, memo);
	
	}
	
	private static User mainMenuPrompt(Bank bank, Scanner scanner) {
		// TODO Auto-generated method stub
		String userID;
		User authUser;
		String pin;
		do {
			System.out.printf("\n\n wellcome to %s\n\n",bank.getName());
			//System.out.printf("wellcome in bank:",bank.getName());
			//System.out.println();
			System.out.print("enter userId   : ");
			
			userID=scanner.nextLine();
			//System.out.println();
			System.out.print("enter pin :");
			
			pin=scanner.nextLine();
		//	System.out.println();
			//try to get user object corresponding userid and pin combo
			authUser = bank.userLogin(userID, pin);
			if(authUser==null) {
				System.out.println("Incorrect userid and pin pleasetey again");
			}
			
		}
		while(authUser==null) ;//try login untill successful login
			return authUser;
			
		
	
	}}