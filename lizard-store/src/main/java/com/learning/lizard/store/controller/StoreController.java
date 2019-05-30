package com.learning.lizard.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.learning.lizard.common.CartItem;
import com.learning.lizard.persistence.ProductsTbMaster;
import com.learning.lizard.product.service.ProductService;

@Controller
public class StoreController {

	@Autowired
	ProductService productService;

	/*
	 * COntroller Mapping to fetch the HOme for Store.
	 * 
	 * @param request
	 * 
	 * @return
	 */
	@RequestMapping(value = "storeHome.do", method = RequestMethod.GET)
	public ModelAndView StoreHome(HttpServletRequest request) {

		System.out.println("welcome to store home");
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("store/storeHome");

		List<ProductsTbMaster> prod_List = productService.findAll();

		modelAndView.addObject("prod_List", prod_List);

		return modelAndView;
	}

	/*
	 * Controller Mapping to get the details page for a Product on basis of ID.
	 */
	@RequestMapping(value = "product_details.do", method = RequestMethod.GET)
	public ModelAndView productDetails(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("store/productDetailsPage");

		int productId = Integer.parseInt(request.getParameter("productId"));
		
		ProductsTbMaster productEntity = productService.findByID(productId);
		
		modelAndView.addObject("product", productEntity);
		
		CartItem addToCartForm =  new CartItem();
		
		addToCartForm.setQuantity(1);
		
		modelAndView.addObject("addToCartForm",addToCartForm);

		return modelAndView;
	}

}
