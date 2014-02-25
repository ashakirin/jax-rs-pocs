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

import java.util.List;

import javax.xml.ws.BindingProvider;

import junit.framework.Assert;

import com.example.customerservice.Customer;
import com.example.customerservice.CustomerService;
import com.example.customerservice.NoSuchCustomerException;

public final class CustomerServiceTester {
    
    // The CustomerService proxy will be injected either by spring or by a direct call to the setter 
    CustomerService customerService;
    
    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void testCustomerService() throws NoSuchCustomerException {
    	
        List<Customer> customers = null;
        
        // First we test the positive case where customers are found and we retreive
        // a list of customers
        System.out.println("Sending request for customers named Smith");
//        BindingProvider bc = (BindingProvider) customerService;
//        bc.getRequestContext().put(key, value);

        
        customers = customerService.getCustomersByName("Smith");
        System.out.println("Response received");
        
        // Then we test for an unknown Customer name and expect the NoSuchCustomerException
//        try {
//            customers = customerService.getCustomersByName("None");
//        } catch (NoSuchCustomerException e) {
//            System.out.println(e.getMessage());
//            System.out.println("NoSuchCustomer exception was received as expected");
//        }
        
        // The implementation of updateCustomer is set to sleep for some seconds. 
        // Still this method should return instantly as the method is declared
        // as a one way method in the WSDL
        
        System.out.println("All calls were successful");
    }

}
