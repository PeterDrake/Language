package languageTest.testingResources;

import java.util.ArrayList;

import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.FillInTheBlankQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.ShortAnswerQuestion;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;


public class DatabaseGenerator {
	
	public static ArrayList<AbstractQuestion> createExampleQuestions() {
		ArrayList<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();
		
		MultipleChoiceQuestion multipleChoice = new MultipleChoiceQuestion();
		multipleChoice.setLevel(QuestionLevel.LEVEL_102);
		multipleChoice.setText("Who is the best Lord of the Rings character?");
		multipleChoice.setAnswers(new String[] { "Frodo", "Sam", "Gandalf", "Aragorn" });
		multipleChoice.setCorrectAnswers(new String[] { "Sam" });
		questions.add(multipleChoice);

		ShortAnswerQuestion shortAnswer = new ShortAnswerQuestion();
		shortAnswer.setLevel(QuestionLevel.LEVEL_101);
		shortAnswer.setText("Why is Sam the best LOTR character?");
		shortAnswer.setAnswers(new String[0]);
		shortAnswer.setCorrectAnswers(new String[] { "Because he is a BAMF!" });
		questions.add(shortAnswer);
		
		ShortAnswerQuestion shortAnswer2 = new ShortAnswerQuestion();
		shortAnswer2.setLevel(QuestionLevel.LEVEL_201);
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
		
		FillInTheBlankQuestion ex1 = new FillInTheBlankQuestion();
		fillInTheBlank.setLevel(QuestionLevel.LEVEL_102);
		fillInTheBlank.setText("Tú _ (lavar-lavarse) el auto antes de ir a la fiesta.");
		fillInTheBlank.setAnswers(new String[0]);
		fillInTheBlank.setCorrectAnswers(new String[] { "lavas" });
		questions.add(fillInTheBlank);
		
		FillInTheBlankQuestion ex2 = new FillInTheBlankQuestion();
		fillInTheBlank.setLevel(QuestionLevel.LEVEL_101);
		fillInTheBlank.setText("Hola me llamo Ignacio y _ (ser-estar) de Argentina. ");
		fillInTheBlank.setAnswers(new String[0]);
		fillInTheBlank.setCorrectAnswers(new String[] { "soy" });
		questions.add(fillInTheBlank);
		
		return questions;
	}
}
