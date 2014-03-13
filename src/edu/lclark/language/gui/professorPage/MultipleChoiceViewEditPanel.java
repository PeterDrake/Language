package edu.lclark.language.gui.professorPage;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MultipleChoiceViewEditPanel extends JPanel {
	
	public MultipleChoiceViewEditPanel() {
		
		JLabel message = new JLabel("This will be an area to enter new multiple choice questions");
		add(message);
		setBackground(Color.WHITE);
	}
}
