<%-- 
    Document   : employeeaddform
    Created on : Jun 15, 2025, 1:08:42 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Employee Form</h1>
        <form action="addemployee.jsp" method="post">
            
            Name: <input type="text" name="name"> <br>
            Email: <input type="email" name="email"> <br>
            Designation : <input type="text" name="designation"> <br>
            Salary : <input type="text" name="salary"> <br>
            
            
            <input type="submit" value="Save">
            
        </form>
        
    </body>
</html>
