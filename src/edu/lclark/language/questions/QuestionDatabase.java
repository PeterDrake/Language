package edu.lclark.language.questions;

import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

import java.util.ArrayList;

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
	
	public void setTestPath(){
		writer.setTestPath();
		reader.setTestPath(); 
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

	/* (non-Javadoc)
	 * @see edu.lclark.language.questions.ExamDatabaseInterface#getAllQuestions()
	 * 
	 * Returns an ArrayList that is a duplicate of the database ArrayList of AbstractQuestions.
	 */
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
	
	@Override
	public void reloadDatabase()
	{
		loadQuestionsFromFile();
	}
}
