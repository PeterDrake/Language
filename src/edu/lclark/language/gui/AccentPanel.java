package edu.lclark.language.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class AccentPanel extends JPanel{
	
	JButton[] buttons = new JButton[16];
	MainWindow main;


public AccentPanel(MainWindow main){
	this.main = main;
	
	JButton a = new JButton("á");
	JButton e = new JButton("é");
	JButton i = new JButton("í");
	JButton o = new JButton("ó");
	JButton u = new JButton("ú");
	JButton umlaut = new JButton("ü");
	JButton n = new JButton("ñ");
	JButton exclaim = new JButton("¡");
	JButton A = new JButton("Á");
	JButton E = new JButton("É");
	JButton I = new JButton("Í");
	JButton O = new JButton("Ó");
	JButton U = new JButton("Ú");
	JButton Umlaut = new JButton("ü");
	JButton N = new JButton("Ñ");
	JButton question = new JButton("¿");
	buttons[0] = a;
	buttons[1] = e;
	buttons[2] = i;
	buttons[3] = o;
	buttons[4] = u;
	buttons[5] = umlaut;
	buttons[6] = n;
	buttons[7] = exclaim;
	buttons[8] = A;
	buttons[9] = E;
	buttons[10] = I;
	buttons[11] = O;
	buttons[12] = U;
	buttons[13] = Umlaut;
	buttons[14] = N;
	buttons[15] = question;


	GridLayout layout = new GridLayout(8, 2);
	setLayout(layout);
	setBackground(Color.WHITE);
	setSize(1500, 1500);
	

			for (int j = 0; j < buttons.length; j++) {
				buttons[j].addActionListener(new PrintAction(buttons[j].getText()));
				buttons[j].setFocusable(false);
				add(buttons[j]);
			}
	
}

private class PrintAction implements ActionListener {

	String s;
	public PrintAction(String text) {
		s  = text;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField f =(JTextField)(main.getFocusOwner());
		f.setText(f.getText() + (((JButton) e.getSource()).getText()));
		
	}

}
	
}
