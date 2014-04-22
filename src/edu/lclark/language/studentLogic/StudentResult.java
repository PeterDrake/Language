package edu.lclark.language.studentLogic;

import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

public class StudentResult {

	private String name;
	private String date;
	private QuestionLevel level;
	
	public StudentResult(String name, String date, QuestionLevel level){
		this.name = name;
		this.date = date;
		this.level = level; 
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public QuestionLevel getLevel() {
		return level;
	}
	
}
