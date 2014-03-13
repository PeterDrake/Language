package edu.lclark.language.questions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class QuestionXMLReader {

	public static final String PATH = System.getProperty("user.dir")
			+ File.separator + "questions.xml";

	private DocumentBuilderFactory docFactory;
	private DocumentBuilder docBuilder;

	public File xmlFile;

	public QuestionXMLReader() {
		try {
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public File loadXMLFile() {
		xmlFile = new File(PATH);
		if (!xmlFile.exists()) {
			try {
				xmlFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return xmlFile;
	}

	public Document parseXMLFile() {
		// if the file is empty, create a new document from scratch
		if (xmlFile.length() == 0) {
			return initializeXMLDocument();
		}
		
		try {
			Document doc = docBuilder.parse(xmlFile);
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Document initializeXMLDocument() {
		Document doc = docBuilder.newDocument();
		doc.appendChild(doc.createElement("test"));
		return doc;
	}
	
	public ArrayList<AbstractQuestion> loadQuestionsFromFile(){
		//TODO: Finish makeQuestion and return the arraylist.
		ArrayList<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();
		Document doc = parseXMLFile();
		
		Element root = doc.getDocumentElement();
		NodeList questionNodes = root.getElementsByTagName("question");
		for(int i = 0; i < questionNodes.getLength(); i++){
			questions.add(makeQuestion(questionNodes.item(i)));
		}
		return null;
	}

	private AbstractQuestion makeQuestion(Node questionNode) {
		//TODO: Finish parsing a question!
		String type = questionNode.getAttributes().getNamedItem("type").getNodeValue();
		return null;
	}

}
