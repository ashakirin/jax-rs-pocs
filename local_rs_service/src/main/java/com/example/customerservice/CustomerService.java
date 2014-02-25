package com.example.customerservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Consumes({"application/json"})
@Produces({"application/json"})
//@Consumes({"application/xml"})
//@Produces({"application/xml"})
@Path("customerservice")
public interface CustomerService {
	    @GET
	    @Path("customers/{id}")
	    Customer getCustomer(@PathParam("id") String id);

	    @PUT
	    @Path("customers")
	    Response updateCustomer(Customer customer);

	    @POST
	    @Path("customers")
	    Customer addCustomer(Customer customer);


	    @DELETE
	    @Path("customers/{id}/")
	    Response deleteCustomer(@PathParam("id") String id);

}
