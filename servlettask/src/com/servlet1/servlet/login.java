package com.servlet1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class login extends GenericServlet {

	public void init(ServletConfig config) {
		

	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		String uname = req.getParameter("userName");
		String pwd = req.getParameter("pwd");

		dbconnection dbcon = null;
		if (dbcon == null) {
			dbcon = dbconnection.getObject();

		}

		boolean found = dbcon.check(uname, pwd);
		try {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			if (found) {
				RequestDispatcher rd = req.getRequestDispatcher("home.html");
				rd.forward(req, res);
				pw.println("User Exists");
			}
			

		} catch (IOException e) {

		}

	}

	public void destroy() {

	}

}
