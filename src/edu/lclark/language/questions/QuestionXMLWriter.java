package edu.lclark.language.questions;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * This class handles writing new XML files based on an ArrayList of
 * AbstractQuestions.
 * 
 * @author Team Language
 * 
 */
public class QuestionXMLWriter {

	private DocumentBuilderFactory docFactory;
	private DocumentBuilder docBuilder;
	private TransformerFactory transformerFactory;
	private Transformer transformer;
	private String path;

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
		path = QuestionInfo.QUESTIONS_PATH;
	}

	public void setTestPath() {
		path = QuestionInfo.TEST_QUESTIONS_PATH;
	}

	public String getPath() {
		return path;
	}

	public void createNewDocument() {
		document = docBuilder.newDocument();
	}

	/**
	 * Fills the document field with Nodes created from an ArrayList of
	 * AbstractQuestions.
	 * 
	 * @param questions
	 *            An ArrayList of AbstractQuestions.
	 */
	public void fillXMLDocument(ArrayList<AbstractQuestion> questions) {
		Element rootElement = document.createElement("test");
		document.appendChild(rootElement);

		for (AbstractQuestion question : questions) {
			rootElement.appendChild(createQuestionXMLNode(question));
		}
	}

	/**
	 * Creates a Node based on the AbstractQuestion.
	 * 
	 * @param question
	 *            An AbstractQuestion
	 * @return A Node Element
	 */
	public Element createQuestionXMLNode(AbstractQuestion question) {

		Element questionElement = document.createElement("question");

		questionElement.setAttribute("type", question.getQuestionType()
				.toString());
		questionElement.setAttribute("level", question.getLevel().toString());
		questionElement.setAttribute("topic", question.getTopic().toString());

		Element questionText = document.createElement("text");
		questionText.appendChild(document.createTextNode(question.getText()));
		questionElement.appendChild(questionText);

		Element answers = document.createElement("answers");
		answers.setAttribute("quantity",
				Integer.toString(question.getNumberOfAnswers()));
		questionElement.appendChild(answers);
		for (int i = 0; i < question.getNumberOfAnswers(); i++) {
			Element answer = document.createElement("answer");
			answer.appendChild(document.createTextNode(question
					.getAnswerAtIndex(i)));
			answers.appendChild(answer);
		}

		Element correctAnswers = document.createElement("correct-answers");
		correctAnswers.setAttribute("quantity",
				Integer.toString(question.getNumberOfCorrectAnswers()));

		for (int i = 0; i < question.getNumberOfCorrectAnswers(); i++) {
			Element correctAnswer = document.createElement("correct");
			correctAnswer.appendChild(document.createTextNode(question
					.getCorrectAnswerAtIndex(i)));

			correctAnswers.appendChild(correctAnswer);
		}

		questionElement.appendChild(correctAnswers);

		return questionElement;
	}

	/**
	 * Writes the document to an XML file at path.
	 */
	public void writeToFile() {
		try {
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(path));
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns a String representation of the contents of document.
	 * 
	 * @return A String
	 */
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
