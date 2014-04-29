package edu.lclark.language.gui.studentPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.AccentPanel;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.MainWindow;
import edu.lclark.language.questions.QuestionInfo;
import edu.lclark.language.studentLogic.ProgressTracker;
import edu.lclark.language.studentLogic.ScoreWriter;
import edu.lclark.language.studentLogic.StudentScore;

public class ExamPage extends AbstractUserPage {

	private JButton submitButton;
	private AbstractQuestionPanel questionPanel;
	private JPanel testPagePanel;
	private ProgressTracker tracker;
	private MainWindow window;

	public ExamPage(MainWindow main) {
		super(main);
		window = main;
		tracker = new ProgressTracker();
		submitButton = new JButton("Submit");
		testPagePanel = new JPanel();
		questionPanel = tracker.getFirstQuestionPanel();

		GridBagLayout layout = new GridBagLayout();
		testPagePanel.setLayout(layout);
		testPagePanel.setBackground(Color.WHITE);
		testPagePanel.setSize(1500, 1500);
		testPagePanel
				.add(submitButton, new GBC(750, 1500).setAnchor(GBC.SOUTH));

		AccentPanel accentPanel = new AccentPanel(main);
		add(accentPanel, BorderLayout.WEST);

		title.setText("Language Placement Test");
		testPagePanel.add(questionPanel);

		// testPagePanel.add(shortAnswerQuestionPanel);

		add(testPagePanel);
		submitButton.addActionListener(new SubmitAction());

	}

	public void refresh() {
		// TODO Write refresh method for refresh button
	}
	
	private void writeStudentScore(){
		ScoreWriter writer = new ScoreWriter();
		StudentScore score = new StudentScore(window.getSession());
		score.setLevel(tracker.getPlacementLevel());
		writer.writeScoreToFile(score);
	}

	private class SubmitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean correct = questionPanel.isCorrectAnswerSelected();
			System.out.println(correct);
			tracker.updateTestProgress(correct);
			if (tracker.getIterationsComplete() == QuestionInfo.MAX_ITERATIONS) {
				writeStudentScore();
				StudentResultsPage srp = new StudentResultsPage(window,
						tracker.getPlacementLevel());
				window.switchPage(srp);
			} else {
				testPagePanel.remove(questionPanel);
				try {
					questionPanel = tracker.getNextQuestionPanel();
				} catch (EmptyDatabaseException ex) {
					writeStudentScore();
					StudentResultsPage srp = new StudentResultsPage(window,
							tracker.getPlacementLevel());
					window.switchPage(srp);
					System.out.println("Out of Questions");
				}
				testPagePanel.add(questionPanel);
				testPagePanel.repaint();
				testPagePanel.revalidate();
			}
		}

	}
}
