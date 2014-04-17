package languageTests.questionTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import languageTest.testingResources.DatabaseGenerator;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.*;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

public class QuestionDatabaseTests {
	public QuestionDatabase database;
	private final QuestionLevel VALID_LEVEL = QuestionLevel.LEVEL_101;
	private ArrayList<AbstractQuestion> questions;

	@Before
	public void setUp() {
		database = new QuestionDatabase();
		database.setTestPath();
		questions = DatabaseGenerator.createExampleQuestions();
		database.setQuestions(questions);
	}
	
	@Test
	public void testGetAllQuestions(){
		ArrayList<AbstractQuestion> copiedQuestions = database.getAllQuestions();
		assertFalse(copiedQuestions == questions);
		AbstractQuestion removedQuestion = copiedQuestions.remove(0);
		assertTrue(questions.contains(removedQuestion));
	}

	@Test
	public void testWriteAndReadQuestions() {
		database.writeQuestionsToFile();
		database.loadQuestionsFromFile();
		ArrayList<AbstractQuestion> loadedQuestions = database.getAllQuestions();

		assertEquals(questions.size(), loadedQuestions.size());
		for (int i = 0; i < questions.size(); i++) {
			AbstractQuestion writtenQuestion = questions.get(i);
			AbstractQuestion readQuestion = loadedQuestions.get(i);
			assertEquals(writtenQuestion.getText(), readQuestion.getText());
			assertEquals(writtenQuestion.getLevel(), readQuestion.getLevel());
		}
	}
	
	@Test
	public void testGetQuestionSubset(){
		ArrayList<AbstractQuestion> subset = database.getQuestionsOfLevel(VALID_LEVEL);
		for(AbstractQuestion question: subset){
			assertEquals(VALID_LEVEL, question.getLevel());
		}
	}
	
	@Test
	public void testDeleteQuestion(){
		AbstractQuestion question= questions.get(0);
		database.deleteQuestion(question);
		assertFalse(questions.contains(question));
	}
	
	@Test
	public void testAddQuestion(){
		ShortAnswerQuestion shortAnswer = new ShortAnswerQuestion();
		shortAnswer.setLevel(VALID_LEVEL);
		shortAnswer.setText("What do the Ents look like?");
		shortAnswer.setAnswers(new String[0]);
		shortAnswer.setCorrectAnswers(new String[] { "Trees!" });
		
		database.addQuestion(shortAnswer);
		assertTrue(questions.contains(shortAnswer));
	}


}
