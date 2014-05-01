package edu.lclark.language.studentLogic;

import edu.lclark.language.LanguagePlacementExam;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * This class creates text files containing the information from StudentScore
 * objects and saves them to SCORE_PATH.
 * 
 * @author connorlay
 * 
 */
public class ScoreWriter {

	/**
	 * Creates a text file containing name, date, and level based on a
	 * StudentScore object and saves it in SCORE_PATH.
	 * 
	 * @param score
	 *            The StudentScore object to be saved.
	 */
	public void writeScoreToFile(StudentScore score) {
		String user = score.getUser();
		String date = score.getDate();
		String level = score.getLevel().toString();

		try {
			PrintWriter out = new PrintWriter(LanguagePlacementExam.SCORE_PATH
					+ "/" + user + " " + date + ".txt", "UTF-8");
			out.println(user);
			out.println(date);
			out.println(level);
			out.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a single text file containing the name, date, and level for each
	 * StudentScore in an ArrayList of StudentScores and saves the file in the
	 * path provided.
	 * 
	 * @param scores
	 *            An ArrayList of StudentScores
	 * @param path
	 *            A String of the path to save the text files in.
	 */
	public void writeAllScoresToFile(ArrayList<StudentScore> scores, String path) {

		if (!path.endsWith(".txt")) {
			path += ".txt";
		}
		try {
			PrintWriter out = new PrintWriter(path, "UTF-8");
			for (StudentScore score : scores) {
				out.println(score.getUser());
				out.println(score.getDate());
				out.println(score.getLevel());
				out.println();
			}
			out.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
