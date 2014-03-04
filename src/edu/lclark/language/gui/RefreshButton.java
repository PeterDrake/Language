package edu.lclark.language.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Refreshes the page, repolling the database if necessary.
 */
public class RefreshButton extends JButton {

	public RefreshButton() {
		
		setText("Refresh");
		addActionListener(new RefreshAction());

	}

	private class RefreshAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO Write refresh code
		}
	}

}