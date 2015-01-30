package xmlBaza;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import Shared.Article;

public class Test {

	private static boolean testArticleConstructor() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		
		Document xmldoc = docReader.parse(new File("./xml/Articles.xml"));
		Node testItem = xmldoc.getElementsByTagName("item").item(0);
		Article testArticle = new Article(testItem);
		if( testArticle.getId() != 1){
			return false;
		}
		if(testArticle.getAutorId() !=1){
			return false;
		}
		if(testArticle.getPubDate() != 0){
			return false;
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		try {
			if(testArticleConstructor() == false){
				System.err.println("testArticleConstructor false");
			} else{
				System.out.println("Polozio");
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println("testArticleConstructor false");

		}
		
		
	}
}
