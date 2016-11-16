package com.tm.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tm.dao.UserDAO;



@Path("/UserCRUD")
public class UserCRUD {
	
	
@Path("/add")
@POST
@Produces(MediaType.APPLICATION_JSON)
public Response addUser(@QueryParam("username")String username,@QueryParam("password")String password)
{
	UserDAO userDAO=new UserDAO();
	int status=userDAO.add(username,password);
	
	
	
	
		
	
	
	if(status==1)
	{
		return Response.status(200).entity("{\"success\":false,\"message\":\"User already exists\"}").build();
	}
	if(status==2)
	{
		return Response.status(201).entity("{\"success\":true,\"message\":\"User added successfully\"}").build();
	}
	
	
	return Response.status(409).entity("{\"success\":false,\"message\":\"Unable to add user\"}").build();
	
}

@Path("/update/{username}")
@POST
@Produces(MediaType.APPLICATION_JSON)
public Response updateUser(@PathParam("username")String username,@QueryParam("password")String password)
{
	UserDAO userDAO=new UserDAO();
	int status=userDAO.update(username,password);
	
	
	
	
		
	
	
	if(status==1)
	{
		return Response.status(404).entity("{\"success\":false,\"message\":\"User does not exists\"}").build();
	}
	if(status==2)
	{
		return Response.status(200).entity("{\"success\":true,\"message\":\"User updated successfully\"}").build();
	}
	
	
	return Response.status(500).entity("{\"success\":false,\"message\":\"Unable to update user\"}").build();
	
}

@Path("/delete/{username}")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response deleteUser(@PathParam("username")String username)
{
	UserDAO userDAO=new UserDAO();
	int status=userDAO.delete(username);
	
	if(status==1)
	{
		return Response.status(404).entity("{\"success\":false,\"message\":\"User does not exists\"}").build();
	}
	if(status==2)
	{
		return Response.status(200).entity("{\"success\":true,\"message\":\"User deleted successfully\"}").build();
	}
	
	
	return Response.status(500).entity("{\"success\":false,\"message\":\"Unable to delete user\"}").build();
}

}
