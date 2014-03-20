package edu.lclark.language.questions;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class QuestionXMLWriter {
	
	public static final String PATH = System.getProperty("user.dir") + File.separator + "questions.xml";
	
	private DocumentBuilderFactory docFactory;
	private DocumentBuilder docBuilder;
	private TransformerFactory transformerFactory;
	private Transformer transformer;
	

	private Document document;

	public QuestionXMLWriter() {
		try {
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			transformerFactory = TransformerFactory.newInstance();
			transformer = transformerFactory.newTransformer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createNewDocument() {
		document = docBuilder.newDocument();
	}
	
	public void fillXMLDocument(ArrayList<AbstractQuestion> questions){
		Element rootElement = document.createElement("test");
		document.appendChild(rootElement);
		
		for(AbstractQuestion question: questions){
			rootElement.appendChild(createQuestionXMLNode(question));
		}
	}

	public Element createQuestionXMLNode(AbstractQuestion question) {

		Element questionElement = document.createElement("question");
		
		questionElement.setAttribute("type", question.getQuestionType().toString());
		questionElement.setAttribute("level",
				question.getLevel());

		Element questionText = document.createElement("text");
		questionText
				.appendChild(document.createTextNode(question.getText()));
		questionElement.appendChild(questionText);

		Element answers = document.createElement("answers");
		answers.setAttribute("quantity",
				Integer.toString(question.getNumberOfAnswers()));
		questionElement.appendChild(answers);
		for (int i = 0; i < question.getNumberOfAnswers(); i++) {
			Element answer = document.createElement("answer");
			answer.appendChild(document.createTextNode(question.getAnswerAtIndex(i)));
			answers.appendChild(answer);
		}

		Element correctAnswers= document.createElement("correct-answers");
		correctAnswers.setAttribute("quantity", Integer.toString(question.getNumberOfCorrectAnswers()));
		
		for(int i = 0; i < question.getNumberOfCorrectAnswers(); i++){
			Element correctAnswer = document.createElement("correct");
			correctAnswer.appendChild(document.createTextNode(question
					.getCorrectAnswerAtIndex(i)));
			
			correctAnswers.appendChild(correctAnswer);
		}
		
		questionElement.appendChild(correctAnswers);
		
		return questionElement;
	}

	public void writeToFile() {
		try {
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(PATH));
			//transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getDocumentString() {
		try {
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(
					writer));
			String output = writer.getBuffer().toString()
					.replaceAll("\n|\r", "");
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
}
