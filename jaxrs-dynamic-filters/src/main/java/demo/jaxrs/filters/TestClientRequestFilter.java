package demo.jaxrs.filters;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class TestClientRequestFilter implements ClientRequestFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestClientRequestFilter.class); 

	@Override
	public void filter(ClientRequestContext requestContext)
			throws IOException {
		LOGGER.info("Client request filter");
		System.out.println("*** Client request filter ***");
	}

}
