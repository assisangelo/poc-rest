package com.assisangelo.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.validation.ValidateRequest;

import com.assisangelo.model.User;

@Path("/user-management")
public class UserManagementModule {
	
	@GET
	@Path("/users/{id}")
	@Produces("application/json")
	public Response getUserbyId(@PathParam("id") Integer id){
		User user = new User();
		user.setId(id);
		user.setFirstName("Angelo");
		user.setLastName("Assis");
		return Response.status(200).entity(user).build();
	}
	
	@Path("/users")
	@POST
	@ValidateRequest
	public Response addUser
	(
			@NotNull
			@Size(min=1,max=50)
			@FormParam("firstName") String firstName,
			@NotNull
			@Size(max=50)
			@FormParam("lastName") String lastName
	){
		return Response.ok().entity("User \"" + firstName + 
				" " + lastName + "\" added through JAX-RS Javascript API").build();
	}
	
}
