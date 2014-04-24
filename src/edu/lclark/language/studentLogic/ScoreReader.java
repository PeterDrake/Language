package edu.lclark.language.studentLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import edu.lclark.language.LanguagePlacementExam;
import edu.lclark.language.questions.QuestionInfo;
public class ScoreReader {

	public ScoreReader(){
		
	}
	
	public ArrayList<StudentScore> getScores(){
		ArrayList<StudentScore> scores = new ArrayList<StudentScore>();
		File folder = new File(LanguagePlacementExam.SCORE_PATH);
		for(File file: folder.listFiles()){
			if (file.toString().endsWith(".txt")){
				scores.add(readScoreFile(file));				
			}
		}
		return scores;
	}
	
	private StudentScore readScoreFile(File scoreFile){
		String name;
		String date;
		String level;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(scoreFile), "UTF-8"));
			name = in.readLine();
			date = in.readLine();
			level = in.readLine();
			return new StudentScore(name, date, QuestionInfo.createQuestionLevel(level));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
