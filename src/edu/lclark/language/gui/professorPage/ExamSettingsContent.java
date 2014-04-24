package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import edu.lclark.language.LanguagePlacementExam;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.questions.QuestionXMLReader;

/**
 * The content panel for displaying options for various exam settings
 */
public class ExamSettingsContent extends AbstractContent {

	private File database;
	private JFileChooser fileChooser;
	private JComponent parent = this;
	private QuestionXMLReader reader;

	public ExamSettingsContent() {

		reader = new QuestionXMLReader();

		setLayout(new GridBagLayout());

		JLabel importExport = new JLabel("Import/Export Database");
		add(importExport, new GBC(1, 0).setAnchor(GBC.NORTH));

		JButton exportButton = new JButton("Export");
		exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser();
				int returnVal = fileChooser.showSaveDialog(parent);
				if (returnVal == fileChooser.APPROVE_OPTION) {
					File destination = fileChooser.getSelectedFile();
					try {
						Files.copy(Paths.get(LanguagePlacementExam.PATH + "questions.xml"),
								destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e1) {
						e1.printStackTrace();
						System.exit(0);
					}
				}
			}
		});
		add(exportButton, new GBC(2, 1));

		JButton importButton = new JButton("Import");
		importButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("XML Files", "xml"));
				int returnVal = fileChooser.showOpenDialog(parent);
				if (returnVal == fileChooser.APPROVE_OPTION) {
					database = fileChooser.getSelectedFile();
					if (reader.verifyDatabase(database)) {
						try {
							Files.copy(database.toPath(),
									Paths.get(LanguagePlacementExam.PATH + "questions.xml"),
									StandardCopyOption.REPLACE_EXISTING);
							LanguagePlacementExam.questionDatabase.reloadDatabase();
						} catch (IOException e1) {
							e1.printStackTrace();
							System.exit(0);
						}
					}
				}
			}
		});
		add(importButton, new GBC(0, 1));

		JButton editHtmlButton = new JButton("Edit HTML Files");
		editHtmlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().open(new File(LanguagePlacementExam.PATH + "HTMLs"));
				} catch (IOException e1) {
					e1.printStackTrace();
					System.exit(0);
				}
			}
		});
		add(editHtmlButton, new GBC(1, 2));
		
		JLabel questionsPerLevel = new JLabel("Questions per Level");
		add(questionsPerLevel, new GBC(0,3));
		
		JTextField numberOfQuestions = new JTextField(3);
		add(numberOfQuestions, new GBC(1,3));
		
		JLabel questionsToAdvance = new JLabel("Correct Answers to Advance Level");
		add(questionsToAdvance, new GBC(0,4));
		
		JTextField numberToAdvance = new JTextField(3);
		add(numberToAdvance, new GBC(1,4));
		
		JLabel maxIterations = new JLabel("Maximum Iterations");
		add(maxIterations, new GBC(0,4));
		
		JTextField numberOfIterations = new JTextField(3);
		add(numberOfIterations, new GBC(1,4));

	}

}
