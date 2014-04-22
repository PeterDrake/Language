package edu.lclark.language.studentLogic;

import edu.lclark.language.gui.loginPage.Session;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

public class StudentScore {
	
	String user;
	String date;
	QuestionLevel level;
	
	public StudentScore(Session session){
		user = session.getUser();
		date = session.getDate();
	}
	
	public StudentScore() {
		
	}

	public void setLevel(QuestionLevel level){
		this.level = level;
	}
	
	public String getUser(){
		return user;
	}
	
	public String getDate(){
		return date;
	}
	
	public QuestionLevel getLevel(){
		return level;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
