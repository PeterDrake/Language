package edu.lclark.language.gui.studentPage;

import java.awt.*;

import javax.swing.*;

import edu.lclark.language.gui.ImageComponent;
import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.MainWindow;
import edu.lclark.language.gui.professorPage.ProfessorPage;
import edu.lclark.language.testPage.TestPage;

import java.awt.event.*;
import java.util.Scanner;

/**Displays the instructions for a student about to take a test. Contains a "Begin Test" button that will send the student on to the test.*/
public class StudentInstructionPage extends AbstractUserPage {
	
	public StudentInstructionPage(MainWindow main) {
		super(main);
		
		JPanel content = new JPanel();
		GridBagLayout layout = new GridBagLayout(); 
		content.setLayout(layout);
		content.setBackground(Color.WHITE);
		title.setText("Test Instructions");
		
		String text = "Welcome to the test! Please read these instructions:\n\n";
		//Reads sample test information
		try {
			Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("edu/lclark/language/resources/latin.txt"));
			while (in.hasNext()){
				text += in.nextLine() + "\n";
			}
		} catch (Exception e){
			System.out.println("Error: File not found!");
		}
		
		
		// construct components
		JButton beginTestButton = new JButton("Begin Test");
		beginTestButton.addActionListener(new BeginButtonAction());

		JTextArea testInformation = new JTextArea(text, 33, 66);
		testInformation.setLineWrap(true);
        testInformation.setEditable(false);

		ImageComponent logo = new ImageComponent("LClogo.jpg", 216, 154);

//		add components to GridBagLayout
		content.add(beginTestButton, new GBC(0, 3).setWeight(0, 0)
				.setAnchor(GBC.CENTER));
		content.add(logo, new GBC(0, 1).setWeight(100, 100).setAnchor(GBC.CENTER));

        content.add(testInformation,
				new GBC(0, 2).setWeight(100, 100).setAnchor(GBC.CENTER));

        JScrollPane sPane = new JScrollPane(content);
        sPane.getVerticalScrollBar().setUnitIncrement(16);
        add(sPane, BorderLayout.CENTER);

    }

	private class BeginButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			//System.out.println("Begin button!");
			MainWindow main = getMainWindow();
			main.switchPage(new TestPage(main));
		}

	}
}
