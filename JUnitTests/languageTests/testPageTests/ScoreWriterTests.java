package languageTests.testPageTests;

import static org.junit.Assert.*;
import languageTest.testingResources.DatabaseGenerator;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.LanguagePlacementTest;
import edu.lclark.language.questions.FillInTheBlankQuestion;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.studentLogic.ScoreWriter;
import edu.lclark.language.studentLogic.StudentScore;

public class ScoreWriterTests {
	private ScoreWriter writer;
	private StudentScore score;

	@Before
	public void setUp() throws Exception {
		writer = new ScoreWriter();
		score = new StudentScore();
		score.setUser("Connor");
		score.setDate("06/04/1995");
		score.setLevel(QuestionLevel.LEVEL_102);
		
	}
	
	@Test
	public void testWriteToFile(){
		writer.writeToFile(score);
	}

}
