// Author :: Abhishek Vishnoi 02/02/2017

function addCart(prodID) {


		$.ajax({
			type : "GET",
			url : "add_to_cart.do",
			data : "productID=" + prodID,
			success : function(msg) {
				alert(msg);
				// $('#output').append(msg);
			}
		});
	
}
