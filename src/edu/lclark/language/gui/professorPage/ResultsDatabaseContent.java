package edu.lclark.language.gui.professorPage;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.studentLogic.StudentResult;

/**
 * The content panel for viewing student results in the professor page
 */
public class ResultsDatabaseContent extends AbstractContent{
	
	
	public ResultsDatabaseContent(){
		String[] columnNames = { "Name", "Date", "Level" };
//
//		Object[][] data = new Object[createFakeResults().size()][3]; 
//		for (int i = 0; i < data.length; i++) {
//			data[i][] 
//		}

		Object[][] data = {
		        {"Kathy", "Smith",
		         "Snowboarding", new Integer(5), new Boolean(false)},
		        {"John", "Doe",
		         "Rowing", new Integer(3), new Boolean(true)},
		        {"Sue", "Black",
		         "Knitting", new Integer(2), new Boolean(false)},
		        {"Jane", "White",
		         "Speed reading", new Integer(20), new Boolean(true)},
		        {"Joe", "Brown",
		         "Pool", new Integer(10), new Boolean(false)}
		        };
		
		final JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(800, 600));
		table.setFillsViewportHeight(true);
		
		 //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
	}

	public ArrayList <StudentResult> createFakeResults(){
		ArrayList<StudentResult> fakeResults = new ArrayList<StudentResult>();
		
		StudentResult s1 = new StudentResult("Andi", "1", QuestionLevel.LEVEL_101);
		StudentResult s2 = new StudentResult("Andi1", "2", QuestionLevel.LEVEL_102);
		StudentResult s3 = new StudentResult("Andi2", "3", QuestionLevel.LEVEL_201);
		StudentResult s4 = new StudentResult("Andi3", "4", QuestionLevel.LEVEL_202);
		StudentResult s5 = new StudentResult("Andi4", "5", QuestionLevel.LEVEL_301);
		
		fakeResults.add(s1);
		fakeResults.add(s2);
		fakeResults.add(s3);
		fakeResults.add(s4);
		fakeResults.add(s5);
		
		return fakeResults;
		
	}

}
