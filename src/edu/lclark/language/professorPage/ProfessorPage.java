package edu.lclark.language.professorPage;

import javax.swing.*;

import edu.lclark.language.PageInteface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorPage extends JComponent implements PageInteface {

	private JPanel buttonPanel;
	private JToggleButton profileButton;
	private JToggleButton editTestButton;
	private JToggleButton viewResultsButton;
	private AbstractContent currentContent;
	
	private JPanel titlePanel;
	private JLabel title;

	public ProfessorPage() {
		setLayout(new BorderLayout());

		buttonPanel = new JPanel();
		ButtonGroup buttonGroup = new ButtonGroup();

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

		add(buttonPanel, BorderLayout.CENTER);
		
		titlePanel = new JPanel();
		title = new JLabel("Profile");
		titlePanel.add(title);
		add(titlePanel, BorderLayout.NORTH);
		
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
