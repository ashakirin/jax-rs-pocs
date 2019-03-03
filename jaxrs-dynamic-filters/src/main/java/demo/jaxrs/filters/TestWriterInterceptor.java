package demo.jaxrs.filters;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class TestWriterInterceptor implements WriterInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestContainerResponseFilter.class);

	@Override
	public void aroundWriteTo(WriterInterceptorContext context)
			throws IOException, WebApplicationException {
		LOGGER.info("Writer interceptor");
		System.out.println("*** WriterInterceptor ***");
		context.proceed();
	} 

}
