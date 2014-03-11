package edu.lclark.language.questions;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.*;

import edu.lclark.language.gui.GBC;

import java.awt.*;


public class MultipleChoiceQuestion extends AbstractQuestion {


	private JLabel questionText;
	private JButton submitButton;
	private JRadioButton answer1;
	private JRadioButton answer2;
	private JRadioButton answer3;
	private JRadioButton answer4;
	private ButtonGroup group;
	
public static void main(String[] args) {
	new MultipleChoiceQuestion();
}
	
	
	public MultipleChoiceQuestion() {
		//add arguments to create the question in this class
		
		JFrame content = new JFrame();
		GridBagLayout layout = new GridBagLayout(); 
		content.setLayout(layout);
		content.setSize(500, 500);
		
		content.getContentPane().setBackground(Color.WHITE);
		
		//JPanel panel = new JPanel(new BorderLayout());
		
		content.setLayout(new GridBagLayout());
		
		
		questionText = new JLabel();
		questionText.setText("E un fapt bine stabilit ccititorul va fi sustras de?");
		content.add(questionText,new GBC(245,10));
		
		answer1 = new JRadioButton("Answer 1");
		answer2 = new JRadioButton("Answer 2");
		answer3 = new JRadioButton("Answer 3");
		answer4 = new JRadioButton("Answer 4");
		
		group = new ButtonGroup();
		
		group.add(answer1);
		group.add(answer2);
		group.add(answer3);
		group.add(answer4);
		
		//content.add(group, new GBC(49,10 ));
		
		content.getContentPane().add(answer1, new GBC(245, 50));
		content.getContentPane().add(answer2, new GBC(245,60));
		content.getContentPane().add(answer3, new GBC(245,70));
		content.getContentPane().add(answer4, new GBC(245,80));
		
		content.setVisible(true);
		content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	private static final int NUMBER_OF_ANSWERS = 4;
	
	private String[] answers;
	private String question;
	private int correctAnswerIndex;
	private int questionID;
	
	
}
