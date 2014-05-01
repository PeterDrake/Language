package edu.lclark.language.questions;

import edu.lclark.language.LanguagePlacementExam;

public final class QuestionInfo {

	public static String QUESTIONS_PATH = LanguagePlacementExam.PATH + "questions.xml";
	public static final String TEST_QUESTIONS_PATH = LanguagePlacementExam.PATH + "testQuestions.xml";

	public enum QuestionType {
		MULTIPLE_CHOICE, FILL_IN_THE_BLANK, SHORT_ANSWER
	}

	public enum QuestionLevel {
		LEVEL_101(0, "101", new Topic[] { Topic.SER_ESTAR, Topic.GUSTAR, Topic.SABER_CONOCER }),
		LEVEL_102(1, "102", new Topic[] { Topic.DO_IO, Topic.CONJ_PRET_IRREG, Topic.COMPARATIVE_SUPERLATIVE}),
		LEVEL_201(2, "201", new Topic[] { Topic.POSSESSIVES, Topic.REFLEXIVES }),
		LEVEL_202(3, "202", new Topic[] { Topic.CONJ_PRES_IRREG, Topic.CONJ_PRET_REG }),
		LEVEL_301(4, "301", new Topic[] { Topic.CONJ_PRES_REG, Topic.DO_IO });

		private Topic[] topics;
		private int index;
		private String name;
		
		private QuestionLevel(int index, String name, Topic[] topics) {
			this.topics = topics;
			this.index = index;
			this.name = name; 
		}
		
		public int getIndex(){
			return index;
		}

		public Topic[] getTopics() {
			return topics;
		}

		
		public String toString() {
			return name;
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

	public static QuestionLevel getLevelAtIndex(int i){
		for (QuestionLevel level : QuestionLevel.values()) {
			if (i == level.getIndex()) {
				return level;
			}
		}
		return null; 
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

	// private constructor to prevent instantiation
	private QuestionInfo() {

	}

}
