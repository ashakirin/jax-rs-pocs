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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import demo.jaxrs.server.data.AbstractSchemaTO;
import demo.jaxrs.server.data.AttributableType;
import demo.jaxrs.server.data.PasswordPolicyTO;
import demo.jaxrs.server.data.PolicyTO;
import demo.jaxrs.server.data.PolicyType;
import demo.jaxrs.server.data.SchemaType;
import demo.jaxrs.server.data.SyncPolicyTO;
import demo.jaxrs.server.data.TaskTO;
import demo.jaxrs.server.data.TaskType;

//@Consumes({"application/json"})
//@Produces({"application/json"})
@Consumes({"application/xml"})
@Produces({"application/xml"})
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

		@Path("schemas/{kind}/{type}")
	    @GET
	    List<? extends AbstractSchemaTO> listSchemas(@PathParam("kind") AttributableType kind,
	            @PathParam("type") SchemaType type);

	    @Path("tasks/{type}")
	    @GET
	    <T extends TaskTO> List<T> listTasks(@PathParam("type") TaskType taskType);
//
//	    @GET
//	    @Path("{type}")
//	    <T extends TaskTO> List<T> listTasks(@PathParam("type") TaskType taskType, @QueryParam("page") int page,
//	            @QueryParam("size") @DefaultValue("25") int size);

	    @POST
	    @Path("{userId}/status/activate")
	    Customer activate(@PathParam("userId") long userId, @QueryParam("token") String token);

	    @POST
	    @Path("{userId}/status/activate")
	    Customer activate(@PathParam("userId") long userId, @QueryParam("token") String token,
	    		SyncPolicyTO policyTO);
}
