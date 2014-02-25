package demo.jaxrs.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@PreMatching
public class CustomContainerRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		
		System.out.println("********************");
		System.out.println("Filter is called");
		System.out.println("********************");
		//requestContext.abortWith(Response.status(Status.BAD_REQUEST).build());
	}

}
