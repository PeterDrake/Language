package edu.lclark.language.gui.studentPage;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import languageTest.testingResources.DatabaseGenerator;
import edu.lclark.language.LanguagePlacementTest;
import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.FillInTheBlankQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.QuestionInfo;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.questions.QuestionInfo.QuestionType;
import edu.lclark.language.questions.ShortAnswerQuestion;

public class QuestionFactory {

	private ArrayList<AbstractQuestion> database;
	
	private QuestionLevel currentLevel;

	public QuestionFactory() {
		database = DatabaseGenerator.createExampleQuestions();
		currentLevel = QuestionLevel.LEVEL_101;
	}

	public QuestionFactory(ArrayList<AbstractQuestion> questions) {
		database = questions;
		currentLevel = QuestionLevel.LEVEL_101;
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

	public AbstractQuestionPanel getNextQuestion(int questionsAnswered, int questionsAnsweredCorrectly) throws EmptyDatabaseException {
		QuestionLevel level = getLevelForNextQuestion(questionsAnswered, questionsAnsweredCorrectly);
		AbstractQuestion question = getRandomQuestion(getQuestionsOfLevel(level));
		if(question == null){
			throw new EmptyDatabaseException();
		}
		
		if(question.getQuestionType() == QuestionType.FILL_IN_THE_BLANK){
			return new FillInTheBlankPanel((FillInTheBlankQuestion)question);
		}
		else if(question.getQuestionType() == QuestionType.MULTIPLE_CHOICE){
			return new MultipleChoiceQuestionPanel((MultipleChoiceQuestion)question);
		}
		else if(question.getQuestionType() == QuestionType.SHORT_ANSWER){
			return new ShortAnswerQuestionPanel((ShortAnswerQuestion)question);
		}
		else{
			return null;
		}

	}
	
	private QuestionLevel getLevelForNextQuestion(int questionsAnswered, int correct){
		if(questionsAnswered == 2 && correct == 2){
			System.out.println(currentLevel.next());
			return currentLevel.next();
		}
		else
		{
			return currentLevel;
		}
	}

}
