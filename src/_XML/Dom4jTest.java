package _XML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jTest {

	/**
	 * @param args
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws DocumentException {
//		createXml();
		readXml();
	}
	
	public static void createXml(){
		Document doc = DocumentHelper.createDocument();
		Element  root = doc.addElement("root");
		
		Element book = root.addElement("book");
		book.addAttribute("categroy", "it");
		Element title = book.addElement("title");
		title.setText("think");
		Element price = book.addElement("price");
		price.setText("10");
		
		File xml = new File("./test.xml");
		try {
//			XMLWriter out = new XMLWriter(new FileOutputStream(xml));
			XMLWriter out = new XMLWriter(new FileOutputStream(xml), OutputFormat.createPrettyPrint());
			
			out.write(doc);
			xml.createNewFile();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readXml() throws DocumentException{
		File xml = new File("./test.xml");
		SAXReader reader = new SAXReader();
			Document doc = reader.read(xml);
			Element root = doc.getRootElement();
			List<Element> books = root.elements();
			for(Iterator<Element> iter=books.iterator(); iter.hasNext(); ){
				Element bookEle = iter.next();
				System.out.println(bookEle.attributeValue("categroy"));
				Element title = bookEle.element("title");
				Element price = bookEle.element("price");
				
				System.out.println(title.getName());
				System.out.println(price.getName());
			}
	}
}
