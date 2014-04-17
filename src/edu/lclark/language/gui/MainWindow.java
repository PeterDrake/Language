package edu.lclark.language.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import edu.lclark.language.gui.loginPage.LoginPage;

/**
 * The main JFrame of the program.
 */
public class MainWindow extends JFrame {

	public MainWindow() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) (0.75 * screenSize.width),
				(int) (0.75 * screenSize.height));

		add(new LoginPage(this));

		getContentPane().setBackground(Color.WHITE);

	}

	/**
	 * Removes the current AbstractPage component from the frame and adds the
	 * new page.
	 * 
	 * @param page
	 *            The page being switched to.
	 */
	public void switchPage(AbstractPage page) {
		getContentPane().removeAll();
		getContentPane().add(page);
		repaint();
		revalidate();
	}
	
	/**
	 * Switches the page to the Login page.
	 */
	public void logout() {
		switchPage(new LoginPage(this));
	}
}
