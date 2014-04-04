package edu.lclark.language.gui.studentPage;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.lclark.language.gui.GBC;
import edu.lclark.language.questions.ShortAnswerQuestion;

public class ShortAnswerQuestionPanel extends AbstractQuestionPanel {

	private JTextField shortAnswerResponse;
	private JButton submitButton;
	private JLabel questionText;
	private String question;
	private JLabel questionInstructions;


	public ShortAnswerQuestionPanel(ShortAnswerQuestion exampleShort) {
		this.question = exampleShort.getText();
		questionInstructions = new JLabel("(Please respond with 1-2 complete sentences.)");

		setLayout(new GridBagLayout());
		setSize(700, 700);
		setBackground(Color.WHITE);

		questionText = new JLabel();
		questionText.setText(question);
		add(questionText, new GBC(245, 10).setAnchor(GBC.NORTH));

		shortAnswerResponse = new JTextField(24);
		//shortAnswerResponse.setSize(50, 50);

		add(shortAnswerResponse, new GBC(245, 100).setAnchor(GBC.WEST));
		add(questionInstructions, new GBC(245, 120));

	}

	public String getAnswer() {
		return shortAnswerResponse.getText();
	}
}
