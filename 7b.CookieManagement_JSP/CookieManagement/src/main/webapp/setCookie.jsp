<%--
  7b. Construct a Cookie Management program using JSP to get the fields Name, Domain, and Max
  Expiry Age (in seconds) and press the button Add Cookie for displaying the set cookie information.
  Then it has to go to show the active cookie list when you press the link "go to the active cookie list".
--%>

<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <title>Setting Cookie</title>

    <style>
        .info-box {
            margin: 20px;
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .success {
            color: green;
        }
    </style>
</head>

<body>
    <div class="info-box">
        <%
            /* Retrieve form parameters */
            String name   = request.getParameter("cookieName");
            String domain = request.getParameter("domain");
            String maxAge = request.getParameter("maxAge");

            if (name != null && domain != null && maxAge != null) {

                /* Get or create the list stored in session */
                @SuppressWarnings("unchecked")
                List<Map<String, String>> cookieList =
                        (List<Map<String, String>>) session.getAttribute("cookieList");
                if (cookieList == null) {
                    cookieList = new ArrayList<>();
                }

                /* Save the server time when cookie is created */
                long currentSeconds = System.currentTimeMillis() / 1000;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                Map<String, String> entry = new HashMap<>();
                entry.put("name",   name);
                entry.put("domain", domain);
                entry.put("maxAge", maxAge);
                entry.put("setTime", String.valueOf(currentSeconds));

                /* Create and send the actual cookie */
                Cookie ck = new Cookie(name, "value");
                ck.setMaxAge(Integer.parseInt(maxAge));
                ck.setDomain(domain);
                response.addCookie(ck);

                /* Keep record in the list */
                cookieList.add(entry);
                session.setAttribute("cookieList", cookieList);
        %>

        <h3 class="success">Cookie Set Successfully</h3>
        <p><strong>Cookie Name:</strong> <%= name %></p>
        <p><strong>Domain:</strong> <%= domain %></p>
        <p><strong>Max Age:</strong> <%= maxAge %> seconds</p>
        <p><strong>Set Time:</strong> <%= sdf.format(new Date()) %></p>

        <%
            }  /* end if parameters present */
        %>

        <p><a href="index.jsp">Return to Cookie List</a></p>
    </div>
</body>
</html>
