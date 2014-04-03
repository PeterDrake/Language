package languageTests.questionTests;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.FillInTheBlankQuestion;

public class FillInTheBlankQuestionTest {

	@Before
	public void setUp() throws Exception {
	}

/*	@Test
	public void testIsCorrect() {
		FillInTheBlankQuestion q = new FillInTheBlankQuestion();
		q.setText("¿Dónde _ el baño?");
		q.setAnswers(new String[] {"está"});
		assertTrue(q.isCorrectAnswer("est��"));
		assertFalse(q.isCorrectAnswer("esta"));
		assertTrue(q.isCorrectAnswer("est�� "));
	}
	
	@Test
	public void testSeparateWords() {
		FillInTheBlankQuestion q = new FillInTheBlankQuestion();
		q.setText("¿Dónde _ el baño?");
		q.setAnswers(new String[] {"está"});
		List<String> correctBefore = new ArrayList<String>();
		correctBefore.add("��D��nde ");
		List<String> correctAfter = new ArrayList<String>();
		correctAfter.add("el ");
		correctAfter.add("ba��o, ");
		correctAfter.add("por ");
		correctAfter.add("favor? ");
		assertEquals(correctBefore, q.getWordsBeforeBlank());
		assertEquals(correctAfter, q.getWordsAfterBlank());
	}*/

}
