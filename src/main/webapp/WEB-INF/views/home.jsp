<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<hr>a
<h1 align="center">
	Hello Real world! 
</h1>
<form action="addContact" method="POST" >
<p align="center">

<table>
	<tr>
		<td><b>Username:</b></td>
		<td><input type="text" width="8" name="username" id="username" value="${user.username}"></td>
	</tr>
	<tr>
		<td><b>Password:</b></td>
		<td><input type="text" width="8" name="password" id="password" value="${user.password}"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"> </td>		
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Submit" name="Submit"></td>		
	</tr>
	
</table>
</form>
<hr>
<table>
<tr>
	<th>Username</th>
	<th>Password</th>
</tr>
<c:if test="${not empty allUsers}">
 
		
			<c:forEach var="listValue" items="${allUsers}">
			<tr>
				<td>${listValue.username}</td> 
				<td>${listValue.password}</td> 
			</tr>
			</c:forEach>
		
 
	</c:if>
</table>
<P>  The time on the server is ${serverTime}. </P>
<P>  The number of students is ${numberOfUsers}. </P>
</body>
</html>
