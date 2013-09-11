package _ws.jaxws;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import javax.xml.ws.Service;

import org.junit.Test;
import org.w3c.dom.Document;

public class TestSOAP {

	@Test
	public void test1(){
		try {
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage();
			
			SOAPPart part = message.getSOAPPart();
			SOAPEnvelope envelope = part.getEnvelope();
			SOAPBody body = envelope.getBody();
			
			QName qName = new QName("http://jaxws._ws/", "sayHi", "hw");
			SOAPElement ele = body.addBodyElement(qName);
			ele.addChildElement("name").setValue("zy");
			
			message.writeTo(System.out);
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test2(){
		try {
			QName sQName = new QName("http://jaxws._ws/", "HelloWorldImpService");
			URL sUrl = new URL("http://localhost:8888/helloWorld?wsdl");
			Service service = Service.create(sUrl, sQName);
			
			Dispatch<SOAPMessage> dispatch = service.createDispatch(
					new QName("http://jaxws._ws/", "HelloWorldImpPort"), 
					SOAPMessage.class, Service.Mode.MESSAGE);
			
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage();
			SOAPPart part = message.getSOAPPart();
			SOAPEnvelope envelope = part.getEnvelope();
			SOAPBody body = envelope.getBody();
			QName qName = new QName("http://jaxws._ws/", "sayHi", "hw");
			SOAPElement ele = body.addBodyElement(qName);
			ele.addChildElement("name").setValue("zy");
			
			message.writeTo(System.out);
			
			SOAPMessage responseMessage =  dispatch.invoke(message);
			
			Document doc = responseMessage.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
			String result = doc.getElementsByTagName("result").item(0).getTextContent();
			System.out.println();
			System.out.println(result);
			
			responseMessage.writeTo(System.out);
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3(){
		try {
			QName sQName = new QName("http://jaxws._ws/", "HelloWorldImpService");
			URL sUrl = new URL("http://localhost:8888/helloWorld?wsdl");
			Service service = Service.create(sUrl, sQName);
			
			Dispatch<Source> dispatch = service.createDispatch(
					new QName("http://jaxws._ws/","HelloWorldImpPort"), 
					Source.class, Service.Mode.PAYLOAD);
			
			String msg="<hw:sayHi xmlns:hw=\"http://jaxws._ws/\"><name>asd</name></hw:sayHi>";
			System.out.println(msg);
			StreamSource streamSource = new StreamSource(new StringReader(msg));
			
			Source responseSource = dispatch.invoke(streamSource);
			DOMResult result = new DOMResult();
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(responseSource, result);
			Document doc = (Document) result.getNode();
			System.out.println(doc.getElementsByTagName("result").item(0).getTextContent()); 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	

}
