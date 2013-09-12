package _ws.jaxws;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Element;

public class HandlerA implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean isOut = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(isOut){
			Iterator<String> iterator = context.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				Object value = context.get(key);
				System.out.println(key +">>"+value);
			}
			
			try {
				System.out.println("**************");
				SOAPMessage msg = context.getMessage();
				msg.writeTo(System.out);
				System.out.println();
//				SOAPBody body= msg.getSOAPPart().getEnvelope().getBody();
//				body.getElementsByTagName("result").item(0).setNodeValue("zxc");
				SOAPEnvelope envelope = msg.getSOAPPart().getEnvelope();
				SOAPHeader head = envelope.getHeader();
				if(head == null){
					head = envelope.addHeader();
				}
				head.addHeaderElement(new QName("-*-*-*", "head"));
				msg.writeTo(System.out);
			} catch (SOAPException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
