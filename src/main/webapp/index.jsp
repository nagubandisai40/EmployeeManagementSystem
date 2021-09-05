<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employee Management System</title>
</head>
<body>
<div>
	<center>
    	<h1>Employee Management System</h1>
    </center>
    <div>
        <center>
	        <form action="login" method="post">
	            UserId: <input type="text" name="userId"/><br/><br/>
	            Password: <input type="password" name="password"/><br/><br/>
	            <%
                   if(null!=request.getAttribute("errorMessage"))
                   {
                       out.println(request.getAttribute("errorMessage"));
                   }
                %><br/><br/>
	            <select name="role">
                    <option value="ADMIN">Admin</option>
                    <option value="USER">User</option>
                  </select>
	            <input type="submit" value="Login"/>

	        </form>
        </center>
    </div>
</div>
</body>
</html>
