package edu.lclark.language.gui.professorPage;

import javax.swing.*;

import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.MainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorPage extends AbstractUserPage {
	
	private JPanel buttonPanel;
	private ButtonGroup buttonGroup;

	private JToggleButton profileButton;
	private JToggleButton editTestButton;
	private JToggleButton viewResultsButton;
	private AbstractContent currentContent;
    private JPanel contentPanel;
	
	private String name;
	
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
		setName("Professor");

        //TODO Fix switching views using toggle buttons (doesn't update correctly)
		currentContent = new ProfileContent(name);
		contentPanel.add(currentContent, BorderLayout.CENTER);
	}
	
	public void setName(String name){
		this.name = name;
	}

	//TODO These actions will be performed even if the button is already depress. Fix?
	private class DisplayProfileAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			contentPanel.remove(currentContent);
			currentContent = new ProfileContent(name);
			contentPanel.add(currentContent, BorderLayout.CENTER);
			title.setText("Profile");
		}
	}

	private class DisplayQuestionsAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {		
			contentPanel.remove(currentContent);
			currentContent = new EditTestContent();
            contentPanel.add(currentContent, BorderLayout.CENTER);
			title.setText("Edit Questions");
		}

	}
	
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
