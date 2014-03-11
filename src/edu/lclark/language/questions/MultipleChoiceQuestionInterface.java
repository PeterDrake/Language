package edu.lclark.language.questions;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import edu.lclark.language.gui.GBC;

public class MultipleChoiceQuestionInterface extends JPanel {
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
	
	
	public MultipleChoiceQuestionInterface(String[] answers, String question) {
		//add arguments to create the question in this class
		
		this.answers = answers;
		this.question = question;
		
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
	

}
