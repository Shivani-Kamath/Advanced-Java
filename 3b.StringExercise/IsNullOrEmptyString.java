/*3.b Q1. Write a Java Program for Checking if a given string is null or contains only whitespace using user 
defined function isNullOrEmpty().*/

package StringHandling;
import java.util.Scanner;
public class IsNullOrEmptyString {

	public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        for (char ch : s.toCharArray()) {
            if (!Character.isWhitespace(ch)) {   
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        sc.close();

        boolean empty = isNullOrEmpty(str);
        if (empty) {
            System.out.println("The string is null or whitespace only.");
        } else {
            System.out.println("The string is not null/whitespace.");
        }
    }
}
