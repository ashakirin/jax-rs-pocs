package demo.jaxrs.filters;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class TestClientResponseFilter implements ClientResponseFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestClientResponseFilter.class); 

	@Override
	public void filter(ClientRequestContext requestContext,
			ClientResponseContext responseContext) throws IOException {
		LOGGER.info("Client response filter");
		System.out.println("*** Client response filter ***");
	}

}
