package edu.lclark.language.gui.studentPage;

import edu.lclark.language.gui.GBC;
import edu.lclark.language.questions.ShortAnswerQuestion;

import javax.swing.*;
import java.awt.*;

public class ShortAnswerQuestionPanel extends AbstractQuestionPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField shortAnswerResponse;
	private JLabel questionText;
	private JLabel questionInstructions;


	public ShortAnswerQuestionPanel(ShortAnswerQuestion question) {
		super(question);
		
		questionInstructions = new JLabel("(Please respond with 1-2 complete sentences.)");

		setLayout(new GridBagLayout());
		setSize(700, 700);
		setBackground(Color.WHITE);

		questionText = new JLabel();
		questionText.setText(question.getText());
		add(questionText, new GBC(245, 10).setAnchor(GBC.NORTH));

		shortAnswerResponse = new JTextField(24);

		add(shortAnswerResponse, new GBC(245, 100).setAnchor(GBC.WEST));
		add(questionInstructions, new GBC(245, 120));

	}

	public String getAnswer() {
		return shortAnswerResponse.getText();
	}
}
