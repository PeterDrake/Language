package edu.lclark.language.questions;

import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

import java.util.ArrayList;

public interface ProfessorDatabaseInterface {
	
	public ArrayList<AbstractQuestion> getQuestionsOfLevel(QuestionLevel level);
	public void deleteQuestion(AbstractQuestion question);
	public void addQuestion(AbstractQuestion question);
	public void updateQuestions();
	public void reloadDatabase();

}
