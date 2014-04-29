package languageTest.testingResources;

import edu.lclark.language.gui.loginPage.Session;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.studentLogic.ScoreWriter;
import edu.lclark.language.studentLogic.StudentScore;

public class ScoresGenerator {

	private static ScoreWriter writer;
	private static Session session;
	private static StudentScore score;
	
	public static void createExampleScoreFiles(){
		writer = new ScoreWriter();
		
		session = new Session("Connor Lay");
		score = new StudentScore(session);
		score.setLevel(QuestionLevel.LEVEL_201);
		writer.writeScoreToFile(score);
		
		session = new Session("Maggie Dreyer");
		score = new StudentScore(session);
		score.setLevel(QuestionLevel.LEVEL_301);
		writer.writeScoreToFile(score);
		
		session = new Session("Andrew King");
		score = new StudentScore(session);
		score.setLevel(QuestionLevel.LEVEL_101);
		writer.writeScoreToFile(score);
	}
}
