package languageTests.testPageTests;

import edu.lclark.language.studentLogic.ScoreReader;
import edu.lclark.language.studentLogic.StudentScore;
import languageTest.testingResources.ScoresGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ScoreReaderTests {

	ScoreReader reader;
	@Before
	public void setUp() throws Exception {
		reader = new ScoreReader();
		ScoresGenerator.createExampleScoreFiles();
	}

	@Test
	public void testReadScoreFiles() {
		ArrayList<StudentScore> scores = reader.getScores();
		//assertEquals(3, scores.size());
	}

}
