package edu.lclark.language.questions;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.*;

import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

/**
 * Loads question info from the database and constructs question objects out of
 * it, storing them in the appropriate lists.
 */
public class QuestionDatabase implements ProfessorDatabaseInterface, ExamDatabaseInterface{

	private ArrayList<AbstractQuestion> questions;
	private QuestionXMLWriter writer;
	private QuestionXMLReader reader;

	public QuestionDatabase() {
		writer = new QuestionXMLWriter();
		reader = new QuestionXMLReader();
		questions = new ArrayList<AbstractQuestion>();
		loadQuestionsFromFile();
	}

	/**
	 * Gets a random question of a given level.
	 * 
	 * @param VALID_LEVEL
	 *            The level of the question to be returned.
	 * @return A random question of the given level.
	 */
	public AbstractQuestion getQuestion(QuestionLevel level) {
		return getRandomQuestion(getQuestionsOfLevel(level));
	}

	/**
	 * Generates an ArrayList of questions of a specified level.
	 * 
	 * @param level
	 *            The level of the questions to be filtered.
	 * @return An ArrayList of questions of the given level.
	 */
	@Override
	public ArrayList<AbstractQuestion> getQuestionsOfLevel(QuestionLevel level) {
		ArrayList<AbstractQuestion> filteredQuestions = new ArrayList<AbstractQuestion>();
		for (AbstractQuestion question : questions) {
			if (question.getLevel().equals(level)) {
				filteredQuestions.add(question);
			}
		}
		return filteredQuestions;
	}

	@Override
	public ArrayList<AbstractQuestion> getAllQuestions() {
		ArrayList<AbstractQuestion> allQuestions = new ArrayList<AbstractQuestion>();
		for(AbstractQuestion question: questions){
			allQuestions.add(question);
		}
		return allQuestions;
	}

	public void setQuestions(ArrayList<AbstractQuestion> questions) {
		this.questions = questions;
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
	
	/**
	 * Reads data from the questions XML file, constructs question objects from
	 * the data and stores them in an ArrayList.
	 */
	public void loadQuestionsFromFile() {
		reader.loadXMLFile();
		reader.parseXMLFile();
		questions = reader.loadQuestionsFromFile();
	}

	public void writeQuestionsToFile(){
		writer.createNewDocument();
		writer.fillXMLDocument(questions);
		writer.writeToFile();
	}

	@Override
	public void deleteQuestion(AbstractQuestion question) {
		questions.remove(question);
		writeQuestionsToFile();
	}

	@Override
	public void addQuestion(AbstractQuestion question) {
		questions.add(question);
		writeQuestionsToFile();
	}

	@Override
	public void updateQuestions() {
		writeQuestionsToFile();
	}

}
