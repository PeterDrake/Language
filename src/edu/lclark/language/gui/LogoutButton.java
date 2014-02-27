package edu.lclark.language.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.lclark.language.gui.loginPage.LoginPage;

public class LogoutButton extends JButton {
	
	private MainWindow main;

	public LogoutButton(MainWindow main) {
		
		this.main = main;
		
		setText("Logout");
		addActionListener(new LogoutAction());

	}

	private class LogoutAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			main.logout();
		}
	}

}
