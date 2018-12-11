package com.Servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registrationServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String user_name = request.getParameter("userName");
		String password = request.getParameter("pwd");
		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String contact = request.getParameter("contact");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/workspace?autoReconnect=true&useSSL=false", "root", "Root@123");

			PreparedStatement ps = con.prepareStatement("insert into person values(?,?,?,?,?)");
			

			ps.setString(1, user_name);
			ps.setString(2, password);
			ps.setString(3, first_name);
			ps.setString(4, last_name);
			ps.setString(5, contact);

			int i = ps.executeUpdate();
			if (i > 0)
				out.print("User details successfully entered into database.");

		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}

}