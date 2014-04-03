package edu.lclark.language.questions;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import edu.lclark.language.gui.GBC;

public class MultipleChoiceQuestionPanel extends AbstractQuestionPanel {
	private String[] answers;
	private String question;
	private JLabel questionText;
	private JButton submitButton;
	private JRadioButton answer1;
	private JRadioButton answer2;
	private JRadioButton answer3;
	private JRadioButton answer4;
	private ButtonGroup group;
	
//public static void main(String[] args) {
//	new MultipleChoiceQuestion(args, "question");
//}
	
	
	public MultipleChoiceQuestionPanel(MultipleChoiceQuestion question) {
		//add arguments to create the question in this class
		
		this.answers = question.getAnswers();
		this.question = question.getText();
		
		//JFrame content = new JFrame();
		

		setLayout(new GridBagLayout());
		setSize(700, 700);
		setBackground(Color.WHITE);		
		
		
		
		questionText = new JLabel();
		questionText.setText("E un fapt bine stabilit ccititorul va fi sustras de?");
		add(questionText,new GBC(245,10).setAnchor(GBC.NORTH));
		
		answer1 = new JRadioButton("Answer 1");
		answer2 = new JRadioButton("Answer 2");
		answer3 = new JRadioButton("Answer 3");
		answer4 = new JRadioButton("Answer 4");
		
		group = new ButtonGroup();

		group.add(answer1);
		group.add(answer2);
		group.add(answer3);
		group.add(answer4);
		
		add(answer1, new GBC(245, 50).setAnchor(GBC.WEST));
		add(answer2, new GBC(245,60).setAnchor(GBC.WEST));
		add(answer3, new GBC(245,70).setAnchor(GBC.WEST));
		add(answer4, new GBC(245,80).setAnchor(GBC.WEST));
		
		
		
		//content.setVisible(true);
//		content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public String getPressed(){
		if (answer1.isSelected()){
		return answer1.getText();
	}
		if (answer2.isSelected()){
			return answer2.getText();
		}
		if (answer3.isSelected()){
			return answer3.getText();
		}
		if (answer4.isSelected()){
			return answer4.getText();
		}
		return null;
		
	}

	@Override
	public String getAnswer() {
		return getPressed();
	}
}

