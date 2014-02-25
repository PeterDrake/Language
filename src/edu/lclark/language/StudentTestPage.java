package edu.lclark.language;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class StudentTestPage extends AbstractUserPage implements PageInterface {

	public StudentTestPage() {
		
		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		content.setLayout(layout);
		add(content, BorderLayout.CENTER);
		title.setText("Student");

		// construct components
		JButton beginTestButton = new JButton("Begin Test");
		beginTestButton.addActionListener(new BeginButtonAction());
		JTextArea testInformation = new JTextArea(
				"\nThis is a langauge placement exam!", 20, 100);
		testInformation.setEditable(false);
		ImageComponent logo = new ImageComponent("logo.jpg", 216, 154);

		// add components to GridBagLayout
		content.add(beginTestButton, new GBC(0, 2).setWeight(0, 0)
				.setAnchor(GBC.CENTER));
		content.add(logo, new GBC(0, 1).setWeight(100, 100).setAnchor(GBC.CENTER));
		content.add(testInformation,
				new GBC(0, 3).setWeight(100, 100).setAnchor(GBC.CENTER));
	}

	private class BeginButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			System.out.println("Begin button!");
		}

	}
}
