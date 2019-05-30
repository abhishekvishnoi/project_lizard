package com.learning.lizard.cart.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.learning.lizard.cart.service.CartService;
import com.learning.lizard.common.Cart;
import com.learning.lizard.exception.BusinessFailureException;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	/*
	 * REquest Mapping for controller to fetch all the Orders.
	 */
	@RequestMapping(value = "view_cart.do", method = RequestMethod.GET)
	public ModelAndView viewOrders(HttpServletResponse response, HttpServletRequest request, Locale locale,
			Model model) {

		Integer userID = 0;

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("store/view_cart");

		if (request.getSession().getAttribute("userID") != null) {
			userID = Integer.parseInt(request.getSession().getAttribute("userID").toString());
		}

		try {
		
			Cart cart =cartService.viewCart(request);

			modelAndView.addObject("cart", cart);
		
		} catch (BusinessFailureException e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}

	/*
	 * Request mapping for controller to create a New Order.
	 */
	@ResponseBody
	@RequestMapping(value = "add_to_cart.do", method = RequestMethod.GET)
	public  String addToCart(@ModelAttribute("productID") int productID ,HttpServletResponse response, HttpServletRequest request,
			Locale locale, Model model /*, @PathVariable("productID") int productID*/) {

		//int productID = 1;
		
		try {
			cartService.addToCart(request , productID);

		} catch (Exception e) {

			 System.out.println("exp occured dring creation of a new order" + e.getMessage());

			e.printStackTrace();
		}

		return "Added to Cart";

	}

}