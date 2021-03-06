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

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

import com.example.customerservice.Customer;

import demo.jaxrs.server.data.AbstractSchemaTO;
import demo.jaxrs.server.data.AttributableType;
import demo.jaxrs.server.data.DerivedSchemaTO;
import demo.jaxrs.server.data.NotificationTaskTO;
import demo.jaxrs.server.data.PasswordPolicyTO;
import demo.jaxrs.server.data.PolicyTO;
import demo.jaxrs.server.data.PolicyType;
import demo.jaxrs.server.data.PropagationTaskTO;
import demo.jaxrs.server.data.SchedTaskTO;
import demo.jaxrs.server.data.SchemaTO;
import demo.jaxrs.server.data.SchemaType;
import demo.jaxrs.server.data.SyncPolicyTO;
import demo.jaxrs.server.data.SyncTaskTO;
import demo.jaxrs.server.data.TaskTO;
import demo.jaxrs.server.data.TaskType;

public class CustomerProxy implements CustomerService {
    long currentId = 123;
    Map<String, Customer> customers = new HashMap<String, Customer>();

    public CustomerProxy() {
        init();
    }

    @Override
    public Customer getCustomer(String name) {
        System.out.println("getCustomer");
        System.out.println("----invoking getCustomer, Customer name is: " + name);
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

    @Override
    public List<? extends PolicyTO> listByType(final PolicyType type) {
//  public List<PasswordPolicyTO> listByType(final PolicyType type) {
    	System.out.println("Type: " + type);
		List<PolicyTO> list = new ArrayList<PolicyTO>();
//   	if (type == PolicyType.PASSWORD) {
    		PasswordPolicyTO passwordPolicy = new PasswordPolicyTO(true);
    		passwordPolicy.setId(1);
    		passwordPolicy.setSpecification("strongPasswordPolicy");
    		System.out.println(passwordPolicy.getType());
    		list.add(passwordPolicy);
//    	} else if (type == PolicyType.SYNC) {
    		SyncPolicyTO syncPolicy = new SyncPolicyTO();
    		syncPolicy.setId(2);
    		syncPolicy.setSpecification("weakPasswordPolicy");
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
        customers.put(c.getName(), c);

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

	@Override
	public List<? extends AbstractSchemaTO> listSchemas(
			AttributableType kind,
			SchemaType type) {
    	System.out.println("Type: " + type);
    	System.out.println("Kind: " + kind);
		List<AbstractSchemaTO> list = new ArrayList<AbstractSchemaTO>();
    		SchemaTO schemaTO = new SchemaTO();
    		schemaTO.setType(SchemaType.Boolean);
    		schemaTO.setName("schema");
    		list.add(schemaTO);

    		DerivedSchemaTO dSchemaTO = new DerivedSchemaTO();
    		dSchemaTO.setName("dschema");
    		list.add(dSchemaTO);
		return list;
	}

	@Override
	public <T extends TaskTO> List<T> listTasks(TaskType taskType) {
		System.out.println(taskType);
		List<TaskTO> list = new ArrayList<TaskTO>();
		
		NotificationTaskTO nTask = new NotificationTaskTO();
		SyncTaskTO sTask = new SyncTaskTO();
		SchedTaskTO schTask = new SchedTaskTO();
		PropagationTaskTO pTask = new PropagationTaskTO();
		
		list.add(nTask);
		list.add(sTask);
		list.add(schTask);
		list.add(pTask);
		
		return (List<T>) list;
	}

	@Override
	public Customer activate(long userId, String token) {
		System.out.println("Activate");
		// TODO Auto-generated method stub
		return new Customer();
	}

	@Override
	public Customer activate(long userId, String token, SyncPolicyTO policyTO) {
		// TODO Auto-generated method stub
		System.out.println("Activate with policy");
		return new Customer();
	}

	@Override
	public SubResource updateSubresourceCustomer() {
		System.out.println(" ++ returning locator ++");
		return new SubResource();
	}

	@Override
	public SubResource getSubresourceCustomer() {
		System.out.println(" ++ returning locator ++");
		return new SubResource();
	}

//	@Override
//	public <T extends TaskTO> List<T> listTasks(TaskType taskType,
//			int page,
//			int size) {
//		// TODO Auto-generated method stub
//		System.out.println(taskType);
//		System.out.println(page + " - " + size);
//		return null;
//	}

}
