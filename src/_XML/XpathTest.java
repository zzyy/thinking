package _XML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.mysql.jdbc.BufferRow;

public class XpathTest {

	@Test
	public void testXpath() throws Exception{
		
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true); // never forget this!
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    Document doc = builder.parse("test.xml");

	    XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
	    XPathExpression expr = xpath.compile("//book");

	    Object result = expr.evaluate(doc, XPathConstants.NODESET);
	    NodeList nodes = (NodeList) result;
	    for (int i = 0; i < nodes.getLength(); i++) {
	        System.out.println(nodes.item(i).getNodeValue()); 
	    }
	}
	
	@Test
	public void testXpathNameSpace() throws Exception{
		
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true); // never forget this!
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    Document doc = builder.parse("test.xml");

	    XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
	    xpath.setNamespaceContext(new NamespaceContext() {
			public Iterator getPrefixes(String namespaceURI) {return null;}
			
			public String getPrefix(String namespaceURI) {return null;}
			
			public String getNamespaceURI(String prefix) {
				if("zy".equalsIgnoreCase(prefix)){
					return "zy";
				}
				return XMLConstants.NULL_NS_URI;
			}
		});
	    XPathExpression expr = xpath.compile("//book[1]");

	    Object result = expr.evaluate(doc, XPathConstants.NODE);
	    
	    XPath xpath2 = factory.newXPath();
	    String title = xpath2.evaluate("//title[1]/text()", result);
	    System.out.println(title);
	    
	}
	
	@Test
	public void testXpath_String() throws Exception{
		
		File xml = new File("test.xml");
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(xml)));
		String doc="";
		for(String tmp = in.readLine(); tmp !=null; tmp=in.readLine()){
			doc =doc + tmp.trim();
		}
		System.out.println(doc);

	    XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
	    XPathExpression expr = xpath.compile("//book");

	    Object result = expr.evaluate(new InputSource(new StringReader(doc)), XPathConstants.NODESET);
	    NodeList nodes = (NodeList) result;
	    for (int i = 0; i < nodes.getLength(); i++) {
	        System.out.println(nodes.item(i).getNodeValue()); 
	    }
	}
}
