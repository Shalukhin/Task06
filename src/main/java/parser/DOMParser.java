package parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParser {
	
	private File file;
	
	public void parseFile() {
		file = new File(this.getClass().getClassLoader().getResource("temp.xml").getFile());
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			Element el = doc.getDocumentElement();
			NodeList childs = el.getChildNodes();
			Node node;
			for (int i = 0; i < childs.getLength(); i++) {
				//NodeList nl = childs.item(i).getChildNodes();
//				for (int j = 0; j < nl.getLength(); j++) {
//					System.out.println("<" + nl.item(j).getNodeName() + " == " + nl.item(j).getNodeValue() + ">");
//				}
				
				node = childs.item(i);
				System.out.println(node.getNodeName() + "  " + node.getUserData("model"));
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		
		
		
		
		
		
	}

}
