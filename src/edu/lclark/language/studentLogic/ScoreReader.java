package edu.lclark.language.studentLogic;

import edu.lclark.language.LanguagePlacementExam;
import edu.lclark.language.questions.QuestionInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * This class reads in text files storing StudentScore information from SCORE_PATH and
 * constructs the appropriate StudentScore objects.
 * 
 * @author Team Language
 * 
 */

public class ScoreReader {

	public ScoreReader() {

	}

	/**
	 * Reads in all student score text files within SCORE_PATH into an
	 * ArrayList.
	 * 
	 * @return An ArrayList of StudentScores
	 */
	public ArrayList<StudentScore> getScores() {
		ArrayList<StudentScore> scores = new ArrayList<StudentScore>();
		File folder = new File(LanguagePlacementExam.SCORE_PATH);
		for (File file : folder.listFiles()) {
			if (file.toString().endsWith(".txt")) {
				scores.add(readScoreFile(file));
			}
		}
		Collections.sort(scores, new Comparator<StudentScore>() {
			public int compare(StudentScore s1, StudentScore s2) {
				return s2.getDate().compareTo(s1.getDate());
			}
		});
		return scores;
	}

	/**
	 * Creates a StudentScore object based on a given score file path.
	 * 
	 * @param scoreFile
	 *            The path of a text file containing the name, date, and level
	 *            of a student score.
	 * @return A StudentScore based on the given scoreFile.
	 */
	private StudentScore readScoreFile(File scoreFile) {
		String name;
		String date;
		String level;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(scoreFile), "UTF-8"));
			name = in.readLine();
			date = in.readLine();
			level = in.readLine();
			in.close();
			return new StudentScore(name, date, QuestionInfo.createQuestionLevel(level));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
