package edu.lclark.language.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Extended by pages that need a title bar and logout and refresh buttons.*/
public abstract class AbstractUserPage extends AbstractPage{
	
	protected JPanel titlePanel;
	protected JLabel title;
	protected LogoutButton logout;
	
	public AbstractUserPage(MainWindow main) {
		
		super(main);
		
		setLayout(new BorderLayout());		
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.WHITE);
		titlePanel.setLayout(new BorderLayout());
		
		logout = new LogoutButton(main);
		titlePanel.add(logout, BorderLayout.EAST);
		
		Font bigFont = new Font("SansSerif", Font.PLAIN, 24);
		title = new JLabel();
		title.setFont(bigFont);
		title.setBorder(BorderFactory.createEmptyBorder(0, logout.getPreferredSize().width, 0, 0));
		title.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(title, BorderLayout.CENTER);
		
		add(titlePanel, BorderLayout.NORTH);
		
	}

}
