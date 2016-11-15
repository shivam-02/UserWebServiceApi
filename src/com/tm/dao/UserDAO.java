package com.tm.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tm.dao.DBUtils;

public class UserDAO {
	
private Connection connection=DBUtils.getConnection();
	
	public UserDAO()
	{
		System.out.println("in user dao");
	}
	
	public boolean getUser(String username)
	{
		boolean exists=false;
		try
		{
			
		PreparedStatement ps=connection.prepareStatement("select * from user where username=?");
		ps.setString(1,username);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			exists=true;
		}
		
		
		
		}catch(SQLException se)
		{
			System.out.println("unable to identify user...");
			se.printStackTrace();
		}
		return exists;
	}
	
	
	public int add(String username,String password)
	{
		int status=0;
		boolean userExists=getUser(username);
		
		if(userExists)
		{
			status=1;
		}
		else{
			
			try
			{
			
			PreparedStatement ps=connection.prepareStatement("insert into user values(?,?)");
			ps.setString(1,username);
			ps.setString(2,password);
			ps.executeUpdate();
			status=2;
			
		}catch(SQLException se)
		{
			System.out.println("unable to insert user...");
			se.printStackTrace();
		}
			}
		
		return status;
		
	}
	
	
	public int authenticate(String username,String password)
	{
		int status=0;
		try
		{
			
		PreparedStatement ps=connection.prepareStatement("select * from user where username=? and userPassword=?");
		ps.setString(1,username);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			status=1;
		}
		
		
		
		}catch(SQLException se)
		{
			System.out.println("unable to authenticate user...");
			se.printStackTrace();
		}
		return status;
	}
	
	
	public int update(String username,String password)
	{
		int status=0;
		boolean userExists=getUser(username);
		if(userExists)
		{
			try
			{
			
			PreparedStatement ps=connection.prepareStatement("update user set userPassword=? where username=?");
			ps.setString(1,password);
			ps.setString(2,username);
			if(ps.executeUpdate()!=0)
			status=2;
			
			
			
		}catch(SQLException se)
		{
			System.out.println("unable to update user...");
			se.printStackTrace();
		}
			
		}
		else
		{
			status=1;
		}
		
		return status;
	}
	
	public int delete(String username)
	{
		int status=0;
		boolean userExists=getUser(username);
		if(userExists)
		{
			
			
			try
			{
			
			PreparedStatement ps=connection.prepareStatement("delete from user where username=?");
			
			ps.setString(1,username);
			if(ps.executeUpdate()!=0)
			status=2;
			
			
			
		}catch(SQLException se)
		{
			System.out.println("unable to delete user...");
			se.printStackTrace();
		}
			
		}
		
		else
		{
			status=1;
		}
		
		return status;
	}
	

}
