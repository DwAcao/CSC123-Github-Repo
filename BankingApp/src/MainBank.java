import java.util.Scanner;

public class MainBank 
{
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int choice;
		
		//creating a bank object
		Bank bank = new Bank();
		
		do {
			//display the menu options
			displayMenu();
			choice=input.nextInt();
			input.nextLine();
			
			switch(choice) 
			{
			// if choice is 1 then call openCheckingAccount method with necessary parameters read from user
			case 1:
				System.out.print("\nEnter first name: ");
				String fn=input.nextLine();
				
				System.out.print("\nEnter last name: ");
				String ln=input.nextLine();
				
				System.out.print("\nEnter social security number: ");
				String ssn=input.nextLine();
				
				System.out.print("\nEnter overdraft Limit: ");
				double limit=input.nextDouble();
				
				bank.addAccount(bank.openCheckingAccount(fn,ln,ssn,limit));
				break;
				
			// if choice is 2 then call openSavingAccount method with necessary parameters read from user
			case 2:
				System.out.print("\nEnter first name: ");
				fn=input.nextLine();
				
				System.out.print("\nEnter last name: ");
				ln=input.nextLine();
				
				System.out.print("\nEnter social security number: ");
				ssn=input.nextLine();
				
				bank.addAccount(bank.openSavingAccount(fn,ln,ssn));
				break;
				
			// if choice is 3 then call openCreditAccount method with necessary parameters read from user
			case 3:
				System.out.print("\nEnter first name: ");
				fn=input.nextLine();
				
				System.out.print("\nEnter last name: ");
				ln=input.nextLine();
				
				System.out.print("\nEnter social security number: ");
				ssn=input.nextLine();
				
				System.out.print("\nEnter credit Limit: ");
				limit=input.nextDouble();
				
				bank.addAccount(bank.openCreditAccount(fn,ln,ssn,limit));
				break;
				
			// calls the listAccounts method of bank
			case 4:
				bank.listAccounts();
				break;
				
			//asks the user to enter the account number and amount and calls the depositAccount method
			case 5:
				System.out.print("Enter account number: ");
				int acctNo=input.nextInt();
				
				System.out.print("Enter the amount to deposit: ");
				double amount=input.nextDouble();
				
				bank.depositAccount(acctNo, amount);
				break;
				
			//asks the user to enter the account number and amount and calls the withdrawAccount method
			case 6:
				System.out.print("Enter account number: ");
				acctNo=input.nextInt();
				
				System.out.print("Enter the withdrawal amount: ");
				amount=input.nextDouble();
				
				bank.withdrawAccount(acctNo, amount);
				break;
				
			//ask the user to enter the account number and calls the closeAccount method of bank
			case 7:
				System.out.print("Enter account number: ");
				acctNo=input.nextInt();
				
				bank.closeAccount(acctNo);
				break;
			
			// break the loop
			case 8:
				break;
				
			// for anyother choice iterate the loop continuously
			default:
				System.out.println("Invalid choice. Try Again!!!");
				break;
			}
			
		} while(choice!=8);
	}	
	
	//this function displays the menu options
	private static void displayMenu() 
	{
		System.out.println("1 - Open Checking account");
		System.out.println("2 - Open Saving account");
		System.out.println("3 - Open Credit account");
		System.out.println("4 - List accounts");
		System.out.println("5 - Deposit funds");
		System.out.println("6 - Withdraw funds");
		System.out.println("7 - Close an account");
		System.out.println("8 - Exit");
		System.out.print("\nPlease enter your choice: ");

	}

}
