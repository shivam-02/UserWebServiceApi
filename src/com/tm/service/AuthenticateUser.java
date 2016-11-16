package com.tm.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tm.dao.UserDAO;

@Path("/AuthenticateUser")
public class AuthenticateUser {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response authentication(@QueryParam("username")String username,@QueryParam("password") String password)
	{
		
		int status=0;
		
		UserDAO userDAO=new UserDAO();
		
		 status=userDAO.authenticate(username,password);
		
		
		if(status==1)
		{
			
			return Response.status(200).entity("{\"success\":true,\"message\":\"Employee logged in successfully\"}").build();
		}
		else
		{
			return Response.status(401).entity("{\"success\":false,\"message\":\"Invalid username/password\"}").build();
		}
		
	}

}
