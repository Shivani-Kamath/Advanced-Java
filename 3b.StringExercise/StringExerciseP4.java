/*3.b Q4. Write a Java Program for Checking if a string reads the same backward as forward (ignoring case 
and punctuation) using user defined function isPalindrome(): */

package StringHandling;

public class StringExerciseP4 {
	 public static boolean isPalindrome(String s) {
	        if (s == null) return false;

	        // Remove all non-alphanumeric characters and convert to lowercase
	        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

	        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
	    }

	 public static void main(String[] args) {
	        String test1 = "Hello World";
	        String test2 = "Welcome to Java Programming";
	        String test3 = "A Java Java a";

	        System.out.println(test1 + " -> " + isPalindrome(test1));
	        System.out.println(test2 + " -> " + isPalindrome(test2));
	        System.out.println(test3 + " -> " + isPalindrome(test3));
	    }

}
