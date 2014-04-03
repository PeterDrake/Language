package edu.lclark.language.testPage;

import java.util.ArrayList;

import javax.swing.JPanel;

import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.AbstractQuestionPanel;
import edu.lclark.language.questions.FillInTheBlankPanel;
import edu.lclark.language.questions.FillInTheBlankQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestionPanel;
import edu.lclark.language.questions.QuestionInfo;
import edu.lclark.language.questions.ShortAnswerQuestion;
import edu.lclark.language.questions.ShortAnswerQuestionPanel;

public class QuestionFactory {

	private AbstractQuestionPanel questionPanel;
	private ArrayList<JPanel> questions;
	private AbstractQuestion currentQuestion;
	private int i;

	public QuestionFactory() {
		i = 0;
	}

	public AbstractQuestionPanel getQuestionPanel() {
		return questionPanel;

	}
	
	public AbstractQuestion getCurrentQuestion(){
		return currentQuestion;
	}

	public AbstractQuestionPanel getNextQuestion() {

		if ((i % 2 == 0)) {
			currentQuestion = QuestionInfo.getSampleMultipleChoiceQuestion();
			questionPanel = new MultipleChoiceQuestionPanel((MultipleChoiceQuestion)currentQuestion);
		} else {
			currentQuestion = QuestionInfo.getSampleFillInTheBlankQuestion();
			questionPanel = new FillInTheBlankPanel((FillInTheBlankQuestion)currentQuestion);
		}
		i++;

		return questionPanel;
	}
}
