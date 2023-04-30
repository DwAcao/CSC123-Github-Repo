import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract class Account implements Serializable 
{
	private static int accountCounter = 1000;
	private String accountNumber;
	private AccountType accountType;
	private double balance;
	private String currency;
	private List<Transaction> transactions;

	public Account(String currency) 
	{
		this.accountNumber = generateAccountNumber();
		this.currency = currency;
		this.transactions = new ArrayList<>();
	}

	private String generateAccountNumber() 
	{
		return String.valueOf(++accountCounter);

	}
	
	public void setAccountType(AccountType accountType) 
	{
		this.accountType = accountType;
	}

	public String getAccountNumber() 
	{
		return accountNumber;
	}
	
	public double getBalance() 
	{
		return balance;
	}

	public double getBalanceInUSD(Bank bank) 
	{
		double exchangeRate = bank.getExchangeRate(currency);
		
		if (exchangeRate != -1) 
		{
			return balance * exchangeRate;
		}

		return -1; // Return -1 if exchange rate not found
	}

	public void deposit(double amount) 
	{
		balance += amount;
		Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount);
		transactions.add(transaction);
	}

	public void withdraw(double amount) 
	{
		if (balance >= amount) 
		{
			balance -= amount;
			Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, amount);
			transactions.add(transaction);
		} 
		else 
		{
			System.out.println("Insufficient funds.");
		}
		
	}
	
	public void displayAccountInfo() 
	{
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Type: " + accountType);
		System.out.println("Balance: " + balance);
		System.out.println("Currency: " + currency);
		System.out.println("Transactions:");

		for (Transaction transaction : transactions) 
		{
			System.out.println(transaction);
		}

	}

	// public String getCurrency() {
		// get currency stuff here
	//}
}