package edu.lclark.language.testPage;

import java.util.ArrayList;

import javax.swing.JPanel;

import edu.lclark.language.questions.AbstractQuestionPanel;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestionPanel;

public class QuestionFactory {

	private AbstractQuestionPanel questionPanel;
	private ArrayList<JPanel> questions;
	private MultipleChoiceQuestion[] exampleQuestionsArray;
	private int i;

	public QuestionFactory(){
		exampleQuestionsArray = createExampleQuestions();	
		i = 0;
	}
	
	public AbstractQuestionPanel getQuestionPanel(){
		return questionPanel;
		
	}
	
	public AbstractQuestionPanel getNextQuestion() {
		if (i >= exampleQuestionsArray.length){
			System.exit(0);
			// place holder for some type of finish test page or something 
		}
		questionPanel = new MultipleChoiceQuestionPanel(exampleQuestionsArray[i]);
		i++;
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
		qs[2].setAnswers(new String[] { "To Seek the Holy Grail", "Food" });
		qs[2].setCorrectAnswerIndex(1);
		qs[3] = new MultipleChoiceQuestion();
		qs[3].setQuestion("What is the avg speed of a swallow?");
		qs[3].setAnswers(new String[] { "45", "57", "What kind, African of European?" });
		qs[3].setCorrectAnswerIndex(1);
		return qs;
	}


}
