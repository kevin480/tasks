package com.Servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet extends GenericServlet {

	public void init(ServletConfig config) {
		// System.out.println("This is from init");

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("This is from service");

		// System.out.println("Username and password is "+req.getParameter("userName")+req.getParameter("pwd"));
		String uname = req.getParameter("userName");
		String pwd = req.getParameter("pwd");

		databasecon dbcon = null;
		if (dbcon == null) {
			dbcon = databasecon.getObject();

		}

		boolean found = dbcon.check(uname, pwd);
		try {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			if (found) {
				RequestDispatcher rd = req.getRequestDispatcher("home.html");
				rd.forward(req, res);
				pw.println("User Exists");
			} else {

				RequestDispatcher rd = req.getRequestDispatcher("register.html");
				rd.forward(req, res);

			}

		} catch (IOException e) {

		}

	}

	public void destroy() {

	}

}