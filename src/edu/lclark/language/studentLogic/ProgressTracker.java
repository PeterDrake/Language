package edu.lclark.language.studentLogic;

import java.util.ArrayList;

import edu.lclark.language.gui.studentPage.AbstractQuestionPanel;
import edu.lclark.language.gui.studentPage.EmptyDatabaseException;
import edu.lclark.language.gui.studentPage.QuestionFactory;
import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.QuestionInfo;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

public class ProgressTracker {

	private QuestionFactory factory;
	private int questionsAnswered;
	private int questionsCorrect;
	private QuestionLevel currentLevel;
	private QuestionLevel placementLevel;
	private int iterationsComplete;
	private ScoreWriter recorder;

	public ProgressTracker() {
		this(new QuestionFactory());
	}

	public ProgressTracker(QuestionFactory factory) {
		this.factory = factory;
		recorder = new ScoreWriter();
		questionsAnswered = 0;
		questionsCorrect = 0;
		currentLevel = QuestionLevel.LEVEL_101;
		placementLevel = QuestionLevel.LEVEL_101;
	}

	public int getQuestionsAnswered() {
		return questionsAnswered;
	}

	public int getQuestionsCorrect() {
		return questionsCorrect;
	}

	public int getIterationsComplete() {
		return iterationsComplete;
	}

	/**
	 * Called when a question has just been answered. Updates the test status
	 * based on whether the answer was correct.
	 */
	public void updateTestProgress(boolean correct) {
		System.out.println(questionsAnswered);
		if (correct) {
			questionsCorrect = QuestionInfo.QUESTIONS_PER_LEVEL == questionsAnswered ? 1
					: questionsCorrect + 1;
		} else {
			questionsCorrect = QuestionInfo.QUESTIONS_PER_LEVEL == questionsAnswered ? 0
					: questionsCorrect;
		}
		questionsAnswered = QuestionInfo.QUESTIONS_PER_LEVEL == questionsAnswered ? 1
				: questionsAnswered + 1;
		if (questionsAnswered == QuestionInfo.QUESTIONS_PER_LEVEL) {
			iterationsComplete++;
		}
	}

	public AbstractQuestionPanel getNextQuestionPanel()
			throws EmptyDatabaseException {
		AbstractQuestionPanel panel = null;
		panel = factory.getNextQuestion(getLevelForNextQuestion());
		System.out.println(currentLevel);
		return panel;
	}

	public AbstractQuestionPanel getFirstQuestionPanel() {
		AbstractQuestionPanel panel = null;
		try {
			panel = factory.getNextQuestion(QuestionLevel.LEVEL_101);
		} catch (EmptyDatabaseException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return panel;
	}

	public QuestionLevel getLevelForNextQuestion() {

		if (questionsAnswered == QuestionInfo.QUESTIONS_PER_LEVEL
				&& questionsCorrect == QuestionInfo.QUESTIONS_CORRECT_TO_PASS) {
			currentLevel = QuestionInfo.getNextLevel(currentLevel);
			if(currentLevel.getIndex() - placementLevel.getIndex() > 1){
				placementLevel = QuestionInfo.getNextLevel(placementLevel);
			}
			return currentLevel;
		} else if (questionsAnswered == QuestionInfo.QUESTIONS_PER_LEVEL
				&& questionsCorrect < QuestionInfo.QUESTIONS_CORRECT_TO_PASS) {
			currentLevel = QuestionInfo.getPreviousLevel(currentLevel);
			if(currentLevel.getIndex() - placementLevel.getIndex() < -1){
				placementLevel = QuestionInfo.getPreviousLevel(placementLevel);
			}
			return currentLevel;
		} else {
			return currentLevel;
		}
	}

	public QuestionLevel getPlacementLevel() {
		return placementLevel;
	}
}
