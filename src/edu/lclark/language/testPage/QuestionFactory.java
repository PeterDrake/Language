package edu.lclark.language.testPage;

import java.util.ArrayList;

import javax.swing.JPanel;

import edu.lclark.language.gui.studentPage.AbstractQuestionPanel;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.gui.studentPage.MultipleChoiceQuestionPanel;
import edu.lclark.language.questions.ShortAnswerQuestion;
import edu.lclark.language.gui.studentPage.ShortAnswerQuestionPanel;

public class QuestionFactory {

	private AbstractQuestionPanel questionPanel;
	private ArrayList<JPanel> questions;
	private MultipleChoiceQuestion[] exampleQuestionsArray;
	private ShortAnswerQuestion[] exampleShort;
	private int i;

	public QuestionFactory(){
		exampleQuestionsArray = createExampleQuestions();	
		exampleShort = createSampleShortAnswerQ();	
		i = 0;
	}
	
	public AbstractQuestionPanel getQuestionPanel(){
		return questionPanel;
		
	}
	
	public AbstractQuestionPanel getNextQuestion() {
		
		
		if (i >= exampleShort.length){
			System.exit(0);
			// place holder for some type of finish test page or something 
		}
		if ((i%2 == 0)){
			questionPanel = new MultipleChoiceQuestionPanel(exampleQuestionsArray[i]);			
		} else {
		questionPanel = new ShortAnswerQuestionPanel(exampleShort[i]);
		}
		i++;
		
		return questionPanel;
	}

	public MultipleChoiceQuestion[] createExampleQuestions() {
		MultipleChoiceQuestion[] qs = new MultipleChoiceQuestion[4];
		qs[0] = new MultipleChoiceQuestion();
		qs[0].setText("What is your name?");
		qs[0].setAnswers(new String[] { "Andi", "Srey", "Maggie" });
		qs[0].setCorrectAnswers(new String[] { "Srey" });
		qs[1] = new MultipleChoiceQuestion();
		qs[1].setText("What is your favorite color?");
		qs[1].setAnswers(new String[] { "Blue", "Yellow", "Green", "Red" });
		qs[1].setCorrectAnswers(new String[] { "Red" });
		qs[2] = new MultipleChoiceQuestion();
		qs[2].setText("What is your quest?");
		qs[2].setAnswers(new String[] { "To Seek the Holy Grail", "Food" });
		qs[2].setCorrectAnswers(new String[] { "Food" });
		qs[3] = new MultipleChoiceQuestion();
		qs[3].setText("What is the avg speed of a swallow?");
		qs[3].setAnswers(new String[] { "45", "57", "What kind, African of European?" });
		qs[3].setCorrectAnswers(new String[] { "57" });
		return qs;
	}
	
	public ShortAnswerQuestion[] createSampleShortAnswerQ(){
		
		ShortAnswerQuestion[] shortQS = new ShortAnswerQuestion[4];
		shortQS[0] = new ShortAnswerQuestion();
		shortQS[0].setText("Hello how are you doing today?");
		shortQS[1] = new ShortAnswerQuestion();
		shortQS[1].setText("Please explain why you are in college?");
		shortQS[2] = new ShortAnswerQuestion();
		shortQS[2].setText("What is your major?");
		shortQS[3] = new ShortAnswerQuestion();
		shortQS[3].setText("What will you be doing this summer?");
		
		return shortQS;
	}


}
