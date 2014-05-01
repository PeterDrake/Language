package edu.lclark.language.gui;

import javax.swing.*;
import java.io.File;

public class PromptFileChooser extends JFileChooser {

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
