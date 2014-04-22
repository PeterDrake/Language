package edu.lclark.language.gui.professorPage;

import javax.swing.*;

import edu.lclark.language.LanguagePlacementTest;
import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.MainWindow;
import edu.lclark.language.questions.ProfessorDatabaseInterface;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The professor page, which contains the title and all other content panels for question editing, results viewing, etc.
 */
public class ProfessorPage extends AbstractUserPage {
	
	private JPanel buttonPanel;
	private ButtonGroup buttonGroup;

	private JToggleButton profileButton;
	private JToggleButton editTestButton;
	private JToggleButton viewResultsButton;
	private AbstractContent currentContent;
    private JPanel contentPanel;
    
	private String name;
	
	/**
	 * @param main the main JFrame that contains all components
	 */
	public ProfessorPage(MainWindow main) {
		
		super(main);
		
		title.setText("Profile");
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		add(contentPanel, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonGroup = new ButtonGroup();
		contentPanel.add(buttonPanel, BorderLayout.NORTH);

		profileButton = new JToggleButton("Profile", true);
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

		//This will be removed eventually
		setUserName("Professor");

        //TODO Fix switching views using toggle buttons (doesn't update correctly)
		currentContent = new ExamSettingsContent(name);
		contentPanel.add(currentContent, BorderLayout.CENTER);
	}

	/**
	 * Sets the User's name for display on the professor page
	 * 
	 * @param name The user's name
	 */
	public void setUserName(String name){
        this.name = name;
	}

    public void refresh() {
        //TODO Write refresh method for refresh button
    }

	//TODO These actions will be performed even if the button is already depress. Fix?
	/**
	 * An action listener that switches to ProfileContent when the "Profile" button is clicked
	 */
	private class DisplayProfileAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			contentPanel.remove(currentContent);
			currentContent = new ExamSettingsContent(name);
			contentPanel.add(currentContent, BorderLayout.CENTER);
			title.setText("Profile");
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
