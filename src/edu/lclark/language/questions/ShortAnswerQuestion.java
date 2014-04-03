package edu.lclark.language.questions;

import edu.lclark.language.questions.QuestionInfo.QuestionType;

public class ShortAnswerQuestion extends AbstractQuestion{
	
	private String question;
	private int correctAnswerIndex;
	private int questionID;
	private int level;
	private final QuestionType type;
	private int numberOfAnswers;
	
	public ShortAnswerQuestion() {
		type = QuestionType.SHORT_ANSWER;
	}

	@Override
	public boolean isCorrectAnswer() {
		return true;
	}

	@Override
	public int getLevel() {
		return 0;
	}

	@Override
	public QuestionType getType() {
		return type;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
		
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public int getNumberOfAnswers() {
		return 0;
	}

	@Override
	public int getNumberOfCorrectAnswers() {

		return 0;
	}

	@Override
	public String getCorrectAnswer(int index) {
		return null;
	}

	@Override
	public String getAnswer(int index) {
		return null;
	}

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		
	}

}
