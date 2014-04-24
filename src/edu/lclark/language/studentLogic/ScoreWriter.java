package edu.lclark.language.studentLogic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import edu.lclark.language.LanguagePlacementExam;

public class ScoreWriter {

	public void writeToFile(StudentScore score) {
		String user = score.getUser();
		String date = score.getDate();
		String level = score.getLevel().toString();

		try {
			PrintWriter out = new PrintWriter(LanguagePlacementExam.PATH
					+ "Student Results/" + user + " " + date + ".txt", "UTF-8");
			out.println(user);
			out.println(date);
			out.println(level);
			out.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
}
