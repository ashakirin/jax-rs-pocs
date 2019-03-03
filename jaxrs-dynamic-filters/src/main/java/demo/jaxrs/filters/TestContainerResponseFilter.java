package demo.jaxrs.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class TestContainerResponseFilter implements ContainerResponseFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestContainerResponseFilter.class); 

	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		LOGGER.info("Container response filter");
		System.out.println("*** Container response filter ***");
	}

}
