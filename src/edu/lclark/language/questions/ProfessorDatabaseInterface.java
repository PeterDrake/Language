package edu.lclark.language.questions;

import java.util.ArrayList;

import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

public interface ProfessorDatabaseInterface {
	
	public ArrayList<AbstractQuestion> getQuestionsOfLevel(QuestionLevel level);
	public void deleteQuestion(AbstractQuestion question);
	public void addQuestion(AbstractQuestion question);
	public void updateQuestions();

}
