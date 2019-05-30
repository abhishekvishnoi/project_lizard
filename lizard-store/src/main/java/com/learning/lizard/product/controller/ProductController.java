package com.learning.lizard.product.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learning.lizard.category.service.CategoryService;
import com.learning.lizard.common.UploadFile;
import com.learning.lizard.persistence.ProductsTbMaster;
import com.learning.lizard.product.form.AddProductForm;
import com.learning.lizard.product.form.ProductFormValidator;
import com.learning.lizard.product.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductFormValidator productFormValidator;

	@Autowired
	UploadFile uploadFile;

	/*
	 * Controller Mapping to fetch the list of products
	 */
	@RequestMapping(value = "admin/view_products.do", method = RequestMethod.GET)
	public ModelAndView viewProducts(HttpServletResponse response,
			HttpServletRequest request, Locale locale, Model model) {

		ModelAndView modelAndView = new ModelAndView();

		// Set view name (JSP)
		modelAndView.setViewName("products");

		List<ProductsTbMaster> prod_List = productService.findAll();

		modelAndView.addObject("prod_List", prod_List);

		return modelAndView;
	}

	/*
	 * Controller Mapping to add a new Product (GO TO add product page)
	 */
	@RequestMapping(value = "admin/add_product.do", method = RequestMethod.GET)
	public ModelAndView addProduct(
			@ModelAttribute("addProductForm") AddProductForm addProductForm,
			HttpServletResponse response, Locale locale, Model model) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("categoryList",
				categoryService.findAllCategory());
		
		addProductForm.setPageMode(0);
		modelAndView.addObject("addProductForm", addProductForm);

		modelAndView.setViewName("addProduct");

		return modelAndView;

	}

	/*
	 * Controller Mapping to add a new Product
	 */
	@RequestMapping(value = "admin/add_product_submit.do", method = RequestMethod.POST)
	public ModelAndView addProductSubmit(
			@ModelAttribute("addProductForm") AddProductForm addProductForm,
			HttpServletResponse response, HttpServletRequest request,
			Locale locale, BindingResult bindingResult, Model model) {

		productFormValidator.validate(addProductForm, bindingResult);

		addProductForm.setProductImagePath(uploadFile.upload(addProductForm,
				request));

		productService.createProduct(addProductForm);

		return new ModelAndView("redirect:view_products.do");
	}

	/*
	 * Controller Mapping for editing a product. Page mode is 1 for editing a
	 * product.
	 */
	@RequestMapping(value = "admin/edit_product.do", method = RequestMethod.GET)
	public ModelAndView editProduct(
			@ModelAttribute("addProductForm") AddProductForm addProductForm,
			HttpServletRequest request, HttpServletResponse response,
			Locale locale, Model model) {

		ModelAndView modelAndView = new ModelAndView();

		int productId = Integer.parseInt(request.getParameter("productId"));

		addProductForm = productService.findProductForm(productId);

		addProductForm.setPageMode(1);

		modelAndView.addObject("addProductForm", addProductForm);

		modelAndView.setViewName("addProduct");

		return modelAndView;

	}

	/*
	 * Controller Mapping to delete an existing product by ID Fetch product Id
	 * from jsp . 
	 * Call Product service to delete the product.
	 */
	@RequestMapping(value = "admin/delete_product.do", method = RequestMethod.GET)
	public ModelAndView deleteProduct(
			@ModelAttribute("addProductForm") AddProductForm addProductForm,
			HttpServletResponse response, HttpServletRequest request,
			Model model, final RedirectAttributes redirectAttributes) {

		int productId = Integer.parseInt(request.getParameter("productId"));

		productService.deleteProduct(productId);

		return new ModelAndView("redirect:view_products.do");
	}

}
