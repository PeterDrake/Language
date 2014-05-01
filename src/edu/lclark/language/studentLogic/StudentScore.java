package edu.lclark.language.studentLogic;

import edu.lclark.language.gui.loginPage.Session;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

/**
 * This class stores the name, date, and level of a completed Language Placement
 * Exam. Is constructed from a Session or from information read in from a text file.
 * 
 * @author connorlay
 * 
 */
public class StudentScore {

	String user;
	String date;
	QuestionLevel level;

	public StudentScore(Session session) {
		user = session.getUser();
		date = session.getDate();
	}

	public StudentScore(String user, String date, QuestionLevel level) {
		this.user = user;
		this.date = date;
		this.level = level;
	}

	public void setLevel(QuestionLevel level) {
		this.level = level;
	}

	public String getUser() {
		return user;
	}

	public String getDate() {
		return date;
	}

	public QuestionLevel getLevel() {
		return level;
	}

	public String toString() {
		return user + " " + date + " " + level.toString();
	}

}
