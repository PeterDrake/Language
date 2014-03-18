package languageTests.questionTests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.QuestionXMLWriter;

public class QuestionXMLWriterTests {

	private QuestionXMLWriter writer;

	@Before
	public void setUp() {
		writer = new QuestionXMLWriter();

		ArrayList<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();
		MultipleChoiceQuestion question = new MultipleChoiceQuestion();
		question.setQuestion("Which of these words does not belong?");
		question.setAnswers(new String[] { "el queso", "la manzana",
				"la zanahoria", "el jabón" });
		question.setLevel(102);
		question.setCorrectAnswerIndex(3);
		questions.add(question);

		writer.createNewDocument();
		writer.fillXMLDocument(questions);
	}

	@Test
	public void testWriteQuestionMultipleChoice() {
		assertEquals(
				"<test><question level=\"102\" type=\"MULTIPLE_CHOICE\"><text>Which of these words does not belong?</text><answers quantity=\"4\"><answer>el queso</answer><answer>la manzana</answer><answer>la zanahoria</answer><answer>el jabón</answer></answers><correct>3</correct></question></test>",
				writer.getDocumentString());
	}

	@Test
	public void testWriteToFile() {
		writer.writeToFile();
		assertTrue(new File(writer.PATH).exists());
	}
}
