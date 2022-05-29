package palindrome;

import java.util.Scanner;
/**
 *
 * Program that checks if user input String is a palindrome or not
 *
 * **/
public class Palindrome {

    public static void main(String[] args) {


        System.out.println("Input String to check if it is a palindrome");
        System.out.println("Example: \n Malayalam - is palindrome \n Anzelika - is not a Palindrome");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        StringBuilder reversedResult = new StringBuilder();

        // Reverse string starting from last character of input string
        for (int i = input.length() - 1; i >= 0; i--) {
            reversedResult.append(input.charAt(i));
        }

        // Compare reversed and input string, if they are equal, it is a Palindrome
        if (input.equalsIgnoreCase(reversedResult.toString())) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is not a Palindrome.");
        }
    }
}
