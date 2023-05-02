import java.util.Scanner;

class BankingApplication {

	public static void main(String[] args) {

		Bank bank = new Bank();
		bank.loadExchangeRatesFromUrl("http://www.usman.cloud/banking/exchange-rate.csv");

		// Load bank data from file (if exists)
		bank.loadDataFromFile("bank-data.dat");
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {

			displayMenu();
			choice = scanner.nextInt();
			
			scanner.nextLine(); // Consume the newline character

			switch (choice) 
			{
			
			case 1:
				openAccount(scanner, bank, AccountType.CHECKING);
				break;

			case 2:
				openAccount(scanner, bank, AccountType.SAVING);
				break;

			case 3:
				listAccounts(scanner, bank);
				break;

			case 4:
				viewStatement(scanner, bank);
				break;

			case 5:
				showAccountInformation(scanner, bank);
				break;

			case 6:
				depositFunds(scanner, bank);
				break;

			case 7:
				withdrawFunds(scanner, bank);
				break;

			case 8:
				performCurrencyConversion(scanner, bank);
				break;

			case 9:
				closeAccount(scanner, bank);
				break;

			case 10:
				exitApplication(bank);
				break;

			default:
				System.out.println("Invalid choice. Please try again.");

			}

		} while (choice != 10);

		// Save bank data to file
		bank.saveDataToFile("bank-data.dat");

	}

	public static void displayMenu() 
	{
		System.out.println("1 - Open a Checking account");
		System.out.println("2 - Open a Saving account");
		System.out.println("3 - List Accounts");
		System.out.println("4 - View Statement");
		System.out.println("5 - Show Account Information");
		System.out.println("6 - Deposit Funds");
		System.out.println("7 - Withdraw Funds");
		System.out.println("8 - Perform Currency Conversion");
		System.out.println("9 - Close an Account");
		System.out.println("10 - Exit");
		
		System.out.print("Enter choice: ");

	}

	public static void openAccount(Scanner scanner, Bank bank, AccountType accountType) {

		String currency;
		
		// unable to implement
		if (bank.getExchangeRates().isEmpty()) 
		{
			currency = "USD";
		} 
		
		else 
		{
			System.out.print("Enter account currency: ");
			currency = scanner.nextLine();
		}

		Account account = bank.openAccount(accountType, currency);
		
		System.out.println("Account opened successfully. Account number: " + account.getAccountNumber());

	}

	public static void listAccounts(Scanner scanner, Bank bank) 
	{
		System.out.print("Enter account number: ");
		
		String accountNumber = scanner.nextLine();
		Account account = bank.getAccount(accountNumber);

		if (account != null) 
		{
			double balance = account.getBalance();
			double usdBalance = account.getBalanceInUSD(bank);
			String currency = account.getCurrency(); // was still not able to implement

			System.out.println("Account Number: " + accountNumber);
			System.out.println("Currency: " + currency);
			System.out.println("Balance: " + balance);
			System.out.println("USD Balance: " + usdBalance);

		} 
		else 
		{
			System.out.println("Account not found.");
		}

	}

	public static void viewStatement(Scanner scanner, Bank bank) 
	{
		// Implement code to view statement
	}

	public static void showAccountInformation(Scanner scanner, Bank bank) 
	{
		System.out.print("Enter account number: ");
		String accountNumber = scanner.nextLine();
		Account account = bank.getAccount(accountNumber);

		if (account != null) 
		{
			account.displayAccountInfo();
		} 
		else 
		{
			System.out.println("Account not found.");
		}

	}

	public static void depositFunds(Scanner scanner, Bank bank) 
	{
		// Implement code to deposit funds
	}

	public static void withdrawFunds(Scanner scanner, Bank bank) 
	{
		// Implement code to withdraw funds
	}

	public static void performCurrencyConversion(Scanner scanner, Bank bank) 
	{
		// Implement code for currency conversion
	}

	public static void closeAccount(Scanner scanner, Bank bank) 
	{
		// Implement code to close an account
	}

	public static void exitApplication(Bank bank) 
	{
		System.out.println("Exiting application...");

		// Save bank data to file
		bank.saveDataToFile("bank-data.dat");
		System.out.println("Bank data saved successfully.");

	}

}