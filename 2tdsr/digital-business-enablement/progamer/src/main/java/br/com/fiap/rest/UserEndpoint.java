package br.com.fiap.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.User;

@Path("/users")
public class UserEndpoint {

	private UserDao dao = new UserDao();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(User user) {
		if(user == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		try {
			dao.save(user);
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();		
		}
		return Response.status(Response.Status.CREATED).entity(user).build();
		
	}
	
}
