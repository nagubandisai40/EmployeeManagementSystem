<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>Employee Management System</title>
	</head>
	<body>
		<div>
			<center>
				<h1>Create Regulation</h1>
			</center>
		</div>
		<div>
			<center>
				<form action="addRegulation" method="post">
		            <table>
		                <tr>
		                    <td>
                               Regulation Type:
                            </td>
		                    <td>
		                        <input type="text" name="regulationType"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td>
		                       Details:
		                    </td>
                            <td>
                                <input type="text" name="regulationDetails"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                               Date:
                            </td>
                            <td>
                                <input type="date" name="date"/>
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
		            <input type="submit" value="Add Regulation"></input>
                </form>
			</center>
		</div>
	</body>
</html>