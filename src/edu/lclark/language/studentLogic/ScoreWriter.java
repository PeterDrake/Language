package edu.lclark.language.studentLogic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import edu.lclark.language.LanguagePlacementTest;
import edu.lclark.language.questions.AbstractQuestion;

public class ScoreWriter {
	
	public void recordScore(boolean isCorrect, AbstractQuestion question){

	}

	public void writeToFile(StudentScore score) {
		String user = score.getUser();
		String date = score.getDate();
		String level = score.getLevel().toString();
		
		try {
			PrintWriter out = new PrintWriter(LanguagePlacementTest.PATH + "Student Results/" +  user + " " + date + ".txt");
			out.println(user);
			out.println(date);
			out.println("Level: " + level);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
