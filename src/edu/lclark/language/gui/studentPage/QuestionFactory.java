package edu.lclark.language.gui.studentPage;

import edu.lclark.language.LanguagePlacementExam;
import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.FillInTheBlankQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.questions.QuestionInfo.QuestionType;
import edu.lclark.language.questions.ShortAnswerQuestion;

import java.util.ArrayList;
import java.util.Random;

/**
 * Interfaces between QuestionDatabase and ProgressTracker. Handles filtering
 * questions based on level and type.
 * 
 * @author Team Language
 * 
 */
public class QuestionFactory {

	private ArrayList<AbstractQuestion> database;

	public QuestionFactory() {
		database = LanguagePlacementExam.questionDatabase.getAllQuestions();
	}

	public QuestionFactory(ArrayList<AbstractQuestion> questions) {
		database = questions;
	}

	public void printDatabase() {
		for (AbstractQuestion question : database) {
			System.out.print(question.getText() + ",");
		}
	}

	/**
	 * Returns a random QuestionPanel based on a level.
	 * 
	 * @param level
	 *            The level of question to be returned.
	 * @return An AbstractQuestionPanel
	 */
	public AbstractQuestionPanel getQuestionPanelOfLevel(QuestionLevel level) {
		AbstractQuestion question = getRandomQuestion(getQuestionsOfLevel(level));
		AbstractQuestionPanel panel = null;

		if (question.getQuestionType() == QuestionType.MULTIPLE_CHOICE) {
			panel = new MultipleChoiceQuestionPanel(
					(MultipleChoiceQuestion) question);
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

	/**
	 * Filters each question of a specified level and returns an ArrayList.
	 * 
	 * @param level
	 *            The level to be filtered by.
	 * @return An ArrayList of AbstractQuestions
	 */
	private ArrayList<AbstractQuestion> getQuestionsOfLevel(QuestionLevel level) {
		ArrayList<AbstractQuestion> filteredQuestions = new ArrayList<AbstractQuestion>();
		for (AbstractQuestion question : database) {
			if (question.getLevel().equals(level)) {
				filteredQuestions.add(question);
			}
		}
		return filteredQuestions;
	}

	/**
	 * Removes a random question from an ArrayList of AbstractQuestions and
	 * returns it.
	 * 
	 * @param questions
	 *            An ArrayList of AbstractQuestions
	 * @return An AbstractQuestions
	 */
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

	/**
	 * Returns a random AbstractQuestionPanel based on a specified level.
	 * 
	 * @param level
	 *            The level specified.
	 * @return An AbstractQuestionPanel
	 * @throws EmptyDatabaseException
	 */
	public AbstractQuestionPanel getNextQuestion(QuestionLevel level)
			throws EmptyDatabaseException {
		AbstractQuestion question = getRandomQuestion(getQuestionsOfLevel(level));
		if (question == null) {
			throw new EmptyDatabaseException();
		}

		if (question.getQuestionType() == QuestionType.FILL_IN_THE_BLANK) {
			return new FillInTheBlankPanel((FillInTheBlankQuestion) question);
		} else if (question.getQuestionType() == QuestionType.MULTIPLE_CHOICE) {
			return new MultipleChoiceQuestionPanel(
					(MultipleChoiceQuestion) question);
		} else if (question.getQuestionType() == QuestionType.SHORT_ANSWER) {
			return new ShortAnswerQuestionPanel((ShortAnswerQuestion) question);
		} else {
			return null;
		}

	}

}
