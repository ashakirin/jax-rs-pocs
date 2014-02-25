package com.example.customerservice.server;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class HeaderInInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	
	public HeaderInInterceptor() {
		super(Phase.USER_LOGICAL);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		List<Header> headers = (List<Header>) message
				.get(Header.HEADER_LIST);
		
		System.out.println("*************  Headers ****************");
		for (Header header : headers) {
			System.out.println(header.getName() + "-" + header.getObject() );
		}
	}
}
