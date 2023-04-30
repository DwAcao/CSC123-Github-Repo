import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

class Bank 
{
	private List<Account> accounts;
	private Map<String, Double> exchangeRates;

	public Bank() 
	{
		accounts = new ArrayList<>();
		exchangeRates = new HashMap<>();
	}

    public void loadExchangeRatesFromUrl(String url) 
    {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String csvData = response.body();

            BufferedReader reader = new BufferedReader(new StringReader(csvData));
            String line;
            
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");
                String currency = parts[0].trim();
                double exchangeRate = Double.parseDouble(parts[2].trim());
                
                exchangeRates.put(currency, exchangeRate);
            }
            
            reader.close();
            
        } 
        
        catch (IOException | InterruptedException e) 
        {
            System.out.println("Exchange rate data could not be loaded. Currency Conversion Service and Foreign Currency accounts are not available.");
        }
        
    }

    public double getExchangeRate(String currency) 
    {
        if (exchangeRates.containsKey(currency)) 
        {
            return exchangeRates.get(currency);
        }
        
        return -1; // Return -1 if exchange rate not found
        
    }

	public Account openAccount(AccountType accountType, String currency) 
	{
		Account account;

		if (accountType == AccountType.CHECKING) 
		{
			account = new CheckingAccount(currency);
		} 
		else 
		{
			account = new SavingAccount(currency);
		}

		accounts.add(account);
		
		return account;

	}

	public Account getAccount(String accountNumber) 
	{
		for (Account account : accounts) 
		{
			if (account.getAccountNumber().equals(accountNumber)) 
			{
				return account;
			}
			
		}

		return null; // Return null if account not found
	}

	public void saveDataToFile(String filename) 
	{

		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));

			outputStream.writeObject(accounts);
			outputStream.close();
			System.out.println("Bank data saved successfully.");

		} 
		catch (IOException e) 
		{
			System.out.println("Error occurred while saving bank data.");
		}
	}

	@SuppressWarnings("unchecked")
	public void loadDataFromFile(String filename) 
	{

		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
			accounts = (List<Account>) inputStream.readObject();
			inputStream.close();
			System.out.println("Bank data loaded successfully.");
		} 
		catch (IOException | ClassNotFoundException e) 
		{
			System.out.println("Error occurred while loading bank data.");
		}
	}

	//public String getExchangeRates() {
	//	  get ExchangeRates here
	//}
}