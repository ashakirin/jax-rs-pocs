package com.example.customerservice.server;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class CustomOutInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	
	public CustomOutInterceptor() {
		super(Phase.WRITE );
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		throw new Fault(new RuntimeException("Test Out exception"));
	}
	
	@Override
	public void handleFault(SoapMessage message) throws Fault {
		System.out.println("Fault is called");
	}
}
