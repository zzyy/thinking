package _XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		createXml();
		readXml();
	}
	
	public static void createXml(){
		try{
			SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
			TransformerHandler handler = factory.newTransformerHandler();
			
			//设置xml属性
			Transformer transformer = handler.getTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "GBK");
			
			File xml = new File("./test.xml");
			//设置保存
			Result xmlResult = new StreamResult(new FileOutputStream(xml));
			handler.setResult(xmlResult);
			
			//xml开始
			handler.startDocument();
			handler.startElement("", "", "root", null);
			
			//新建属性
			AttributesImpl attr = new AttributesImpl();
			attr.addAttribute("", "", "zy:categroy", "", "it");
			
			handler.startElement("uri", "", "zy:book", attr);
			
			handler.startElement("", "", "zy:title", null);
			handler.characters("thinking".toCharArray(), 0, "thinking".toCharArray().length);
			handler.endElement("", "", "zy:title");
			
			handler.startElement("", "", "price", null);
			handler.characters("10".toCharArray(), 0, 2);
			handler.endElement("", "", "price");
			
			handler.endElement("", "", "zy:book");
			handler.endElement("", "", "root");
			
			handler.endDocument();
			
			xml.createNewFile();
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readXml(){
		try {
			File xmlFile = new File("./test.xml");
			
			/*XMLReader reader = XMLReaderFactory.createXMLReader();
			DefaultHandler handler = new MyHandler();
			reader.setContentHandler(handler);
			reader.setErrorHandler(handler);
			
			reader.parse(new InputSource(new FileReader(xmlFile)));*/
			
			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			saxParser.parse(xmlFile, new MyHandler());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}

class MyHandler extends DefaultHandler{

	@Override
	public void startDocument() throws SAXException {
		System.out.println("*start document");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("*end document");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		 System.out.println(" -startElement qName: " + qName +" |uri: "+ uri +" |localName: "+ localName);
		 
		 for(int i=0, length=attributes.getLength(); i<length; i++){
			 System.out.println("   "+attributes.getQName(i) +":"+ attributes.getValue(i));
		 }
	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		System.out.println("   prefix:"+prefix +" |uri:" +uri);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println(" -end Element");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		StringBuffer buffer = new StringBuffer();  
        for(int i = start ; i < start+length ; i++){  
            switch(ch[i]){  
                case '\\':buffer.append("\\\\");break;  
                case '\r':buffer.append("\\r");break;  
                case '\n':buffer.append("\\n");break;  
                case '\t':buffer.append("\\t");break;  
                case '\"':buffer.append("\\\"");break;  
                default : buffer.append(ch[i]);   
            }  
        }  
        System.out.println("  characters("+length+"): "+buffer.toString());  
    
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.err.println("Error ("+e.getLineNumber()+","  
                +e.getColumnNumber()+") : "+e.getMessage());  
	}
	
}
