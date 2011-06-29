package org.kirunews.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathHandler {

	private XPath xPath;
	private DocumentBuilder documentBuilder;
	private Document dom;
	
	public XPathHandler(String content) {
		init();
		this.dom = createDom(content);
	}
	
	private void init() {
		XPathFactory factory = XPathFactory.newInstance();
		xPath = factory.newXPath();

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			documentBuilder = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public String getContent(String xpath) throws XPathExpressionException {
		//System.out.println(xpath);
		// get nodes with xpath
		NodeList results;
		results = (NodeList) xPath.evaluate(xpath, dom, XPathConstants.NODESET);

		// get content
		StringBuffer content = new StringBuffer();
		for(int i=0; i<results.getLength(); i++) {
			Node item = results.item(i);
			content.append(item.getTextContent());
		}
		return content.toString();
	}

	/**
	 * Creates DOM object from InptStream
	 * @param content
	 * @return
	 */
	private Document createDom(InputStream content) {
		Document dom = null;
		try {
			dom = documentBuilder.parse(content);
		} catch(SAXException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return dom;
	}

	/** 
	 * Create a DOM object from file
	 * @param fileName The path of the file
	 * @return
	 */
	private Document createDom(String content) {
		Document dom = null;
		try {
			dom = createDom(new ByteArrayInputStream(content.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return dom;
	}
	
	public void setNamespaceContext(NamespaceContext nsContext) {
		xPath.setNamespaceContext(nsContext);
	}

}
