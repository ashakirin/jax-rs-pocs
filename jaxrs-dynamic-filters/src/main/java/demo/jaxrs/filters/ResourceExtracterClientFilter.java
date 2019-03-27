package demo.jaxrs.filters;

import demo.jaxrs.server.ResourceIdentifier;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;

@Provider
public class ResourceExtracterClientFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        final Message message = JAXRSUtils.getCurrentMessage();
        if (null == message) {
            return;
        }

        final Exchange exchange = message.getExchange();
        if (null != exchange && exchange.containsKey(Method.class.getName())) {
            Method resourceMethod = ((Method) exchange.get(Method.class.getName()));
            System.out.println(" **************************************");
            Class<?> resourceClass = resourceMethod.getDeclaringClass();
            System.out.println("Class: " + resourceClass.getName());
            System.out.println("Method: " + resourceMethod.getName());
            System.out.println("Resource annotation: " + resourceClass.getAnnotation(ResourceIdentifier.class).value());
            System.out.println("JAX-RS property: " + message.getContextualProperty("service.id"));
            System.out.println(" **************************************");
        }
    }

}
