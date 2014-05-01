package edu.lclark.language.questions;

import edu.lclark.language.questions.QuestionInfo.QuestionType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class reads in and parses an XML document containing all the questions
 * for the Language Placement Exam.
 * 
 * @author Team Language
 * 
 */
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

	/**
	 * Ensures that the file being imported is a correctly formatted question
	 * database.
	 * 
	 * @param database
	 *            The path of the file being loaded.
	 * @return True if the database is valid, false otherwise.
	 */
	public boolean verifyDatabase(File database) {
		if (!database.isFile()) {
			return false;
		}

		if (database.length() == 0) {
			return false;
		}

		try {
			Document doc = docBuilder.parse(database);
			NodeList questions = doc.getElementsByTagName("question");
			for (int i = 0; i < questions.getLength(); i++) {
				NodeList nodes = questions.item(i).getChildNodes();
				if (!nodes.item(0).getNodeName().equals("text")
						|| !nodes.item(1).getNodeName().equals("answers")
						|| !nodes.item(2).getNodeName()
								.equals("correct-answers")) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void setTestPath() {
		path = QuestionInfo.TEST_QUESTIONS_PATH;
	}

	/**
	 * Creates a File object based on path. If not such file exists, one is
	 * created.
	 * 
	 * @return A File object of the provided path.
	 */
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

	/**
	 * Parses an XML database file and returns the corresponding Document
	 * object.
	 * 
	 * @return A Document of the XML file.
	 */
	public Document parseXMLFile() {
		// if the file is empty, create a new document from scratch
		if (xmlFile.length() == 0) {
			try {
				return docBuilder
						.parse(ClassLoader
								.getSystemResourceAsStream("edu/lclark/language/resources/questionExamples.xml"));
			} catch (Exception e) {
				e.printStackTrace();
				return initializeXMLDocument();
			}
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

	/**
	 * Reads in each question node from the Document object created from an XML
	 * file and returns an ArrayList of AbstractQuestions.
	 * 
	 * @return An ArrayList of AbstractQuestions based on the contents of the
	 *         XML file.
	 */
	public ArrayList<AbstractQuestion> loadQuestionsFromFile() {
		ArrayList<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();
		Document doc = parseXMLFile();

		NodeList questionNodes = doc.getElementsByTagName("question");
		for (int i = 0; i < questionNodes.getLength(); i++) {
			questions.add(makeQuestion(questionNodes.item(i)));
		}
		return questions;
	}

	/**
	 * Creates an AbstractQuestion object based on the type and contents of the
	 * Node provided.
	 * 
	 * @param questionNode
	 *            A Node from an XML Document object.
	 * @return An AbstractQuestion based on the data from questionNode.
	 */
	public AbstractQuestion makeQuestion(Node questionNode) {

		String type = questionNode.getAttributes().getNamedItem("type")
				.getNodeValue();
		String level = questionNode.getAttributes().getNamedItem("level")
				.getNodeValue();
		String topic = questionNode.getAttributes().getNamedItem("topic")
				.getNodeValue();

		AbstractQuestion newQuestion = null;

		if (type.equals(QuestionType.MULTIPLE_CHOICE.toString())) {
			newQuestion = new MultipleChoiceQuestion();
		} else if (type.equals(QuestionType.FILL_IN_THE_BLANK.toString())) {
			newQuestion = new FillInTheBlankQuestion();
		} else if (type.equals(QuestionType.SHORT_ANSWER.toString())) {
			newQuestion = new ShortAnswerQuestion();
		}
		// can add more if statements as we add more question types

		newQuestion.setLevel(QuestionInfo.createQuestionLevel(level));
		newQuestion.setTopic(QuestionInfo.createQuestionTopic(topic));

		NodeList questionNodeList = questionNode.getChildNodes();
		newQuestion.setText(questionNodeList.item(0).getTextContent());

		String[] answers = getStringsFromNode(questionNodeList.item(1));
		newQuestion.setAnswers(answers);

		String[] correctAnswers = getStringsFromNode(questionNodeList.item(2));
		newQuestion.setCorrectAnswers(correctAnswers);

		return newQuestion;
	}

	/**
	 * Returns an array of Strings based on the child nodes of a given Node.
	 * 
	 * @param nodeWithChildNodes
	 *            The Node to be read.
	 * @return String[] An array of Strings based on the child nodes of
	 *         nodeWithChildNodes
	 */
	private String[] getStringsFromNode(Node nodeWithChildNodes) {

		int quantity = Integer.parseInt(nodeWithChildNodes.getAttributes()
				.getNamedItem("quantity").getNodeValue());
		NodeList childrenNodes = nodeWithChildNodes.getChildNodes();
		String[] strings = new String[quantity];
		for (int i = 0; i < quantity; i++) {
			strings[i] = childrenNodes.item(i).getTextContent();
		}
		return strings;

	}

}
