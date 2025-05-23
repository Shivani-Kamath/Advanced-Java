/*2.b. Develop a Java program to make a  Performance Test on  StringBuffer and StringBuilder for
 appending the string ‘AIET’ for 10000 times both in the StringBuffer and StringBuilder. Justify 
your answer which one is better.*/

package String_Functions;

public class PerformanceTest {
	 public static void main(String[] args) {
	        int iterations = 10000;

	        // Test StringBuffer
	        long startBuffer = System.nanoTime();
	        StringBuffer sbuffer = new StringBuffer();
	        for (int i = 0; i < iterations; i++) {
	            sbuffer.append("AIET");
	        }
	        long endBuffer = System.nanoTime();
	        long durationBuffer = endBuffer - startBuffer;

	        // Test StringBuilder
	        long startBuilder = System.nanoTime();
	        StringBuilder sbuilder = new StringBuilder();
	        for (int i = 0; i < iterations; i++) {
	            sbuilder.append("AIET");
	        }
	        long endBuilder = System.nanoTime();
	        long durationBuilder = endBuilder - startBuilder;

	        // Output results
	        System.out.println("Time taken by StringBuffer: " + durationBuffer + " ns");
	        System.out.println("Time taken by StringBuilder: " + durationBuilder + " ns");

	        // Conclusion
	        if (durationBuffer > durationBuilder) {
	            System.out.println("StringBuilder is faster than StringBuffer.");
	        } else {
	            System.out.println("StringBuffer is comparable but slightly slower ");
	        }
	    }
}
