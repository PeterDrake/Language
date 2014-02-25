package edu.lclark.language.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import edu.lclark.language.gui.loginPage.LoginPage;
import edu.lclark.language.gui.professorPage.ProfessorPage;

public class MainWindow extends JFrame{
	
	public MainWindow(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)(0.75 * screenSize.width), (int)(0.75 * screenSize.height));
		
		
//		add(new ProfessorPage());
		add(new LoginPage());
		
		getContentPane().setBackground(Color.WHITE);
		
		}

}
