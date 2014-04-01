package languageTests.questionTests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.questions.QuestionXMLWriter;

public class QuestionXMLWriterTests {

	private QuestionXMLWriter writer;

	@Before
	public void setUp() {
		writer = new QuestionXMLWriter();

		ArrayList<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();
		MultipleChoiceQuestion question = new MultipleChoiceQuestion();
		question.setText("Which of these words does not belong?");
		question.setAnswers(new String[] { "el queso", "la manzana",
				"la zanahoria", "el jabón" });
		question.setLevel(QuestionLevel.LEVEL_102);
		question.setCorrectAnswers(new String[] {"el jabón"});
		questions.add(question);

		writer.createNewDocument();
		writer.fillXMLDocument(questions);
	}

	@Test
	public void testWriteQuestionMultipleChoice() {
		assertEquals(
				"<test><question level=\"LEVEL_102\" type=\"MULTIPLE_CHOICE\"><text>Which of these words does not belong?</text><answers quantity=\"4\"><answer>el queso</answer><answer>la manzana</answer><answer>la zanahoria</answer><answer>el jabón</answer></answers><correct-answers quantity=\"1\"><correct>el jabón</correct></correct-answers></question></test>",
				writer.getDocumentString());
	}

	@Test
	public void testWriteToFile() {
		writer.writeToFile();
		assertTrue(new File(writer.PATH).exists());
	}
}