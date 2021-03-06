package com.learning.lizard.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.lizard.user.form.UserForm;

@Controller
public class HomeController {

	@RequestMapping(value="/home.do")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userForm", new UserForm());
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
