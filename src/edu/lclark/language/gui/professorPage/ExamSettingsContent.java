package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import edu.lclark.language.LanguagePlacementTest;
import edu.lclark.language.gui.GBC;

/**
 * The content panel for displaying options for various exam settings
 */
public class ExamSettingsContent extends AbstractContent{
	
	public ExamSettingsContent(){
		
		setLayout(new GridBagLayout());
		
		JLabel importExport = new JLabel("Import/Export Database");
		add(importExport, new GBC(1,0).setAnchor(GBC.NORTH));
		
		JButton exportButton = new JButton("Export");
		add(exportButton, new GBC(0,1));
		
		JButton importButton = new JButton("Import");
		add(importButton, new GBC(2,1));
		
		JButton editHtmlButton = new JButton("Edit HTML Files");
		editHtmlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					Desktop.getDesktop().open(new File(LanguagePlacementTest.PATH + "HTMLs"));
					//Runtime.getRuntime().exec("/usr/bin/open ~/Library/Application\\ Support/Foreign\\ Language\\ Exam");
				} catch (IOException e1) {
					e1.printStackTrace();
					System.exit(0);
				}
			}
		});
		add(editHtmlButton, new GBC(1,2));

    }

}
