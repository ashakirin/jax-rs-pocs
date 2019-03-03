package demo.jaxrs.filters;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class TestReaderInterceptor implements ReaderInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestContainerResponseFilter.class); 

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context)
			throws IOException, WebApplicationException {
		LOGGER.info("Reader interceptor");
		System.out.println("*** ReaderInterceptor ***");
		return context.proceed();
	}

}
