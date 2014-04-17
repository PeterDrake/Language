package edu.lclark.language.gui.studentPage;

import edu.lclark.language.gui.AbstractPage;
import edu.lclark.language.gui.MainWindow;

import java.awt.*;

import javax.swing.*;

import edu.lclark.language.gui.ImageComponent;
import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.loginPage.LoginPage;
import edu.lclark.language.gui.professorPage.ProfessorPage;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

import java.awt.event.*;
import java.util.Scanner;

/**
 * Accessible to students who have already taken the test. Displays the the
 * results of the student's test.
 */
public class StudentResultsPage extends AbstractUserPage {

	QuestionLevel level;
	String conditionalText;

	public StudentResultsPage(MainWindow main, QuestionLevel studentLevel) {
		super(main);
		level = studentLevel;
		String levelText = level.toString().substring(6);
		
		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		content.setLayout(layout);
		content.setBackground(Color.WHITE);
		title.setText("Student Results");

		JButton exitTestButton = new JButton("Exit Test");
		exitTestButton.addActionListener(new BeginButtonAction());
		
		String text = "You have placed into Español " + levelText + "!";
		
		if(Integer.parseInt(levelText) == 202 || Integer.parseInt(levelText) == 301){
			conditionalText = "You have placed high enough to fulfill your foriegn language requirement. "
					+ "As a result, you will have to take this test again.";
			
		} else {
			conditionalText = "You are now cleared to register in Spanish " + levelText + " or lower.";
			
		}
		
		JLabel endText = new JLabel(
				"You have now completed the Spanish Foreign Language Exam");
		JLabel studentTestInformation = new JLabel(text);
		
		JLabel instructions = new JLabel(conditionalText);
		
		// test for accents 
		
		//JTextArea area = new JTextArea("test", 2, 2);
		//content.add(area,
			//	new GBC(0, 1).setWeight(50, 50).setAnchor(GBC.NORTH));
		
		
		
		//accents end test

		// add components to GridBagLayout
		content.add(endText,
				new GBC(0, 1).setWeight(50, 50).setAnchor(GBC.SOUTH));
		
		content.add(instructions, 
				new GBC(0, 3).setWeight(50, 50).setAnchor(GBC.NORTH));

		content.add(exitTestButton,
				new GBC(0, 4).setWeight(50, 50).setAnchor(GBC.CENTER));

		content.add(studentTestInformation, new GBC(0, 2).setWeight(50, 50)
				.setAnchor(GBC.CENTER));

		JScrollPane sPane = new JScrollPane(content);
		sPane.getVerticalScrollBar().setUnitIncrement(16);
		add(sPane, BorderLayout.CENTER);

	}


	private class BeginButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			// System.out.println("Begin button!");
			MainWindow main = getMainWindow();
			main.switchPage(new LoginPage(main));
		}

	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

}
