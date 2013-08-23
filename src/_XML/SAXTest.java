package _XML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class SAXTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		createXml();
	}
	
	public static void createXml(){
		try{
			SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
			TransformerHandler handler = factory.newTransformerHandler();
			
			//设置xml属性
			Transformer transformer = handler.getTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			
			File xml = new File("./test.xml");
			//设置保存
			Result xmlResult = new StreamResult(new FileOutputStream(xml));
			handler.setResult(xmlResult);
			
			//xml开始
			handler.startDocument();
			handler.startElement("", "", "root", null);
			
			//
			AttributesImpl attr = new AttributesImpl();
			attr.addAttribute("", "", "categroy", "", "it");
			
			handler.startElement("", "", "book", attr);
			handler.startElement("", "", "title", null);
			handler.characters("thinking".toCharArray(), 0, "thinking".toCharArray().length);
			
			handler.endElement("", "", "title");
			handler.endElement("", "", "boot");
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
}
