package languageTests.questionTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.*;

public class QuestionLoaderTests {
	public QuestionLoader loader;
	private final int VALID_LEVEL = 101;
	private final int INVALID_LEVEL = 22;

	@Before
	public void setUp() throws Exception {
		loader = new QuestionLoader();
	}

	@Test
	public void testGetQuestion() {
		Question validQuestion = loader.getQuestion(VALID_LEVEL);
		Question invalidQuestion = loader.getQuestion(INVALID_LEVEL);
		assertNotNull(validQuestion);
		assertNull(invalidQuestion);
		assertEquals(VALID_LEVEL, validQuestion.getLevel());
	}

}
