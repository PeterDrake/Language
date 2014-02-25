package edu.lclark.language;

import java.awt.EventQueue;

import javax.swing.JFrame;

import edu.lclark.language.gui.MainWindow;


public class LanguagePlacementTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
        {
           public void run()
           {
              JFrame mainWindow = new MainWindow();
              mainWindow.setTitle("Language Exam");
              mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              mainWindow.setVisible(true);
           }
        });

	}

}
