package demo.jaxrs.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
@PreMatching
public class TestContainerRequestFilter implements ContainerRequestFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestContainerRequestFilter.class); 

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		LOGGER.info("Prematching Container request filter");
		System.out.println("*** Prematching Container response filter ***");
	}

}
