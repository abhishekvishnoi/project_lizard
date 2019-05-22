<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style type="text/css">
.margin_top20 {
	margin-top: 40px;
}

.box_name {
	margin-left: 3%;
	padding: 1%;
}

.float_left {
	float: left;
}

.float_right {
	float: right;
}

.border1px {
	border: 1px solid;
}
</style>

</head>
<body>



	<div class="container margin_top20">

		<div class=".col-md-4">
			<img class="img-thumbnail" alt="product image"
				src="${product.productImage}" width="400px;">
		</div>

		<div class="border1px .col-md-8">
			<div class="box_name">${product.productName}</div>

			<!-- <div class="well">
				<p style="font-family: cursive; color: olive;">Lorem ipsum dolor
					sit amet, consectetur adipiscing elit. Maecenas sed diam eget risus
					varius blandit sit amet non magna. Lorem ipsum dolor sit amet,
					consectetur adipiscing elit. Praesent commodo cursus magna, vel
					scelerisque nisl consectetur et. Cras mattis consectetur purus sit
					amet fermentum. Duis mollis, est non commodo luctus, nisi erat
					porttitor ligula, eget lacinia odio sem nec elit. Aenean lacinia
					bibendum nulla sed consectetur.</p>
			</div>
 -->



		<%-- <form:form commandName="addToCartForm" action="./add_to_cart.do"
			method="post" id="addToCartForm" name="addToCartForm" >
			
			<form:hidden path="productID"  xmlns="productId"  value="${product.productId}"/> 
			<div>
			Qty : <form:input path="quantity" type="text" style="width:300px;" maxlength="2" />
				<!-- <button type="button" class="btn btn-primary">Add To Cart</button> -->
				${product.productId}----
				
				<input type="submit" value="Add To Cart" class="btn btn-success btn-large" name="addToCart" />
				
				 <a
					href="./add_to_cart.do?productId=${product.productId}"
					class="btn btn-success btn-large">Add To Cart</a>

			</div>
			</form:form> --%>
		</div>

	</div>

	</div>