/*3.c Q9. Write a Java Program for  Creating  a random string of a specified length using user defined 
function generateRandomString()*/

package StringHandling;
import java.util.*;

public class GenerateRandomString {
	public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the desired length of the random string: ");
        int length = sc.nextInt();
        sc.close();

        String randomStr = generateRandomString(length);
        System.out.println("Generated Random String: " + randomStr);
    }
}
