import java.io.Serializable;

class Transaction implements Serializable {

	private TransactionType transactionType;
	private double amount;

	public Transaction(TransactionType transactionType, double amount) 
	{
		this.transactionType = transactionType;
		this.amount = amount;
	}

	public TransactionType getTransactionType() 
	{
		return transactionType;
	}

	public double getAmount() 
	{
		return amount;
	}

	@Override
	public String toString() 
	{
		return "Type: " + transactionType + ", Amount: " + amount;
	}

}