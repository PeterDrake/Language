package edu.lclark.language.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LogoutButton extends JButton {

	public LogoutButton() {
		
		setText("Logout");
		addActionListener(new LogoutAction());

	}

	private class LogoutAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO Write logout code
		}
	}

}
