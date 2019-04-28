package demo.jaxrs.filters;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxrs.client.ClientProviderFactory;
import org.apache.cxf.jaxrs.client.spec.ClientRequestFilterInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.udp.UDPTransportFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class UDPTransportClientInterceptor extends AbstractPhaseInterceptor<Message> {

    public UDPTransportClientInterceptor() {
        super(Phase.PRE_LOGICAL);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        EndpointInfo ei = message.getExchange().getEndpoint().getEndpointInfo();
        if (ei.getAddress().startsWith("udp")) {
            UDPTransportFactory factory = new UDPTransportFactory();
            try {
                Conduit conduit = factory.getConduit(ei, message.getExchange().getBus());
                message.put(Conduit.class, conduit);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
