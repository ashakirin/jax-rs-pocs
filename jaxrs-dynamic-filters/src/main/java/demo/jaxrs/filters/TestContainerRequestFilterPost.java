package demo.jaxrs.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class TestContainerRequestFilterPost implements ContainerRequestFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestContainerRequestFilterPost.class); 

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		LOGGER.info("Postmatching Container request filter");
		System.out.println("*** Postmatching Container response filter ***");
	}

}
