<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<!-- Bootstrap core CSS -->
<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<link href="<c:url value='/resources/css/registration.css'/>" rel="stylesheet">
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> -->
<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<title>Registration Success</title>
</head>
<body>
	<div class="navbar-wrapper">
		<div class="container-fluid">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Banksys</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class=""><a href="<c:url value='/' />">Home</a></li>
							<li><a href="<c:url value='/product/productList' />" >Products</a></li>
							<li><a href="#contact">Contact</a></li>
						</ul>
						<ul class="nav navbar-nav pull-right">
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
								<li><a href="<c:url value='/j_spring_security_logout' />" >Logout</a></li>
								<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
									<li><a href="<c:url value='/user' />">Cart</a></li>
								</c:if>
								<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
									<li><a href="<c:url value='/admin' />">Admin</a></li>
								</c:if>
							</c:if>
							
							<%-- <c:if test="${pageContext.request.userPrincipal.name == null}">
								<li><a href="<c:url value='/login'/>">Login</a></li>
								<li><a href="<c:url value='/register'/>">Register</a></li>
							</c:if> --%>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Customer registered successfully</h1>
					<p>Welcome to our bank ${user.firstName} ${user.lastName}</p>
				</div>
			</div>
		</section>
		<section class="container">
			<p>
				<a href="<spring:url value='/' />" class="btn btn-info">Home page</a>
			</p>						
		</section>
	</div>
</body>
</html>