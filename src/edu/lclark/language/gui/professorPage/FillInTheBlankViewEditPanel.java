package edu.lclark.language.gui.professorPage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

/**
 * The Panel that handles entering and editing fill in the blank questions
 */
public class FillInTheBlankViewEditPanel extends JPanel{
	
	private EditExamContent previousPage;
	
	public FillInTheBlankViewEditPanel(EditExamContent previousPage) {
		
		this.previousPage = previousPage;
		
		JLabel message = new JLabel("This will be an area to enter new fill in the blank questions");
		add(message);
		setBackground(Color.WHITE);
		
	}
}