package edu.lclark.language.gui;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.File;

public class PromptFileChooser extends JFileChooser {

	private static final long serialVersionUID = 1L;

	@Override
	public void approveSelection() {
		File f = getSelectedFile();
		if (f.exists() && getDialogType() == SAVE_DIALOG) {
			int result = JOptionPane.showConfirmDialog(this, "The file exists. Overwrite?",
					"Existing file", JOptionPane.YES_NO_OPTION);
			switch (result) {
			case JOptionPane.YES_OPTION:
				super.approveSelection();
				return;
			case JOptionPane.NO_OPTION:
				return;
			case JOptionPane.CLOSED_OPTION:
				return;
			case JOptionPane.CANCEL_OPTION:
				cancelSelection();
				return;
			}
		}
		super.approveSelection();
	}

}
