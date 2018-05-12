<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Banking Users Page</title>
</head>
<body>
	<h3 class="lead">All the users with account(s) at this Bank</h3>
	<c:forEach items="${users}" var="user">
		<p>
			${user.firstName} ${user.dateOfBirth} <a href="<c:url value='/admin/users/${user.clientId}' />">More Info</a>
			<a href="<c:url value='/admin/users/deleteUser/${user.clientId}' />">Remove</a>
		</p>
	</c:forEach>
</body>
</html>