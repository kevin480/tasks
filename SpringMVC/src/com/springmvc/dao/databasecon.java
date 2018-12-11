package com.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.springmvc.dao.databasecon;


public class databasecon {

	public static databasecon obj = null;
	static Connection con = null;

	public static databasecon getObject() {
		if (obj == null) {
			obj = new databasecon();
		}
		return obj;
	}

	public static Connection databaseconnection() {
		Connection con = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/workspace?autoReconnect=true&useSSL=false",
					"root", "Root@123");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public boolean check(String username, String password) {

		try {
			if (con == null)
				con = databasecon.databaseconnection();
			java.sql.Statement mystat = con.createStatement();
			String displayuser = "Select * from person";
			ResultSet res = mystat.executeQuery(displayuser);

			while (res.next()) {
				if (username.equals(res.getString("user_name")) && password.equals(res.getString("password"))) {

					return true;
				}
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List listofusers()
	{
		List<String> l1 = new ArrayList<String>();
		try {
		Connection con = databasecon.databaseconnection();
		Statement mystat = con.createStatement();
		String displayuser = "Select * from person";
		ResultSet res = mystat.executeQuery(displayuser);
		Iterator iterator1 = l1.iterator();
		while(res.next())
		{
			l1.add(res.getString("user_name")+"--"+res.getString("first_name")+"--"+res.getString("last_name"));
			
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return l1;	
	}
}
