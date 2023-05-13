/**
 * Write a program that takes a person’s Birthday using MM/DD/YY and outputs the day
	of the week (e.g. Monday, Tuesday etc.) the person was born
 */
import java.util.Calendar;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
 
public class BirthdayDayOfWeek { 
  
    public static void main(String[] args) { 
  
        // Prompt user to input birth date 
        Scanner KB = new Scanner(System.in); 
        System.out.print("Please enter your birth date in MM/DD/YY format: "); 
        String bDayString = KB.nextLine(); 

        // Create date formats and parse input string into Date object  
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy"); 
        Calendar DayCalendar = Calendar.getInstance();  

        try 
        { 
        	DayCalendar.setTime(sdf.parse(bDayString)); 
        } 
        catch (ParseException e) 
        { 
        	e.printStackTrace(); 
        }

        // Use the Calendar set method to set the day of the week 
        int dayOfWeek = DayCalendar.get(Calendar.DAY_OF_WEEK);

        // Declare array of days of week strings and output the correct string value  
        String[] daysOfWeekStrings = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        System.out.println("You were born on " + daysOfWeekStrings[dayOfWeek - 1] + ".");  

    }      
    
}