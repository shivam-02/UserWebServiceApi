package com.tm.dao;

import java.sql.*;

public class DBUtils {
	

	public static Connection getConnection()  {
		// TODO Auto-generated method stub
	    Connection cn=null;
		
	try{
         Class.forName("com.mysql.jdbc.Driver");
         cn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
         System.out.println("Connection made");
		
	    }
	catch(Exception e)
	{
		
	}
	return cn;
	}
	}

	
