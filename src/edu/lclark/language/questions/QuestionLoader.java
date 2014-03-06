package edu.lclark.language.questions;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.*;

/**Loads question info from the database and constructs question objects out of it, storing them in the appropriate lists. */
public class QuestionLoader {
	
	private ArrayList<Question> questions;
	
	public QuestionLoader(){
		questions = new ArrayList<Question>();
		loadQuestionsFromDatabase();
	}
	
	public void loadQuestionsFromDatabase(){
		//TODO: Read data from XML file and construct question objects, putting them into their respective lists.
		Question sampleQuestion = new MultipleChoiceQuestion();
		sampleQuestion.setLevel(101);
		questions.add(sampleQuestion);
	}
	
	/**
	 * Gets a random question of a given level.
	 * @param level The level of the question to be returned.
	 * @return A random question of the given level.
	 */
	public Question getQuestion(int level){
		return getRandomQuestion(getQuestionsOfLevel(level));
	}
	
	/**
	 * Generates an ArrayList of questions of a specified level.
	 * @param level The level of the questions to be filtered.
	 * @return An ArrayList of questions of the given level.
	 */
	public ArrayList<Question> getQuestionsOfLevel(int level){
		ArrayList<Question> filteredQuestions = new ArrayList<Question>();
		for(Question question: questions){
			if(question.getLevel()==level){
				filteredQuestions.add(question);
			}
		}
		return filteredQuestions;
	}
	
	/**
	 * Gets a random question from an ArrayList of Questions.
	 * @param list 
	 * @return A random question from the list.
	 */
	private Question getRandomQuestion(ArrayList<Question> list){
		if (list.isEmpty()){
			return null;
		}
		Random random = new Random();
		return list.get(random.nextInt(list.size()));
	}

}
