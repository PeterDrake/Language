package languageTests.questionTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.*;

public class QuestionDatabaseTests {
	public QuestionDatabase database;
	private final String VALID_LEVEL = "101";
	private final String INVALID_LEVEL = "22";

	@Before
	public void setUp() {
		database = new QuestionDatabase();
	}

	@Test
	public void testGetQuestion() {
		AbstractQuestion validQuestion = database.getQuestion(VALID_LEVEL);
		AbstractQuestion invalidQuestion = database.getQuestion(INVALID_LEVEL);
		assertNotNull(validQuestion);
		assertNull(invalidQuestion);
		assertEquals(VALID_LEVEL, validQuestion.getLevel());
	}
	
	@Test
	public void testWriteAndReadQuestions(){
		ArrayList<AbstractQuestion> questions = createExampleQuestions();
		database.setQuestions(questions);
		database.writeQuestionsToFile();
		database.loadQuestionsFromFile();
		ArrayList<AbstractQuestion> loadedQuestions = database.getQuestions();
		
		assertEquals(questions.size(), loadedQuestions.size());	
		for(int i = 0; i < questions.size(); i++){
			AbstractQuestion writtenQuestion = questions.get(i);
			AbstractQuestion readQuestion = loadedQuestions.get(i);		
			assertEquals(writtenQuestion.getText(), readQuestion.getText());
			assertEquals(writtenQuestion.getLevel(), readQuestion.getLevel());
		}
	}
	
		public ArrayList<AbstractQuestion> createExampleQuestions() {
			ArrayList<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();
			MultipleChoiceQuestion multiple = new MultipleChoiceQuestion();
			multiple.setLevel("102");
			multiple.setText("Who is the best Lord of the Rings character?");
			multiple.setAnswers(new String[] {"Frodo", "Sam", "Gandalf", "Aragorn"});
			multiple.setCorrectAnswers(new String[] {"Sam"});
			questions.add(multiple);
			
			ShortAnswerQuestion sa = new ShortAnswerQuestion();
			sa.setLevel(VALID_LEVEL);
			sa.setText("Why is Sam the best LOTR character?");
			sa.setAnswers(new String[0]);
			sa.setCorrectAnswers(new String[] {"Because he is a BAMF!"});
			questions.add(sa);
			
			FillInTheBlankQuestion fill = new FillInTheBlankQuestion();
			fill.setLevel("301");
			fill.setText("One _ to rule them all.");
			fill.setAnswers(new String[0]);
			fill.setCorrectAnswers(new String[] {"ring"});
			questions.add(fill);
			return questions;
		}

}
