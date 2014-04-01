package languageTests.questionTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		questions = createExampleQuestions();
		database.setQuestions(questions);
	}

	@Test
	public void testGetQuestion() {
		AbstractQuestion validQuestion = database.getQuestion(VALID_LEVEL);
		assertNotNull(validQuestion);
		assertEquals(VALID_LEVEL, validQuestion.getLevel());
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
		assertEquals(2, subset.size());
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

	public ArrayList<AbstractQuestion> createExampleQuestions() {
		ArrayList<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();
		
		MultipleChoiceQuestion multipleChoice = new MultipleChoiceQuestion();
		multipleChoice.setLevel(QuestionLevel.LEVEL_102);
		multipleChoice.setText("Who is the best Lord of the Rings character?");
		multipleChoice.setAnswers(new String[] { "Frodo", "Sam", "Gandalf", "Aragorn" });
		multipleChoice.setCorrectAnswers(new String[] { "Sam" });
		questions.add(multipleChoice);

		ShortAnswerQuestion shortAnswer = new ShortAnswerQuestion();
		shortAnswer.setLevel(VALID_LEVEL);
		shortAnswer.setText("Why is Sam the best LOTR character?");
		shortAnswer.setAnswers(new String[0]);
		shortAnswer.setCorrectAnswers(new String[] { "Because he is a BAMF!" });
		questions.add(shortAnswer);
		
		ShortAnswerQuestion shortAnswer2 = new ShortAnswerQuestion();
		shortAnswer2.setLevel(VALID_LEVEL);
		shortAnswer2.setText("How did Gollum acquire the one ring?");
		shortAnswer2.setAnswers(new String[0]);
		shortAnswer2.setCorrectAnswers(new String[] { "He killed his cousin after he found it in a lake!" });
		questions.add(shortAnswer2);

		FillInTheBlankQuestion fillInTheBlank = new FillInTheBlankQuestion();
		fillInTheBlank.setLevel(QuestionLevel.LEVEL_301);
		fillInTheBlank.setText("One _ to rule them all.");
		fillInTheBlank.setAnswers(new String[0]);
		fillInTheBlank.setCorrectAnswers(new String[] { "ring" });
		questions.add(fillInTheBlank);
		
		return questions;
	}

}
