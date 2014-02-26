package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

public class ProfileContent extends AbstractContent{
	
	private String name;
	
	public ProfileContent(String name){
		super();
		
		setLayout(new BorderLayout());
		
		this.name = name;
		
		JLabel message = new JLabel("Welcome, " + name + "!");
		message.setFont(new Font("SansSerif", Font.PLAIN, 18));
		add(message, BorderLayout.NORTH);
	}

}
