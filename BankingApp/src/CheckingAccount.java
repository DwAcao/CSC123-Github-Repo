public class CheckingAccount extends Account
{
	private double overdraftLimit;
	
	//constructor
	public CheckingAccount(Customer accountholder,double overdraftLimit) 
	{
		super();
		setAccountName("Checking");
		setCustomer(accountholder);
		this.overdraftLimit=overdraftLimit;
	
	}
	
	//getter and setter for overdraftLimit
	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	//update the withdraw method to allow the negative balance upto overdraftLimit
	public void withdraw(double amount) 
	{
		if (amount <= getBalance()+overdraftLimit && !isClosed()) 
		{
			setBalance(getBalance()-amount);
			System.out.println("Withdraw successful, the new balance is: " + getBalance());

		}
		else {
			System.out.println("Withdraw failed, the balance is: " + getBalance());

		}
	}
	
}