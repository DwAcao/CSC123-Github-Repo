public class SavingAccount extends Account
{
	//constructor which in turn calls the base class constructor
	public SavingAccount(Customer accountholder) 
	{
		super();
		setAccountName("Saving");
		setCustomer(accountholder);
	}

}