import java.util.Scanner;
public class Q6_2InsertFromKeyboard {
	    public static void main(String[] args) {
	        Scanner keyboard = new Scanner(System.in);

	        // Prompt user for inputs
	        System.out.print("What's your name? ");
	        String strName = keyboard.nextLine();

	        System.out.print("How old are you? ");
	        int iAge = keyboard.nextInt();

	        System.out.print("How tall are you (m)? ");
	        double dHeight = keyboard.nextDouble();

	        // Display the collected information
	        System.out.println("Mrs/Ms. " + strName + ", you are " + iAge + " years old.");
	        System.out.println("Your height is " + dHeight + " meters.");

	        keyboard.close(); // Close the scanner to avoid resource leaks
	    }
	}