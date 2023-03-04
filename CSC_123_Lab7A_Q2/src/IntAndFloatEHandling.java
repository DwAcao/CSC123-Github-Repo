import java.util.*;
/**
 * 
 * @author Alex C
 * Write a program that accepts an integer a and a float b. The program should divide 
 * a by b and output the result. 
 * Anticipate and handle all exceptions and displays appropriate error messages. This will 
 * include input validation as well as general exception handling.
 */
public class IntAndFloatEHandling
{
	public static void main(String[] args)
	{

		int a;	 float b;
		Scanner KB = new Scanner(System.in);
		
		// Handling integer input validation
		while(true) 
		{
			try {
				System.out.print("Enter an integer: ");
				a = KB.nextInt();
				break;
			}
			catch(InputMismatchException IME) 
			{
				System.out.println("Invalid, enter a integer...");
				KB.nextLine();
			}
		}
		
		// Handling float input validation
		while(true) 
		{
			try {
				System.out.print("Enter a float value: ");
				b = KB.nextFloat();
				break;
			}
			catch(InputMismatchException IME) 
			{
				System.out.println("Invalid, enter a float...");
				KB.nextLine();
			}
		}
		// Handling result validation.
		try {
			int result = a/(int)b;
			System.out.print(result);
		}
		catch (ArithmeticException AE) {
			System.out.println("Cannot divide by zero " + AE);
		}
	}
}