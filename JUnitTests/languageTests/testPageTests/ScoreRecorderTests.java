package languageTests.testPageTests;

import static org.junit.Assert.*;
import languageTest.testingResources.DatabaseGenerator;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.FillInTheBlankQuestion;
import edu.lclark.language.studentLogic.ScoreRecorder;

public class ScoreRecorderTests {
	private ScoreRecorder recorder;

	@Before
	public void setUp() throws Exception {
		recorder = new ScoreRecorder();

	}

	@Test
	public void testRecordQuestion() {
		FillInTheBlankQuestion blank = DatabaseGenerator.getSampleFillInTheBlank();
		recorder.addQuestion(blank, "Hola");
		assertEquals(1, recorder.getQuestionsToWrite().size());
		assertEquals("Question: " + blank.getText() + ", Student Answer: Hola", recorder
				.getQuestionsToWrite().get(0));

	}

}
