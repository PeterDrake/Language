package edu.lclark.language.questions;

public class MultipleChoiceQuestion implements Question {
	
	private static final int NUMBER_OF_ANSWERS = 4;
	
	private String[] answers;
	private String question;
	private int correctAnswerIndex;
	private int questionID;
	private int level;
	
	private int answerCandidateIndex;
	
	public MultipleChoiceQuestion()
	{
		answers = new String[NUMBER_OF_ANSWERS];
	}

	@Override
	public boolean isCorrectAnswer() {
		return false;
	}

	@Override
	public int getLevel() {
		return level;
	}
	
	@Override
	public void setLevel(int level){
		this.level = level;
	}

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		
	}

}
