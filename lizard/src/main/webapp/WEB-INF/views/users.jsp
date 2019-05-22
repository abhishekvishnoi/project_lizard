<html>
<head>
<%@ page session="true"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Abhishek Vishnoi">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

<!-- Bootstrap core CSS -->
<!-- <link href="../assets/dist/css/bootstrap.css" rel="stylesheet">
<link href="../assets/dist/css/style.css" rel="stylesheet">
Custom styles for this template
<link href="../assets/dist/css/sticky-footer-navbar.css" rel="stylesheet">
<link href="../assets/dist/css/sticky-footer.css" rel="stylesheet">
 -->
<script type="text/javascript">


//Autthor :: Abhishek Vishnoi 02/02/2017
/* $( document ).ready(function() {
	
	$( "#navigationLeft" ).load(function() {
		  // Handler for .load() called.
		
		$( "#Users" ).addClass( "active" );
		  
		});
}); */

</script>
</head>
<body>


	<div class="floatright" style="width: 70%; height: 80%;">


		<!-- Page Heading -->
		<div class="page_heading">Users userid--${sessionScope.userID}
			---${remoteAdd} }</div>
		<!-- Page Heading Ends-->


		<div class="container mrgtop50">
			<div class="row">
				<div class="">
					<form action="#" method="get">
						<div class="input-group">
							<!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
							<input class="form-control" id="system-search" name="q"
								placeholder="Search for" required> <span
								class="input-group-btn">
								<button type="submit" class="btn btn-default">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</span>
						</div>
					</form>
				</div>
				<div class="col-md-9">
					<table class="table table-list-search">
						<thead>


							<tr>
								<th>User ID</th>
								<th>Name</th>
								<th>Email</th>
								<th>Password</th>


							</tr>
						</thead>
						<tbody>
							<c:forEach var="user_list" items="${user_list}">
								<tr>
									<td>${user_list.userId}</td>
									<td>${user_list.userName}</td>
									<td>${user_list.userEmail}</td>
									<td>${user_list.userPassword}</td>






								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>





	</div>


	</div>


</body>


</html>