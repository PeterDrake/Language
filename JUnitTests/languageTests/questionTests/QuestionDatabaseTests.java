package languageTests.questionTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.*;

public class QuestionDatabaseTests {
	public QuestionDatabase loader;
	private final int VALID_LEVEL = 101;
	private final int INVALID_LEVEL = 22;

	@Before
	public void setUp() {
		loader = new QuestionDatabase();
	}

	@Test
	public void testGetQuestion() {
		AbstractQuestion validQuestion = loader.getQuestion(VALID_LEVEL);
		AbstractQuestion invalidQuestion = loader.getQuestion(INVALID_LEVEL);
		assertNotNull(validQuestion);
		assertNull(invalidQuestion);
		assertEquals(VALID_LEVEL, validQuestion.getLevel());
	}
	
	@Test
	public void testWriteQuestions(){
		loader.writeQuestions();
	}

}
