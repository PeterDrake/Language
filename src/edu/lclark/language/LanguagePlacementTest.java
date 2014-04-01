package edu.lclark.language;

import java.awt.EventQueue;

import javax.swing.JFrame;

import edu.lclark.language.gui.*;
import edu.lclark.language.questions.QuestionDatabase;


public class LanguagePlacementTest {

	public static QuestionDatabase questionDatabase;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
        {
           public void run()
           {
              JFrame mainWindow = new MainWindow();
              questionDatabase = new QuestionDatabase();
              mainWindow.setTitle("Language Exam");
              mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              mainWindow.setVisible(true);
           }
        });

	}

}
