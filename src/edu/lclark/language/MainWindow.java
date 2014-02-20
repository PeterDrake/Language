package edu.lclark.language;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class MainWindow extends JFrame{

	public MainWindow(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)(0.75*screenSize.width), (int)(0.75 * screenSize.height));
		
		add(new StudentTestPage());
		pack();
	}
}
