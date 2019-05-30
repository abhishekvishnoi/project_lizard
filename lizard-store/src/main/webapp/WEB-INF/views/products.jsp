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
<link href="../assets/dist/css/sticky-footer.css" rel="stylesheet"> -->

<style type="text/css">

.head_font
{

font-family: sans-serif;
font-size: large;
font-weight: bold;

}

</style>
</head>
<body>


	<div class="floatright" style="width: 70%; height: 80%;">

		<!-- Page Heading -->
		<div class="page-header head_font">Products
			userid--${sessionScope.userID}</div>
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
				<div class="" style="width: 90%;">
					<table class="table table-list-search">
						<thead>
							<tr>
								<th>Product ID</th>
								<th>Product Name</th>
								<th>Product Price</th>
								<th>Date</th>
								<th>Preview</th>
								<th>Actions</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="prod_List" items="${prod_List}">
								<tr>
									<c:set var="productId" value="${prod_List.productId}" />
									<td>${prod_List.productId}</td>
									<td>${prod_List.productName}</td>
									<td>${prod_List.productPrice}</td>
									<td>12-12-2013</td>
									<td><img src="${prod_List.productImage}" width="65px" /></td>
									<td>
									<a
                                        href="edit_product.do?productId=${prod_List.productId}"
                                        class="btn btn-info btn-large">Edit </a>
									<a
										href="delete_product.do?productId=${prod_List.productId}"
										class="btn btn-danger btn-large">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
			href="./add_product.do" class="btn btn-success btn-large">Add new
			Product</a>

	</div>
	</div>

	</div>



</body>
</html>