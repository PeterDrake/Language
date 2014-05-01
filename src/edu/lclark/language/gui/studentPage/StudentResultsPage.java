package edu.lclark.language.gui.studentPage;

import edu.lclark.language.gui.MainWindow;

import java.awt.*;

import javax.swing.*;

import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.loginPage.LoginPage;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

/**
 * Accessible to students who have already taken the test. Displays the the
 * results of the student's test.
 */
@SuppressWarnings("serial")
public class StudentResultsPage extends AbstractUserPage {

	QuestionLevel level;
	String conditionalText;

	public StudentResultsPage(MainWindow main, QuestionLevel studentLevel) {
		super(main);
		level = studentLevel;
		String levelText = level.toString();

		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		content.setLayout(layout);
		content.setBackground(Color.WHITE);
		title.setText("Student Results");

		JButton exitTestButton = new JButton("Exit Test");
		exitTestButton.addActionListener(new BeginButtonAction());

		URL htmlUrl = ClassLoader.getSystemResource("edu/lclark/language/resources/result1.html");

		if (Integer.parseInt(levelText) == 101) {
			htmlUrl = ClassLoader
					.getSystemResource("edu/lclark/language/resources/result1.html");
		} else if (Integer.parseInt(levelText) == 102) {
			htmlUrl = ClassLoader
					.getSystemResource("edu/lclark/language/resources/result2.html");
		} else if (Integer.parseInt(levelText) == 201) {
			htmlUrl = ClassLoader
					.getSystemResource("edu/lclark/language/resources/result3.html");
		} else if (Integer.parseInt(levelText) == 202
				|| Integer.parseInt(levelText) == 301) {

			htmlUrl = ClassLoader
					.getSystemResource("edu/lclark/language/resources/result4.html");

		}

		JTextPane testResult = new JTextPane();
		try {
			testResult.setPage(htmlUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}


		content.add(testResult);

		content.add(exitTestButton,
				new GBC(0, 4).setWeight(50, 50).setAnchor(GBC.CENTER));

		JScrollPane sPane = new JScrollPane(content);
		sPane.getVerticalScrollBar().setUnitIncrement(16);
		add(sPane, BorderLayout.CENTER);

	}

	private class BeginButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			MainWindow main = getMainWindow();
			main.switchPage(new LoginPage(main));
		}

	}


}
