package edu.lclark.language.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class AccentPanel extends JPanel{
	
	JButton[] buttons = new JButton[16];
	JTextArea text;


public AccentPanel(JTextArea area){
	text = area;
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
				buttons[j].addActionListener(new PrintAction());
				add(buttons[j]);
			}
	
}

private class PrintAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == buttons[0]){
			text.append("á");
		}
		if (e.getSource() == buttons[1]){
			text.append("é");
		}
		if (e.getSource() == buttons[2]){
			text.append("í");
		}
		if (e.getSource() == buttons[3]){
			text.append("ó");
		}
		if (e.getSource() == buttons[4]){
			text.append("ú");
		}
		if (e.getSource() == buttons[5]){
			text.append("ü");
		}
		if (e.getSource() == buttons[6]){
			text.append("ñ");
		}
		if (e.getSource() == buttons[7]){
			text.append("¡");
		}
		if (e.getSource() == buttons[8]){
			text.append("Á");
		}
		if (e.getSource() == buttons[9]){
			text.append("É");
		}
		if (e.getSource() == buttons[10]){
			text.append("Í");
		}
		if (e.getSource() == buttons[11]){
			text.append("Ó");
		}
		if (e.getSource() == buttons[12]){
			text.append("Ú");
		}
		if (e.getSource() == buttons[13]){
			text.append("Ü");
		}
		if (e.getSource() == buttons[14]){
			text.append("Ñ");
		}
		if (e.getSource() == buttons[15]){
			text.append("¿");
		}
			
		
		
	}

}
	
}
