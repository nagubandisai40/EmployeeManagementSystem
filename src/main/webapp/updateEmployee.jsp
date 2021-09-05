<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>Employee Management System</title>
	</head>
	<body>
		<div>
			<center>
				<h1>Update Employee Details</h1>
			</center>
		</div>
		<div>
			<center>
				<form action="updateEmployee" method="update">
		            <table>
		                <tr>
		                    <td>
                               FirstName:
                            </td>
		                    <td>
		                        <input type="text" name="firstName" value="${employee.firstName}"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td>
		                       LastName:
		                    </td>
                            <td>
                                <input type="text" name="lastName" value="${employee.lastName}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                               Email:
                            </td>
                            <td>
                                <input type="email" name="email" value="${employee.email}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                               Date of Birth:
                            </td>
                            <td>
                                <input type="date" name="dob" value="${employee.dob}"/>
                            </td>
                        </tr>
                        <tr>
	                        <td>
	                            Department
	                        </td>
                            <td>
	                            <select name="department">
	                                <c:forEach items="${departmentList}" var="department">
	                                    <option value="${department.deptId}">${department.deptName}</option>
	                                </c:forEach>
	                            </select>
                            </td>
                        </tr>
		            </table><br/>
		            <input type="submit" value="Update Employee"></input>
                </form>
			</center>
		</div>
	</body>
</html>