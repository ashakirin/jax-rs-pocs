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

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.springframework.beans.factory.InitializingBean;

import com.example.customerservice.Customer;
import com.example.customerservice.CustomerService;

import demo.local.factory.common.LocalTransportFactoryHolder;

public final class CustomerServiceTester implements InitializingBean {
    
    private Bus bus;
    private CustomerService customerService;
    
    public void setBus(Bus bus) {
		this.bus = bus;
	}

	public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        if (null == customerService) {
            System.out.println("Consumer is NULL!");
            return;
        }

		LocalTransportFactoryHolder.initSharedFactory(bus);
        System.out.println("*** Client: initialized with shared factory ***");
        System.out.println("Sending request for customers named Smith");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Customer customer = new Customer();
                    customer.setName("Smith");
                    customerService.updateCustomer(customer);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }
            }
        }, 1000);
    }

}
