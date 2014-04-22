package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.*;

import edu.lclark.language.gui.GBC;

/**
 * The content panel for displaying options for various exam settings
 */
public class ExamSettingsContent extends AbstractContent{
	
	public ExamSettingsContent(){
		
		setLayout(new GridBagLayout());
		
		JLabel importExport = new JLabel("Import/Export Database");
		add(importExport, new GBC(1,0).setAnchor(GBC.NORTH));
		JButton exportButton = new JButton("Import");
		add(exportButton, BorderLayout.CENTER);

    }

}
