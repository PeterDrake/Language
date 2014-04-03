package edu.lclark.language.questions;

import java.io.File;

public final class QuestionInfo {

	public static final String PATH = System.getProperty("user.dir")
			+ File.separator + "questions.xml";

	public enum QuestionType {
		MULTIPLE_CHOICE, FILL_IN_THE_BLANK, SHORT_ANSWER
	}

	public enum QuestionLevel {
		LEVEL_101, LEVEL_102, LEVEL_201, LEVEL_202, LEVEL_301
	}
	
	public static QuestionLevel createQuestionLevel(String level){
		if(level.equals(QuestionLevel.LEVEL_101.toString())){
			return QuestionLevel.LEVEL_101;
		}
		else if(level.equals(QuestionLevel.LEVEL_102.toString())){
			return QuestionLevel.LEVEL_102;
		}
		else if(level.equals(QuestionLevel.LEVEL_201.toString())){
			return QuestionLevel.LEVEL_201;
		}
		else if(level.equals(QuestionLevel.LEVEL_202.toString())){
			return QuestionLevel.LEVEL_202;
		}
		else if(level.equals(QuestionLevel.LEVEL_301.toString())){
			return QuestionLevel.LEVEL_301;
		}
		else{
			return null;
		}			
	}

	// private constructor to prevent instantiation
	private QuestionInfo() {

	}

}
