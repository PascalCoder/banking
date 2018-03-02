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
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css"> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value='/resources/css/registration.css'/>" rel="stylesheet">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<style>
	.error{
		/*font-weight:bold;*/
		font-size:18px;
		color: #ff0000;
	}	
</style>
<title>Banking Registration Page</title>
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
						<a class="navbar-brand" href="/">Banksys</a>
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
		<div class="row main"> <!--main-->
				<h2 class="title"><spring:message code="label.registrationFormHeader" /></h2>
				<div class="col-md-12 main-login main-center">
				<h4><spring:message code="label.registrationFormSubHeader" /></h4>
					<form:form class="col-md-12" method="post" action="${pageContext.request.contextPath}/register" commandName="user">
					
					<div class="row">
						<div class="col-md-5 col-md-offset-0"> <!--col-md-offset-0-->
							<div class="form-group">
								<p></p>
								<label for="firstName" class="cols-sm-2 control-label"><spring:message code="label.yourFirstName"/></label> <!---->
								<form:errors path="firstName" cssStyle="color: #ff0000;" cssClass="error"/>
								<div class="cols-sm-10"> <!---->
									<!-- <p>Please enter</p> -->
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="firstName" id="firstName"  placeholder="Enter your First Name"/>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<label for="middleName" class="cols-sm-2 control-label"><spring:message code="label.yourMiddleName"/></label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="middleName" id="middleName"  placeholder="Enter your Middle Name"/>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<label for="lastName" class="cols-sm-2 control-label"><spring:message code="label.yourLastName"/></label>
								<form:errors path="lastName" cssStyle="color: #ff0000;" cssClass="error"/>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="lastName" id="lastName"  placeholder="Enter your Last Name"/>
									</div>
								</div>
							</div>
							
							<div class="form-inline" style="margin-bottom:15px">
								<label for="sex" class="cols-sm-2 control-label"><spring:message code="label.sex"/></label>
								<div class="form-check form-check-inline">
									<c:forEach var="genderOption" items="${genders}">
										<label class="form-check-label">
								    		<form:radiobutton class="form-check-input" path="gender" id="gender" value="${genderOption.gender}" /> ${genderOption.gender}
								  		</label>
									</c:forEach>
								</div>
							</div>

							<div class="form-group">
								<label for="email" class="cols-sm-2 control-label"><spring:message code="label.yourEmail"/></label>
								<form:errors path="email" cssStyle="color: #ff0000;" cssClass="error"/>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="email" id="email"  placeholder="Enter your Email"/>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<label for="phoneNumber" class="cols-sm-2 control-label"><spring:message code="label.yourNumber"/></label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-book fa" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="phoneNumber" id="phoneNumber"  placeholder="Enter your Phone Number"/>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<label for="dateOfBirth" class="cols-sm-2 control-label">Date of Birth</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
										<input type="date" class="form-control" name="dob" id="dateOfBirth"  placeholder="Enter your Date of Birth"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="username" class="cols-sm-2 control-label"><spring:message code="label.username"/></label>
								<form:errors path="username" cssStyle="color: #ff0000;" cssClass="error"/>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="username" id="username"  placeholder="Enter your Username"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="cols-sm-2 control-label"><spring:message code="label.password"/></label>
								<form:errors path="password" cssStyle="color: #ff0000;" cssClass="error"/>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
										<form:input type="password" class="form-control" path="password" id="password"  placeholder="Enter your Password"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
								<form:errors path="passwordConfirm" cssClass="error" />
								<span class="error">${nomatch.password}</span>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
										<form:input type="password" class="form-control" path="passwordConfirm" id="confirm"  placeholder="Confirm your Password"/>
									</div>
								</div>
							</div>
						</div>
						
						<div class="col-md-5 col-md-offset-2">
							<div class="form-group">
								<label for="addressLine1" class="cols-sm-2 control-label"><spring:message code="label.addressLine1"/></label>
								<form:errors path="address.addressLine1" cssStyle="color: #ff0000;" cssClass="error"/>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-address-book-o" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="address.addressLine1" id="addressLine1"  placeholder="Enter your Address"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="addressLine2" class="cols-sm-2 control-label"><spring:message code="label.addressLine2"/></label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-address-book-o" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="address.addressLine2" id="addressLine2"  placeholder="Enter your Apartment Number"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="city" class="cols-sm-2 control-label"><spring:message code="label.city"/></label>
								<form:errors path="address.city" cssStyle="color: #ff0000;" cssClass="error"/>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-address-book-o" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="address.city" id="city"  placeholder="Enter your City"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="state" class="cols-sm-2 control-label"><spring:message code="label.state"/></label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-address-book-o" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="address.state" id="state"  placeholder="Enter your State"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="country" class="cols-sm-2 control-label"><spring:message code="label.country"/></label>
								<form:errors path="address.country" cssStyle="color: #ff0000;" cssClass="error"/>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-address-book-o" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="address.country" id="country"  placeholder="Enter your Country"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="zipCode" class="cols-sm-2 control-label"><spring:message code="label.zipCode"/></label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-address-book-o" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" path="address.zipCode" id="zipCode"  placeholder="Enter your zip code"/>
									</div>
								</div>
							</div>
						</div>
					</div>
						<div class="form-group col-md-5 col-md-offset-0">
							<!--<a href="http://deepak646.blogspot.in" target="_blank" type="button" id="button" class="btn btn-primary btn-lg btn-block login-button">Register</a>-->
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button button" id="button"><spring:message code="label.createAccount"/></button>
						</div>
						<div class="form-group col-md-4 col-md-offset-0">
							<a href="<c:url value='/'/>" class="btn btn-warning btn-lg btn-block login-button button" id="button" ><spring:message code="label.cancel"/></a>
						</div>
						
					</form:form>
				</div>
			</div>
	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>