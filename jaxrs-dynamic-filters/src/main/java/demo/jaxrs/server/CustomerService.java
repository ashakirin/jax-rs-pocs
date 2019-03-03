package demo.jaxrs.server;

import java.util.List;

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
public interface CustomerService {
	    @GET
	    @Path("customers/{id}/")
	    Customer getCustomer(@PathParam("id") String id);

	    @PUT
	    @Path("customers/")
	    Response updateCustomer(Customer customer);

	    @POST
	    @Path("customers/")
	    Response addCustomer(Customer customer);

	    @DELETE
	    @Path("customers/{id}/")
	    Response deleteCustomer(@PathParam("id") String id);

	    @Path("orders/{orderId}/")
	    @GET
	    Order getOrder(@PathParam("orderId") String orderId);

		@POST
		@Path("policies")
	    <T extends PolicyTO> T create(final T policyTO);

		@Path("policies/{type}")
	    @GET
	    List<? extends PolicyTO> listByType(@PathParam("type") final PolicyType type);

		@Path("policies/typed")
	    @GET
	    List<PasswordPolicyTO> listTyped();

		@Path("policies/validate")
	    @POST
	    <T extends PolicyTO> boolean validate(List<T> policies);
}
