package edu.lclark.language.questions;

import edu.lclark.language.questions.QuestionInfo.QuestionType;

public abstract class AbstractQuestion {
	
	public abstract boolean isCorrectAnswer();
	
	public abstract int getLevel();
	public abstract QuestionType getType();
	public abstract void setLevel(int level);
	public abstract String getQuestion();
	public abstract int getNumberOfAnswers();
	public abstract int getNumberOfCorrectAnswers();
	public abstract String getCorrectAnswer(int index); //this is awkward for multiple choice, as there is only ever one correct answer, will consider revising
	public abstract String getAnswer(int index);
	public abstract void writeToFile();
	private int questionId;

}
