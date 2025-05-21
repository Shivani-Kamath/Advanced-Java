/*3.b Q5. Write a Java Program for Eliminating all whitespace characters from a string using user defined function removeWhitespace()*/
		
	package StringHandling;
	import java.util.Scanner;
	
	public class RemoveWhitespaceStringP5 {
	
	    public static String removeWhitespace(String str) {
	        return str.replaceAll("\\s+", "");
	    }
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String s = sc.nextLine();
	        sc.close();
	
	        String result = removeWhitespace(s);
	        System.out.println("String without whitespace: " + result);
	    }
	}
	
