package edu.lclark.language.questions;

public class MultipleChoiceQuestion extends AbstractQuestion {
	
	private static final int NUMBER_OF_ANSWERS = 4;
	
	private String[] answers;
	private String question;
	private int correctAnswerIndex;
	private int questionID;
	
	public MultipleChoiceQuestion()
	{
		answers = new String[NUMBER_OF_ANSWERS];
	}
}
