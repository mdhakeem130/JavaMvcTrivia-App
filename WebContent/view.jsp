<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<table border="1">

		<tr>
			<td>What is your name</td>
			<td>Who is the best cricketer?</td>
			<td>What are the colors in the Indian flag?</td>

		</tr>

		<c:forEach var="t" items="${details }">


			<tr>

				<td><c:out value="${t.name }"></c:out></td>
				<td><c:out value="${t.q1answer }"></c:out></td>
				<td><c:out value="${t.q2answer }"></c:out></td>





			</tr>

		</c:forEach>
	</table>
	<br>
	<button onclick="window.location.href='index.html'">FINISH</button>
	<br><hr>
	<form action="Historycontroller" method="post">
	<p align="center"><input type=submit Value = HISTORY ></p>
	</form>
</body>
</html>