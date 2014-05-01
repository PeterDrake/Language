package edu.lclark.language.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccentPanel extends JPanel {


	private static final long serialVersionUID = 1L;
	
	JButton[] buttons = new JButton[16];
	MainWindow main;

	public AccentPanel(MainWindow main) {
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
		JButton Umlaut = new JButton("Ü");
		JButton N = new JButton("Ñ");
		JButton question = new JButton("¿");
		buttons[0] = a;
		buttons[1] = A;
		buttons[2] = e;
		buttons[3] = E;
		buttons[4] = i;
		buttons[5] = I;
		buttons[6] = o;
		buttons[7] = O;
		buttons[8] = u;
		buttons[9] = U;
		buttons[10] = umlaut;
		buttons[11] = Umlaut;
		buttons[12] = n;
		buttons[13] = N;
		buttons[14] = exclaim;
		buttons[15] = question;

		GridLayout layout = new GridLayout(8, 2);
		setLayout(layout);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(100, 400));

		for (int j = 0; j < buttons.length; j++) {
			buttons[j].addActionListener(new PrintAction());
			buttons[j].setFocusable(false);
			add(buttons[j]);
		}

	}

	private class PrintAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField f = new JTextField();
			try {
				if (main.getFocusOwner() != null) {
					f = (JTextField) (main.getFocusOwner());
					f.setText(f.getText() + (((JButton) e.getSource()).getText()));
				}
			} catch (ClassCastException oops) {
				oops.printStackTrace();
				System.exit(0);
			}

		}
	}
}
