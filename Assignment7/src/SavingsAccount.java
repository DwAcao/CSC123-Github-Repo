class SavingAccount extends Account 
{

	public SavingAccount(String currency) 
	{
		super(currency);
		setAccountType(AccountType.SAVING);
	}

}