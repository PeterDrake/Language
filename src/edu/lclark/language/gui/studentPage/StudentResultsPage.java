package edu.lclark.language.gui.studentPage;

import edu.lclark.language.LanguagePlacementExam;
import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.MainWindow;
import edu.lclark.language.gui.loginPage.LoginPage;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

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

        JTextPane testResult = new JTextPane();
        testResult.setPreferredSize(new Dimension((int)(main.getWidth() * .70), (int)(main.getHeight() * 0.60)));

        try {
            URL htmlUrl = null;

            if (Integer.parseInt(levelText) == 101) {
                htmlUrl = Paths.get(LanguagePlacementExam.PATH + "HTMLs/result1.html").toUri().toURL();
            } else if (Integer.parseInt(levelText) == 102) {
                htmlUrl = Paths.get(LanguagePlacementExam.PATH + "HTMLs/result2.html").toUri().toURL();
            } else if (Integer.parseInt(levelText) == 201) {
                htmlUrl = Paths.get(LanguagePlacementExam.PATH + "HTMLs/result3.html").toUri().toURL();
            } else if (Integer.parseInt(levelText) == 202 || Integer.parseInt(levelText) == 301) {
                htmlUrl = Paths.get(LanguagePlacementExam.PATH + "HTMLs/result4.html").toUri().toURL();
            }

            testResult.setPage(htmlUrl);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
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
