package edu.lclark.language.gui;

import javax.swing.*;

/** Extended by all pages. Allows pages to access the switchPage method of MainWindow. */
public abstract class AbstractPage extends JComponent{
	
	private static final long serialVersionUID = 1L;
	
	private MainWindow main;
	
	public AbstractPage(MainWindow main){
		this.main = main;
	}
	
	public MainWindow getMainWindow(){
		return main;
	}

}
