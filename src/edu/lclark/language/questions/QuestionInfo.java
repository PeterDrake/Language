package edu.lclark.language.questions;

import java.io.File;

public final class QuestionInfo {
	
	public static final int QUESTIONS_PER_LEVEL = 2;
	public static final int QUESTIONS_CORRECT_TO_PASS = 2;

	public static final String PATH = System.getProperty("user.dir")
			+ File.separator + "questions.xml";

	public enum QuestionType {
		MULTIPLE_CHOICE, FILL_IN_THE_BLANK, SHORT_ANSWER
	}

	public enum QuestionLevel {
		LEVEL_101, LEVEL_102, LEVEL_201, LEVEL_202, LEVEL_301;
	}
	
	public static QuestionLevel getNextLevel(QuestionLevel currentLevel){
		if(currentLevel == QuestionLevel.LEVEL_101){
			return QuestionLevel.LEVEL_102;
		}
		else if(currentLevel == QuestionLevel.LEVEL_102){
			return QuestionLevel.LEVEL_201;
		}
		else if(currentLevel == QuestionLevel.LEVEL_201){
			return QuestionLevel.LEVEL_202;
		}
		else if(currentLevel == QuestionLevel.LEVEL_202){
			return QuestionLevel.LEVEL_301;
		}
		else{
			return currentLevel;
		}
	}
	
	public static QuestionLevel getPreviousLevel(QuestionLevel currentLevel){
		if(currentLevel == QuestionLevel.LEVEL_301){
			return QuestionLevel.LEVEL_202;
		}
		else if(currentLevel == QuestionLevel.LEVEL_202){
			return QuestionLevel.LEVEL_201;
		}
		else if(currentLevel == QuestionLevel.LEVEL_201){
			return QuestionLevel.LEVEL_102;
		}
		else if(currentLevel == QuestionLevel.LEVEL_102){
			return QuestionLevel.LEVEL_101;
		}
		else{
			return currentLevel;
		}
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
	
	public static MultipleChoiceQuestion getSampleMultipleChoiceQuestion(){
		MultipleChoiceQuestion question = new MultipleChoiceQuestion();
		question.setText("Translate: Hello");
		question.setAnswers(new String[] { "Adiós", "Hola", "¿Cómo estás?" });
		question.setCorrectAnswers(new String[] { "Hola" });
		question.setLevel(QuestionLevel.LEVEL_101);
		return question;
	}
	
	public static FillInTheBlankQuestion getSampleFillInTheBlankQuestion(){
		FillInTheBlankQuestion question = new FillInTheBlankQuestion();
		question.setText("¿Hola, _ estás?");
		question.setAnswers(new String[0]);
		question.setCorrectAnswers(new String[] { "cómo" });
		question.setLevel(QuestionLevel.LEVEL_101);
		return question;
	}
	
	
	// private constructor to prevent instantiation
	private QuestionInfo() {

	}

}
