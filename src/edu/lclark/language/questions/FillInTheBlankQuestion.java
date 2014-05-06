package edu.lclark.language.questions;

import edu.lclark.language.questions.QuestionInfo.QuestionType;

import java.util.ArrayList;
import java.util.List;

/** A question where the student fills a word or short phrase into a blank. */
public class FillInTheBlankQuestion extends AbstractQuestion {

	/** The part of the question before the blank. */
	private String before;

	/** The part of the question after the blank. */
	private String after;

	public FillInTheBlankQuestion() {
		setQuestionType(QuestionType.FILL_IN_THE_BLANK);
		setAnswers(new String[0]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.lclark.language.questions.AbstractQuestion#setText(java.lang.String)
	 * 
	 * Overides Abstract Questions set text. Find the underscore that represents
	 * the blank, and parses the questions string into before and after the
	 * blank
	 * 
	 * @param text: string containing the question text 
	 * 
	 * 
	 */
	public void setText(String text) {
		int blank = text.indexOf('_');
		before = text.substring(0, blank);
		if (blank == text.length() - 1) {
			after = "";
		} else {
			after = text.substring(blank + 1, text.length());
		}
		this.text = text;
	}

	public boolean isCorrectAnswer(String studentAnswer) {
		studentAnswer = studentAnswer.trim();
		studentAnswer = studentAnswer.toLowerCase();
		for (int i = 0; i < getNumberOfCorrectAnswers(); i++) {
			if (correctAnswers[i].equals(studentAnswer))
				return true;
		}
		return false;
	}

	/** Returns a list of words before the blank. 
	 * 
	 * @return answer a list of the words as string
	 * 
	 */
	
	public List<String> getWordsBeforeBlank() {
		String[] words = before.split(" ");
		List<String> answer = new ArrayList<String>();
		for (String w : words) {
			answer.add(w + " ");
		}
		return answer;
	}

	/**Returns a list of words before the blank. 
	 * 
	 * @return answer a list of the words as string
	 * 
	 */
	public List<String> getWordsAfterBlank() {
		String[] words = after.split(" ");
		List<String> answer = new ArrayList<String>();
		for (String w : words) {
			answer.add(w + " ");
		}
		return answer;
	}

}
