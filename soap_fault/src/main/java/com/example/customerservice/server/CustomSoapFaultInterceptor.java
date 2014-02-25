package com.example.customerservice.server;

import java.io.ByteArrayInputStream;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;

public class CustomSoapFaultInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	
	public CustomSoapFaultInterceptor() {
		super(Phase.WRITE);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		Exception e = message.getContent(Exception.class);
		if (e instanceof Fault) {
			Fault fault = (Fault) e;
			fault.setMessage("This is a critical fault");
			fault.setFaultCode(new QName("ns", "CriticalFault"));
			try {
				DocumentBuilder builder = getBuilder();
				Document doc = builder.parse(new ByteArrayInputStream("<detail><critical>critical details</critical></detail>".getBytes()));
				fault.setDetail(doc.getDocumentElement());
			} catch (Exception e1) {
				System.out.println("Cannot build detail element: " + e.getMessage());
			}
		}
	}

	private DocumentBuilder getBuilder() throws ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		return dbf.newDocumentBuilder();
	}

}
