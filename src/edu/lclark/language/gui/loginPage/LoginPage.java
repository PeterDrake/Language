package edu.lclark.language.gui.loginPage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.lclark.language.ImageComponent;
import edu.lclark.language.gui.AbstractPage;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.MainWindow;
import edu.lclark.language.gui.professorPage.ProfessorPage;
import edu.lclark.language.gui.studentPage.StudentInstructionPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class LoginPage extends AbstractPage {

	private JButton loginButton;
	private JLabel name;
	JTextField usernameInput;
	private JLabel passwordText;
	private JTextField passwordInput;
	private Image logo;
	private JLabel title1;
	private JLabel title2;
	private JLabel title3;

	public LoginPage(MainWindow main) {
		
		super(main);
		
		ImageComponent logo = new ImageComponent("LClogo.jpg",  216, 154);

		
		setLayout(new GridBagLayout());
		add(logo, new GBC(48, 20, 51, 20));
		
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

		add(title1, new GBC(49,10 ));
		add(title2, new GBC(50,10 ));
		add(title3, new GBC(51,10 ));
		add(name, new GBC(49, 40));
		add(usernameInput, new GBC(50, 40));
		add(passwordText, new GBC(49, 60));
		add(passwordInput, new GBC(50, 60));
		add(loginButton, new GBC(50, 80));

		loginButton.addActionListener(new LoginAction());
	}
	
	private class LoginAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String nameText = usernameInput.getText();
			String passwordText = passwordInput.getText();
			
			MainWindow main = getMainWindow();
			
			if(nameText.equals("professor")){
				main.switchPage(new ProfessorPage(main));
			}
			else if(nameText.equals("student")){
				main.switchPage(new StudentInstructionPage(main));				
			}
		}
		
	}
}