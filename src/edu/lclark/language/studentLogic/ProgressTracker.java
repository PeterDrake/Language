package edu.lclark.language.studentLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.lclark.language.LanguagePlacementExam;
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
	private QuestionLevel placementLevel;
	private int iterationsComplete;
	
	private int questionsToPass;
	private int questionsPerLevel;
	private int maxIterations;

	public ProgressTracker() {
		this(new QuestionFactory());
	}

	public ProgressTracker(QuestionFactory factory) {
		this.factory = factory;
		questionsAnswered = 0;
		questionsCorrect = 0;
		currentLevel = QuestionLevel.LEVEL_101;
		placementLevel = QuestionLevel.LEVEL_101;
		
		loadTestSettings();
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
	
	public int getMaxIterations(){
		return maxIterations;
	}
	
	void loadTestSettings(){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(LanguagePlacementExam.PATH + "settings.txt")), "UTF-8"));
			questionsPerLevel = Integer.parseInt(in.readLine());
			questionsToPass = Integer.parseInt(in.readLine());
			maxIterations = Integer.parseInt(in.readLine());
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Called when a question has just been answered. Updates the test status
	 * based on whether the answer was correct.
	 */
	public void updateTestProgress(boolean correct) {
		System.out.println(questionsAnswered);
		if (correct) {
			questionsCorrect = questionsPerLevel == questionsAnswered ? 1
					: questionsCorrect + 1;
		} else {
			questionsCorrect = questionsPerLevel == questionsAnswered ? 0
					: questionsCorrect;
		}
		questionsAnswered = questionsPerLevel == questionsAnswered ? 1
				: questionsAnswered + 1;
		if (questionsAnswered == questionsPerLevel) {
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

		if (questionsAnswered == questionsPerLevel
				&& questionsCorrect == questionsToPass) {
			currentLevel = QuestionInfo.getNextLevel(currentLevel);
			if(currentLevel.getIndex() - placementLevel.getIndex() > 1){
				placementLevel = QuestionInfo.getNextLevel(placementLevel);
			}
			return currentLevel;
		} else if (questionsAnswered == questionsPerLevel
				&& questionsCorrect < questionsToPass) {
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
