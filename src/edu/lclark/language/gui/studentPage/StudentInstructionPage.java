package edu.lclark.language.gui.studentPage;

import java.awt.*;

import javax.swing.*;

import edu.lclark.language.gui.ImageComponent;
import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.MainWindow;

import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

/**
 * Displays the instructions for a student about to take a test. Contains a "Begin Test" button that will send the student on to the test.
 */
@SuppressWarnings("serial")
public class StudentInstructionPage extends AbstractUserPage {

    public StudentInstructionPage(MainWindow main) {
        super(main);

        JPanel content = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        content.setLayout(layout);
        content.setBackground(Color.WHITE);
        title.setText("Test Instructions");

        URL htmlUrl = ClassLoader.getSystemResource("edu/lclark/language/resources/student_instructions.html");


        // construct components
        JButton beginTestButton = new JButton("Begin Test");
        beginTestButton.addActionListener(new BeginButtonAction());

        JTextPane testInstructions = new JTextPane();
        testInstructions.setPreferredSize(new Dimension((int)(main.getWidth() * .70), (int)(main.getHeight() * 0.60)));
        try {
            testInstructions.setPage(htmlUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageComponent logo = new ImageComponent("LClogo.jpg", 216, 154);

//		add components to GridBagLayout
        content.add(beginTestButton, new GBC(0, 3).setWeight(0, 0)
                .setAnchor(GBC.CENTER));
        content.add(logo, new GBC(0, 1).setWeight(100, 100).setAnchor(GBC.CENTER));

        content.add(testInstructions,
                new GBC(0, 2).setWeight(100, 100).setAnchor(GBC.NORTH));

        JScrollPane sPane = new JScrollPane(content);
        sPane.getVerticalScrollBar().setUnitIncrement(16);
        add(sPane, BorderLayout.CENTER);

    }

    private class BeginButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            MainWindow main = getMainWindow();
            main.switchPage(new ExamPage(main));
        }

    }
}
