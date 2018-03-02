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
<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<style>
	
</style>
<title>Banking Home Page</title>
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
						<a class="navbar-brand" href="<c:url value='/' />">Banksys</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class=""><a href="<c:url value='/' />">Home</a></li>
							<li><a href="<c:url value='/product/productList' />" >Products</a></li>
							<li><a href="#contact">Contact</a></li>
							<!-- <li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Dropdown <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li role="separator" class="divider"></li>
									<li class="dropdown-header">Nav header</li>
									<li><a href="#">Separated link</a></li>
									<li><a href="#">One more separated link</a></li>
								</ul></li> -->
						</ul>
						<ul class="nav navbar-nav pull-right">
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
									<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
								</c:if>
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
	<div class="container-fluid">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>${greeting}</h1>
					<p>${subtitle}</p>
				</div>
			</div>
		</section>
		<section>
			<div class="container">
				<div class="row">
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
					</c:if>
					<!-- <div class="col-md-1 col-sm-1 col-xs-3"></div> -->
					<div class="col-xs-offset-1 col-md-3 col-md-offset-0 col-sm-4 col-sm-offset-4 col-xs-6" style="border:1px solid grey; padding-top:10px; padding-bottom:10px">
						<form name="loginForm" action="<c:url value='j_spring_security_check' />" method="post">
							<spring:message code="label.username" var="username"/>
							<spring:message code="label.password" var="password"/>
							<spring:message code="label.signIn" var="signIn"/>
							<c:if test="${not empty error}">
								<div class="error">${error}</div>
							</c:if>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="${username}" name="username"/> <!--  -->
							</div>
							<div class="form-group">
								<input type="password" class="form-control" placeholder="${password}" name="password" /> <!--  -->
							</div>
							<div class="form-group">
								<label class="checkbox-inline">
									<input type="checkbox"><spring:message code="label.saveUsername" />
								</label>
							</div>
							<input type="submit" value="${signIn}" class="btn btn-primary">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<div class="form-group">
								<a href="#"><spring:message code="label.forgotUsername" /></a> | <a href="#"><spring:message code="label.forgotPassword" /></a>
							</div>
							<a href="<c:url value='/register'/>" class="btn btn-default btn-large"><spring:message code="label.signUp" /></a>
						</form>
					</div>
					<div class="col-md-4">
						<a href="<c:url value='/?siteLanguage=en' />">English</a> | <a href="<c:url value='/?siteLanguage=fr' />">French</a>
					</div>
				</div>
			</div>
		</section>
	</div>
	
	 <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>