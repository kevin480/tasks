package com.springmvc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.springmvc.dao.databasecon;

@Controller
public class LoginController {

	@RequestMapping("/login.htm")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("loginPojo") LoginPojo pojo) 
			throws Exception {

		String uname = req.getParameter("userName");
		String pwd = req.getParameter("pwd");

		System.out.println("Username is : " + uname + ", and the Password is: " + pwd);
		
/*		 ModelAndView view = new ModelAndView("home");
		
		 return view;*/
		
		databasecon dbcon = null;
		if (dbcon == null) {
			dbcon = databasecon.getObject();
		}

		boolean found = dbcon.check(uname, pwd);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/workspace?autoReconnect=true&useSSL=false", "root", "Root@123");

			PreparedStatement ps = con.prepareStatement("select * from person where user_name=? and password=?");

			ps.setString(1, uname);
			ps.setString(2, pwd);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ModelAndView rs1 = new ModelAndView("listofusers");

				return rs1;
			}

			ModelAndView rs2 = new ModelAndView("register");

			return rs2;
		} finally {

		}
	}
		
	    
		@RequestMapping("/loginGet.htm")
		public ModelAndView loginGet(HttpServletRequest req, 
				HttpServletResponse res, @ModelAttribute("loginPojo") LoginPojo pojo) {
		
			
			 ModelAndView view = new ModelAndView("index");
			
			 return view;
			
		}

		
		@RequestMapping("/register.abc")
		public ModelAndView reg(HttpServletRequest req, 
				HttpServletResponse res, @ModelAttribute("loginPojo") LoginPojo pojo) {
		
			
			 ModelAndView view = new ModelAndView("register");
			
			 return view;
			
		}
		
		
	}

