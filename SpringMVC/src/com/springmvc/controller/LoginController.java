package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		String userName = req.getParameter("userName");
		String pass = req.getParameter("pwd");
		
		System.out.println("Username is : "+userName+", and the Password is: "+pass);
		
		ModelAndView view = new ModelAndView("home");
		
		return view;
	}

}
