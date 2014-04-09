package edu.lclark.language.gui.studentPage;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.MainWindow;

public class ExamPage extends AbstractUserPage {

	private JButton submitButton;
	private AbstractQuestionPanel questionPanel;
	private QuestionFactory factory;
	private JPanel testPagePanel;
	
	private int questionsAnswered;
	private int questionsAnsweredCorrectly;

	public ExamPage(MainWindow main) {
		super(main);
		factory = new QuestionFactory();

		submitButton = new JButton("Submit");
		testPagePanel = new JPanel();
		questionPanel = factory.getNextQuestion(questionsAnswered, questionsAnsweredCorrectly);

		GridBagLayout layout = new GridBagLayout();
		testPagePanel.setLayout(layout);
		testPagePanel.setBackground(Color.WHITE);
		testPagePanel.setSize(1500, 1500);
		testPagePanel
				.add(submitButton, new GBC(750, 1500).setAnchor(GBC.SOUTH));

		title.setText("Language Placement Test");
		testPagePanel.add(questionPanel);

		// testPagePanel.add(shortAnswerQuestionPanel);

		add(testPagePanel);
		submitButton.addActionListener(new SubmitAction());

	}

    public void refresh() {
        //TODO Write refresh method for refresh button
    }

	private class SubmitAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean correct = questionPanel.isCorrectAnswerSelected();
			questionsAnswered++;
			if(correct){
				questionsAnsweredCorrectly++;
			}
			System.out.println(correct);
			testPagePanel.remove(questionPanel);
			questionPanel = factory.getNextQuestion(questionsAnswered, questionsAnsweredCorrectly);
			testPagePanel.add(questionPanel);
			testPagePanel.repaint();
			testPagePanel.revalidate();
		}

	}
}
