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

package com.example.customerservice.client;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.InitializingBean;

import com.example.customerservice.Customer;
import com.example.customerservice.CustomerService;

public final class CustomerServiceTester implements InitializingBean {

	private CustomerService localCustomerService;
	private CustomerService httpCustomerService;

	public void setLocalCustomerService(CustomerService localCustomerService) {
		this.localCustomerService = localCustomerService;
	}

	public void setHttpCustomerService(CustomerService httpCustomerService) {
		this.httpCustomerService = httpCustomerService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		if (null == localCustomerService) {
			System.out.println("Consumer is NULL!");
			return;
		}

		System.out.println("Sending request for customers named Smith");

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					System.out.println("*****************************");
					System.out.println("1. Invoke using local transport");
					System.out.println("Client thread: " + Thread.currentThread());
					invokeService(localCustomerService);
					System.out.println("\n\n*****************************");
					System.out.println("2. Invoke using http transport");
					invokeService(httpCustomerService);
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new RuntimeException(ex);
				}
			}
		}, 1000);
	}

	private void invokeService(CustomerService client) {
		if (client == null) {
			return;
		}
		Customer customer = client.getCustomer("John");

		System.out.println("Customer: " + customer.getCustomerId()
				+ "; " + customer.getName() + "; "
				+ customer.getAddress());
		customer.setCustomerId(23);
		customer.setRevenue(1000);
		customer.setName("Bob");
		customer.getAddress().add("address1");
		// customer.getAddress().add("address2");

		client.updateCustomer(customer);
	}
}
