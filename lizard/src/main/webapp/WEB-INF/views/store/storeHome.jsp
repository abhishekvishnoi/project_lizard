<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">


<style type="text/css">
.backgorund_style {
	background-color: #4D94FF;
}
</style>

</head>

<body>


	<div class="row">
	<div class="col-md-6">
					<img class="first-slide"
						src="./assets/images/image1.png"
						alt="First slide">
					
				</div>
	<div class="col-md-6">
					<img class="first-slide"
						src="./assets/images/image2.png"
						alt="First slide">
					
				</div>
	
	</div>
	<!-- <div class="jumbotron backgorund_style" > -->
	<div>
		<!-- <div id="myCarousel" class="carousel slide" data-ride="carousel">
			Indicators
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="carousel-item active">
					<img class="first-slide"
						src="./assets/images/image1.png"
						alt="First slide">
					<div class="container">
					
					</div>
				</div>
				<div class="carousel-item">
					<img class="second-slide"
						src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
						alt="Second slide">
					<div class="container">
						
					</div>
				</div>
				<div class="carousel-item">
					<img class="third-slide"
						src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
						alt="Third slide">
					<div class="container">
						
						
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div> -->
	</div>
	<!-- </div> -->

	<div class="container">



		<!-- Example row of columns -->
		<div class="row">
			<c:forEach var="prod_List" items="${prod_List}">

				<div class="col-md-3 border">
				
				<div class="heading">${prod_List.productName}</div>
					
					<img alt="prod_image" src="${prod_List.productImage}"
						height="200px" width="200px">
					<p>Price : ${prod_List.productPrice}</p>

					<p>
						<a class="btn btn-success"
							href="./product_details.do?productId=${prod_List.productId}"
							role="button">View details</a>
							
							
							<a class="btn btn-success" id="addToCart" onclick="addCart(${prod_List.productId})"
							<%-- href="./add_to_cart.do?productId=${prod_List.productId}" --%>
							role="button">Add to Cart</a>
					</p>
				</div>


			</c:forEach>


		</div>
	</div>

	</div>