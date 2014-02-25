package com.example.customerservice.server;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class CustomInInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	
	public CustomInInterceptor() {
		super(Phase.USER_LOGICAL);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		throw new Fault(new RuntimeException("Test In exception"));
	}
}
