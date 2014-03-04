package edu.lclark.language.gui.professorPage;

import javax.swing.JLabel;


/**
 * The content panel for editing test questions from the professor page
 */
public class EditExamContent extends AbstractContent{
	
	public EditExamContent(){
		
		JLabel message = new JLabel("This will be a page for editing test questions.");
		add(message);
	}

}
