package com.example.customerservice.client;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class ClientSoapFaultInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	
	public ClientSoapFaultInterceptor() {
		super(Phase.PRE_LOGICAL);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		Exception e = message.getContent(Exception.class);
		if (e != null) {
			message.setContent(Exception.class, new IllegalArgumentException("my test"));
		}
	}
}
