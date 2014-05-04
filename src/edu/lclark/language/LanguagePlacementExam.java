package edu.lclark.language;

import edu.lclark.language.gui.MainWindow;
import edu.lclark.language.questions.QuestionDatabase;

import javax.swing.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
 			InputStream sourceStream = LanguagePlacementExam.class.getClass().getResourceAsStream("/edu/lclark/language/resources/" + source);
 			if (!f.isFile()) {
 	        	BufferedReader in = new BufferedReader(new InputStreamReader(sourceStream));
 	        	PrintWriter out = new PrintWriter(f.toString());
 	        	String line;
 	        	while((line = in.readLine()) != null){
 	        		out.println(line);
 	        	}
 	        	out.close();
 	        }
 		} catch (Exception e) {
 			e.printStackTrace();
 			System.exit(0);
 		}
    }

}
