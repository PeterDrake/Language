package languageTests.testPageTests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import languageTest.testingResources.DatabaseGenerator;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.LanguagePlacementExam;
import edu.lclark.language.gui.loginPage.Session;
import edu.lclark.language.questions.FillInTheBlankQuestion;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.studentLogic.ScoreReader;
import edu.lclark.language.studentLogic.ScoreWriter;
import edu.lclark.language.studentLogic.StudentScore;

public class ScoreWriterTests {
	private ScoreWriter writer;
	private ScoreReader reader;
	private StudentScore score;
	private Session session;
	private ArrayList<StudentScore> scores;

	@Before
	public void setUp() throws Exception {
		writer = new ScoreWriter();
		reader = new ScoreReader();
		session = new Session("Connor Lay");
		score = new StudentScore(session);
		score.setLevel(QuestionLevel.LEVEL_101);
		scores = reader.getScores();
	}
	
	@Test
	public void testWriteToFile(){
		writer.writeScoreToFile(score);
		assertTrue(new File(LanguagePlacementExam.PATH + "Student Results" + "/Connor Lay " + score.getDate() + ".txt").exists());
	}


}
