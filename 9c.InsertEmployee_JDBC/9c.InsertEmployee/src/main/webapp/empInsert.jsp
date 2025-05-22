<%-- 
  9c. Develop a JDBC project using MySQL to append the fields empno, empname, and basicsalary
  into the table Emp of the database Employee by getting the fields through keyboard
  and generate the report as follows for the table Emp (Emp_NO, Emp_Name, Basicsalary) 
  using HTML and JSP to get the field and display the results respectively.
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

    String empnoStr = request.getParameter("empno");
    String empname = request.getParameter("empname");
    String basicsalaryStr = request.getParameter("basicsalary");

    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        if(empnoStr != null && empname != null && basicsalaryStr != null) {
            int empno = Integer.parseInt(empnoStr);
            float basicsalary = Float.parseFloat(basicsalaryStr);

            String insertSQL = "INSERT INTO Emp (Emp_NO, Emp_Name, Basicsalary) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, empno);
            pstmt.setString(2, empname);
            pstmt.setFloat(3, basicsalary);

            int rows = pstmt.executeUpdate();
            if(rows > 0) {
                out.println("<p style='color:green;'>Employee inserted successfully!</p>");
            }
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
