package bankingApplication;

import java.util.Scanner;

public class BankingApp {
	public static void main(String[] args) {

		BankAcccount obj=new BankAcccount("Swechha", "S123");
		obj.showMenu();
	}

}
class BankAcccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	public BankAcccount(String cName,String cId) {
		customerName = cName;
		customerId = cId;
		
	}
	void deposit(int amount){
		
		if (amount !=0) {
			balance=balance + amount;
			previousTransaction=amount;
		}
	}
	
	void withDraw(int amount){
		
		if (amount !=0) {
			balance=balance - amount;
			previousTransaction=-amount;
		}	
	}
	
	void getPreviousTransaction(){
		if (previousTransaction>0) {
			System.out.println("Deposited: "+previousTransaction);
		}
		
		else if (previousTransaction<0) {
			System.out.println("Withdrawn:" +Math.abs(previousTransaction));//math.absolute is used to give a positive value
		}
		
		else {
			System.out.println("No transaction occured");
		}
	}
	
	void showMenu(){
		char option= '\0';
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Welcome "+customerName );
		System.out.println("your ID is"+customerId);
		System.out.println("\n" );
		System.out.println("A. Check balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. previous transaction");
		System.out.println("E. Exit");
		
		do {
			System.out.println("=================================================================================================================================");
			System.out.println("Enter an option");
			System.out.println("=================================================================================================================================");
			option=scanner.next().charAt(0);
			System.out.println("\n");
			
			switch (option) {
			case 'A':
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("balance: "+balance);
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("\n");
				break;
			case 'B':	
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Enter an amount to deposit");
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
				 int amount=scanner.nextInt();
				 deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':	
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Enter an amount to withdraw");
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
				 int amount2=scanner.nextInt();
				 withDraw(amount2);
				System.out.println("\n");
				break;	
				
			case 'D':
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
				getPreviousTransaction();
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("\n");
				break;	
				
			case 'E':	
				System.out.println("************************************************************************************************************************************");
				break;

			default:
				break;
			}
			
		} while (option != 'E');
		System.out.println("Thank You For Using Our Services");
	}
}
