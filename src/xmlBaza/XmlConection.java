package xmlBaza;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlConection {

	private DocumentBuilder docReader;
	private Document xmldoc;

	// konstruktor
	public XmlConection() throws ParserConfigurationException {
		docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	}

	public void setDocument(String tableName)
			throws ParserConfigurationException, SAXException, IOException {
		String path = "./xml/" + tableName + ".xml";

		xmldoc = docReader.parse(new File(path));
	}

	public NodeList query(String tableName, String query)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		setDocument(tableName);
		query = "//item";
		XPath xPath = XPathFactory.newInstance().newXPath();
		NodeList xmlNodeList = (NodeList) xPath.compile(query).evaluate(xmldoc,
				XPathConstants.NODESET);
		return xmlNodeList;
	}

}
