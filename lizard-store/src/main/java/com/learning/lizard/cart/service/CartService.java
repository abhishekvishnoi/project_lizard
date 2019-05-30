package com.learning.lizard.cart.service;

import javax.servlet.http.HttpServletRequest;

import com.learning.lizard.common.Cart;
import com.learning.lizard.exception.BusinessFailureException;

/**
 * 
 * @author abhishek.vishnoi
 *
 */
public interface CartService {

	
	public boolean addToCart(HttpServletRequest request , Integer productID) throws BusinessFailureException;
	
	public Cart viewCart(HttpServletRequest request) throws BusinessFailureException;
} 
