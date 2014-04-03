package languageTests.testPageTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import languageTest.testingResources.DatabaseGenerator;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.QuestionDatabase;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.testPage.QuestionFactory;

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
