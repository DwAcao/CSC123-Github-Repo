public class CreditCardAccount extends Account
{
	//instance variable
	private double creditLimit;
	
	//constructor
	public CreditCardAccount(Customer accountholder,double creditLimit) {
		super();
		setAccountName("Credit");
		setCustomer(accountholder);
		this.creditLimit=creditLimit;
	}
	
	//getter and setter for creditLimit
	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	//it calls the deposit operation of super class method
	public void withdraw(double amount) {
		super.deposit(amount);

	}
	
	//it calls the withdrawal operation of super class method
	public void deposit(double amount) {
		super.withdraw(amount);

	}

}
