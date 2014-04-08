package edu.lclark.language.gui.studentPage;

import javax.swing.JPanel;

import edu.lclark.language.questions.AbstractQuestion;

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

	public boolean isCorrectAnswerSelected(){
		return currentQuestion.isCorrectAnswer(getAnswer());
	}
}
