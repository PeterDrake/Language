package edu.lclark.language.gui.studentPage;

import edu.lclark.language.questions.FillInTheBlankQuestion;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Graphic panel for displaying a FillInTheBlankQuestion. */
public class FillInTheBlankPanel extends AbstractQuestionPanel {

	/** Listens for the student to hit enter when the JTextField has focus. */
	private class BlankListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String answer = ((JTextField) (e.getSource())).getText();
			System.out.println(question.isCorrectAnswer(answer));
		}

	}

	private static final long serialVersionUID = 1L;

	/** The question associated with this panel. */
	private FillInTheBlankQuestion question;

	public FillInTheBlankPanel(FillInTheBlankQuestion question) {
		this.question = question;
		for (String w : question.getWordsBeforeBlank()) {
			add(new JLabel(w));
		}
		JTextField blank = new JTextField(10);
		add(blank);
		blank.addActionListener(new BlankListener());
		for (String w : question.getWordsAfterBlank()) {
			add(new JLabel(w));
		}
	}

	@Override
	public String getAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

}
