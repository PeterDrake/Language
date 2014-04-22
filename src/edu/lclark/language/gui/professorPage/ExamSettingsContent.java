package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Desktop;
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

import edu.lclark.language.LanguagePlacementTest;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.questions.QuestionXMLReader;

/**
 * The content panel for displaying options for various exam settings
 */
public class ExamSettingsContent extends AbstractContent {

	private File database;	
	private JFileChooser fileChooser;
	private JComponent parent = this;

	public ExamSettingsContent() {

		setLayout(new GridBagLayout());

		JLabel importExport = new JLabel("Import/Export Database");
		add(importExport, new GBC(1, 0).setAnchor(GBC.NORTH));

		JButton exportButton = new JButton("Export");
		exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		add(exportButton, new GBC(2, 1));

		JButton importButton = new JButton("Import");
		importButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("XML Files", "xml"));
				int returnVal = fileChooser.showOpenDialog(parent);
				if(returnVal == fileChooser.APPROVE_OPTION){
					database = fileChooser.getSelectedFile();
					if(QuestionXMLReader.verifyDatabase(database)){
						try {
							Files.copy(database.toPath(), Paths.get(LanguagePlacementTest.PATH + "questions.xml"), StandardCopyOption.REPLACE_EXISTING);
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
					Desktop.getDesktop().open(new File(LanguagePlacementTest.PATH + "HTMLs"));
				} catch (IOException e1) {
					e1.printStackTrace();
					System.exit(0);
				}
			}
		});
		add(editHtmlButton, new GBC(1, 2));

	}
}
