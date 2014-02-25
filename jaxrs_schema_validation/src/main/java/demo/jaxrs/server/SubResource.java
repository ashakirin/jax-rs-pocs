package demo.jaxrs.server;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.example.customerservice.Customer;

public class SubResource {
	
    @PUT
    @Path("test")
	public Response updateSubresourceCustomer(Customer customer) {
		System.out.println("-------- Subresource call ------------");
		return Response.ok().build();
	}
	
    @GET
    @Path("subresource")
	public Customer getSubresourceCustomer() {
		System.out.println("-------- Subresource call ------------");
		return new Customer();
	}

}
