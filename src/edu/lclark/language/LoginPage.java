package edu.lclark.language;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

	private JButton loginButton;
	private JLabel name;
	private JLabel passwordText;
	private Image logo;

	// private LoginPage loginPage;

	public LoginPage() {
		// loginPage = new LoginPage();
		LogoPanel logoPanel = new LogoPanel(new ImageIcon(
				"Lewis and CLark Logo.jpg").getImage());

		// JFrame frame = new JFrame();
		setLayout(new GridBagLayout());
		getContentPane().add(logoPanel, new GBC(50, 50));
		pack();
		setVisible(true);

		name = new JLabel();
		passwordText = new JLabel();

		name.setText("Username: ");
		JTextField txt = new JTextField(10);

		passwordText.setText("Password: ");

		// txt.setText("Username");
		JPasswordField password = new JPasswordField(10);
		loginButton = new JButton();
		loginButton.setText("Login");

		add(name);
		add(txt);
		add(passwordText);
		add(password);
		add(loginButton);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// add action that will send you to the correct page
			}

		});

		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
