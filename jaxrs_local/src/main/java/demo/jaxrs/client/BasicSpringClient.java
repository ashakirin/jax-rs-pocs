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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.jaxrs.server.CustomerService;
import demo.jaxrs.server.data.PolicyTO;
import demo.jaxrs.server.data.PolicyType;




public final class BasicSpringClient {

    private BasicSpringClient() {
    }

    public static void main(String args[]) throws Exception {
    	startServer();
        Thread.sleep(1000);

        // Initialize the spring context and fetch our test client    	
        ClassPathXmlApplicationContext context 
            = new ClassPathXmlApplicationContext(new String[] {"classpath:client-applicationContext.xml"});
        CustomerService proxy = (CustomerService)context.getBean("restClient");

        List<PolicyTO> policies = (List<PolicyTO>)proxy.listByType(PolicyType.PASSWORD);
    	for (PolicyTO policy : policies) {
    		System.out.println("Policy: " + policy.getId());
    	}

//		List<TaskTO> tasks = (List<TaskTO>)proxy.listTasks(TaskType.NOTIFICATION);
//    	for (TaskTO task : tasks) {
//    		System.out.println("Listed Policy: " + task.getClass());
//    	}


//    	List<AbstractSchemaTO> schemas = (List<AbstractSchemaTO>)proxy.listSchemas(AttributableType.ROLE, SchemaType.Boolean);
//    	for (AbstractSchemaTO schema : schemas) {
//    		System.out.println(schema.getName());
//    	}
    }
    
    public static void startServer() {
    	ExecutorService executor = Executors.newFixedThreadPool(1);
    	executor.execute(new Runnable() {
			
			@Override
			public void run() {
		        new ClassPathXmlApplicationContext(new String[] {"classpath:server-applicationContext.xml"});
			}
		});
    }
}
