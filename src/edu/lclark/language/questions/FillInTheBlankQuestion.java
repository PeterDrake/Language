package edu.lclark.language.questions;

import java.util.ArrayList;
import java.util.List;

/** A question where the student fills a word or short phrase into a blank. */
public class FillInTheBlankQuestion extends AbstractQuestion {

	/** The part of the question before the blank. */
	private String before;
	
	/** The part of the question after the blank. */
	private String after;
	
	/** The correct answer to this question. */
	private String correctAnswer;
	
	/** Example of argument: "¿Dónde _ el baño, por favor?" */
	public FillInTheBlankQuestion(String question, String correctAnswer) {
		int blank = question.indexOf('_');
		before = question.substring(0, blank);
		after = question.substring(blank + 2, question.length());
		this.correctAnswer = correctAnswer.trim();
	}

	/** Returns true if the answer is correct. */
	public boolean isCorrect(String answer) {
		return answer.trim().equals(correctAnswer);
	}

	/** Returns a list of words before the blank. */
	public List<String> getWordsBeforeBlank() {
		String[] words = before.split(" ");
		List<String> answer = new ArrayList<String>();
		for(String w : words){
			answer.add(w + " ");
		}
		return answer;
	}

	public List<String> getWordsAfterBlank() {
		String[] words = after.split(" ");
		List<String> answer = new ArrayList<String>();
		for(String w : words){
			answer.add(w + " ");
		}
		return answer;
	}

}
