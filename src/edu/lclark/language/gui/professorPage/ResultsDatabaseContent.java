package edu.lclark.language.gui.professorPage;

import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.PromptFileChooser;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.studentLogic.ScoreReader;
import edu.lclark.language.studentLogic.ScoreWriter;
import edu.lclark.language.studentLogic.StudentScore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * The content panel for viewing student results in the professor page
 */

public class ResultsDatabaseContent extends AbstractContent {

	private static final long serialVersionUID = 1L;
	
	private JFileChooser fileChooser;
	private JComponent parent = this;
	private ScoreReader reader;
	private ScoreWriter writer;
	
	public ResultsDatabaseContent() {
		setLayout(new GridBagLayout());
		String[] columnNames = { "Name", "Date", "Level" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		final JTable table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(800, 600));
		table.setFillsViewportHeight(true);
		reader = new ScoreReader();
		writer = new ScoreWriter();
		ArrayList<StudentScore> scores = reader.getScores();
		for (int i = 0; i < scores.size(); i++) {
			String name = scores.get(i).getUser();
			String date = scores.get(i).getDate();
			QuestionLevel level = scores.get(i).getLevel();

			Object[] data = { name, date, level };
			tableModel.addRow(data);
		}

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane, new GBC(0, 0));

		JButton exportButton = new JButton("Export");
		exportButton.addActionListener(new ExportAction());
		add(exportButton, new GBC(0, 1));

	}
	

	private class ExportAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			fileChooser = new PromptFileChooser();
			int returnVal = fileChooser.showSaveDialog(parent);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File destination = fileChooser.getSelectedFile();
				System.out.println(destination.toString());
				writer.writeAllScoresToFile(reader.getScores(), destination.toString());
			}

		}

	}


}
// tableModel idea implemented from
// http://stackoverflow.com/questions/20526917/load-arraylist-data-into-jtable
