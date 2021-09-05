<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>Employee Management System</title>
	</head>
	<body>
	<div>
		<center>
			<h1>Add Department</h1>
			<form action="addDepartment" method="post">
				<table>
				  <tr>
	                <td>
	                   Department Name:
	                </td>
	                <td>
	                    <input type="text" name="deptName"/>
	                </td>
	              </tr>

	            </table>
	            <br/>
	            <input type="submit" value="Add Department"></input>
	        </form>
		</center>

	</div>
	</body>
</html>