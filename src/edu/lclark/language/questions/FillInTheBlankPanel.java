package edu.lclark.language.questions;

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

	private static final long serialVersionUID = 1L;

	/** The question associated with this panel. */
	private JTextField blank;

	public FillInTheBlankPanel(FillInTheBlankQuestion question) {
		super(question);
		
		for (String w : question.getWordsBeforeBlank()) {
			add(new JLabel(w));
		}
		blank = new JTextField(10);
		add(blank);
		blank.addActionListener(new BlankListener());
		for (String w : question.getWordsAfterBlank()) {
			add(new JLabel(w));
		}
	}

	@Override
	public String getAnswer() {
		return blank.getText();
	}
	

	/** Listens for the student to hit enter when the JTextField has focus. */
	private class BlankListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String answer = ((JTextField) (e.getSource())).getText();
			System.out.println(getCurrentQuestion().isCorrectAnswer(answer));
		}

	}

}
