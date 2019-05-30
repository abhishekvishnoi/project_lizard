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
<!-- <link href="./assets/dist/css/bootstrap.css" rel="stylesheet">
<link href="./assets/dist/css/style.css" rel="stylesheet">
Custom styles for this template
<link href="./assets/dist/css/sticky-footer-navbar.css" rel="stylesheet">
<link href="./assets/dist/css/sticky-footer.css" rel="stylesheet">
 -->

</head>
<body>

	<div class="floatright" style="width: 70%; height: 80%;">

		<!-- Page Heading -->
		<div class="page_heading">Orders userid--${sessionScope.userID}</div>
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
								<th>Order ID</th>
								<!-- 	<th>User Name</th> -->
								<th>User Email</th>
								<!-- <th>Product Name</th> -->
								<th>Order Price</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="order_List" items="${order_List}">
								<tr>
									<td>${order_List.orderID}</td>
									<%-- <td>${order_List.userName}</td> --%>
									<td>${order_List.emailID}</td>
									<%-- <td>${order_List.productName}</td> --%>
									<td>${order_List.productPrice}</td>
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