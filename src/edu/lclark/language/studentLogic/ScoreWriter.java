package edu.lclark.language.studentLogic;

import edu.lclark.language.LanguagePlacementExam;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ScoreWriter {

	public void writeScoreToFile(StudentScore score) {
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
	
	public void writeAllScoresToFile(ArrayList<StudentScore> scores, String path){
		
		if (!path.endsWith(".txt")){
			path += ".txt";
		}
		try {
			PrintWriter out = new PrintWriter(path, "UTF-8");
			for(StudentScore score: scores){
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
