package edu.lclark.language.questions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.lclark.language.LanguagePlacementTest;
import edu.lclark.language.questions.QuestionInfo.QuestionType;

public class QuestionXMLReader {

	private DocumentBuilderFactory docFactory;
	private DocumentBuilder docBuilder;
	private String path; 
	public File xmlFile;

	public QuestionXMLReader() {
		try {
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
		} catch (Exception e) {
			e.printStackTrace();
		}
		path = QuestionInfo.QUESTIONS_PATH;
	}
	
	public void setTestPath(){
		path = QuestionInfo.TEST_QUESTIONS_PATH;
	}

	public File loadXMLFile() {
		xmlFile = new File(path);
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
		ArrayList<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();
		Document doc = parseXMLFile();
		
		NodeList questionNodes = doc.getElementsByTagName("question");
		for(int i = 0; i < questionNodes.getLength(); i++){
			questions.add(makeQuestion(questionNodes.item(i)));
		}
		return questions;
	}

	public AbstractQuestion makeQuestion(Node questionNode) {
		
		String type = questionNode.getAttributes().getNamedItem("type").getNodeValue();
		String level = questionNode.getAttributes().getNamedItem("level").getNodeValue();
		
		AbstractQuestion newQuestion = null;
		
		if(type.equals(QuestionType.MULTIPLE_CHOICE.toString())){
			newQuestion = new MultipleChoiceQuestion();
		} else if (type.equals(QuestionType.FILL_IN_THE_BLANK.toString())){
			newQuestion = new FillInTheBlankQuestion();
		} else if (type.equals(QuestionType.SHORT_ANSWER.toString())){
			newQuestion = new ShortAnswerQuestion();
		}
		//can add more if statements as we add more question types
		
		newQuestion.setLevel(QuestionInfo.createQuestionLevel(level));
		
		NodeList questionNodeList = questionNode.getChildNodes();
		newQuestion.setText(questionNodeList.item(0).getTextContent());
		
		String[] answers = getStringsFromNode(questionNodeList.item(1));
		newQuestion.setAnswers(answers);
		
		String[] correctAnswers = getStringsFromNode(questionNodeList.item(2));
		newQuestion.setCorrectAnswers(correctAnswers);
		
		return newQuestion;
	}
	
	private String[] getStringsFromNode(Node nodeWithChildNodes){
		
		int quantity = Integer.parseInt(nodeWithChildNodes.getAttributes().getNamedItem("quantity").getNodeValue());
		NodeList childrenNodes = nodeWithChildNodes.getChildNodes();
		String[] strings = new String[quantity];
		for(int i = 0; i < quantity; i++){
			strings[i] = childrenNodes.item(i).getTextContent();
		}
		return strings;
		
	}

}
