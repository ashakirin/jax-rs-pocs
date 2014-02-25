package demo.jaxrs.client;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import demo.jaxrs.server.Customer;

public class WebClientTest {

    public static void main(String args[]) throws Exception {
    	
        // List<Object> providers = new ArrayList<Object>();
        WebClient wc = WebClient.create("http://localhost:9000/customerservice/customers/1");
//        WebClient.getConfig(wc).getRequestContext().put("TEST_CONTEXT_PROPERTY", "my test value");
        Response r = wc.get();
        Customer customer = r.readEntity(Customer.class);
        System.out.println(customer.getId());

    }
}
