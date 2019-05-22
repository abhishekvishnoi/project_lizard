<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Abhishek Vishnoi">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

<!-- Bootstrap core CSS -->
<link href="./assets/dist/css/bootstrap.css" rel="stylesheet">
<link href="./assets/dist/css/style.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="./assets/dist/css/sticky-footer-navbar.css" rel="stylesheet">
<link href="./assets/dist/css/sticky-footer.css" rel="stylesheet">



</head>
<body>


	<div class="floatright" style="width: 70%; height: 80%;">


        <c:if test="${addProductForm.pageMode == 1}"><div class="page_heading">Edit Product</div></c:if>
        
         <c:if test="${addProductForm.pageMode == 0}"><div class="page_heading">Add Product</div></c:if>
		

		<div class="container" style="width: 95%;">
			<div class="row">



				<div class="panel-body">
					<form:form commandName="addProductForm"
						action="./add_product_submit.do" method="POST"
						enctype="multipart/form-data" cssClass="form-horizontal">
						<span style="font-size: 14px; font-style: normal;">
							&nbsp;&nbsp; ${login_error}</span>
						<%-- <form class="form-horizontal" role="form"> --%>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">
								Product Name</label>
							<div class="col-sm-9">

								<form:input path="productName" class="form-control" type="text"
									style="width:300px;" maxlength="256" />
								<!-- <input type="email" class="form-control" id="inputEmail3" placeholder="Email" required> -->
							</div>
						</div>



						<div class="form-group">
							<label class="col-sm-3 control-label"> Product Price</label>
							<div class="col-sm-9">
								<form:input path="productPrice" class="form-control"
									style="width:300px;" maxlength="256" />
								<!-- <input type="email" class="form-control" id="inputEmail3" placeholder="Email" required> -->
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-3 control-label"> Product
								Description</label>
							<div class="col-sm-9">

								<form:input path="productDesc" class="form-control"
									style="width:300px;" maxlength="256" />
								<!--  <input type="password" class="form-control" id="inputPassword3" placeholder="Password" required> -->
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">
								Upload Image:</label>
							<div class="col-sm-9">
								<form:input path="productImage" class="" type="file"
									style="width:300px;" maxlength="256" />
								<!-- <input type="email" class="form-control" id="inputEmail3" placeholder="Email" required> -->
							</div>
						</div>

						<br>
						<br>

						<div class="form-group last">
							<div class="col-sm-offset-3 col-sm-9">
								 
								 <c:if test="${addProductForm.pageMode == 1}"><button type="submit" class="btn btn-success btn-sm">
                                    Edit Product</button></c:if>
        
                                 <c:if test="${addProductForm.pageMode == 0}"><button type="submit" class="btn btn-success btn-sm">
                                    Add Product</button></c:if>
								
								
								

							</div>
						</div>
					</form:form>
				</div>



			</div>
		</div>

	</div>

	</div>

	</div>


</body>


</html>