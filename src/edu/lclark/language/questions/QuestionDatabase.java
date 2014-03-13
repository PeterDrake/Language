package edu.lclark.language.questions;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.*;

/**
 * Loads question info from the database and constructs question objects out of
 * it, storing them in the appropriate lists.
 */
public class QuestionDatabase {

	private ArrayList<AbstractQuestion> questions;
	private QuestionXMLWriter writer;

	public QuestionDatabase() {
		writer = new QuestionXMLWriter();
		
		questions = new ArrayList<AbstractQuestion>();
		loadQuestionsFromDatabase();
	}

	/**
	 * Reads data from the questions XML file, constructs question objects from
	 * the data and stores them in an ArrayList.
	 */
	public void loadQuestionsFromDatabase() {
		// TODO: Read data from XML file and construct question objects, putting
		// them into their respective lists.
		createExampleQuestions();
	}
	
	//TODO: This is for testing purposes only. Will implement the actual loadQuestionsFromDatabase once other branches are merged in
	public void createExampleQuestions() {
		MultipleChoiceQuestion[] qs = new MultipleChoiceQuestion[4];
		qs[0] = new MultipleChoiceQuestion();
		qs[0].setQuestion("What is your name?");
		qs[0].setAnswers(new String[] { "Andi", "Srey", "Maggie" });
		qs[0].setCorrectAnswerIndex(2);
		qs[0].setLevel(101);
		qs[1] = new MultipleChoiceQuestion();
		qs[1].setQuestion("What is your favorite color?");
		qs[1].setAnswers(new String[] { "Blue", "Yellow", "Green", "Red" });
		qs[1].setCorrectAnswerIndex(3);
		qs[1].setLevel(101);
		qs[2] = new MultipleChoiceQuestion();
		qs[2].setQuestion("What is your quest?");
		qs[2].setAnswers(new String[] { "Grail", "Food" });
		qs[2].setCorrectAnswerIndex(1);
		qs[2].setLevel(101);
		qs[3] = new MultipleChoiceQuestion();
		qs[3].setQuestion("What is the avg speed of a swallow?");
		qs[3].setAnswers(new String[] { "45", "57", "20" });
		qs[3].setCorrectAnswerIndex(1);
		qs[3].setLevel(101);
		questions.add(qs[0]);
		questions.add(qs[1]);
		questions.add(qs[2]);
		questions.add(qs[3]);
	}

	/**
	 * Gets a random question of a given level.
	 * 
	 * @param level
	 *            The level of the question to be returned.
	 * @return A random question of the given level.
	 */
	public AbstractQuestion getQuestion(int level) {
		return getRandomQuestion(getQuestionsOfLevel(level));
	}

	/**
	 * Generates an ArrayList of questions of a specified level.
	 * 
	 * @param level
	 *            The level of the questions to be filtered.
	 * @return An ArrayList of questions of the given level.
	 */
	public ArrayList<AbstractQuestion> getQuestionsOfLevel(int level) {
		ArrayList<AbstractQuestion> filteredQuestions = new ArrayList<AbstractQuestion>();
		for (AbstractQuestion question : questions) {
			if (question.getLevel() == level) {
				filteredQuestions.add(question);
			}
		}
		return filteredQuestions;
	}

	/**
	 * Gets a random question from an ArrayList of Questions.
	 * 
	 * @param list
	 * @return A random question from the list.
	 */
	private AbstractQuestion getRandomQuestion(ArrayList<AbstractQuestion> list) {
		if (list.isEmpty()) {
			return null;
		}
		Random random = new Random();
		return list.get(random.nextInt(list.size()));
	}
	
	public void writeQuestions(){
		writer.createNewDocument();
		writer.fillXMLDocument(questions);
		writer.writeToFile();
	}

}
