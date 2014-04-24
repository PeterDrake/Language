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

    public static void main(String[] args) {
        File f = new File(PATH + "HTMLs");
        if (!f.exists()) {
            f.mkdirs();
        }
//        f = new File(PATH + "questions.xml");
//        if (!f.isFile()) {
////            f.createNewFile();
//            //TODO copy file: (ClassLoader.getSystemResource("edu/lclark/language/resources/questionExamples.xml")
//        }
//        f = new File(PATH + "instructions.html");
//        if (!f.isFile()) {
////            f.createNewFile();
//            //TODO copy file: (ClassLoader.getSystemResource("edu/lclark/language/resources/instructions.html")
//        }

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
