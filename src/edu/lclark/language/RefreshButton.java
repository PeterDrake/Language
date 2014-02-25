package edu.lclark.language;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RefreshButton extends JButton {

	public RefreshButton() {
		
		setText("Refresh");
		addActionListener(new RefreshAction());

	}

	private class RefreshAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO Write logout code
		}
	}

}