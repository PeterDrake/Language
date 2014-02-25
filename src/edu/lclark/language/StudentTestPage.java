package edu.lclark.language;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class StudentTestPage extends JComponent implements PageInterface {

	public StudentTestPage() {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);

		// construct components

		JButton beginTestButton = new JButton("Begin Test");
		beginTestButton.addActionListener(new BeginButtonAction());
		JTextArea testInformation = new JTextArea(
				"\nThis is a langauge placement exam!", 10, 20);
		testInformation.setEditable(false);
		ImageComponent logo = new ImageComponent("logo.jpg", 216, 154);
		JLabel userName = new JLabel("Student");

		// add components to GridBagLayout
		add(beginTestButton, new GBC(0, 2).setWeight(0, 0)
				.setAnchor(GBC.CENTER));
		add(logo, new GBC(0, 1).setWeight(100, 100).setAnchor(GBC.CENTER));
		add(testInformation,
				new GBC(0, 3).setWeight(100, 100).setAnchor(GBC.CENTER));
		add(userName, new GBC(0, 0).setWeight(0, 0).setAnchor(GBC.CENTER));
	}

	private class BeginButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			System.out.println("Begin button!");
		}

	}
}
