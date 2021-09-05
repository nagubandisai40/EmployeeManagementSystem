<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
	<head>
		<title>Employee Management System</title>
	</head>
	<body>
		<center>
			 <div align="center">
                    <table border="1" cellpadding="5">
                        <caption><h2>List of Departments</h2></caption>
                        <tr>
                            <th>Department ID</th>
                            <th>Department Name</th>
                        </tr>
                        <c:forEach var="dept" items="${deptList}">
                            <tr>
                                <td><c:out value="${dept.deptId}" /></td>
                                <td><c:out value="${dept.deptName}" /></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
		</center>
	</body>
</html>