package edu.lclark.language.questions;

import static org.junit.Assert.*;

import java.util.*;
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
	
	@Test
	public void testSeparateWords() {
		FillInTheBlankQuestion q = new FillInTheBlankQuestion("¿Dónde _ el baño, por favor?", "está");
		List<String> correctBefore = new ArrayList<String>();
		correctBefore.add("¿Dónde ");
		List<String> correctAfter = new ArrayList<String>();
		correctAfter.add("el ");
		correctAfter.add("baño, ");
		correctAfter.add("por ");
		correctAfter.add("favor? ");
		assertEquals(correctBefore, q.getWordsBeforeBlank());
		assertEquals(correctAfter, q.getWordsAfterBlank());
	}

}
