/*2.b. Develop a Java program to make a  Performance Test on  StringBuffer and StringBuilder for
 appending the string ‘AIET’ for 10000 times both in the StringBuffer and StringBuilder. Justify 
your answer which one is better.*/

package String_Functions;

public class PerformanceTest {
    public static void main(String[] args) {

        // StringBuffer Performance Test
        long startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer("Java");
        for (int i = 0; i < 10000; i++) {
            sb.append("AIET");
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // StringBuilder Performance Test
        startTime = System.nanoTime();
        StringBuilder sb2 = new StringBuilder("Java");
        for (int i = 0; i < 10000; i++) {
            sb2.append("AIET");
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}
