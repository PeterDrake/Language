package edu.lclark.language.gui.professorPage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class FillInTheBlankViewEditPanel extends JPanel{
	
	public FillInTheBlankViewEditPanel() {
		
		JLabel message = new JLabel("This will be an area to enter new fill in the blank questions");
		add(message);
		setBackground(Color.WHITE);
		
	}
}