<%--
  8c. Develop a JDBC project using JSP to append the fields empno, empname and basicsalary 
  into the table Emp of the database Employee by getting the fields through keyboard and 
  generate the report as follows for the TABLE Emp (Emp_NO, Emp_Name, Basicsalary) using 
  HTML and JSP to get the fields and display the results respectively.
--%>


<%@ page import="java.sql.*" %>
<%
    // DB connection info
    String JDBC_URL = "jdbc:mysql://localhost:3306/Employee?useSSL=false&serverTimezone=UTC";
    String DB_USER = "root"; // change as per your MySQL user
    String DB_PASS = "";     // change as per your MySQL password

    String empNoStr = request.getParameter("empno");
    String empName = request.getParameter("empname");
    String basicSalaryStr = request.getParameter("basicsalary");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

        // Insert if parameters are present
        if(empNoStr != null && empName != null && basicSalaryStr != null) {
            int empNo = Integer.parseInt(empNoStr);
            float basicSalary = Float.parseFloat(basicSalaryStr);

            String insertSQL = "INSERT INTO Emp (Emp_No, Emp_Name, BasicSalary) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertSQL);
            ps.setInt(1, empNo);
            ps.setString(2, empName);
            ps.setFloat(3, basicSalary);

            try {
                ps.executeUpdate();
                out.println("<p style='color:green;'>Employee inserted successfully!</p>");
            } catch(SQLIntegrityConstraintViolationException e) {
                out.println("<p style='color:red;'>Error: Employee with this Emp_No already exists.</p>");
            }

            ps.close();
        }

        // Display Salary Report
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
<p><a href="insertEmployee.html">Go back to Insert Employee Form</a></p>
