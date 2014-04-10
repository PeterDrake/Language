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
		multipleChoice.setLevel(QuestionLevel.LEVEL_101);
		multipleChoice.setText("Who is the best Lord of the Rings character?");
		multipleChoice.setAnswers(new String[] { "Frodo", "Sam", "Gandalf", "Aragorn" });
		multipleChoice.setCorrectAnswers(new String[] { "Sam" });
		questions.add(multipleChoice);

		FillInTheBlankQuestion fillInTheBlank = new FillInTheBlankQuestion();
		fillInTheBlank.setLevel(QuestionLevel.LEVEL_101);
		fillInTheBlank.setText("One _ to rule them all.");
		fillInTheBlank.setAnswers(new String[0]);
		fillInTheBlank.setCorrectAnswers(new String[] { "ring" });
		questions.add(fillInTheBlank);
		
		FillInTheBlankQuestion ex1 = new FillInTheBlankQuestion();
		ex1.setLevel(QuestionLevel.LEVEL_102);
		ex1.setText("Tú _ (lavar-lavarse) el auto antes de ir a la fiesta.");
		ex1.setAnswers(new String[0]);
		ex1.setCorrectAnswers(new String[] { "lavas" });
		questions.add(ex1);
		
		FillInTheBlankQuestion ex2 = new FillInTheBlankQuestion();
		ex2.setLevel(QuestionLevel.LEVEL_102);
		ex2.setText("Hola me llamo Ignacio y _ (ser-estar) de Argentina.");
		ex2.setAnswers(new String[0]);
		ex2.setCorrectAnswers(new String[] { "soy" });
		questions.add(ex2);
		
		FillInTheBlankQuestion ex3 = new FillInTheBlankQuestion();
		ex3.setLevel(QuestionLevel.LEVEL_101);
		ex3.setText("Nosotros no _ (acordar-acordarse) de comprar los regalos.");
		ex3.setAnswers(new String[0]);
		ex3.setCorrectAnswers(new String[] { "nos acordamos" });
		questions.add(ex3);
		
		return questions;
	}
}
