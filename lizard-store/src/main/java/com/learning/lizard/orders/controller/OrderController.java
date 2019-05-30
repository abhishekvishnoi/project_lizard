package com.learning.lizard.orders.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.learning.lizard.common.Cart;
import com.learning.lizard.orders.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	
	/*
	 * Request mapping for controller to create a New Order.
	 */
	@RequestMapping(value = "create_order.do", method = RequestMethod.GET)
	public ModelAndView createOrder(HttpServletResponse response,
			HttpServletRequest request, Locale locale, Model model) {

		try {

			Integer userID = Integer.parseInt(request.getSession()
					.getAttribute("userID").toString());

			Cart cart = (Cart) request.getSession().getAttribute("cart");

			orderService.createOrder(cart, userID);
			
		} catch (Exception e) {

			System.out.println("exp occured dring creation of a new order"
					+ e.getMessage());
			
			e.printStackTrace();
		}

		return new ModelAndView();

	}

}