package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IAccountService;


@Path("/movie")
public class AccountEndpoint {
	
	@Inject
	private IAccountService service;
	
	
	@GET
	@Path ("/json")
	@Produces ({"application/json"})
	
	public String getallaccounts() {
		
		return service.getallaccounts();
	}
	
	
	@GET
	@Path ("/json/{id}")
	@Produces ({"application/json"})
	public String getAnAccount(@PathParam("id") Long id) {
		
		return service.getAnAccount(id);
	}
	
	@POST
	@Path ("/json")
	@Produces ({"application/json"})
	public String createAnAccount (String account) {
		
		return service.createAnAccount(account);
	}
	
	@PUT
	@Path ("/json")
	@Produces ({"application/json"})
	public String updateAnAccount (String account) {
		
		return service.updateAnAccount(account);
	}
	
	@DELETE
	@Path ("/json/{id}")
	@Produces ({"application/json"})
	public String deleteAnAccount (@PathParam("id") Long id) {
		
		return service.deleteAnAccount(id);
	}

}
