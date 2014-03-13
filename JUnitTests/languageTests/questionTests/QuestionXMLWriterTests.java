package languageTests.questionTests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.QuestionXMLWriter;

public class QuestionXMLWriterTests {

	private QuestionXMLWriter writer;

	@Before
	public void setUp() {
		writer = new QuestionXMLWriter();

		MultipleChoiceQuestion question = new MultipleChoiceQuestion();
		question.setQuestion("Which of these words does not belong?");
		question.setAnswers(new String[] { "el queso", "la manzana",
				"la zanahoria", "el jabón" });
		question.setLevel(102);
		question.setCorrectAnswerIndex(3);

		writer.createNewDocument();
		writer.createQuestionXMLNode(question);
	}

	@Test
	public void testWriteQuestionMultipleChoice() {
		assertEquals(
				"<question level=\"102\" type=\"multiple-choice\"><text>Which of these words does not belong?</text><answers quantity=\"4\"><answer>el queso</answer><answer>la manzana</answer><answer>la zanahoria</answer><answer>el jabón</answer></answers><correct>3</correct></question>",
				writer.getDocumentString());
	}

	@Test
	public void testWriteToFile() {
		writer.writeToFile();
		assertTrue(new File(writer.PATH).exists());
	}
}
