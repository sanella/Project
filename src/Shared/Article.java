package Shared;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class Article {

	private int id;
	private String title;
	private int pubDate;
	private int autorId;
	private String content;

	public Article(int id, String title, int pubDate, int autorId,
			String content) {
		super();
		this.id = id;
		this.title = title;
		this.pubDate = pubDate;
		this.autorId = autorId;
		this.content = content;
	}

	public Article(Node current) {

		if (current instanceof Element) {
			Element currentElement = (Element) current;
			// parsamo jer je int
			this.id = Integer.parseInt(currentElement.getAttribute("id"));

			NodeList xmlChildren = current.getChildNodes();

			for (int i = 0; i < xmlChildren.getLength(); i++) {
				Node currentChild = xmlChildren.item(i);
				if (currentChild instanceof Element) {
					Element currentChildElement = (Element) currentChild;

					if (currentChildElement.getTagName().equals("title")) {
						this.title = currentChildElement.getTextContent();
					}

					if (currentChildElement.getTagName().equals("clanak")) {
						this.content = currentChildElement.getTextContent();
					}

					if (currentChildElement.getTagName().equals("pubDate")) {
						this.pubDate = Integer.parseInt(currentChildElement
								.getTextContent());
					}

					if (currentChildElement.getTagName().equals("autor")) {
						this.autorId = Integer.parseInt(currentChildElement
								.getAttribute("id"));
					}
				}
			}

		} else {
			System.err.println("Not instance of Element");
			
		}		
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getPubDate() {
		return pubDate;
	}

	public int getAutorId() {
		return autorId;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", pubDate="
				+ pubDate + ", autorId=" + autorId + ", content=" + content
				+ "]";
	}

}
