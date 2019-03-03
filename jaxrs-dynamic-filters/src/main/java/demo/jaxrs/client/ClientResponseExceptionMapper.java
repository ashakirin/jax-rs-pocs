package demo.jaxrs.client;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.ResponseExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientResponseExceptionMapper implements ResponseExceptionMapper<Throwable> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientResponseExceptionMapper.class); 

    @Override
    public Throwable fromResponse(Response r) {
        LOGGER.info("*** Client ResponseExceptionMapper ***");
        System.out.println(" *** Client Exception mapper !!! ***");
        throw new RuntimeException("my test exception");
    }

}
