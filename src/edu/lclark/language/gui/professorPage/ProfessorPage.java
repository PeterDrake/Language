package edu.lclark.language.gui.professorPage;

import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The professor page, which contains the title and all other content panels for question editing, results viewing, etc.
 */
@SuppressWarnings("serial")
public class ProfessorPage extends AbstractUserPage {
	
	private JPanel buttonPanel;
	private ButtonGroup buttonGroup;

	private JToggleButton profileButton;
	private JToggleButton editTestButton;
	private JToggleButton viewResultsButton;
	private AbstractContent currentContent;
    private JPanel contentPanel;
    
	
	/**
	 * @param main the main JFrame that contains all components
	 */
	public ProfessorPage(MainWindow main) {
		
		super(main);
		
		title.setText("Exam Settings");
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		add(contentPanel, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonGroup = new ButtonGroup();
		contentPanel.add(buttonPanel, BorderLayout.NORTH);

		profileButton = new JToggleButton("Exam Settings", true);
		profileButton.addActionListener(new DisplayProfileAction());
		buttonGroup.add(profileButton);
		buttonPanel.add(profileButton);

		editTestButton = new JToggleButton("Edit Questions");
		editTestButton.addActionListener(new DisplayQuestionsAction());
		buttonGroup.add(editTestButton);
		buttonPanel.add(editTestButton);

		viewResultsButton = new JToggleButton("Student Results");
		viewResultsButton.addActionListener(new DisplayResultsAction());
		buttonGroup.add(viewResultsButton);
		buttonPanel.add(viewResultsButton);

		currentContent = new ExamSettingsContent();
		contentPanel.add(currentContent, BorderLayout.CENTER);
	}


	/**
	 * An action listener that switches to ProfileContent when the "Profile" button is clicked
	 */
	private class DisplayProfileAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			contentPanel.remove(currentContent);
			currentContent = new ExamSettingsContent();
			contentPanel.add(currentContent, BorderLayout.CENTER);
			title.setText("Exam Settings");
		}
	}

	/**
	 * An action listener that switches to EditTestContent when the "Edit Questions" button is clicked
	 */
	private class DisplayQuestionsAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {		
			contentPanel.remove(currentContent);
			currentContent = new EditExamContent();
            contentPanel.add(currentContent, BorderLayout.CENTER);
			title.setText("Edit Questions");
		}

	}
	
	/**
	 * An action listener that switches to ResultsDatabaseContnet when the "Student Results" button is clicked
	 */
	private class DisplayResultsAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e){		
			contentPanel.remove(currentContent);
			currentContent = new ResultsDatabaseContent();
            contentPanel.add(currentContent, BorderLayout.CENTER);
			title.setText("Student Results");
		}
	}

}
