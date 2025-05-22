/*3b  Q3. Write a Java Program for  Reversing the characters in a string using user defined function 
reverseString().*/

package StringHandling;
import java.util.*;

public class ReverseString {
	public static String reverseString(String str) {
        if (str == null) {
            return null;            
        }
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        sc.close();

        String reversed = reverseString(input);
        System.out.println("Reversed string: " + reversed);
    }

}
