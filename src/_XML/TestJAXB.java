package _XML;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class TestJAXB {
	
	@Test
	public void object2xml(){
		try {
			JAXBContext jc = JAXBContext.newInstance(Po.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			Po po = new Po(0, "zy", false);
			marshaller.marshal(po, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void xml2obj(){
		try {
			String xml="<po><id>0</id><name>zy</name><status>false</status></po>";
			
			JAXBContext jc = JAXBContext.newInstance(Po.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			
			Po po = (Po) unmarshaller.unmarshal(new StringReader(xml));
			System.out.println(po.getName());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
	}
}
