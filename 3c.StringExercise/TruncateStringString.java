/*3.c Q7. Write a Java Program for  Shortening a string to a specified length and adds an ellipsis using user 
defined function truncate()*/

package StringHandling;
import java.util.*;
public class TruncateStringString {
	 public static String truncate(String str, int length) {
	        if (str.length() <= length) {
	            return str;
	        }
	        if (length <= 3) {
	            return "...".substring(0, length);
	        }
	        // Truncate and add ellipsis
	        return str.substring(0, length - 3) + "...";
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String s = sc.nextLine();
	        System.out.print("Enter max length: ");
	        int len = sc.nextInt();
	        sc.close();

	        String result = truncate(s, len);
	        System.out.println(result);
	    }
	}
