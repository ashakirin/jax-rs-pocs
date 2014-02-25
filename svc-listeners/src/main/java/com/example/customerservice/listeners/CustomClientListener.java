package com.example.customerservice.listeners;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientLifeCycleListener;

import com.example.customerservice.client.HeaderOutInterceptor;

public class CustomClientListener implements ClientLifeCycleListener {

    private final HeaderOutInterceptor headerOutInterceptor = new HeaderOutInterceptor();

	@Override
	public void clientCreated(Client client) {
		System.out.println("******** Client listener ************: " + client.getEndpoint().getEndpointInfo().getAddress());
		client.getOutInterceptors().add(headerOutInterceptor);
	}

	@Override
	public void clientDestroyed(Client client) {
		// TODO Auto-generated method stub

	}

}
