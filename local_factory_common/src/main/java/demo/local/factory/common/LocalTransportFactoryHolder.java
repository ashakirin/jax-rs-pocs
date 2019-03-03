package demo.local.factory.common;

import org.apache.cxf.Bus;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.apache.cxf.transport.local.LocalConduit;
import org.apache.cxf.transport.local.LocalTransportFactory;

public class LocalTransportFactoryHolder {
	private static LocalTransportFactory factory;


	public static synchronized void initSharedFactory(Bus bus) {		
		if (factory == null) {
			factory = new LocalTransportFactory();
		}
		bus.setProperty(LocalConduit.DIRECT_DISPATCH, "true");
		DestinationFactoryManager dfm = bus
				.getExtension(DestinationFactoryManager.class);
		for (String ns : factory.getTransportIds()) {
			dfm.registerDestinationFactory(ns, factory);
		}
		ConduitInitiatorManager cim = bus
				.getExtension(ConduitInitiatorManager.class);
		for (String ns : factory.getTransportIds()) {
			cim.registerConduitInitiator(ns, factory);
		}
		bus.setExtension(factory, LocalTransportFactory.class);
		
//		initHttpFactories(bus);
	}
	
//	private static void initHttpFactories(Bus bus) {
//		new SoapTransportFactory(bus);
//		new HTTPTransportFactory(bus);
//	}
}
