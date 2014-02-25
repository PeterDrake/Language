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
import java.io.BufferedWriter;
import java.io.FileWriter;

public class LoginPage extends JFrame {

	private JButton loginButton;
	private JLabel name;
	JTextField usernameInput;
	private JLabel passwordText;
	private JTextField passwordInput;
	private Image logo;
	private JLabel title1;
	private JLabel title2;
	private JLabel title3;

	// private LoginPage loginPage;

	public LoginPage() {
		
		LogoPanel logoPanel = new LogoPanel(new ImageIcon(
				"LClogo.jpg").getImage());

		
		setLayout(new GridBagLayout());
		getContentPane().add(logoPanel, new GBC(48, 20, 51, 20));
		
		title1 = new JLabel();
		title1.setText("Language ");
		title2 = new JLabel();
		title2.setText("Placement ");
		title3 = new JLabel();
		title3.setText("Exam");
		
		Font font = new Font("Verdana", Font.BOLD, 24);
		title1.setFont(font);
		title2.setFont(font);
		title3.setFont(font);
		

		name = new JLabel();
		name.setText("Username:");
		usernameInput = new JTextField(12);

		passwordText = new JLabel();
		passwordText.setText("Password:");

		passwordInput = new JPasswordField(12);
		
		loginButton = new JButton();
		loginButton.setText("Login");

		getContentPane().setBackground(Color.WHITE);;
		getContentPane().add(title1, new GBC(49,10 ));
		getContentPane().add(title2, new GBC(50,10 ));
		getContentPane().add(title3, new GBC(51,10 ));
		getContentPane().add(name, new GBC(49, 40));
		getContentPane().add(usernameInput, new GBC(50, 40));
		getContentPane().add(passwordText, new GBC(49, 60));
		getContentPane().add(passwordInput, new GBC(50, 60));
		getContentPane().add(loginButton, new GBC(50, 80));

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameText = usernameInput.getText();
				String passwordText = passwordInput.getText();
				//new BufferedWriter(new FileWriter("text.txt")).write(nameText);
				System.out.println(nameText);
				System.out.println(passwordText);
				
				//just need to extract the information into a text file
				
			}

		});

		pack();
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
