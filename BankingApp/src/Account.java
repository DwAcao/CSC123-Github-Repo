public class Account 
{
	// instance members
	private boolean isClosed;
	private double balance;
	private int accountNumber;
	private String accountName;
	private Customer customer;
	private static int counter = 999;
	
	// constructors
	protected Account() 
	{
		isClosed = false;
		balance = 0;
		accountNumber = counter;
		counter++;
	}

	// Program deposits said amount
	public void deposit(double amount) 
	{
		if (amount > 0 && !isClosed) 
		{
			balance += amount;
			System.out.println("Deposit successful, the new balance is: " + balance);
		}

		else {
			System.out.println("Deposit failed, the balance is: " + balance);
		}
	}

	// Program withdraws said amount

	public void withdraw(double amount) 
	{
		if (balance - amount >= 0 && amount >= 0 && !isClosed) {
			balance -= amount;
			System.out.println("Withdraw successful, the new balance is: " + balance);
		}

		else {
			System.out.println("Withdraw failed, the balance is: " + balance);
		}
	}

	// setters and getters
	public boolean isClosed() 
	{
		return isClosed;
	}

	public void setClosed(boolean closed) {
		isClosed = closed;
	}

	// get balance information
	public double getBalance() {
		return balance;
	}

	// set balance information
	public void setBalance(double balance) {
		this.balance = balance;
	}

	// get account number
	public int getAccountNumber() {
		return accountNumber;
	}

	// set account number
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	// get account name
	public String getAccountName() {
		return accountName;
	}

	// set account name
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	// get customer information
	public Customer getCustomer() {
		return customer;
	}

	// set customer information
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// return the string representation of the Account
	@Override
	public String toString() {
		return String.format("%d(%s) : %s : %s : %s : %.2f : %s", accountNumber, accountName, customer.getFirstName(),
				customer.getLastName(), customer.getSocialSecurityNumber(), balance,
				(isClosed == false ? "Account Open" : "Account Closed"));

	}

}