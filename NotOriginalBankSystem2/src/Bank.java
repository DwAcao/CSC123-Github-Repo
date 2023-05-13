import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bank {
    private static List<Account> accounts = new ArrayList<>();
    private static int accountNumbers = 100;

    private Bank() {

    }

    public static Account openAccount(String firstName, String lastName, String email, String SSN, String accountType) {
        Person customer = new Person(firstName, lastName, email, SSN);

        if (accountType.equals("Checking"))
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter overdraft limit: ");
            double overDraftLimit = scan.nextDouble();
            scan.nextLine();

            CheckingAccount account = new CheckingAccount(accountNumbers++, accountType, customer, overDraftLimit);
            accounts.add(account);
            return account;
        }

        Account account = new Account(accountNumbers++, accountType, customer);
        accounts.add(account);
        return account;
    }

    public static void printAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public static Account findAccount(int accountNumber) {
        return accounts.stream()
                .filter(account -> account.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);
    }

    public static boolean deposit(int accountNumber, double amount) throws AccountClosedException {
        Account account = findAccount(accountNumber);
        if (account != null) {
            return account.deposit(amount);
        }
        return false;
    }

    public static boolean withdraw(int accountNumber, double amount) throws AccountClosedException, InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        if (account != null) {
            if (account.getType().equals("Checking")) {
                CheckingAccount checkingAccount = (CheckingAccount) account;
                return checkingAccount.withdraw(amount);
            }
            return account.withdraw(amount);
        }
        return false;
    }

    public static boolean closeAccount(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.closeAccount();
            return true;
        }
        return false;
    }
    public static void saveTransactions(int accountNumber, String fileName) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (Transaction transaction : account.getTransactions()) {
                    writer.write(transaction.toString() + "\n");
                }
                writer.close();
                System.out.println("Transactions saved to file: " + fileName);
            } catch (IOException e) {
                System.out.println("Error saving transactions to file: " + fileName);
                e.printStackTrace();
            }
        }

        else {
            System.out.println("Account not found.");
        }
    }
}