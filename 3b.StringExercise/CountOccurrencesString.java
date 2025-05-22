/*3.b Q2. Write a Java Program for Counting how many times a substring appears in a main string
 using user defined function countOccurrences()*/

package StringHandling;

public class CountOccurrencesString {

    public static int countOccurrences(String mainStr, String substr) {
        if (mainStr == null || substr == null || substr.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = mainStr.indexOf(substr, index)) != -1) {
            count++;
            index++;                 
        }
        return count;
    }

    public static void main(String[] args) {
        String main = "helloooo";   
        String sub  = "lo";          
        int result = countOccurrences(main, sub);
        System.out.println("Occurrences of \"" + sub + "\" in \"" + main + "\": " + result);
    }

}
