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
	
	/** Example of argument: "��D��nde _ el ba��o, por favor?" */
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

	@Override
	public boolean isCorrectAnswer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLevel(int level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfAnswers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfCorrectAnswers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCorrectAnswer(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAnswer(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		
	}

}
