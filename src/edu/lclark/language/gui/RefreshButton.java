package edu.lclark.language.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Refreshes the page, repolling the database if necessary.
 */
public class RefreshButton extends JButton {

    private AbstractUserPage parent;

	public RefreshButton(AbstractUserPage parent) {
        this.parent = parent;
		
		setText("Refresh");
		addActionListener(new RefreshAction());

	}

	private class RefreshAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			parent.refresh();
		}
	}

}