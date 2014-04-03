package edu.lclark.language.questions;

import javax.swing.JPanel;

public abstract class AbstractQuestionPanel extends JPanel{
	
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

}
