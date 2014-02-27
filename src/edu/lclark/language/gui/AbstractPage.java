package edu.lclark.language.gui;

import javax.swing.JComponent;

public abstract class AbstractPage extends JComponent{
	
	private MainWindow main;
	
	public AbstractPage(MainWindow main){
		this.main = main;
	}
	
	public MainWindow getMainWindow(){
		return main;
	}

}
