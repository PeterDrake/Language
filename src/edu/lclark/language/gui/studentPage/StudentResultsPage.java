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

	public StudentResultsPage(MainWindow main) {
		super(main);

		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		content.setLayout(layout);
		content.setBackground(Color.WHITE);
		title.setText("Student Results");

		String text = "You have placed into Español " + level + "!";

		JButton exitTestButton = new JButton("Exit Test");
		exitTestButton.addActionListener(new BeginButtonAction());

		JLabel endText = new JLabel(
				"You have now completed the Spanish Foreign Language Exam");
		JLabel studentTestInformation = new JLabel(text);

		// add components to GridBagLayout
		content.add(endText,
				new GBC(0, 1).setWeight(50, 50).setAnchor(GBC.CENTER));

		content.add(exitTestButton,
				new GBC(0, 3).setWeight(0, 0).setAnchor(GBC.CENTER));

		content.add(studentTestInformation, new GBC(0, 2).setWeight(100, 100)
				.setAnchor(GBC.NORTH));

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

	public void setLevel(QuestionLevel currentLevel) {
		level = currentLevel;
	}

}
