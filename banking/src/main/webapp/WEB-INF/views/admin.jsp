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
	<h1>Administrator Page</h1>
	<h3 class="lead">This is the administrator Page</h3>
	<a href="<c:url value='/admin/users' />">View All Users</a>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<h4>
					Welcome: ${pageContext.request.userPrincipal.name} |
					<a href="<c:url value='/j_spring_security_logout' />" >Logout</a>
				</h4>
			</div>
		</div>
	</c:if>
</body>
</html>