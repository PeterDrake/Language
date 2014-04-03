package edu.lclark.language.testPage;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import edu.lclark.language.LanguagePlacementTest;
import edu.lclark.language.questions.*;
import edu.lclark.language.questions.QuestionInfo.*;

public class QuestionFactory {

	private ArrayList<AbstractQuestion> database;

	public QuestionFactory() {
		database = LanguagePlacementTest.questionDatabase.getAllQuestions();
	}

	public QuestionFactory(ArrayList<AbstractQuestion> questions) {
		database = questions;
	}

	public AbstractQuestionPanel getQuestionPanelOfLevel(QuestionLevel level) {
		// TODO: Implement this method!
		AbstractQuestion question = getRandomQuestion(getQuestionsOfLevel(level));
		AbstractQuestionPanel panel = null;
		
		if (question.getQuestionType() == QuestionType.MULTIPLE_CHOICE) {
			panel = new MultipleChoiceQuestionPanel((MultipleChoiceQuestion) question);
		} else if (question.getQuestionType() == QuestionType.SHORT_ANSWER) {
			panel = new ShortAnswerQuestionPanel((ShortAnswerQuestion) question);
		} else if (question.getQuestionType() == QuestionType.FILL_IN_THE_BLANK) {
			panel = new FillInTheBlankPanel((FillInTheBlankQuestion) question);
		}
		return panel;
	}

	public ArrayList<AbstractQuestion> getDatabase() {
		return database;
	}

	private ArrayList<AbstractQuestion> getQuestionsOfLevel(QuestionLevel level) {
		ArrayList<AbstractQuestion> filteredQuestions = new ArrayList<AbstractQuestion>();
		for (AbstractQuestion question : database) {
			if (question.getLevel().equals(level)) {
				filteredQuestions.add(question);
			}
		}
		return filteredQuestions;
	}

	public AbstractQuestion getRandomQuestion(
			ArrayList<AbstractQuestion> questions) {
		if (questions.isEmpty()) {
			return null;
		}
		Random random = new Random();
		AbstractQuestion question = questions.get(random.nextInt(questions
				.size()));
		database.remove(question);
		return question;
	}

}
