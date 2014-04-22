package languageTests.testPageTests;

import static org.junit.Assert.*;
import languageTest.testingResources.DatabaseGenerator;

import org.junit.Before;
import org.junit.Test;

import edu.lclark.language.questions.FillInTheBlankQuestion;
import edu.lclark.language.studentLogic.ScoreWriter;

public class ScoreWriterTests {
	private ScoreWriter writer;

	@Before
	public void setUp() throws Exception {
		writer = new ScoreWriter();
		
	}
	
	@Test
	public void testWriteToFile(){
		
	}

}
