<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<html>
 	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <link rel="stylesheet"href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		 
		 <title>Admin Panel Login</title>
	 </head>
	 
 	 <body>
 <section>
 	<div class="jumbotron">
	 	<div class="container">
 			<h1>Admin Panel</h1>
 			<p>Login page</p>
 		</div>
	 </div>
 </section>
 <div class="container">
	 <div class="row">
		 <div class="col-md-4 col-md-offset-4">
			 <div class="panel panel-default">
				 <div class="panel-heading">
				 	<h3 class="panel-title">Log in</h3>
				 </div>
				 <div class="panel-body">
				 	<c:if test="${not empty error}">
					 <div class="alert alert-danger">
				 		<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
					 </div>
					 </c:if>
				 <form action="<c:url value="./j_spring_security_check"></c:url>" method="post">
				 	<fieldset>
				 		<div class="form-group">
				 		<input class="form-control" placeholder="Username" name='j_username' type="text">
				 </div>
				 <div class="form-group">
				 	<input class="form-control" placeholder="Password" name='j_password' type="password" value="">
				 </div>
				 	<input class="btn btn-lg btn-success btn-block" type="submit" value="Log In">
				 </fieldset>
				 </form>
				 </div>
			 </div>
			 <p><a href="<spring:url value="/" />" class="btn btndefault">
			 	<span class="glyphicon-hand-left glyphicon"></span> Back
			 </a></p>
		 </div>
	 </div>
 </div>
 </body>
</html>