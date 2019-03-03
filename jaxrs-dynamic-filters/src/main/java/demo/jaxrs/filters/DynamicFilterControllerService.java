package demo.jaxrs.filters;

import java.util.Arrays;
import java.util.List;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxrs.interceptor.JAXRSInInterceptor;
import org.apache.cxf.jaxrs.provider.ServerProviderFactory;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class DynamicFilterControllerService extends AbstractPhaseInterceptor<Message> {

    public DynamicFilterControllerService() {
        super(Phase.UNMARSHAL);
        getBefore().add(JAXRSInInterceptor.class.getName());
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        ServerProviderFactory providerFactory = ServerProviderFactory.getInstance(message);
        if (providerFactory == null) {
            return;
        }
        List<Object> providers = Arrays.asList(new TestContainerRequestFilter(),
                                               new TestContainerRequestFilterPost(),
                                               new TestContainerResponseFilter(),
                                               new TestReaderInterceptor(),
                                               new TestWriterInterceptor());
        providerFactory.setUserProviders(providers);
    }

}
