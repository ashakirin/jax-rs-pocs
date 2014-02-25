package demo.jaxrs.client;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import com.example.customerservice.Customer;

public class WebClientTest {

    public static void main(String args[]) throws Exception {
    	
        // List<Object> providers = new ArrayList<Object>();
        WebClient wc = WebClient.create("http://localhost:9000/customerservice/customers/subresource/test");

       Customer customer = new Customer();
        customer.setCustomerId(123);
        Response r = wc.put(customer);
        System.out.println(r.getStatus());

//        Response r = wc.get();
//        System.out.println(r.readEntity(Customer.class));
    }
}
