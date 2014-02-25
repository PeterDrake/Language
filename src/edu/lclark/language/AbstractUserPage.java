package edu.lclark.language;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.lclark.language.professorPage.AbstractContent;
import edu.lclark.language.professorPage.ProfileContent;

public abstract class AbstractUserPage extends JComponent implements PageInterface {
	
	protected JPanel buttonPanel;
	protected ButtonGroup buttonGroup;
	protected JPanel titlePanel;
	protected JLabel title;
	
	protected LogoutButton logout;
	protected RefreshButton refresh;
	
	public AbstractUserPage() {
		
		setLayout(new BorderLayout());

		//buttonPanel = new JPanel();
		//buttonGroup = new ButtonGroup();
		//add(buttonPanel, BorderLayout.CENTER);
		
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		
		Font bigFont = new Font("SansSerif", Font.PLAIN, 24);
		title = new JLabel();
		title.setFont(bigFont);
		title.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(title, BorderLayout.CENTER);
		
		logout = new LogoutButton();
		titlePanel.add(logout, BorderLayout.EAST);
		refresh = new RefreshButton();
		titlePanel.add(refresh, BorderLayout.WEST);
		
		add(titlePanel, BorderLayout.NORTH);
		
	}

}
