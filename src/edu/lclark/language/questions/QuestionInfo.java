package edu.lclark.language.questions;

import edu.lclark.language.LanguagePlacementExam;

/**
 * A class holding a number of static fields for use when creating questions
 * 
 * @author Team Language
 * 
 */
public final class QuestionInfo {

	public static String QUESTIONS_PATH = LanguagePlacementExam.PATH
			+ "questions.xml";
	public static final String TEST_QUESTIONS_PATH = LanguagePlacementExam.PATH
			+ "testQuestions.xml";

	public enum QuestionType {
		MULTIPLE_CHOICE, FILL_IN_THE_BLANK, SHORT_ANSWER
	}

	public enum QuestionLevel {
		LEVEL_101(0, "101", new Topic[] { 
				Topic.NOUNS_ARTICLES,
				Topic.ADJECTIVES,
				Topic.NUMBERS,
				Topic.POSSESSIVES,
				Topic.CONJ_PRES_REG,
				Topic.TIME,
				Topic.QUESTIONS,
				Topic.CONJ_PRES_STEM_CHNG,
				Topic.CONJ_PRES_IRREG,
				Topic.SER_ESTAR,
				Topic.CONJ_PRES_PROG,
				Topic.DO_PRONOUNS,
				Topic.IO_PRONOUNS}), 
		LEVEL_102(1, "102", new Topic[] {
				Topic.REFLEXIVES,
				Topic.INDEF_NEG_WORDS,
				Topic.SER_ESTAR,
				Topic.GUSTAR,
				Topic.DO_IO_PRONOUNS,
				Topic.CONJ_PRETERITE,
				Topic.COMP_SUPERLATIVE,
				Topic.CONJ_PRET_IMP,
				Topic.QUE_CUAL,
				Topic.POSSESSIVES,
				Topic.PREP_PRONOUNS,
				Topic.SE_CONSTRUCTIONS,
				Topic.ADVERBS,
				Topic.POR_PARA}), 
		LEVEL_201(2, "201",	new Topic[] { 
				Topic.CONJ_PRES_REG_IRREG,
				Topic.CONJ_PRETERITE,
				Topic.CONJ_IMPERFECT,
				Topic.CONJ_PRET_IMP,
				Topic.CONJ_COMMANDS,
				Topic.SUBJ_NOUN,
				Topic.SUBJ_ADJECTIVE,
				Topic.CONJ_FUTURE,
				Topic.CONJ_COND,
				Topic.SER_ESTAR,
				Topic.GUSTAR,
				Topic.DO_IO_PRONOUNS,
				Topic.SABER_CONOCER,
				Topic.REFLEXIVES,
				Topic.POR_PARA,
				Topic.RELATIVE_PRONOUNS}), 
		LEVEL_202(3, "202", new Topic[] { 
				Topic.SUBJ_ADV,
				Topic.PAST_SUBJ,
				Topic.CONJ_PRES_PERF,
				Topic.CONJ_PAST_PERF,
				Topic.CONJ_PAST_PERF_SUBJ,
				Topic.CONJ_FUT_PERF,
				Topic.CONJ_COND_PERF,
				Topic.COMP_SUPERLATIVE,
				Topic.USE_OF_SE,
				Topic.PREPOSITIONS,
				Topic.TRANS_EXPR,
				Topic.PERO_SINO
		}), 
		LEVEL_301(4, "301",	new Topic[] {
				Topic.SER_ESTAR,
				Topic.CONJ_PRET_IMP,
				Topic.SUBJ_IMPERSONAL,
				Topic.SUBJ_NOUN,
				Topic.SUBJ_ADV,
				Topic.SUBJ_ADJECTIVE,
				Topic.TIME_WORDS,
				Topic.VERB_TIME_PRONOUN,
				Topic.PERO_SINO,
				Topic.TRANS_EXPR,
				Topic.MASC_FEM_MEANING,
				Topic.PREPOSITIONS,
				Topic.POR_PARA,
				Topic.REFLEXIVES,
				Topic.ADJ_FORMATION,
				Topic.RELATIVE_PRONOUNS
		});

