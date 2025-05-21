/*3.c  Q10. Write a Java Program for  Counting the number of words in a string using user defined function  
countWords()*/

package StringHandling;
import java.util.Scanner;

public class CountWordsString {

    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        sc.close();

        int result = countWords(s);
        System.out.println("Word count: " + result);
    }
}
