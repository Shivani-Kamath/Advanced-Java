<%-- 
  8d. Develop a JDBC project using JDBC to update the fields empno, empname and basicsalary 
  into the table Emp of the database Employee using HTML and JSP to get the fields and display the results respectively.
--%>


<%@ page import="java.sql.*" %>
<%
    // DB connection info
    String JDBC_URL = "jdbc:mysql://localhost:3306/Employee?useSSL=false&serverTimezone=UTC";
    String DB_USER = "root"; 
    String DB_PASS = "";     

    String empNoStr = request.getParameter("empno");
    String empName = request.getParameter("empname");
    String basicSalaryStr = request.getParameter("basicsalary");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

        if(empNoStr != null && empName != null && basicSalaryStr != null) {
            int empNo = Integer.parseInt(empNoStr);
            float basicSalary = Float.parseFloat(basicSalaryStr);

            String updateSQL = "UPDATE Emp SET Emp_Name = ?, BasicSalary = ? WHERE Emp_No = ?";
            PreparedStatement ps = con.prepareStatement(updateSQL);
            ps.setString(1, empName);
            ps.setFloat(2, basicSalary);
            ps.setInt(3, empNo);

            int rows = ps.executeUpdate();
            if(rows > 0) {
                out.println("<p style='color:green;'>Employee updated successfully!</p>");
            } else {
                out.println("<p style='color:red;'>Employee with Emp_No " + empNo + " not found.</p>");
            }
            ps.close();
        }

        // Reuse insertEmp.jsp code to show updated report
        String selectSQL = "SELECT * FROM Emp ORDER BY Emp_No";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(selectSQL);

        float grandSalary = 0;

        out.println("<h2>Salary Report</h2>");
        out.println("<pre style='border:1px solid #000; padding:10px;'>");

        while(rs.next()) {
            int eno = rs.getInt("Emp_No");
            String ename = rs.getString("Emp_Name");
            float bsal = rs.getFloat("BasicSalary");

            grandSalary += bsal;

            out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            out.println("Emp_No     : " + eno);
            out.println("Emp_Name   : " + ename);
            out.println("Basic      : " + bsal);
        }

        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        out.println("Grand Salary   : " + grandSalary);
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        out.println("</pre>");

        rs.close();
        stmt.close();
        con.close();
    } catch(Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    }
%>
<p><a href="updateEmp.html">Go back to Update Employee Form</a></p>
