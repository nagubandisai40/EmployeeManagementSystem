<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>Employee Management System</title>
	</head>
	<body>
		<div>
			<center>
				<h1>Add Employee</h1>
			</center>
		</div>
		<div>
			<center>
				<form action="addEmployee" method="post">
		            <table>
		                <tr>
		                    <td>
                               FirstName:
                            </td>
		                    <td>
		                        <input type="text" name="firstName"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td>
		                       LastName:
		                    </td>
                            <td>
                                <input type="text" name="lastName"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                               Email:
                            </td>
                            <td>
                                <input type="email" name="email"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                               Date of Birth:
                            </td>
                            <td>
                                <input type="date" name="dob"/>
                            </td>
                        </tr>
                        <tr>
	                        <td>
	                            Department
	                        </td>
                            <td>
	                            <select name="department">
	                                <c:forEach items="${deptList}" var="department">
	                                    <option value="${department.deptId}">${department.deptName}</option>
	                                </c:forEach>
	                            </select>
                            </td>
                        </tr>
		            </table><br/>
		            <input type="submit" value="Add Employee"></input>
                </form>
			</center>
		</div>
	</body>
</html>