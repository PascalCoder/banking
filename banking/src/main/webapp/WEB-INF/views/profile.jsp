<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%-- <sec:authentication property="principal.password"/> --%>
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
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> -->
<style>
	.header{
		margin-top:10%;
	}
	.buttons{
		margin-top:10%;
	}
	.sub-menu{
		margin-left:20%;
	}
	.card{
		display:block;
		color:black;
		width:100%;
		border:1px solid grey;
		text-align:center;
		cursor:pointer;
	}
	div.card span{
		font-weight:bold;
	}
	a:hover{
		text-decoration:none;
		color:black;
	}
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
									<li><a href="<c:url value='/viewProfile/${user.clientId}' />">Profile &amp; Settings</a></li>
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
	<div class="container-fluid">
		<section>
			<div class="container">
				<ul class="nav nav-tabs">
				    <li><a data-toggle="tab" href="#home">Accounts</a></li>
				    <li><a data-toggle="tab" href="#menu1">Deposits</a></li>
				    <li><a data-toggle="tab" href="#menu2">Withdrawals</a></li>
				    <li><a data-toggle="tab" href="#menu3">Transfers</a></li>
					<li><a data-toggle="tab" href="#menu4">Tools &amp; Investing</a></li>
					<li><a data-toggle="tab" href="#menu5">Open an Account</a></li>
					<li class="active"><a data-toggle="tab" href="#menu6">Help &amp; Support</a></li>
				</ul>
				<div class="row">
					<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
						<div class="row">
							<div class="col-md-8">
								<h4>
									Welcome: ${pageContext.request.userPrincipal.name} |
									<a href="<c:url value='/j_spring_security_logout' />" >Logout</a>
								</h4>
							</div>
							<h1>Administrator Page</h1>
							<h3 class="lead">This is the administrator Page</h3>
							<a href="<c:url value='/admin/users' />">View All Users</a>
						</div>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
						<div class="tab-content col-md-12">
							<div id="home" class="tab-pane fade in row">
								<div class="col-md-8">
								<c:set var="balance" value="${user.bankAccounts.toArray()[0].balance}" />
								<fmt:setLocale value = "en_US"/>
								<h5 class="header">Hello, ${user.firstName} <span class="sub-menu"><a href="">Update Profile</a> | <a href="">Security Center</a></span></h5>
								<div style="margin-top:10%;">
									<p>Personal accounts</p>
									<hr>
								</div>
								<div>
									<a href="<c:url value='/bankAccount/details/${user.clientId}?accountType=checking' />" class="bankType">Banksys Checking</a>
									<span class="pull-right"><fmt:formatNumber value = "${balance}" type = "currency"/></span>
									<p><a href="">Quick View</a></p>
									<%-- ${bankAccounts[0].accountDescription} --%>
								</div>
								<div class="buttons">
									<a href="<c:url value='/transaction/deposit/${user.clientId}?accountType=checking' />" class="btn btn-primary btn-lg">Deposit</a>
									<a href="<c:url value='/transaction/withdraw/${user.clientId}?accountType=checking' />" class="btn btn-primary btn-lg">Withdraw</a>
									<a href="<c:url value='/transaction/transfer/${user.clientId}?accountType=checking' />" class="btn btn-primary btn-lg">Transfer</a>
								</div>
								</div>
							</div>
							<div id="menu1" class="tab-pane fade">
						    	<h3>Menu 1</h3>
						      	<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
						    </div>
						    <div id="menu2" class="tab-pane fade">
						      	<h3>Menu 2</h3>
						      	<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
						    </div>
						    <div id="menu3" class="tab-pane fade">
						      	<h3>Menu 3</h3>
						      	<p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
						    </div>
							<div id="menu4" class="tab-pane fade">
						      	<h3>Menu 4</h3>
						      	<p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
						    </div>
							<div id="menu5" class="tab-pane fade">
						      	<h3>Menu 5</h3>
						      	<p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
						    </div>
							<div id="menu6" class="tab-pane fade in active row">
						      	<c:set var="checking" value="${user.bankAccounts.toArray()[0]}" />
						      	<h3>Profile &amp; Settings</h3>
								<div class="col-md-4">
									<a href="" class="card" id="contact">
										<h2>Your Contact Info</h2>
										<p>Manage addresses, phone/mobile numbers, email addresses and contact preferences.</p>
									</a>
									<%-- Full Name: ${user.firstName} ${user.middleName} ${user.lastName}<br>
									Address: ${user.address.addressLine1},<br> ${user.address.addressLine2}
											 ${user.address.city}, ${user.address.state} ${user.address.zipCode}<br>
									Phone Number: ${user.phoneNumber}<br>
									Email: ${user.email}<br>
									Account Number: ${checking.accountNumber}<br>
									Routing Number: ${checking.routingNumber}<br> --%>
								</div>
								<div class="col-md-4">
									<div class="card" id="contact">
										<h2>Security Center</h2>
										<a>Change my username</a><br>
										<a>Change my password</a><br>
										<a>Change my security preference</a><br>
										<a>Extra security at sign in</a><br>
										<a>Change my security preference</a><br>
										<a>Security alerts</a><br>
										<a>Sign-in history</a><br>
										<a>Challenge questions</a><br>
										<a>Report a problem</a><br>
									</div>
								</div>
								<div class="col-md-4">
									<div class="card" id="contact">
										<h2>Account Info</h2>
										<p><span>Account Number:</span> ${checking.accountNumber}</p>
										<p><span>Routing Number:</span> ${checking.routingNumber}</p>
									</div>
								</div>
						    </div>
						</div>
					</c:if>
					
				</div>
			</div>
		</section>
		
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>	
	<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>