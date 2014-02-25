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
package com.example.customerservice.server;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.example.customerservice.Customer;
import com.example.customerservice.CustomerService;

public class CustomerServiceMapBased implements CustomerService  {
    long currentId = 123;
    Map<String, Customer> customers = new HashMap<String, Customer>();

    public CustomerServiceMapBased() {
		init();
    }
    
    final void init() {
        Customer c = new Customer();
        c.setName("John");
        customers.put(c.getName(), c);

    }

    @Override
    public Customer getCustomer(String name) {
        System.out.println("getCustomer");
        System.out.println("----invoking getCustomer, Customer name is: " + name);
		System.out.println("Service thread: " + Thread.currentThread());
        Customer c = customers.get(name);
        c.getAddress().add("address1");
        return c;
    }

    @Override
    public Response updateCustomer(Customer customer) {
        System.out.println("----invoking updateCustomer, Customer name is: " + customer.getName() + "; " + customer.getRevenue() + "; " + customer.getAddress());
        return Response.ok().build();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        System.out.println("----invoking addCustomer, Customer name is: " + customer.getName());
        customers.put(customer.getName(), customer);
        return customer;
    }

	@Override
    public Response deleteCustomer(String id) {
        System.out.println("----invoking deleteCustomer, Customer id is: " + id);
        long idNumber = Long.parseLong(id);
        Customer c = customers.get(idNumber);

        Response r;
        if (c != null) {
            r = Response.ok().build();
            customers.remove(idNumber);
        } else {
            r = Response.notModified().build();
        }

        return r;
    }

}
