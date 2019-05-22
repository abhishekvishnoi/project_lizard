package com.learning.lizard.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.learning.lizard.user.handler.UserHandler;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("Inside Login Interceptor");
		Integer userID = 0;

		String reqURL = request.getRequestURL().toString();

		/* Enumeration<String> refferer = request.getHeaderNames(); */

		request.getSession().getAttributeNames();

		if (request.getSession().getAttribute("userID") != null) {
			userID = Integer.parseInt(request.getSession().getAttribute("userID").toString());

		}

		HttpSession session = request.getSession();

		if (reqURL.contains("RegisterUser.do") || reqURL.contains("admin/RegisterUserSubmit.do")) {
			return true;
		}
		if (session == null && (reqURL.contains("login_red"))) {
			return false;
		} else if (request.getSession().getAttribute("userID") == null && !reqURL.contains("login")) {
			response.sendRedirect("../login_red.do");
			return false;
		} else
			return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
