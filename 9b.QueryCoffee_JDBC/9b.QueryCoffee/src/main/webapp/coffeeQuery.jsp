<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Coffee Products Starting with 'D'</title>
    <style>
        table { border-collapse: collapse; width: 50%; margin-top: 20px; }
        th, td { border: 1px solid black; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>

<h2>Coffee Products Starting with 'D'</h2>

<%
    String jdbcURL = "jdbc:mysql://localhost:3306/test";
    String dbUser = "root";
    String dbPassword = "";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM coffee WHERE coffee_name LIKE 'D%' ORDER BY id");

        out.println("<table>");
        out.println("<tr><th>ID</th><th>Coffee Name</th><th>Price</th></tr>");

        boolean found = false;
        while (rs.next()) {
            found = true;
            int coffeeId = rs.getInt("id");
            String name = rs.getString("coffee_name");
            float price = rs.getFloat("price");

            out.println("<tr>");
            out.println("<td>" + coffeeId + "</td>");
            out.println("<td>" + name + "</td>");
            out.println("<td>" + price + "</td>");
            out.println("</tr>");
        }

        if (!found) {
            out.println("<tr><td colspan='3'>No coffee products starting with 'D' found.</td></tr>");
        }

        out.println("</table>");

    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        try { if (rs != null) rs.close(); } catch(Exception e) {}
        try { if (stmt != null) stmt.close(); } catch(Exception e) {}
        try { if (conn != null) conn.close(); } catch(Exception e) {}
    }
%>

</body>
</html>
