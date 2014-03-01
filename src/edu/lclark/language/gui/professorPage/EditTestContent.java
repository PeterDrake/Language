package edu.lclark.language.gui.professorPage;

import javax.swing.JLabel;


public class EditTestContent extends AbstractContent{
	
	public EditTestContent(){
		super();
		
		JLabel message = new JLabel("This will be a page for editing test questions.");
		add(message);
	}

}
