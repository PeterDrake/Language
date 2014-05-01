package edu.lclark.language.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


/**
 *Sends the user back to the Login screen when clicked.
 */
public class LogoutButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	private MainWindow main;

	public LogoutButton(MainWindow main) {
		
		this.main = main;
		
		setText("Logout");
		addActionListener(new LogoutAction());

	}

	/**
	 *Calls the logout method from the MainWindow. 
	 */
	private class LogoutAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			main.logout();
		}
	}

}
