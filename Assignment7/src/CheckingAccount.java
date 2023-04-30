class CheckingAccount extends Account 
{

	public CheckingAccount(String currency) 
	{
		super(currency);
		setAccountType(AccountType.CHECKING);
	}

}