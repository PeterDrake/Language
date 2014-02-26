package edu.lclark.language.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import edu.lclark.language.gui.loginPage.LoginPage;
import edu.lclark.language.gui.professorPage.ProfessorPage;
import edu.lclark.language.gui.studentPage.StudentTestPage;

public class MainWindow extends JFrame{

	public MainWindow(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)(0.75*screenSize.width), (int)(0.75 * screenSize.height));		
		add(new StudentTestPage());
		//add(new ProfessorPage());		
		//add(new LoginPage());	
		getContentPane().setBackground(Color.WHITE);
		
	}
}
