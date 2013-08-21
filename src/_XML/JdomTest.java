package _XML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JdomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		createXML();
		readXml();
	}
	
	public static void createXML(){
		Document doc = new Document();
		
		Element root = new Element("root");
		doc.setRootElement(root);
		
		Element book = new Element("book");
		book.setAttribute("categroy", "it");
		root.addContent(book);
		
		Element title = new Element("title");
		title.addContent("think");
		Element price = new Element("price");
		price.addContent("10");
		book.addContent(title);
		book.addContent(price);
		
		File xml = new File("./test.xml");
		//设置输出格式
//		Format format = Format.getCompactFormat();
		Format format = Format.getPrettyFormat();
//		Format format = Format.getRawFormat();
//		format.setIndent("  ");
//		format.setEncoding("GBK");
		XMLOutputter out = new XMLOutputter(format);
		try {
			out.output(doc, new FileOutputStream(xml));
			xml.createNewFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readXml(){
		SAXBuilder builder = new SAXBuilder();
		Document doc = null;
		try {
			doc = builder.build(new File("./test.xml"));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Element root = doc.getRootElement();
		List<Element> children = root.getChildren();
		for(Iterator<Element> iter = children.iterator(); iter.hasNext();){
			Element ele = iter.next();
			System.out.println(ele.getName());
		}
	}
}
