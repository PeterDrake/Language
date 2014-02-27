package edu.lclark.language.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import edu.lclark.language.gui.loginPage.LoginPage;

public class MainWindow extends JFrame{
	
	public MainWindow(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)(0.75 * screenSize.width), (int)(0.75 * screenSize.height));
	
		
        add(new LoginPage(this));
		
		getContentPane().setBackground(Color.WHITE);
		
		}
	
	public void switchPage(AbstractPage page){
		System.out.println("Switch page");
		getContentPane().removeAll();
		getContentPane().add(page);
		repaint();
		revalidate();
	}
	
	public void logout(){
		switchPage(new LoginPage(this));
	}
}

