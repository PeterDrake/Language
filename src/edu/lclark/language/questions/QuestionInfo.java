package edu.lclark.language.questions;

import java.io.File;

import edu.lclark.language.LanguagePlacementTest;

public final class QuestionInfo {

	public static final int QUESTIONS_PER_LEVEL = 2;
	public static final int QUESTIONS_CORRECT_TO_PASS = 2;
	public static final int MAX_ITERATIONS = 7;

	public static String QUESTIONS_PATH = LanguagePlacementTest.PATH + "questions.xml";
	public static final String TEST_QUESTIONS_PATH = LanguagePlacementTest.PATH + "testQuestions.xml";

	public enum QuestionType {
		MULTIPLE_CHOICE, FILL_IN_THE_BLANK, SHORT_ANSWER
	}

	public enum QuestionLevel {
		LEVEL_101(0, new Topic[] { Topic.SER_ESTAR, Topic.GUSTAR, Topic.SABER_CONOCER }),
		LEVEL_102(1, new Topic[] { Topic.DO_IO, Topic.CONJ_PRET_IRREG, Topic.COMPARATIVE_SUPERLATIVE}),
		LEVEL_201(2, new Topic[] { Topic.POSSESSIVES, Topic.REFLEXIVES }),
		LEVEL_202(3,new Topic[] { Topic.CONJ_PRES_IRREG, Topic.CONJ_PRET_REG }),
		LEVEL_301(4,new Topic[] { Topic.CONJ_PRES_REG, Topic.DO_IO });

		private Topic[] topics;
		private int index;

		private QuestionLevel(int index, Topic[] topics) {
			this.topics = topics;
			this.index = index;
		}
		
		public int getIndex(){
			return index;
		}

		public Topic[] getTopics() {
			return topics;
		}
	}

	public enum Topic {
		SER_ESTAR("Ser/Estar"),
		SABER_CONOCER("Saber/Conocer"),
		GUSTAR("Gustar"),
		DO_IO("Direct/Indirect Objects"),
		REFLEXIVES("Reflexives"),
		CONJ_PRES_REG("Conjugation: Present Reg."),
		CONJ_PRES_IRREG("Conjugation: Present Irreg."),
		POSSESSIVES("Possessives"),
		CONJ_PRET_REG("Conjugation: Preterite Reg."),
		CONJ_PRET_IRREG("Conjugation: Preterite Irreg."),
		COMPARATIVE_SUPERLATIVE("Comparative/Superlative");
		
		private String name;

		private Topic(String name) {
			this.name = name;
		}

		public String toString() {
			return name;
		}
	}
	
	public static Topic createQuestionTopic(String name){
		for(Topic topic : Topic.values()){
			if(name.equals(topic.toString())){
				return topic;
			}
		}
		return null;
	}

	public static QuestionLevel getNextLevel(QuestionLevel currentLevel) {
		if (currentLevel == QuestionLevel.LEVEL_101) {
			return QuestionLevel.LEVEL_102;
		} else if (currentLevel == QuestionLevel.LEVEL_102) {
			return QuestionLevel.LEVEL_201;
		} else if (currentLevel == QuestionLevel.LEVEL_201) {
			return QuestionLevel.LEVEL_202;
		} else if (currentLevel == QuestionLevel.LEVEL_202) {
			return QuestionLevel.LEVEL_301;
		} else {
			return currentLevel;
		}
	}

	public static QuestionLevel getPreviousLevel(QuestionLevel currentLevel) {
		if (currentLevel == QuestionLevel.LEVEL_301) {
			return QuestionLevel.LEVEL_202;
		} else if (currentLevel == QuestionLevel.LEVEL_202) {
			return QuestionLevel.LEVEL_201;
		} else if (currentLevel == QuestionLevel.LEVEL_201) {
			return QuestionLevel.LEVEL_102;
		} else if (currentLevel == QuestionLevel.LEVEL_102) {
			return QuestionLevel.LEVEL_101;
		} else {
			return currentLevel;
		}
	}

	public static QuestionLevel createQuestionLevel(String levelString) {
		for(QuestionLevel level : QuestionLevel.values()){
			if(levelString.equals(level.toString())){
				return level;
			}
		}
		return null;
	}

	public static MultipleChoiceQuestion getSampleMultipleChoiceQuestion() {
		MultipleChoiceQuestion question = new MultipleChoiceQuestion();
		question.setText("Translate: Hello");
		question.setAnswers(new String[] { "Adiós", "Hola", "¿Cómo estás?" });
		question.setCorrectAnswers(new String[] { "Hola" });
		question.setLevel(QuestionLevel.LEVEL_101);
		return question;
	}

	public static FillInTheBlankQuestion getSampleFillInTheBlankQuestion() {
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
