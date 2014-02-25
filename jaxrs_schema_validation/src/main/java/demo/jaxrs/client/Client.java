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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import demo.jaxrs.server.CustomerService;
import demo.jaxrs.server.data.PasswordPolicyTO;
import demo.jaxrs.server.data.PolicyTO;
import demo.jaxrs.server.data.SyncPolicyTO;

public final class Client {

    private Client() {
    }

    public static void main(String args[]) throws Exception {
    	
//    	marshal();

        List<Object> providers = new ArrayList<Object>();
        providers.add( new JacksonJaxbJsonProvider() );
//        providers.add(new CustomExceptionMapper());
        
        CustomerService service = JAXRSClientFactory.create("http://localhost:9001/", CustomerService.class, providers);
//    	WebClient.client(service).type("application/json").accept("application/json");
    	WebClient.client(service).type("application/xml").accept("application/xml");
    	
//    	Customer customer1 = service.activate(123, "123");
//
//    	Customer customer2 = service.activate(123, "123", new SyncPolicyTO());

//    	List<TaskTO> tasks = service.listTasks(TaskType.NOTIFICATION);
//    	for (TaskTO task : tasks) {
//    		System.out.println(task);
//    	}
    	
//    	service.getCustomer("123");
    	
//    	Customer customer = new Customer();
//    	customer.setId(123);
//    	service.addCustomer(customer);

//		List<PolicyTO> policies = (List<PolicyTO>)service.listByType(PolicyType.PASSWORD);
//    	for (PolicyTO policy : policies) {
//    		System.out.println("Listed Policy: " + policy.getClass());
//    		System.out.println(policy.getType());
//    	}

//    	List<AbstractSchemaTO> schemas = (List<AbstractSchemaTO>)service.listSchemas(AttributableType.ROLE, SchemaType.Boolean);
//    	for (AbstractSchemaTO schema : schemas) {
//    		System.out.println(schema.getName());
//    	}
    	
//    	List<PasswordPolicyTO> policies = service.listTyped();
//    	System.out.println(policies.size());


//    	Customer customer = new Customer();
//    	customer.setId(123);
//    	service.addCustomer(customer);
    	
//    	PolicyTO policyTO = new PasswordPolicyTO();
//		policyTO.setId(1);
//		policyTO = service.create(policyTO);
//		System.out.println("Created policy: " + policyTO.getClass());
//
//    	List<SyncPolicyTO> sPolicies = (List<SyncPolicyTO>)service.listByType(PolicyType.SYNC);
//    	for (PolicyTO policy : sPolicies) {
//    		System.out.println("Read Policy: " + policy.getClass());
//    	}
//    	
//    	policyTO = new SyncPolicyTO();
//    	policyTO = service.create(policyTO);
//		System.out.println("Created policy: " + policyTO.getClass());
//		
//		List<PolicyTO> policiesList = new ArrayList<PolicyTO>();
//    	PasswordPolicyTO pwdPolicyTO1 = new PasswordPolicyTO();
//    	SyncPolicyTO syncPolicyTO2 = new SyncPolicyTO();
//    	policiesList.add(pwdPolicyTO1);
//    	policiesList.add(syncPolicyTO2);
//		
//		boolean test = service.validate(policiesList);
//		System.out.println(test);
		

    	// Sent HTTP GET request to query all customer info
        /*
         * URL url = new URL("http://localhost:9000/customers");
         * System.out.println("Invoking server through HTTP GET to query all
         * customer info"); InputStream in = url.openStream(); StreamSource
         * source = new StreamSource(in); printSource(source);
         */

        // Sent HTTP GET request to query customer info
//        System.out.println("Sent HTTP GET request to query customer info");
//        URL url = new URL("http://localhost:9000/customerservice/customers/123");
//        InputStream in = url.openStream();
//        System.out.println(getStringFromInputStream(in));

        // Sent HTTP GET request to query sub resource product info
//        System.out.println("\n");
//        System.out.println("Sent HTTP GET request to query sub resource product info");
//        url = new URL("http://localhost:9000/customerservice/orders/223/products/323");
//        in = url.openStream();
//        System.out.println(getStringFromInputStream(in));

        // Sent HTTP PUT request to update customer info
//        System.out.println("\n");
//        System.out.println("Sent HTTP PUT request to update customer info");
//        Client client = new Client();
//        String inputFile = client.getClass().getResource("update_customer.xml").getFile();
//        URIResolver resolver = new URIResolver(inputFile);
//        File input = new File(resolver.getURI());
//        PutMethod put = new PutMethod("http://localhost:9000/customerservice/customers");
//        RequestEntity entity = new FileRequestEntity(input, "text/xml; charset=ISO-8859-1");
//        put.setRequestEntity(entity);
//        HttpClient httpclient = new HttpClient();

//        try {
//            int result = httpclient.executeMethod(put);
//            System.out.println("Response status code: " + result);
//            System.out.println("Response body: ");
//            System.out.println(put.getResponseBodyAsString());
//        } finally {
//            // Release current connection to the connection pool once you are
//            // done
//            put.releaseConnection();
//        }

        // Sent HTTP POST request to add customer
//        System.out.println("\n");
//        System.out.println("Sent HTTP POST request to add customer");
//        inputFile = client.getClass().getResource("add_customer.xml").getFile();
//        resolver = new URIResolver(inputFile);
//        input = new File(resolver.getURI());
//        PostMethod post = new PostMethod("http://localhost:9000/customerservice/customers");
//        post.addRequestHeader("Accept" , "text/xml");
//        entity = new FileRequestEntity(input, "text/xml; charset=ISO-8859-1");
//        post.setRequestEntity(entity);
//        httpclient = new HttpClient();
//
//        try {
//            int result = httpclient.executeMethod(post);
//            System.out.println("Response status code: " + result);
//            System.out.println("Response body: ");
//            System.out.println(post.getResponseBodyAsString());
//        } finally {
//            // Release current connection to the connection pool once you are
//            // done
//            post.releaseConnection();
//        }

        System.out.println("\n");
        System.exit(0);
    }

    private static String getStringFromInputStream(InputStream in) throws Exception {
        CachedOutputStream bos = new CachedOutputStream();
        IOUtils.copy(in, bos);
        in.close();
        bos.close();
        return bos.getOut().toString();
    }

    private static void marshal() {
        try {
			JAXBContext jc = JAXBContext.newInstance(PolicyTO.class, PasswordPolicyTO.class, SyncPolicyTO.class);
			PolicyTO element = new PasswordPolicyTO();
			
			Marshaller marshaller = jc.createMarshaller();
			marshaller.marshal(element, System.out);
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
