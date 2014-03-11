package edu.lclark.language.questions;

public class MultipleChoiceQuestion extends AbstractQuestion {

	private String[] answers;
	private String question;
	private int correctAnswerIndex;
	private int questionID;
	private int level;
	private final String type;
	private int numberOfAnswers;

	private int answerCandidateIndex;

	public MultipleChoiceQuestion() {
		type = "multiple-choice";
	}

	@Override
	public boolean isCorrectAnswer() {
		return true;
	}

	public int getNumberOfAnswers() {
		return numberOfAnswers;
	}

	public void setNumberOfAnswers(int numberOfAnswers) {
		this.numberOfAnswers = numberOfAnswers;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
		numberOfAnswers = answers.length;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}

	public void setCorrectAnswerIndex(int correctAnswerIndex) {
		this.correctAnswerIndex = correctAnswerIndex;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAnswer(int index) {
		return answers[index];
	}

	@Override
	public int getNumberOfCorrectAnswers() {
		return 1;
	}

	@Override
	public String getCorrectAnswer(int index) {
		return Integer.toString(correctAnswerIndex);
	}

	@Override
	public String getType() {
		return type;
	}

}
