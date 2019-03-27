package demo.jaxrs.filters;

import demo.jaxrs.server.ResourceIdentifier;
import org.apache.cxf.jaxrs.model.OperationResourceInfo;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class ResourceExtracterContainerFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        final Message message = JAXRSUtils.getCurrentMessage();
        if (null == message) {
            return;
        }

        final Exchange exchange = message.getExchange();
        if (null != exchange && exchange.containsKey(OperationResourceInfo.class.getName())) {
            OperationResourceInfo resourceClassInfo = ((OperationResourceInfo) exchange.get(OperationResourceInfo.class.getName()));
            System.out.println(" **************************************");
            Class<?> resourceClass = resourceClassInfo.getAnnotatedMethod().getDeclaringClass();
            System.out.println("Class: " + resourceClass.getName());
            System.out.println("Method: " + resourceClassInfo.getAnnotatedMethod().getName());
            System.out.println("Resource annotation: " + resourceClass.getAnnotation(ResourceIdentifier.class).value());
            System.out.println("JAX-RS property: " + message.getContextualProperty("service.provider.id"));
            System.out.println(" **************************************");

        }
    }

}
