package edu.lclark.language.professorPage;

import javax.swing.*;

import edu.lclark.language.AbstractUserPage;
import edu.lclark.language.PageInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorPage extends AbstractUserPage implements PageInterface {

	private JToggleButton profileButton;
	private JToggleButton editTestButton;
	private JToggleButton viewResultsButton;
	private AbstractContent currentContent;
	
	public ProfessorPage() {

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
		
		title.setText("Profile");

		currentContent = new ProfileContent();
		add(currentContent, BorderLayout.SOUTH);
	}

	//TODO These actions will be performed even if the button is already depress. Fix?
	private class DisplayProfileAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			remove(currentContent);
			currentContent = new ProfileContent();
			add(currentContent, BorderLayout.SOUTH);
			title.setText("Profile");
		}
	}

	private class DisplayQuestionsAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {		
			remove(currentContent);
			currentContent = new EditTestContent();
			add(currentContent, BorderLayout.SOUTH);
			title.setText("Edit Questions");
		}

	}
	
	private class DisplayResultsAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e){		
			remove(currentContent);
			currentContent = new ResultsDatabaseContent();
			add(currentContent, BorderLayout.SOUTH);
			title.setText("Student Results");
		}
	}

}
