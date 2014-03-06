package edu.lclark.language.questions;

public interface Question {
	
	public boolean isCorrectAnswer();
	
	public int getLevel();
	public void setLevel(int level);
	
	public void writeToFile();

}
