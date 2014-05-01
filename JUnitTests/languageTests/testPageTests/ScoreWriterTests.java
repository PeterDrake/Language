package languageTests.testPageTests;

import edu.lclark.language.LanguagePlacementExam;
import edu.lclark.language.gui.loginPage.Session;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.studentLogic.ScoreWriter;
import edu.lclark.language.studentLogic.StudentScore;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class ScoreWriterTests {
	private ScoreWriter writer;
	private StudentScore score;
	private Session session;

	@Before
	public void setUp() throws Exception {
		writer = new ScoreWriter();
		session = new Session("Connor Lay");
		score = new StudentScore(session);
		score.setLevel(QuestionLevel.LEVEL_101);
	}
	
	@Test
	public void testWriteToFile(){
		writer.writeScoreToFile(score);
		assertTrue(new File(LanguagePlacementExam.PATH + "Student Results" + "/Connor Lay " + score.getDate() + ".txt").exists());
	}


}
