package edu.lclark.language.gui.professorPage;

import javax.swing.JLabel;


public class EditTestContent extends AbstractContent{
	
	public EditTestContent(){
		super();
		
		JLabel message = new JLabel("I am the test content panel!");
		add(message);
	}

}