import java.util.ArrayList;
import java.util.Optional;

public class Bank {

	// instance members
	private ArrayList<Account> accounts;

	// constructor
	public Bank() {
		accounts = new ArrayList<>();
	}

	// adds the account into bank
	public void addAccount(Account account) {
		accounts.add(account);
		System.out.println("Thank you, the account number is " + account.getAccountNumber());
	}

	// lists the accounts
	public void listAccounts() {
		accounts.forEach(System.out::println);
	}

	// deposits said amount into account
	public void depositAccount(int accountNumber, double amount) {
		Optional<Account> account = accounts.stream().filter(a -> a.getAccountNumber() == accountNumber).findFirst();
		if (account.isPresent()) {
			account.get().deposit(amount);
		}
		else {
			System.out.println("Account not found");
		}
	}

	// withdraws said amount from account
	public void withdrawAccount(int accountNumber, double amount) {
		Optional<Account> account = accounts.stream().filter(a -> a.getAccountNumber() == accountNumber).findFirst();
		if (account.isPresent()) {
			account.get().withdraw(amount);
		}
		else {
			System.out.println("Account not found");
		}
	}

	// closes the account
	public void closeAccount(int accountNumber) {
		Optional<Account> account = accounts.stream().filter(a -> a.getAccountNumber() == accountNumber).findFirst();
		if (account.isPresent()) {
			account.get().setClosed(true);
			System.out.println("Account closed, current balance is " + account.get().getBalance()
					+ ", deposits are no longer possible");
		}
		else {
			System.out.println("Account not found");
		}
	}

	// this method receives the parameters required for creating checkingAccount and
	// returns the same
	public CheckingAccount openCheckingAccount(String firstName, String lastName, String SSN, double limit) {
		return new CheckingAccount(new Customer(firstName, lastName, SSN), limit);
	}

	// this method receives the parameters required for creating SavingAccount and
	// returns the same
	public SavingAccount openSavingAccount(String firstName, String lastName, String SSN) {
		return new SavingAccount(new Customer(firstName, lastName, SSN));
	}

	// this method receives the parameters required for creating CreditCardAccount
	// and returns the same
	public CreditCardAccount openCreditAccount(String firstName, String lastName, String SSN, double limit) {
		return new CreditCardAccount(new Customer(firstName, lastName, SSN), limit);
	}

}