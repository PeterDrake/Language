package languageTests.testPageTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import languageTest.testingResources.ScoresGenerator;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.studentLogic.ScoreReader;
import edu.lclark.language.studentLogic.StudentScore;

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
