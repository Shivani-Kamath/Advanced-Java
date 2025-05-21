/*6c. Build a servlet program to check the given number is prime number or not using HTML with step
 by step procedure.*/

package com.primechecker;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/primecheck")
public class PrimeCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Get the number from the form
            int number = Integer.parseInt(request.getParameter("number"));

            // Validate the input
            if (number < 2) {
                throw new IllegalArgumentException("Number must be greater than 1");
            }

            // Check if the number is prime
            boolean isPrime = true;
            String  explanation = number + " is a prime number.";

            if (number != 2) {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        explanation = number + " is not prime because it's divisible by " + i;
                        break;
                    }
                }
            }

            // Generate the response
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Prime Number Checker</title>");
            out.println("<style>");
            out.println(".container { margin: 20px; padding: 20px; width: 500px;"
                      + " border: 1px solid #ccc; border-radius: 5px; }");
            out.println(".result    { margin: 10px 0; }");
            out.println(".prime     { color: green; }");
            out.println(".not-prime { color: red; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Prime Number Checker</h2>");
            out.println("<div class='result'>");
            out.println("<p>Number: " + number + "</p>");
            out.println("<p class='" + (isPrime ? "prime" : "not-prime") + "'>"
                      + (isPrime ? "Prime number" : "Not a prime number") + "</p>");
            out.println("<p>" + explanation + "</p>");
            out.println("</div>");
            out.println("<a href='index.html'>Check Another Number</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {
            displayError(out, "Please enter a valid number");
        } catch (IllegalArgumentException e) {
            displayError(out, e.getMessage());
        }
    }

    private void displayError(PrintWriter out, String message) {
        out.println("<html>");
        out.println("<head><title>Error</title></head>");
        out.println("<body>");
        out.println("<div style='margin: 20px; color: red;'>");
        out.println("<h2>Error</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<a href='index.html'>Try Again</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}