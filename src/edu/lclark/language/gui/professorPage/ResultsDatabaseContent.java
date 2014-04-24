package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.MainWindow;

import edu.lclark.language.gui.studentPage.StudentInstructionPage;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;
import edu.lclark.language.studentLogic.StudentResult;

/**
 * The content panel for viewing student results in the professor page
 */
public class ResultsDatabaseContent extends AbstractContent {

	public ResultsDatabaseContent() {
		setLayout(new GridBagLayout());
		String[] columnNames = { "Name", "Date", "Level" };

		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		final JTable table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(800, 600));
		table.setFillsViewportHeight(true);

		ArrayList<StudentResult> fakeResults = createFakeResults();
		for (int i = 0; i < fakeResults.size(); i++) {
			String name = fakeResults.get(i).getName();
			String date = fakeResults.get(i).getDate();
			QuestionLevel level = fakeResults.get(i).getLevel();

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

	public ArrayList<StudentResult> createFakeResults() {
		ArrayList<StudentResult> fakeResults = new ArrayList<StudentResult>();

		for (int i = 0; i < 125; i++) {
			StudentResult s = new StudentResult("Andi" + i, "" + i,
					QuestionLevel.LEVEL_101);

			fakeResults.add(s);
		}

		return fakeResults;

	}
	

	private class ExportAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO
			System.out.println("helo ");

		}

	}


}
// tableModel idea implemented from
// http://stackoverflow.com/questions/20526917/load-arraylist-data-into-jtable
