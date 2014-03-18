package edu.lclark.language.testPage;

import java.util.ArrayList;

import javax.swing.JPanel;

import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestionPanel;

public class QuestionFactory {

	private JPanel questionPanel;
	private ArrayList<JPanel> questions;
	private MultipleChoiceQuestion[] exampleQuestionsArray;

	public QuestionFactory(){
		exampleQuestionsArray = createExampleQuestions();
		
	}
	
	public JPanel getNextQuestion() {
		questionPanel = new MultipleChoiceQuestionPanel(exampleQuestionsArray[0]);
		return questionPanel;
	}

	public MultipleChoiceQuestion[] createExampleQuestions() {
		MultipleChoiceQuestion[] qs = new MultipleChoiceQuestion[4];
		qs[0] = new MultipleChoiceQuestion();
		qs[0].setQuestion("What is your name?");
		qs[0].setAnswers(new String[] { "Andi", "Srey", "Maggie" });
		qs[0].setCorrectAnswerIndex(2);
		qs[1] = new MultipleChoiceQuestion();
		qs[1].setQuestion("What is your favorite color?");
		qs[1].setAnswers(new String[] { "Blue", "Yellow", "Green", "Red" });
		qs[1].setCorrectAnswerIndex(3);
		qs[2] = new MultipleChoiceQuestion();
		qs[2].setQuestion("What is your quest?");
		qs[2].setAnswers(new String[] { "Grail", "Food" });
		qs[2].setCorrectAnswerIndex(1);
		qs[3] = new MultipleChoiceQuestion();
		qs[3].setQuestion("What is the avg speed of a swallow?");
		qs[3].setAnswers(new String[] { "45", "57", "20" });
		qs[3].setCorrectAnswerIndex(1);
		return qs;
	}

}
