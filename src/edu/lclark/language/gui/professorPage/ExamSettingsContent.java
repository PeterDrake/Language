package edu.lclark.language.gui.professorPage;

import edu.lclark.language.LanguagePlacementExam;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.PromptFileChooser;
import edu.lclark.language.questions.QuestionXMLReader;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * The content panel for displaying options for various exam settings
 */
public class ExamSettingsContent extends AbstractContent {

	private static final long serialVersionUID = 1L;
	
	private File database;
	private JFileChooser fileChooser;
	private JComponent parent = this;
	private QuestionXMLReader reader;

	private JPanel importExportPanel;
	private JPanel parametersPanel;
	private JPanel htmlButtonPanel;

	JTextField numberOfQuestions;
	JTextField numberToAdvance;
	JTextField numberOfIterations;

	public ExamSettingsContent() {

		reader = new QuestionXMLReader();

		setLayout(new GridBagLayout());

		makeImportExportPanel();
		makeHtmlPanel();
		makeParametersPanel();

	}

	
	private void makeImportExportPanel() {
		importExportPanel = new JPanel();
		importExportPanel.setLayout(new GridBagLayout());
		importExportPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		add(importExportPanel, new GBC(0, 0).setInsets(15, 0, 15, 0));

		JLabel importExport = new JLabel("Import/Export Database");
		importExportPanel.add(importExport, new GBC(1, 0).setAnchor(GBC.NORTH));

		JButton exportButton = new JButton("Export");
		exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new PromptFileChooser();
				int returnVal = fileChooser.showSaveDialog(parent);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File destination = fileChooser.getSelectedFile();
					String name = destination.toString();
					if(!name.endsWith(".xml")){
						name += ".xml";
					}
					destination = new File(name);
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
		importExportPanel.add(exportButton, new GBC(2, 1));

		JButton importButton = new JButton("Import");
		importButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("XML Files", "xml"));
				int returnVal = fileChooser.showOpenDialog(parent);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
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
					else
					{
						JOptionPane.showMessageDialog(parent,
								"Not a valid database. Choose another file.",
								"Invalid Database", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		importExportPanel.add(importButton, new GBC(0, 1).setAnchor(GBC.EAST));
	}

	private void makeHtmlPanel() {
		htmlButtonPanel = new JPanel();
		htmlButtonPanel.setPreferredSize(new Dimension(importExportPanel.getPreferredSize().width,
				40));
		htmlButtonPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		add(htmlButtonPanel, new GBC(0, 1).setInsets(15, 0, 15, 0));
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
		htmlButtonPanel.add(editHtmlButton, new GBC(0, 1));
	}

	private void makeParametersPanel() {
		parametersPanel = new JPanel();
		parametersPanel.setLayout(new GridBagLayout());
		parametersPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		parametersPanel.setPreferredSize(new Dimension(importExportPanel.getPreferredSize().width,
				200));
		add(parametersPanel, new GBC(0, 2).setInsets(15, 0, 15, 0));

		JLabel questionsPerLevel = new JLabel("Questions per Level");
		parametersPanel.add(questionsPerLevel, new GBC(0, 0).setAnchor(GBC.EAST));

		numberOfQuestions = new JTextField(3);
		parametersPanel.add(numberOfQuestions, new GBC(1, 0));

		JLabel questionsToAdvance = new JLabel("Correct Answers to Advance Level");
		parametersPanel.add(questionsToAdvance, new GBC(0, 1).setAnchor(GBC.EAST));

		numberToAdvance = new JTextField(3);
		parametersPanel.add(numberToAdvance, new GBC(1, 1));

		JLabel maxIterations = new JLabel("Maximum Iterations");
		parametersPanel.add(maxIterations, new GBC(0, 2).setAnchor(GBC.EAST));

		numberOfIterations = new JTextField(3);
		parametersPanel.add(numberOfIterations, new GBC(1, 2));

		JTextArea hints = new JTextArea(
				" If max iterations is lower than 5,\nupper levels will never be reached.");
		hints.setBackground(parametersPanel.getBackground());
		parametersPanel.add(hints, new GBC(0, 3, 2, 1).setInsets(10, 0, 0, 0));

		JButton applyButton = new JButton("Apply");
		applyButton.addActionListener(new EditSettingsAction());
		parametersPanel.add(applyButton,
				new GBC(1, 4).setInsets(15, 0, 0, 0).setAnchor(GBC.SOUTHEAST));

		getCurrentSettings();
	}

	/** Load the data saved in the settings file and fill in the appropriate fields with it. */
	private void getCurrentSettings() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(
					new File(LanguagePlacementExam.PATH + "settings.txt")), "UTF-8"));
			numberOfQuestions.setText(in.readLine());
			numberToAdvance.setText(in.readLine());
			numberOfIterations.setText(in.readLine());
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	private class EditSettingsAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				PrintWriter out = new PrintWriter(LanguagePlacementExam.PATH + "settings.txt",
						"UTF-8");
				out.println(numberOfQuestions.getText());
				out.println(numberToAdvance.getText());
				out.println(numberOfIterations.getText());
				out.close();
			} catch (FileNotFoundException | UnsupportedEncodingException ex) {
				ex.printStackTrace();
				System.exit(0);
			}
		}

	}

}
