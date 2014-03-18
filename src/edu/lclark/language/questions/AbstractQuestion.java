package edu.lclark.language.questions;

import edu.lclark.language.questions.QuestionInfo.QuestionType;

public abstract class AbstractQuestion {
	
	public abstract boolean isCorrectAnswer();
	
	private int questionId;
	private QuestionType type;
	private String level;
	private String text;
	private String[] answers;
	private String[] correctAnswers;
	
	public String getLevel(){
		return level;
	}
	public void setLevel(String level){
		this.level = level;
	}
	public String getText(){
		return text;
	}
	public void setText(String text){
		this.text = text;
	}
	public void setAnswers(String[] answers){
		this.answers = answers;
	}
	public String[] getAnswers(){
		return answers;
	}
	public String getAnswerAtIndex(int index){
		return answers[index];
	}
	public int getNumberOfAnswers(){
		return answers.length;
	}
	public void setCorrectAnswers(String[] correctAnswers){
		this.correctAnswers = correctAnswers;
	}
	public String[] getCorrectAnswers(){
		return correctAnswers;
	}
	public String getCorrectAnswerAtIndex(int index){
		return correctAnswers[index];
	}
	public int getNumberOfCorrectAnswers(){
		return correctAnswers.length;
	}
	public QuestionType getQuestionType(){
		return type;
	}
	public void setQuestionType(QuestionType type){
		this.type = type;
	}
	public String toString(){
		return text;
	}
	
}
