<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
			 <p> Blog notes should be listed here</p>
			 </div>
		 </div>
	 </section>
	 <section class="container">
	 	<div class ="row">
	 	<div class ="col-sm-6 col-md-9" style="padding-bottom: 15px">
	 	<c:forEach items="${notes}" var="note">
		 		<div class ="thumbnail">
		 			<div class = "caption">
		 			<h3><a href=" <spring:url value="./details?id=${note.noteId}"/>">${note.title}</a></h3>
		 			<p>${note.content}</p>
		 			<p> <a href=" <spring:url value="./details?id=${note.noteId}"/>">More...</a></p>
		 			<!-- <p>Tags :<c:forEach items="${note.tags}" var="tag">
	    				<a href="<spring:url value="./tagged?tag=${tag}"/>">${tag}</a>
					</c:forEach></p> -->
					<p>${note.time}</p>
		 			</div>
		 		</div>
	 	</c:forEach>
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