package edu.lclark.language.gui;

import edu.lclark.language.gui.loginPage.LoginPage;
import edu.lclark.language.gui.loginPage.Session;

import javax.swing.*;
import java.awt.*;

/**
 * The main JFrame of the program.
 */
public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Session session;
	
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
		session = null;
		switchPage(new LoginPage(this));
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public Session getSession(){
		return session;
	}
}
