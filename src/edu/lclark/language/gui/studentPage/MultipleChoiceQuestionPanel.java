package edu.lclark.language.gui.studentPage;

import edu.lclark.language.gui.GBC;
import edu.lclark.language.questions.MultipleChoiceQuestion;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class MultipleChoiceQuestionPanel extends AbstractQuestionPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel questionText;
	private ButtonGroup group;


	public MultipleChoiceQuestionPanel(MultipleChoiceQuestion question) {
		super(question);

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
