package demo.local.factory.common;

import org.apache.cxf.Bus;

public class SharedTransportInitializer {
	
	public SharedTransportInitializer(final Bus bus) {
		LocalTransportFactoryHolder.initSharedFactory(bus);
	}

}
