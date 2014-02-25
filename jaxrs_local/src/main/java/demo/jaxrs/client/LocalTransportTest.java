/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package demo.jaxrs.client;

import java.util.List;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.transport.local.LocalConduit;
import org.apache.cxf.transport.local.LocalTransportFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.jaxrs.server.CustomerProxy;
import demo.jaxrs.server.CustomerService;
import demo.jaxrs.server.data.PolicyTO;
import demo.jaxrs.server.data.PolicyType;




public final class LocalTransportTest {

    private LocalTransportTest() {
    }

    public static void main(String args[]) throws Exception {
        startSpringTest();
    	
//    	startServer();
//    	startClient();
    }

    public static void startSpringTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:client-applicationContext.xml",
						"classpath:server-applicationContext.xml" });
        CustomerService proxy = (CustomerService)context.getBean("restClient");
//        WebClient.getConfig(proxy).getRequestContext().put(LocalConduit.DIRECT_DISPATCH, "true");

        Bus bus = new SpringBusFactory(context).createBus();
        BusFactory.setDefaultBus(bus);

        List<PolicyTO> policies = (List<PolicyTO>)proxy.listByType(PolicyType.PASSWORD);
    	for (PolicyTO policy : policies) {
    		System.out.println("Policy: " + policy.getId());
    	}
    }
    
    public static void startServer() {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(CustomerProxy.class);
        sf.setResourceProvider(CustomerProxy.class,
                               new SingletonResourceProvider(new CustomerProxy(), true));
        
        sf.setTransportId(LocalTransportFactory.TRANSPORT_ID);
        sf.setAddress("local://books");
        Server localServer = sf.create();
    }

    public static void startClient() {
    	CustomerService localProxy = 
                JAXRSClientFactory.create("local://books", CustomerService.class);
        List<PolicyTO> policies = (List<PolicyTO>)localProxy.listByType(PolicyType.PASSWORD);
    	for (PolicyTO policy : policies) {
    		System.out.println("Policy: " + policy.getId());
    	}
    }
}
