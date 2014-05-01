package edu.lclark.language.questions;

import edu.lclark.language.questions.QuestionInfo.*;

/**
 * This is an interface that all questions implement. It contains methods that
 * deal with information assigned to individual questions
 * 
 * @author Team Language
 * 
 */
public abstract class AbstractQuestion {

	protected int questionId;
	protected QuestionType type;
	protected QuestionLevel level;
	protected Topic topic;
	protected String text;
	protected String[] answers;
	protected String[] correctAnswers;

	public QuestionLevel getLevel() {
		return level;
	}

	public void setLevel(QuestionLevel level) {
		this.level = level;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Topic getTopic() {
		return topic;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public String[] getAnswers() {
		return answers;
	}

	public String getAnswerAtIndex(int index) {
		return answers[index];
	}

	public int getNumberOfAnswers() {
		return answers.length;
	}

	public void setCorrectAnswers(String[] correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public String[] getCorrectAnswers() {
		return correctAnswers;
	}

	public String getCorrectAnswerAtIndex(int index) {
		return correctAnswers[index];
	}

	public int getNumberOfCorrectAnswers() {
		return correctAnswers.length;
	}

	public QuestionType getQuestionType() {
		return type;
	}

	public void setQuestionType(QuestionType type) {
		this.type = type;
	}

	public String toString() {
		return text;
	}

	/**
	 * Takes in the student's answer to a questions as a string and compares it
	 * to the correct answer associated with each question
	 * 
	 * @param studentAnswer
	 * @return boolean
	 */
	public boolean isCorrectAnswer(String studentAnswer) {
		for (int i = 0; i < getNumberOfCorrectAnswers(); i++) {
			if (correctAnswers[i].equals(studentAnswer))
				return true;
		}
		return false;
	}

}
