<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
<style>
	.main-center{
		margin-left:25%;
	}
	.select{
		color:black;
	}
</style>
<title>Banking Transfer Page</title>
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
							<li class=""><a href="<c:url value='/default' />">Home</a></li>
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
								<c:if test="${pageContext.request.userPrincipal.name == admin}">
									<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
								</c:if>
								<c:if test="${pageContext.request.userPrincipal.name != admin}">
									<li><a>Welcome, ${user.firstName} ${user.lastName}</a></li>
									<li><a href="<c:url value='/updateProfile/${user.userId}' />">Profile &amp; Settings</a></li>
								</c:if>
								<li><a href="<c:url value='/j_spring_security_logout' />" >Logout</a></li>
								<%-- <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
									<li><a href="<c:url value='/user' />">Cart</a></li>
								</c:if> --%>
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
		<div class="row main"> <!--main-->
				<h2 class="title">Transfer Form</h2>
				<div class="col-md-6 col-md-offset-3 main-center"> <!--  main-center -->
					<h5>Please enter amount you want to transfer after selecting/adding a recipient</h5>
					<form:form class="" method="post" action="${pageContext.request.contextPath}/transaction/transfer"><!-- modelAttribute="transfer" commandName="transaction" -->
					
					<div class="row">
						<%-- <c:set var="user" value="${transaction.user}" /> --%>
						<%-- <form:hidden path="user" value="${transaction.user}"/> --%>
						<div class="col-md-8 col-md-offset-2"> <!--col-md-offset-0-->
							<fmt:setLocale value = "en_US"/>
							<div class="form-group">
								<label for="accountFrom">Account From: </label>
								<div class="cols-sm-12">
									<div class="input-group">
										<select name="sendingAccount" class="select form-control"> <!-- name="sendingAccount"  -->
									    	<option value="-">Select One</option>
										    <c:forEach var="sendingAccount" items="${bankAccounts}">
										    	<c:set var="balance" value="${sendingAccount.balance}" />
										    	<fmt:formatNumber value = "${balance}" type = "currency"/>
										        <option value="${sendingAccount.accountNumber}"><c:out value="${sendingAccount.accountDescription} "/> &nbsp;
										        	[<fmt:formatNumber value = "${balance}" type = "currency"/>]
										        </option>
										    </c:forEach>
										</select>
									</div>
								</div>	
							</div>
							<div class="form-group">
								<label for="accountFrom">Account To: </label>
								<div class="cols-sm-12">
									<div class="input-group">
										<select name="receivingAccount" class="select form-control"> <!--  name="receivingAccount"  -->
									    	<option value="-">Select One</option>
										    <c:forEach var="receivingAccount" items="${receivingAccounts}">
										    	<c:set var="balance" value="${receivingAccount.balance}" />
										    	<fmt:formatNumber value = "${balance}" type = "currency"/>
										        <option value="${receivingAccount.accountNumber}">
										        	<c:out value="${receivingAccount.user.lastName}, ${receivingAccount.user.firstName}"/> &nbsp; <!-- ${receivingAccount.accountDescription}- -->
										        	<%-- [<fmt:formatNumber value = "${balance}" type = "currency"/>] --%>
										        </option>
										    </c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-8 col-md-offset-2">
									<label for="amount" class="cols-sm-2 control-label">Amount</label> <!---->
									<div class="cols-sm-8"> <!-- col-md-10-->
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
											<input type="text" class="form-control" name="amount" placeholder="Enter amount"/><!-- id="amount"   -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
						<div class="form-group col-md-6 col-md-offset-3">
							<!--<a href="http://deepak646.blogspot.in" target="_blank" type="button" id="button" class="btn btn-primary btn-lg btn-block login-button">Register</a>-->
							<button type="submit" id="button" class="btn btn-primary btn-lg btn-block login-button">Transfer</button>
						</div>	
					</form:form>
				</div>
				<div class="col-md-3">
					<a class="btn btn-info main-center" href="<c:url value='/addRecipient/${user.userId}/?accountType=checking'/>" style="text-align:center">Add Recepient</a>
				</div>
			</div>
	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>