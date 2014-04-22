package languageTests.testPageTests;

import static org.junit.Assert.*;
import languageTest.testingResources.DatabaseGenerator;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.FillInTheBlankQuestion;
import edu.lclark.language.studentLogic.ScoreRecorder;

public class ScoreRecorderTests {
	private ScoreRecorder recorder;

	@Before
	public void setUp() throws Exception {
		recorder = new ScoreRecorder();

	}
	
	@Test
	public void testWriteToFile(){
		
	}
	
	@Test
	public void testReadFile(){
		
	}

}
