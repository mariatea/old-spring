<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
 	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <link rel="stylesheet"href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		 
		 <title>Admin Panel</title>
	 </head>
	 
 	 <body>
 <section>
 	<div class="jumbotron">
	 	<div class="container">
 			<h1>Admin Panel</h1>
 			<p>Add Note etc</p>
 		</div>
	 </div>
 </section>
<section class="container">
	<form:form modelAttribute="newNote" class="form-horizontal">
		<fieldset>
 		<legend>Add new note</legend>
 			<div class="form-group">
 				<label class="control-label col-lg-2 col-lg-2" for="productId">Title</label>
 				<div class="col-lg-8">
 					<form:input id="title" path="title" type="text" class="form-control"/>
				 </div>
			</div>
			<div class="form-group">
 				<label class="col-sm-2 control-label" for="content">Content</label>
 				<div class="col-lg-8">
 				<form:textarea id="content" class="form-control" path="content" rows ="8"/>
 				</div>
 			</div>
 			 <div class="form-group">
 				<label class="control-label col-lg-2 col-lg-2" for="productId">Tags</label>
 				<div class="col-lg-8">
 					<form:input id="tags" path="tags" type="text" class="form-control"/>
				 </div>
			</div>
 			<div class="form-group">
 				<div class="col-lg-offset-2 col-lg-10">
 				<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
				 </div>
 			</div>
 		</fieldset>
 		<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">Log out</a>
	 </form:form>	
</section>
</body>
</html>