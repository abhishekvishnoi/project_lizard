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
<link href="./assets/dist/css/bootstrap.css" rel="stylesheet">
<link href="./assets/dist/css/style.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="./assets/dist/css/sticky-footer-navbar.css" rel="stylesheet">
<link href="./assets/dist/css/sticky-footer.css" rel="stylesheet">

<style type="text/css">
.head_font {
	font-family: sans-serif;
	font-size: large;
	font-weight: bold;
}
</style>
</head>



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
								<!-- <th>Product ID</th> -->
								<th>Product Name</th>
								<th>Product Price</th>
								<th>Preview</th>
								<th>Quantity</th>
								<!-- <th>Preview</th> -->
								<th>Actions</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="productList" items="${cart.cartItems}">
								<tr>
									<c:set var="productId" value="${productList.productID}" />
									<%-- <td>${productList.productId}</td> --%>
									<td>${productList.productName}</td>
									
									<td>${productList.productPrice}</td>
									
									<td><img src="${productList.productImagePath}" width="65px" /></td>
									<td>${productList.quantity}</td>
									<td><a href="#" class="btn btn-danger btn-large">Remove
											from Cart</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div class="" style="width: 90%;">
					<table class="table table-list-search">

						<tbody>
								<tr>
									<%-- <td>${productList.productId}</td> --%>
									<td>${cart.orderTtlAmnt}</td>
									<td>${cart.vatPrcntge}</td>
									<td>${cart.netVATAmnt}</td>
									<td>${cart.netPayableAmnt}</td>
									<!-- <td><a href="#" class="btn btn-danger btn-large">Remove
											from Cart</a></td> -->
								</tr>
						</tbody>
					</table>
				</div>
			</div>
			<a href="./create_order.do" class="" >
			<input type="submit" value="Place Order" class="btn btn-success btn-large" name="placeOrder" onclick="./create_order.do" />
			</a>


		</div>
	</div>

	</div>
	</div>