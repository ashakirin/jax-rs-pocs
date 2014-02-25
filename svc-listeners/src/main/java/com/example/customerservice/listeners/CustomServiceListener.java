package com.example.customerservice.listeners;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.endpoint.ServerLifeCycleListener;

import com.example.customerservice.server.HeaderInInterceptor;

public class CustomServiceListener implements ServerLifeCycleListener {

    private final HeaderInInterceptor headerInInterceptor = new HeaderInInterceptor();

	@Override
	public void startServer(Server server) {
		System.out.println("******** Service listener ************: " + server.getEndpoint().getEndpointInfo().getAddress());
		server.getEndpoint().getInInterceptors().add(headerInInterceptor);
	}

	@Override
	public void stopServer(Server server) {
		// TODO Auto-generated method stub
		
	}

}
