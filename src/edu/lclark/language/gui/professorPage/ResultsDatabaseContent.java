package edu.lclark.language.gui.professorPage;

import javax.swing.JLabel;

/**
 * The content panel for viewing student results in the professor page
 */
public class ResultsDatabaseContent extends AbstractContent{
	
	public ResultsDatabaseContent(){
		super();
		
		JLabel message = new JLabel("This will be a page to view student results.");
		add(message);
	}


}
