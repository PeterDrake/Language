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
	public ExamSettingsContent(String name){
		
//		setLayout(new BorderLayout());
		
		this.name = name;
		
//		JLabel message = new JLabel("Welcome, " + name + "!");
//		message.setFont(new Font("SansSerif", Font.PLAIN, 18));
//		add(message, BorderLayout.NORTH);

        JLabel message = new JLabel("This will be a page to view information about your profile.");
        add(message);

    }

}
