package demo.jaxrs.filters;

import java.util.Arrays;
import java.util.List;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxrs.client.ClientProviderFactory;
import org.apache.cxf.jaxrs.client.spec.ClientRequestFilterInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class DynamicFilterControllerClient extends AbstractPhaseInterceptor<Message> {

    public DynamicFilterControllerClient() {
        super(Phase.PRE_LOGICAL);
        getBefore().add(ClientRequestFilterInterceptor.class.getName());
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        ClientProviderFactory pf = ClientProviderFactory.getInstance(message);
        if (pf == null) {
            return;
        }
        List<Object> providers = Arrays.asList(new TestClientRequestFilter(),
                                               new TestClientResponseFilter(),
                                               new TestReaderInterceptor(),
                                               new TestWriterInterceptor());
        pf.setUserProviders(providers);

    }

}
