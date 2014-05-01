package languageTests.testPageTests;

import edu.lclark.language.gui.studentPage.QuestionFactory;
import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.QuestionDatabase;
import languageTest.testingResources.DatabaseGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuestionFactoryTests {

	public QuestionDatabase database;
	private ArrayList<AbstractQuestion> questions;
	private QuestionFactory factory;

	@Before
	public void setUp() {
		database = new QuestionDatabase();
		questions = DatabaseGenerator.createExampleQuestions();
		database.setQuestions(questions);
		factory = new QuestionFactory(database.getAllQuestions());
	}
	
	@Test
	public void testGetRandomQuestion() {
		AbstractQuestion question = factory.getRandomQuestion(factory.getDatabase());
		assertFalse(factory.getDatabase().contains(question));
		assertTrue(database.getAllQuestions().contains(question));
	}

}