		private Topic[] topics;
		private int index;
		private String name;

		private QuestionLevel(int index, String name, Topic[] topics) {
			this.topics = topics;
			this.index = index;
			this.name = name;
		}

		public int getIndex() {
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
		NOUNS_ARTICLES("Nouns/Articles"), ADJECTIVES("Adjectives"), NUMBERS("Numbers"),
		POSSESSIVES("Possessives"), CONJ_PRES_REG("Conjugation: Pres. Reg."), TIME("Time"),
		QUESTIONS("Forming questions"), CONJ_PRES_STEM_CHNG("Conjugation: Pres. Stem Change"),
		CONJ_PRES_IRREG("Conjugation: Pres. Irreg."), SER_ESTAR("Ser/Estar"), CONJ_PRES_PROG("Conjugation: Pres. Prog."),
		DO_PRONOUNS("Direct Obj. Pronouns"), IO_PRONOUNS("Indirect Obj. Pronouns"), REFLEXIVES("Reflexives"),
		INDEF_NEG_WORDS("Indefinite/Negative Words"), GUSTAR("Gustar"), DO_IO_PRONOUNS("DO/IO Pronouns"),
		CONJ_PRETERITE("Conjugation: Preterite"), COMP_SUPERLATIVE("Comparative/Superlative"),
		CONJ_PRET_IMP("Conjugation: Pret./Imperfect"), QUE_CUAL("Qué/Cuál"), PREP_PRONOUNS("Prepositional Pronouns"),
		SE_CONSTRUCTIONS("Se Constructions"), ADVERBS("Adverbs"), POR_PARA("Por/Para"), CONJ_PRES_REG_IRREG("Conjugation: Present"),
		CONJ_IMPERFECT("Conjugation: Imperfect"), SUBJ_NOUN("Subjunctive: Noun Clause"), CONJ_COMMANDS("Conjugation: Commands"),
		SUBJ_ADJECTIVE("Subjunctive: Adjective Clause"), CONJ_FUTURE("Conjugation: Future"), CONJ_COND("Conjugation: Condiditional"),
		SABER_CONOCER("Saber/Conocer"), RELATIVE_PRONOUNS("Relative Pronouns"), SUBJ_ADV("Subjunctive: Adverb Clause"),
		PAST_SUBJ("Subjunctive: Past"), CONJ_PRES_PERF("Conjugation: Pres. Perfect"), SUBJ_IMPERSONAL("Subjunctive: Impersonal Expr"),
		TIME_WORDS("Time Words"), USE_OF_SE("Uses of 'se'"), PERO_SINO("Pero/Sino"), PREPOSITIONS("Prepositions"), 
		TRANS_EXPR("Transitional Expr."), VERB_TIME_PRONOUN("Special Verb/Time/Pronoun Constr"), MASC_FEM_MEANING("Masculine/Feminine Meaning"),
		ADJ_FORMATION("Adjective Formation"), CONJ_PRES_PERF_SUBJ("Conjugation: Pres. Perf. Subjunctive"), 
		CONJ_PAST_PERF("Conjugation: Past Perfect"), CONJ_PAST_PERF_SUBJ("Conjugation: Past Perf. Subjunctive"), 
		CONJ_FUT_PERF("Conjugation: Future Perfect"), CONJ_COND_PERF("Conjugation: Conditional Perfect");

		private String name;

		private Topic(String name) {
			this.name = name;
		}

		public String toString() {
			return name;
		}
	}

	public static QuestionLevel getLevelAtIndex(int i) {
		for (QuestionLevel level : QuestionLevel.values()) {
			if (i == level.getIndex()) {
				return level;
			}
		}
		return null;
	}

	public static Topic createQuestionTopic(String name) {
		for (Topic topic : Topic.values()) {
			if (name.equals(topic.toString())) {
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
		for (QuestionLevel level : QuestionLevel.values()) {
			if (levelString.equals(level.toString())) {
				return level;
			}
		}
		return null;
	}

	// private constructor to prevent instantiation
	private QuestionInfo() {

	}

}
