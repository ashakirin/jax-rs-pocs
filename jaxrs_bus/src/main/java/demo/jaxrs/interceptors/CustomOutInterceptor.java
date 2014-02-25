package demo.jaxrs.interceptors;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.Headers;

public class CustomOutInterceptor extends AbstractPhaseInterceptor<Message> {
	
	public CustomOutInterceptor() {
		super(Phase.SETUP);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		System.out.println("*******************");
		System.out.println("Context property: " + message.getContextualProperty("TEST_CONTEXT_PROPERTY"));
		System.out.println("Custom interceptor is invoked");
		System.out.println("*******************");
	}
	

}
