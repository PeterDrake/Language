package languageTests.testPageTests;

import edu.lclark.language.gui.studentPage.QuestionFactory;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.studentLogic.ProgressTracker;
import languageTest.testingResources.DatabaseGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProgressTrackerTests {

	ProgressTracker pt;
	
	@Before
	public void setUp() throws Exception {
		pt = new ProgressTracker(new QuestionFactory(DatabaseGenerator.createExampleQuestions()));
	}

	@Test
	public void updateProgressTest() {
		pt.updateTestProgress(true);
		pt.updateTestProgress(false);
		assertEquals(2, pt.getQuestionsAnswered());
		assertEquals(1, pt.getQuestionsCorrect());
		pt.updateTestProgress(true);
		assertEquals(1, pt.getQuestionsAnswered());
		assertEquals(1, pt.getQuestionsCorrect());
	}
	
	public void getNextLevelTest(){
		pt.updateTestProgress(true);
		pt.updateTestProgress(true);
		assertEquals(QuestionLevel.LEVEL_102, pt.getLevelForNextQuestion());
		pt.updateTestProgress(false);
		pt.updateTestProgress(false);
		assertEquals(QuestionLevel.LEVEL_101, pt.getLevelForNextQuestion());
	}

}
