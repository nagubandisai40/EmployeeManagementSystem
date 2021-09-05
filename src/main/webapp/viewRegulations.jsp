<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Employee Management System</title>
	</head>
	<body>
		<center>
			 <div align="center">
                    <table border="1" cellpadding="5">
                        <caption><h2>List of Regulations</h2></caption>
                        <tr>
                            <th>Regulation Id</th>
                            <th>Regulation Type</th>
                            <th>Details</th>
                            <th>Date</th>
                            <th>Department</th>
                        </tr>
                        <c:forEach var="regulation" items="${complienceList}">
                            <tr>
                                <td><c:out value="${regulation.complienceId}" /></td>
                                <td><c:out value="${regulation.regulationType}" /></td>
                                <td><c:out value="${regulation.details}" /></td>
                                <td><c:out value="${regulation.date}" /></td>
                                <td><c:out value="${regulation.department.deptName}" /></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
		</center>
	</body>
</html>