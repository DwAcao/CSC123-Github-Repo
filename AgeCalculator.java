/**
 * Write a Java program that accepts a person’s Birthday using MM/DD/YY format. The
	program should output the person’s age in Years and Months
 */
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
 
public class AgeCalculator 
{
    public static void main(String[] args) 
    {
        Scanner KB = new Scanner(System.in);
        System.out.print("Please enter your date of birth in MM/DD/YY format: ");
        String DoB = KB.next();   //Get the Date of Birth from user
        
        // Create date format object
        // Create calendar instance
        // Create another calendar instance and give it the Date of Birth provided by the user
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy");
        Calendar today = Calendar.getInstance();
        Calendar birthday = Calendar.getInstance();
        
        try 
        {  // Check if the format is valid 
        	// If valid set the birthday time to the calendar instance created above
            birthday.setTime(df.parse(DoB)); 
        } 
        catch (ParseException e) 
        {    // If not valid print error 
            System.out.println("Invalid format, please try again");  
            return;   // Exit program 
        }
        
        // Get the number of Years between today's year and Birthday's year
        // Get the number of Months between today's month and Birthday's month
        int years = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
        int months = today.get(Calendar.MONTH) - birthday.get(Calendar.MONTH);

        // If there is no exact match, reduce one year and add 12 months
        if (months < 0) 
        { 
            years--;    
            months += 12;   
        }
        
        // Print age in Years & Months
        System.out.println("You are " + years + " years and " + months + " months old."); 								    

    }   
    
}