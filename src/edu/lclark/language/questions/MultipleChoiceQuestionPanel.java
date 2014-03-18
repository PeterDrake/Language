package edu.lclark.language.questions;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import edu.lclark.language.gui.GBC;

public class MultipleChoiceQuestionPanel extends JPanel {

	private JLabel questionText;
	private JButton submitButton;
	private ArrayList<JRadioButton> answers;
	private ButtonGroup group;

	public MultipleChoiceQuestionPanel(MultipleChoiceQuestion multipleChoice) {
		// add arguments to create the question in this class
		answers = new ArrayList<JRadioButton>();
		setLayout(new GridBagLayout());
		setSize(700, 700);
		setBackground(Color.WHITE);

		questionText = new JLabel();
		questionText.setText(multipleChoice.getQuestion());
		add(questionText, new GBC(245, 10).setAnchor(GBC.NORTH));

		int i = 50;
		group = new ButtonGroup();

		for (int j = 0; j < multipleChoice.getAnswers().length; j++) {
			answers.add(new JRadioButton(multipleChoice.getAnswer(j)));
			group.add(answers.get(j));
			add(answers.get(j), new GBC(245, i).setAnchor(GBC.WEST));
			i += 10;
		}

	}

	public String getPressed() {

		for (int i = 0; i < answers.size(); i++) {

			if (answers.get(i).isSelected()) {

				return answers.get(i).getText();
			}
		}

		return null;

	}
}
