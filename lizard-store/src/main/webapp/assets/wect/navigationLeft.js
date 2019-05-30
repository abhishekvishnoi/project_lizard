// Autthor :: Abhishek Vishnoi 02/02/2017
$(document).ready(function() {

	var pathname = window.location.pathname;

	pathname = pathname.split("/")[3];
	
	pathname = pathname.split("_")[1];
	
	console.log(pathname);

	$("#Orders").removeClass("active");
	$("#Products").removeClass("active");
	$("#Orders").removeClass("active");
	$("#Users").removeClass("active");

	if (pathname == "products.do" || pathname == "product.do") {
		$("#Products").addClass("active");
	} else if (pathname == "orders.do" || pathname == "order.do") {
		$("#Orders").addClass("active");
	} else if (pathname == "users.do" || pathname == "user.do") {
		$("#Users").addClass("active");
	} else {
		$("#Dashboard").addClass("active");
	}

});	







