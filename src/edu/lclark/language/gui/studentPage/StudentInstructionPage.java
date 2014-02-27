package edu.lclark.language.gui.studentPage;

import java.awt.*;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import edu.lclark.language.ImageComponent;
import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.MainWindow;

import java.awt.event.*;
import java.util.Scanner;

public class StudentInstructionPage extends AbstractUserPage {
	
	public StudentInstructionPage(MainWindow main) {
		super(main);
		
		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout(); 
		content.setLayout(layout);
		content.setBackground(Color.WHITE);
		add(content, BorderLayout.CENTER);
		title.setText("Student");
		
		String text = "";
		//Reads sample test information
		try {
			Scanner in = new Scanner(Paths.get("text.txt"));
			while (in.hasNext()){
				text += in.nextLine() + "\n";
			}
		} catch (Exception e){
			System.out.println("The file was not read.");
		}
		
		
		// construct components
		JButton beginTestButton = new JButton("Begin Test");
		beginTestButton.addActionListener(new BeginButtonAction());
		JTextArea testInformation = new JTextArea(text, 33, 100);
		testInformation.setLineWrap(true);
		JScrollPane testInformationPane = new JScrollPane(testInformation);
		testInformation.setEditable(false);
		ImageComponent logo = new ImageComponent("LClogo.jpg", 216, 154);

		// add components to GridBagLayout
		content.add(beginTestButton, new GBC(0, 3).setWeight(0, 0)
				.setAnchor(GBC.CENTER));
		content.add(logo, new GBC(0, 1).setWeight(100, 100).setAnchor(GBC.CENTER));
		content.add(testInformationPane,
				new GBC(0, 2).setWeight(100, 100).setAnchor(GBC.CENTER));
	}

	private class BeginButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			System.out.println("Begin button!");
		}

	}
}
