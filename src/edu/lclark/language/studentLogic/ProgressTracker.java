package edu.lclark.language.studentLogic;

import edu.lclark.language.gui.studentPage.AbstractQuestionPanel;
import edu.lclark.language.gui.studentPage.EmptyDatabaseException;
import edu.lclark.language.gui.studentPage.QuestionFactory;
import edu.lclark.language.questions.QuestionInfo;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

public class ProgressTracker {

	private QuestionFactory factory;
	private int questionsAnswered;
	private int questionsCorrect;
	private QuestionLevel currentLevel;

	public ProgressTracker() {
		factory = new QuestionFactory();
		questionsAnswered = 0;
		questionsCorrect = 0;
		currentLevel = QuestionLevel.LEVEL_101;
	}
	
	public int getQuestionsAnswered(){
		return questionsAnswered;
	}
	
	public int getQuestionsCorrect(){
		return questionsCorrect;
	}

	/**Called when a question has just been answered. Updates the test status based on whether the answer was correct. */
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
		if (questionsAnswered == QuestionInfo.QUESTIONS_PER_LEVEL && questionsCorrect == QuestionInfo.QUESTIONS_CORRECT_TO_PASS) {
			currentLevel = QuestionInfo.getNextLevel(currentLevel);
			return currentLevel;
		} else if (questionsAnswered == QuestionInfo.QUESTIONS_PER_LEVEL && questionsCorrect < QuestionInfo.QUESTIONS_CORRECT_TO_PASS) {
			currentLevel = QuestionInfo.getPreviousLevel(currentLevel);
			return currentLevel;
		} else {
			return currentLevel;
		}
	}
}
