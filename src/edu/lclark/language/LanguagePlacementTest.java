package edu.lclark.language;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;

import edu.lclark.language.gui.*;
import edu.lclark.language.questions.QuestionDatabase;

public class LanguagePlacementTest {

    public static QuestionDatabase questionDatabase;

    public static final String PATH = (System.getProperty("os.name").startsWith("Mac")) ?
            System.getProperty("user.home") + "/Library/Application Support/Foreign Language Exam/" :
            System.getProperty("user.dir") + File.separator;
    
    public static final String SCORE_PATH = PATH + "Student Results";

    public static void main(String[] args) {
        File f = new File(PATH + "HTMLs");
        if (!f.exists()) {
            f.mkdirs();
        }
        f = new File(PATH + "Student Results");
        if (!f.exists()) {
            f.mkdirs();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame mainWindow = new MainWindow();
                questionDatabase = new QuestionDatabase();
                mainWindow.setTitle("Language Exam");
                mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainWindow.setVisible(true);
            }
        });

    }

}
