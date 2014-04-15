package languageTests.questionTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.questions.QuestionInfo.QuestionType;
import edu.lclark.language.questions.QuestionXMLReader;

public class QuestionXMLReaderTests {

	private QuestionXMLReader reader;
	
	@Before
	public void setUp(){
		reader = new QuestionXMLReader();
		reader.setTestPath();
		reader.loadXMLFile();
	}

	@Test
	public void testLoadXMLFile() {
		assertNotNull(reader.xmlFile);
		assertTrue(reader.xmlFile.exists());
	}
	
	@Test
	public void testParseXMLFile(){
		Document doc = reader.parseXMLFile();
		assertNotNull(doc);
		assertEquals("test", doc.getDocumentElement().getTagName());
	}
	
	@Test
	public void testLoadQuestionsFromFile(){
		assertNotNull(reader.loadQuestionsFromFile());
	}
	
	@Test
	public void testMakeQuestion(){
		Element questionElement = createQuestionElement();
		AbstractQuestion question = reader.makeQuestion(questionElement);
		assertNotNull(question);
		assertEquals("What is your name?", question.getText());
		assertEquals(QuestionType.MULTIPLE_CHOICE, question.getQuestionType());
		assertEquals(QuestionLevel.LEVEL_101, question.getLevel());
		assertEquals(3, question.getNumberOfAnswers());
		assertEquals("Maggie", question.getAnswerAtIndex(0));
		assertEquals(1, question.getNumberOfCorrectAnswers());
		assertEquals("Maggie", question.getCorrectAnswerAtIndex(0));
		
	}
	
	private Element createQuestionElement(){
		Document doc = reader.initializeXMLDocument();
		Element questionElement = doc.createElement("question");
		questionElement.setAttribute("type", QuestionType.MULTIPLE_CHOICE.toString());
		questionElement.setAttribute("level",
				QuestionLevel.LEVEL_101.toString());

		Element questionText = doc.createElement("text");
		questionText
				.appendChild(doc.createTextNode("What is your name?"));
		questionElement.appendChild(questionText);

		Element answers = doc.createElement("answers");
		answers.setAttribute("quantity",
				"3");
		questionElement.appendChild(answers);
		for (int i = 0; i < 3; i++) {
			Element answer = doc.createElement("answer");
			answer.appendChild(doc.createTextNode("Maggie"));
			answers.appendChild(answer);
		}

		Element correctAnswers= doc.createElement("correct-answers");
		correctAnswers.setAttribute("quantity", "1");
		
		for(int i = 0; i < 1; i++){
			Element correctAnswer = doc.createElement("correct");
			correctAnswer.appendChild(doc.createTextNode("Maggie"));			
			correctAnswers.appendChild(correctAnswer);
		}
		
		questionElement.appendChild(correctAnswers);
		return questionElement;
	}

}
