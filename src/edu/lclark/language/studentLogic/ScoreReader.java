package edu.lclark.language.studentLogic;

import edu.lclark.language.LanguagePlacementExam;
import edu.lclark.language.questions.QuestionInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		Collections.sort(scores, new Comparator<StudentScore>(){
		    public int compare(StudentScore s1, StudentScore s2) {
		        return s2.getDate().compareTo(s1.getDate());
		    }
		});
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
			in.close();
			return new StudentScore(name, date, QuestionInfo.createQuestionLevel(level));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

