package edu.lclark.language.questions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FillInTheBlankQuestionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsCorrect() {
		FillInTheBlankQuestion q = new FillInTheBlankQuestion("¿Dónde _ el baño, por favor?", "está");
		assertTrue(q.isCorrect("está"));
		assertFalse(q.isCorrect("esta"));
		assertTrue(q.isCorrect("está "));
	}

}
