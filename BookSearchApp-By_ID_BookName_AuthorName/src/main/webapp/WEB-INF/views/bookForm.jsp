<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Search</title>
<style type="text/css">
	th,td{
		font-size: x-large;
		background: buttonface;
	}
	input{
		font-size: x-large;
	}
</style>
</head>
<body bgcolor="lime">
	<form:form action="bookSearch.htm" method="POST" modelAttribute="book">
		<h1 style="color: purple; text-align: center;"><u>Book Search</u></h1>
		<table align="center" border="5">
		<tr>
			<td>Book ID :</td>
			<td><form:input path="bookId" placeholder="enter id to search"/></td>
		</tr>
		<tr>
			<td>Book Name :</td>
			<td><form:input path="bookName" placeholder="enter book name to search"/></td>
		</tr>
		<tr>
			<td>Author Name :</td>
			<td><form:input path="authorName" placeholder="enter author name to search"/></td>
		</tr>
		</table>
		<h1 style="color: red;text-align: center;">${msg }</h1>
		<br><br>
			<h1 style="font-size: x-large;text-align: center;"><input type="submit" value="Search"></h1>	 
	</form:form>
	<br><br><br><br><br>
	<table align="center" border="1">
		<thead>
			<tr>
				<th>BOOK ID</th>
				<th>BOOK Name</th>
				<th>Author Name</th>
				<th>Book Price</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${books.size()<=0}">
				<h1 style="color: red; text-align: center;">Records are not
					Found to display !!!</h1>
			</c:if>

			<c:forEach items="${books}" var="b">
				<tr>
					<td><c:out value="${b.bookId}" /></td>
					<td><c:out value="${b.bookName}" /></td>
					<td><c:out value="${b.authorName}" /></td>
					<td><c:out value="${b.bookPrice}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>