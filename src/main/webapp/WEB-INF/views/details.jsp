<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
 	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <link rel="stylesheet"href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		 
		 <title>Blog Test</title>
	 </head>
	 
 	<body>
	 <section>
		 <div class="jumbotron">
			 <div class="container">
			 <h1>Notes</h1>
			 <p> Detailed blog note</p>
			 </div>
		 </div>
	 </section>
	 <section class="container">
	 	<div class ="row">
	 	<div class ="col-sm-6 col-md-9" style="padding-bottom: 15px">
		 		<div class ="thumbnail">
		 			<div class = "caption">
		 			<h3>${note.title}</h3>
		 			<p>${note.content}</p>
		 			
		 			<p>Tags :<c:forEach items="${note.tags}" var="tag">
	    				<a href="<spring:url value="./tagged?tag=${tag}"/>">${tag}</a>
					</c:forEach></p>
					<p>${note.time}</p>
		 			<p><a href="<spring:url value="/" />" class="btn btndefault">
			 			<span class="glyphicon-hand-left glyphicon"></span> Back
					</a></p>
		 			</div>
		 		</div>
		 		
		 		<div class ="thumbnail"><c:forEach items="${comments}" var="comment">
		 			<p><a href="mailto:${comment.mailAdress}">${comment.username}</a> - ${comment.time}</p>
		 			<p>${comment.content}</p>
		 		</c:forEach></div>
		 		
				<form:form modelAttribute="newComment" class="form-horizontal">
				<fieldset>
		 		<legend>Add new comment</legend>
		 			<div class="form-group">
		 				<label class="control-label col-lg-2 col-lg-2" for="username">Username</label>
		 				<div class="col-lg-8">
		 					<form:input id="username" path="username" type="text" class="form-control"/>
						 </div>
					</div>
					<div class="form-group">
		 				<label class="control-label col-lg-2 col-lg-2" for="mailAdress">E-mail</label>
		 				<div class="col-lg-8">
		 					<form:input id="mailAdress" path="mailAdress" type="text" class="form-control"/>
						 </div>
					</div>
					<div class="form-group">
		 				<label class="col-sm-2 control-label" for="content">Content</label>
		 				<div class="col-lg-8">
		 				<form:textarea id="content" class="form-control" path="content" rows ="4"/>
		 				</div>
		 			</div>
		 			<div class="form-group">
		 				<div class="col-lg-offset-2 col-lg-10">
		 				<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
						 </div>
		 			</div>
		 		</fieldset>
			 </form:form>	
		 </div>
	 	<div class ="col-sm-6 col-md-3" style="padding-top: 15px">
	 		<a href="./admin" class="btn btn-warning btn-large">
 				<span class="glyphicon glyphicon-wrench"></span>
 				Admin Panel
 			</a>
 		</div>	
		 </div>
	 </section>
</body>
</html>