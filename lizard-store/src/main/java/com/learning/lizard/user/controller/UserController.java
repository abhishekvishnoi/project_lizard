package com.learning.lizard.user.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.learning.lizard.persistence.UserTbMaster;
import com.learning.lizard.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "admin/view_users.do", method = RequestMethod.GET)
	public ModelAndView Users(HttpServletResponse response, Locale locale,
			Model model) {

		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("users");
		
		List<UserTbMaster> user_list = userService.findAll();
		
		modelAndView.addObject("user_list", user_list);
		
		return modelAndView;
	}
}
