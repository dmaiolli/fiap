package br.com.fiap.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.dao.SetupDao;
import br.com.fiap.model.Setup;

@Path("/setups")
public class SetupEndpoint {

	private SetupDao dao = new SetupDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Setup> Index() {
		return dao.getAll();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Create(Setup setup) {
		if(setup == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			dao.save(setup);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Response.Status.CREATED).entity(setup).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response show(@PathParam("id") Long id) {
		Setup setup = dao.findById(id);
		if(setup == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.status(Response.Status.OK).entity(setup).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Setup setup) {
		if(dao.findById(id) == null || setup == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		setup.setId(id);
		try {
			dao.update(setup);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Response.status(Response.Status.OK).entity(setup).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response destroy(@PathParam("id") Long id) {
		if(dao.findById(id) == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		try {
			dao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Response.status(Response.Status.OK).build();
	}

}
