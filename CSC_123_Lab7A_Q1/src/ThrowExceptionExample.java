/**
 * 
 * @author Alex C (acao4@toromail.csudh.edu)
 *
 * Try running the following program, it will throw an exception. Make note of the exception 
 * that is being thrown. Now modify the program so that all errors are suppressed and the
 * program does not crash.
 * 
 * Exception in thread "main" java.lang.ArithmeticException: / by zero
	at ThrowExceptionExample.main(ThrowExceptionExample.java:7)
	
	if an even number is given we will get an error because % is a division operator
	and spits out the remainder of the calculation.
 */
public class ThrowExceptionExample
{
	public static void main(String[] args) 
	{
		for(int x = 0; x < 9; x++) 
		{	
			// try-catch to suppress the error and make the program not crash
			try 
			{
				System.out.println(x/(x%2));
			}
			catch(ArithmeticException ae)
			{
				System.out.println("Showing no errors, non-existent value...");
			}
		
		}
	}
}