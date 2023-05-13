
/**
 * Write a program that takes two dates as input and output difference between the two
	dates in terms of the number of days.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class DifferenceBetweenDates
{
	// method to fetch calendar instance from user given date string
	private static Calendar getCalendar(String prompt) 
	{
		// display message to enter date
		// create scanner object for user input
		// read user entered value
		System.out.println(prompt);
		Scanner KB = new Scanner(System.in);
		String enteredDate = KB.nextLine();

		// create calendar instance for the given user input
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(enteredDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return cal; // return calendar instance here

	}

	public static void main(String args[]) 
	{
		// Get two calendar instance
		Calendar firstDate = getCalendar("Enter the first date in MM/dd/yyyy format: ");
		Calendar secondDate = getCalendar("Enter the second date in MM/dd/yyyy format: ");

		// Calculate difference between two dates
		long timeInMillis = secondDate.getTimeInMillis() - firstDate.getTimeInMillis();

		// Calculate days between two dates by using Math.abs function
		int days = Math.abs((int) (timeInMillis / (1000 * 60 * 60 * 24)));

		System.out.println("The difference in days between the two dates is: " + days);

	}

}