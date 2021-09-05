<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	if(session.getAttribute("userName")==null || session.getAttribute("role") == null)
	{
		out.print(session.getAttribute("role"));
		response.sendRedirect("/EmployeeManagementSystem");
	}
%>

<html>
<head>
 <title>User Management Application</title>
</head>
<body>
 <center>
  <h1>Employee Management System</h1>
        <h4>
         <a href="admin/addEmployee">Add New Employee</a>
         &nbsp;&nbsp;&nbsp;
         <a href="admin">List All Employees</a>
         &nbsp;&nbsp;&nbsp;
         <a href="admin/addDepartment">Add New Departments</a>
		&nbsp;&nbsp;&nbsp;
         <a href="admin/viewDepartments">List All Departments</a>
         &nbsp;&nbsp;&nbsp;
          <a href="admin/addRegulation">Add New Regulation</a>
          &nbsp;&nbsp;&nbsp;
        <a href="admin/viewRegulations">List ALL Regulations</a>
        </h4>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Employees</h2></caption>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>DOB</th>
                <th>DepartmentID</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.employeeId}" /></td>
                    <td><c:out value="${user.firstName}" /></td>
                    <td><c:out value="${user.lastName}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.dob}" /></td>
                    <td><c:out value="${user.department.deptId}" /></td>
                    <td>
                     <a href="admin/updateEmployee?id=<c:out value='${user.employeeId}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="admin/deleteEmployee?id=<c:out value='${user.employeeId}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>