package languageTests.questionTests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import edu.lclark.language.questions.QuestionXMLReader;

public class QuestionXMLReaderTests {

	private QuestionXMLReader reader;
	
	@Before
	public void setUp(){
		reader = new QuestionXMLReader();
		reader.loadXMLFile();
	}

	@Test
	public void testLoadXMLFile() {
		assertNotNull(reader.xmlFile);
		assertTrue(reader.xmlFile.exists());
	}
	
	@Test
	public void testParseXMLFile(){
		Document doc = reader.parseXMLFile();
		assertNotNull(doc);
		assertEquals("test", doc.getDocumentElement().getTagName());
	}
	
	//TODO: Finish writing this test!
	/*@Test
	public void testLoadQuestionsFromFile(){
		assertNotNull(reader.loadQuestionsFromFile());
		reader.loadQuestionsFromFile();
	}*/

}
