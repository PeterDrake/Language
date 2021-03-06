package edu.lclark.language.gui.studentPage;

import edu.lclark.language.questions.AbstractQuestion;

import javax.swing.*;

public abstract class AbstractQuestionPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private AbstractQuestion currentQuestion;
	
	public AbstractQuestionPanel(AbstractQuestion question){
		currentQuestion = question;
	}
	
	public abstract String getAnswer();
	public AbstractQuestion getCurrentQuestion(){
		return currentQuestion;
	}
	public void setCurrentQuestion(AbstractQuestion question){
		currentQuestion = question;
	}

	public boolean isCorrectAnswerSelected(){
		return currentQuestion.isCorrectAnswer(getAnswer());
	}
}
