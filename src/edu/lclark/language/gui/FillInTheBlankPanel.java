package edu.lclark.language.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.lclark.language.questions.FillInTheBlankQuestion;

public class FillInTheBlankPanel extends JPanel {
	
	private FillInTheBlankQuestion question;
	
	public FillInTheBlankPanel(FillInTheBlankQuestion question){
		this.question = question;
		for(String w : question.getWordsBeforeBlank()){
			add(new JLabel(w));
		}
		for(String w : question.getWordsAfterBlank()){
			add(new JLabel(w));
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
        {
           public void run()
           {
              JFrame mainWindow = new JFrame();
              Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      		mainWindow.setSize((int) (0.75 * screenSize.width),
      				(int) (0.75 * screenSize.height));
              mainWindow.setTitle("Fill In The Blank Test");
              mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              mainWindow.add(new FillInTheBlankPanel(new FillInTheBlankQuestion("¿Dónde _ el baño, por favor?", "está")));
              mainWindow.setVisible(true);
           }
        });

	}
}
