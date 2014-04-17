package edu.lclark.language.studentLogic;

import java.util.ArrayList;

import edu.lclark.language.questions.AbstractQuestion;

public class ScoreRecorder {

	private ArrayList<String> questionsToWrite;

	public ScoreRecorder() {
		questionsToWrite = new ArrayList<String>();
	}

	public ArrayList<String> getQuestionsToWrite() {
		return questionsToWrite;
	}

	public void addQuestion(AbstractQuestion question, String response) {
		questionsToWrite.add(new String("Question: " + question.getText() + ", Student Answer: "
				+ response));
	}
	
	public String createResultsString(){
		String results = "";
		return results;
	}
	
	public void writeResultsFile(){
		
	}

}
