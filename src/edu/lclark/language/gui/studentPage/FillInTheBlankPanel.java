package edu.lclark.language.gui.studentPage;

import edu.lclark.language.questions.FillInTheBlankQuestion;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

/** Graphic panel for displaying a FillInTheBlankQuestion. */
public class FillInTheBlankPanel extends AbstractQuestionPanel {

	private static final long serialVersionUID = 1L;

	/** The question associated with this panel. */
	private JTextField blank;

	public FillInTheBlankPanel(FillInTheBlankQuestion question) {
		super(question);
		setBackground(Color.WHITE);
		
		for (String w : question.getWordsBeforeBlank()) {
			add(new JLabel(w));
		}
		blank = new JTextField(10);
		add(blank);
		for (String w : question.getWordsAfterBlank()) {
			add(new JLabel(w));
		}
	}

	@Override
	public String getAnswer() {
		return blank.getText();
	}

}
