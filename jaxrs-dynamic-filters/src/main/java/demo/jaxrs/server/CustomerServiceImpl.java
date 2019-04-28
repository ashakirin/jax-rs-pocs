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
package demo.jaxrs.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

@ResourceIdentifier("CustomerServiceResourceImpl")
public class CustomerServiceImpl implements CustomerService {
    long currentId = 123;
    Map<Long, Customer> customers = new HashMap<Long, Customer>();
    Map<Long, Order> orders = new HashMap<Long, Order>();

    public CustomerServiceImpl() {
        init();
    }

    @Override
    public Customer getCustomer(String id) {
        System.out.println("----invoking getCustomer, Customer id is: " + id);
        long idNumber = Long.parseLong(id);
        Customer c = customers.get(idNumber);
        return c;
    }

    @Override
    public Response updateCustomer(Customer customer) {
        System.out.println("----invoking updateCustomer, Customer name is: " + customer.getName());
        Customer c = customers.get(customer.getId());
        Response r;
        if (c != null) {
            customers.put(customer.getId(), customer);
            r = Response.ok().build();
        } else {
            r = Response.notModified().build();
        }

        return r;
    }

    @Override
    public Response addCustomer(Customer customer) {
        System.out.println("----invoking addCustomer, Customer name is: " + customer.getName());
        customer.setId(++currentId);

        customers.put(customer.getId(), customer);

        return Response.ok(customer).build();
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

    @Override
    public Order getOrder(String orderId) {
        System.out.println("----invoking getOrder, Order id is: " + orderId);
        long idNumber = Long.parseLong(orderId);
        Order c = orders.get(idNumber);
        return c;
    }

    @Override
    public List<? extends PolicyTO> listByType(final PolicyType type) {
//  public List<PasswordPolicyTO> listByType(final PolicyType type) {
		List<PolicyTO> list = new ArrayList<PolicyTO>();
//   	if (type == PolicyType.PASSWORD) {
    		PasswordPolicyTO passwordPolicy = new PasswordPolicyTO();
    		passwordPolicy.setId(1);
    		passwordPolicy.setSpecification("test");
    		list.add(passwordPolicy);
//    	} else if (type == PolicyType.SYNC) {
    		SyncPolicyTO syncPolicy = new SyncPolicyTO();
    		syncPolicy.setId(1);
    		syncPolicy.setSpecification("test");
    		list.add(syncPolicy);
//    	}
		return list;
    }
    
 	@Override
	public <T extends PolicyTO> T create(T policyTO) {
		System.out.println(policyTO.getClass());
		System.out.println(policyTO.getType());
		PasswordPolicyTO passwordPolicy = new PasswordPolicyTO();
		passwordPolicy.setId(1);
		passwordPolicy.setSpecification("test");
		return (T) passwordPolicy;
	}

    final void init() {
        Customer c = new Customer();
        c.setName("John");
        c.setId(123);
        customers.put(c.getId(), c);

        Order o = new Order();
        o.setDescription("order 223");
        o.setId(223);
        orders.put(o.getId(), o);
    }

	@Override
	public <T extends PolicyTO> boolean validate(List<T> policies) {
		for (PolicyTO policyTO : policies) {
			System.out.println("Validate policy class: " + policyTO.getClass());
		}
		return false;
	}

	@Override
	public List<PasswordPolicyTO> listTyped() {
		List<PasswordPolicyTO> list = new ArrayList<PasswordPolicyTO>();
		PasswordPolicyTO passwordPolicy = new PasswordPolicyTO();
		passwordPolicy.setId(1);
		passwordPolicy.setSpecification("test");
		list.add(passwordPolicy);
		return list;
	}

}
