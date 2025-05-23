/*2.b. Develop a Java program to make a  Performance Test on  StringBuffer and StringBuilder for
 appending the string ‘AIET’ for 10000 times both in the StringBuffer and StringBuilder. Justify 
your answer which one is better.*/

package String_Functions;

public class PerformanceTest {
    public static void main(String[] args) {
        final int iterations = 10000;

        // StringBuffer Test
        long start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("Java");
        for (int i = 0; i < iterations; i++) sbf.append("AIET");
        long timeBuffer = System.currentTimeMillis() - start;

        // StringBuilder Test
        start = System.currentTimeMillis();
        StringBuilder sbd = new StringBuilder("Java");
        for (int i = 0; i < iterations; i++) sbd.append("AIET");
        long timeBuilder = System.currentTimeMillis() - start;

        // Output
        System.out.println("Time taken by StringBuffer: " + timeBuffer + " ms");
        System.out.println("Time taken by StringBuilder: " + timeBuilder + " ms");

        
    }
}
