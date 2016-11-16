package com.tm.service;

import java.io.BufferedReader;

import java.io.FileReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/GetSwagger")


public class GetSwagger {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getSwaggerJson()
	{
		String result = "";
	    try {
	        BufferedReader br = new BufferedReader(new FileReader("C:\\New_workspace\\UserWebServiceApi\\api\\swagger\\Aswagger.json"));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        result = sb.toString();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
}
