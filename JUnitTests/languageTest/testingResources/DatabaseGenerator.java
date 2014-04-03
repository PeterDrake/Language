package languageTest.testingResources;

import java.util.ArrayList;

import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.FillInTheBlankQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.ShortAnswerQuestion;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;


public class DatabaseGenerator {

	private final static QuestionLevel VALID_LEVEL = QuestionLevel.LEVEL_101;
	
	public static ArrayList<AbstractQuestion> createExampleQuestions() {
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
