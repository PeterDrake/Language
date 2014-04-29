package edu.lclark.language;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JFrame;

import edu.lclark.language.gui.*;
import edu.lclark.language.questions.QuestionDatabase;

public class LanguagePlacementExam {

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
        copyFileIfNull("questionExamples.xml", "questions.xml");
        copyFileIfNull("student_instructions.html", "HTMLs/instructions.html");
        copyFileIfNull("result1.html", "HTMLs/result1.html");
        copyFileIfNull("result2.html", "HTMLs/result2.html");
        copyFileIfNull("result3.html", "HTMLs/result3.html");
        copyFileIfNull("result4.html", "HTMLs/result4.html");
        copyFileIfNull("settings.txt", "settings.txt");

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
    
    private static void copyFileIfNull(String source, String destination){
    	 File f = new File(PATH + destination);
         try {
 			Path sourcePath = Paths.get(ClassLoader.getSystemResource("edu/lclark/language/resources/" + source).toURI());
 			if (!f.isFile()) {
 	        	Files.copy(sourcePath, f.toPath(), StandardCopyOption.REPLACE_EXISTING);
 	        }
 		} catch (Exception e) {
 			e.printStackTrace();
 			System.exit(0);
 		}
    }

}
