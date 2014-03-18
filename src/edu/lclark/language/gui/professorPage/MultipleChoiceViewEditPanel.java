package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.lclark.language.gui.GBC;

public class MultipleChoiceViewEditPanel extends JPanel {
	
	private JPanel mcPanel;
	
	public MultipleChoiceViewEditPanel() {
		
		JLabel message = new JLabel("This will be an area to enter new multiple choice questions");
		//add(message);
		setBackground(Color.WHITE);
		
		mcPanel = new JPanel();
		mcPanel.setLayout(new GridBagLayout());
		mcPanel.setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		
		JLabel title = new JLabel();
		title.setText("Multiple Choice Question");
		add(title, new GBC(1,0,1,1));
		
		JLabel question = new JLabel();
		question.setText("Question:");
		JTextArea questionField = new JTextArea(5,50);
//		questionField.setPreferredSize(new Dimension(500,100));
		questionField.setLineWrap(true);
		questionField.setWrapStyleWord(true);
		JScrollPane questionPane = new JScrollPane(questionField);
		questionPane.setBorder(BorderFactory.createLineBorder(Color.black));
		add(question, new GBC(0,1));
		add(questionPane, new GBC(1,1,2,1));
	}
	
}
