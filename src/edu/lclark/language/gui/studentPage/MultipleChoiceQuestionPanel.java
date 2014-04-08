package edu.lclark.language.gui.studentPage;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import edu.lclark.language.gui.GBC;
import edu.lclark.language.questions.MultipleChoiceQuestion;

public class MultipleChoiceQuestionPanel extends AbstractQuestionPanel {
	private String[] answers;
	private String question;
	private JLabel questionText;
	private JButton submitButton;
	private ButtonGroup group;

	// public static void main(String[] args) {
	// new MultipleChoiceQuestion(args, "question");
	// }

	public MultipleChoiceQuestionPanel(MultipleChoiceQuestion question) {
		super(question);
		
		// add arguments to create the question in this class

		this.answers = question.getAnswers();
		this.question = question.getText();

		// JFrame content = new JFrame();

		setLayout(new GridBagLayout());
		setSize(700, 700);
		setBackground(Color.WHITE);

		questionText = new JLabel(question.getText());
		add(questionText, new GBC(245, 10).setAnchor(GBC.NORTH));

		group = new ButtonGroup();

		for (int i = 0; i < question.getNumberOfAnswers(); i++) {
			JRadioButton answer = new JRadioButton(question.getAnswerAtIndex(i));
			group.add(answer);
			add(answer, new GBC(245, 50 + i * 10).setAnchor(GBC.WEST));
		}

	}

	public String getPressed() {
		for(Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();){
			AbstractButton button = buttons.nextElement();
			
			if(button.isSelected()){
				return button.getText();
			}
		}
		return null;

	}

	@Override
	public String getAnswer() {
		return getPressed();
	}
}
