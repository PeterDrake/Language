package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

/**
 * The content panel for displaying profile information on the professor page
 */
public class ExamSettingsContent extends AbstractContent{
	
	private String name;
	
	/**
	 * @param name the username of the professor
	 */
	public ExamSettingsContent(){
		
		JButton exportButton = new JButton("Import Database");
		add(exportButton);

    }

}
