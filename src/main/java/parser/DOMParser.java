package parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMParser {
	
	private File file;
	
	public void parseFile() {
		file = new File(this.getClass().getClassLoader().getResource("comp.xml").getFile());
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			Element el = doc.getDocumentElement();
			NodeList childs = el.getChildNodes();
			System.out.println(childs.item(3).getTextContent());
			//System.out.println(childs.item(0).getNodeValue());
			//System.out.println(childs.item(0).getNodeType());
			//System.out.println(el.getNodeName());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		
		
		
		
		
		
	}

}
