package com.learning.lizard.user.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learning.lizard.exception.BFECommonKeys;
import com.learning.lizard.exception.BusinessFailureException;
import com.learning.lizard.user.form.UserForm;
import com.learning.lizard.user.form.validator.RegisterUserValidator;
import com.learning.lizard.user.form.validator.UserFormValidator;
import com.learning.lizard.user.handler.UserHandler;

@Controller
public class LoginController {

	@Autowired
	UserHandler userHandler;

	@Autowired
	RegisterUserValidator registerUserValidator;

	@Autowired
	UserFormValidator userFormValidator;

	/**
	 * 
	 * @param userForm
	 * @param request
	 * @param response
	 * @param locale
	 * @param model
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "admin/login.do", method = RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("userForm") UserForm userForm, HttpServletRequest request,
			HttpServletResponse response, Locale locale, Model model, BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();
		userFormValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("login");
			modelAndView.addObject("userForm", userForm);
		} else {
			try {
				userHandler.loginUser(userForm, request.getSession());
				modelAndView.setViewName("dashBoard");
			} catch (BusinessFailureException bfe) {

				modelAndView.setViewName("login");
				modelAndView.addObject("errorMessage", bfe.getRoot_cause_message());
			}
		}
		return modelAndView;
	}

	/**
	 * 
	 * @param userForm
	 * @param request
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "admin/login_red.do", method = RequestMethod.GET)
	public ModelAndView Login_red(@ModelAttribute("userForm") UserForm userForm, HttpServletRequest request,
			Locale locale, Model model) {

		HttpSession session = request.getSession(true);
		session.getMaxInactiveInterval();
		return new ModelAndView("login");
	}

	/**
	 * 
	 * @param userForm
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "admin/Logout.do", method = RequestMethod.GET)
	public ModelAndView LogoutUSer(@ModelAttribute("userForm") UserForm userForm, HttpServletRequest request,
			HttpServletResponse response, final RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		HttpSession session = request.getSession(false);

		session.removeAttribute("userID");
		request.getSession().setAttribute("loginStatus", false);

		request.getSession().setAttribute("userID", null);
		session.invalidate();

		return new ModelAndView("redirect:Logout_red.do");
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "admin/Logout_red.do", method = RequestMethod.GET)
	public ModelAndView LogoutUSerRed(HttpServletRequest request, HttpServletResponse response,
			final RedirectAttributes redirectAttributes) {

		return new ModelAndView("redirect:./login_red.do");
	}

	@RequestMapping(value = "admin/RegisterUser.do", method = RequestMethod.GET)
	public ModelAndView RegisterUser(@ModelAttribute("userForm") UserForm userForm, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("registerUser");

		return modelAndView;
	}

	@RequestMapping(value = "admin/RegisterUserSubmit.do", method = RequestMethod.POST)
	public ModelAndView RegisterUserSubmit(@ModelAttribute("userForm") UserForm userForm, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();
		registerUserValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registerUser");
			modelAndView.addObject("userForm", userForm);
		} else {
			modelAndView.setViewName("login");
			try {
				userHandler.registerUser(userForm);
			} catch (BusinessFailureException bfe) {

				System.out.println(bfe.getRoot_cause_message() + "causeID ::" + bfe.getRoot_cause_id());

				if (BFECommonKeys.USER_EMAIL_ALREADY_EXISTS.equals(bfe.getRoot_cause_id()))
					userForm.setError_message("This email address is already registered.");
				{
					modelAndView.addObject("userForm", userForm);
					modelAndView.setViewName("registerUser");
				}
			}
		}

		// emailUtil.doSendEmail(request);

		return modelAndView;
	}

}
