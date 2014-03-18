package edu.lclark.language.questions;

import java.io.File;

public final class QuestionInfo {
	
	public static final String PATH = System.getProperty("user.dir")
			+ File.separator + "questions.xml";
	
	public enum QuestionType { 
		MULTIPLE_CHOICE, 
		FILL_IN_THE_BLANK, 
		SHORT_ANSWER
	}
	
	//private constructor to prevent instantiation
	private QuestionInfo(){
		
	}

}
