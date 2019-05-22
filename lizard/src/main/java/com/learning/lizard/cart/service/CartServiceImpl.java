package com.learning.lizard.cart.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.lizard.common.Cart;
import com.learning.lizard.common.CartItem;
import com.learning.lizard.exception.BusinessFailureException;
import com.learning.lizard.persistence.ProductsTbMaster;
import com.learning.lizard.product.form.AddProductForm;
import com.learning.lizard.product.form.ProductFormValidator;
import com.learning.lizard.product.service.ProductService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	ProductService productService;

	@Override
	public boolean addToCart(HttpServletRequest request, Integer productID) throws BusinessFailureException {

		boolean cartContainsItem = false;
		List<CartItem> cartItems = new ArrayList<>();

		Cart cart = (Cart) request.getSession().getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			cart.setCartItems(new ArrayList<>());
		}

		cartItems = cart.getCartItems();

		
		for (CartItem cartItem : cartItems) {

			if (cartItem.getProductID() == productID) {

				cartContainsItem = true;
				cartItem.setQuantity(cartItem.getQuantity() + 1);
			}

			if (cartContainsItem)
				break;
		}

		if (!cartContainsItem) {

			CartItem newItem = new CartItem();
			newItem.setProductID(productID);
			newItem.setQuantity(1);
			cartItems.add(newItem);

		}

		cart.setCartItems(cartItems);

		request.getSession().setAttribute("cart", cart);

		return true;
	}

	@Override
	public Cart viewCart(HttpServletRequest request) throws BusinessFailureException {

		Cart cart = (Cart) request.getSession().getAttribute("cart");

		List<CartItem> cartItems = cart.getCartItems();

		List<CartItem> cartItemList = new ArrayList<>();

		for (CartItem cartItem : cartItems) {

			if (cartItem.getProductID() != 0) {

				ProductsTbMaster productEntity = productService.findByID(cartItem.getProductID());

				CartItem product = new CartItem();
				product.setProductID(productEntity.getProductId());
				product.setProductName(productEntity.getProductName());
				product.setProductImagePath(productEntity.getProductImage());
				product.setProductPrice(productEntity.getProductPrice());
				product.setQuantity(cartItem.getQuantity());
				cartItemList.add(product);
			}
		}
		cart.setCartItems(cartItemList);
		cart.setOrderTtlAmnt(getTotalAmount(cartItemList));
		cart.setVatPrcntge(13.0f);
		cart.setNetVATAmnt(getVATAmount(cart.getOrderTtlAmnt(), cart.getVatPrcntge()));
		cart.setNetPayableAmnt(cart.getOrderTtlAmnt() + cart.getNetVATAmnt());
		return cart;
	}

	private Float getTotalAmount(List<CartItem> items) {

		Float sum = 0.0f;
		for (CartItem cartItem : items) {
			sum =sum + cartItem.getProductPrice() * cartItem.getQuantity();
		}
		return sum;
	}

	private Float getVATAmount(Float ttlAmnt, Float VATPerc) {
		return (ttlAmnt * VATPerc / 100);

	}

}
