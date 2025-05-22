<%-- 
  9d. Develop a JDBC project using MySQL to delete the records in the table Emp 
  of the database Employee by getting the name starting with ‘S’ through keyboard
  and generate the report as follows using HTML and JSP to get the field and display the results respectively:

  Salary Report
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Emp_No     : 101
  Emp_Name: Ramesh
  Basic
            : 25000
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Emp_No     : 102
  Emp_Name: Ravi
  Basic
            : 20000
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--%>

<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head><title>Salary Report</title></head>
<body>

<%
    String jdbcURL = "jdbc:mysql://localhost:3306/Employee";
    String dbUser = "root";
    String dbPassword = "";

    String startLetter = request.getParameter("startLetter");

    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        if(startLetter != null && !startLetter.trim().isEmpty()) {
            String deleteSQL = "DELETE FROM Emp WHERE Emp_Name LIKE ?";
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setString(1, startLetter + "%");
            int deletedRows = pstmt.executeUpdate();
            out.println("<p style='color:green;'><strong>Deleted " + deletedRows + " employee(s) whose name starts with '" + startLetter.toUpperCase() + "'</strong></p>");
            pstmt.close();
        }

        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM Emp");

        out.println("<h2>Salary Report</h2>");
        while(rs.next()) {
            out.println("<hr>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");
            out.println("Emp_No : " + rs.getInt("Emp_NO") + "<br>");
            out.println("Emp_Name: " + rs.getString("Emp_Name") + "<br>");
            out.println("Basic : " + rs.getFloat("Basicsalary") + "<br>");
        }
        out.println("<hr>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    } catch(Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        try { if(rs != null) rs.close(); } catch(Exception e) {}
        try { if(stmt != null) stmt.close(); } catch(Exception e) {}
        try { if(pstmt != null) pstmt.close(); } catch(Exception e) {}
        try { if(conn != null) conn.close(); } catch(Exception e) {}
    }
%>

</body>
</html>
