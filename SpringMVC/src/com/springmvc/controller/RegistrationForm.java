package com.springmvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class RegistrationForm {
	
	public ModelAndView regForm (HttpServletRequest req, HttpServletResponse res,
			 LoginPojo pojo) throws IOException, ClassNotFoundException, SQLException{
	

		
		String uname = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String first_name = req.getParameter("firstName");
		String last_name = req.getParameter("lastName");
		String contact = req.getParameter("contact");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/workspace?autoReconnect=true&useSSL=false", "root", "Root@123");

			PreparedStatement ps = con.prepareStatement("insert into person values(?,?,?,?,?)");
			

			ps.setString(1, uname);
			ps.setString(2, pwd);
			ps.setString(3, first_name);
			ps.setString(4, last_name);
			ps.setString(5, contact);
		
			int i = ps.executeUpdate();
			if (i > 0) {
				
				ModelAndView view1 = new ModelAndView("success");

				return view1;
				
		}
			
	}
		finally {
			
		}
		return null;
		
	}
}
