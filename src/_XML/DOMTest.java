package _XML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMTest {

	public static void main(String[] args) {
		createXml();
	}

	public static void createXml(){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			doc.setXmlVersion("1.0");
			
			Element root = doc.createElement("root");
			Element book = doc.createElement("book");
			book.setAttribute("category", "it");
			Element title = doc.createElement("title");
			title.setTextContent("thinking");
			
			book.appendChild(title);
			root.appendChild(book);
			doc.appendChild(root);
			
			//Êä³ö
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			Source domSource = new DOMSource(doc);
			File xmlFile = new File("./test2.xml");
			transformer.transform(domSource, new StreamResult(xmlFile));
			
			xmlFile.createNewFile();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
