<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Coffee Product and Display Remaining</title>
    <style>
        table { border-collapse: collapse; width: 60%; }
        th, td { border: 1px solid black; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        form { margin-bottom: 20px; }
        .message { font-weight: bold; }
        .success { color: green; }
        .error { color: red; }
    </style>
</head>
<body>

<h2>Delete Coffee Product</h2>
<form method="post">
    Enter Coffee ID to delete: <input type="text" name="id" required>
    <input type="submit" value="Delete">
</form>

<%
    String jdbcURL = "jdbc:mysql://localhost:3306/test";
    String dbUser = "root";
    String dbPassword = "";

    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    String idStr = request.getParameter("id");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        if (idStr != null && !idStr.trim().isEmpty()) {
            int id = Integer.parseInt(idStr);

            // Delete coffee with given ID
            pstmt = conn.prepareStatement("DELETE FROM coffee WHERE id = ?");
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                out.println("<p class='message success'>Coffee product with ID " + id + " deleted successfully.</p>");
            } else {
                out.println("<p class='message error'>No coffee product found with ID " + id + ".</p>");
            }
            pstmt.close();
        }

        // Display all remaining coffee records
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM coffee ORDER BY id");

        out.println("<h2>Remaining Coffee Products</h2>");
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Coffee Name</th><th>Price</th></tr>");

        while (rs.next()) {
            int coffeeId = rs.getInt("id");
            String name = rs.getString("coffee_name");
            float price = rs.getFloat("price");

            out.println("<tr>");
            out.println("<td>" + coffeeId + "</td>");
            out.println("<td>" + name + "</td>");
            out.println("<td>" + price + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");

    } catch (Exception e) {
        out.println("<p class='message error'>Error: " + e.getMessage() + "</p>");
    } finally {
        try { if (rs != null) rs.close(); } catch(Exception e) {}
        try { if (stmt != null) stmt.close(); } catch(Exception e) {}
        try { if (pstmt != null) pstmt.close(); } catch(Exception e) {}
        try { if (conn != null) conn.close(); } catch(Exception e) {}
    }
%>

</body>
</html>
