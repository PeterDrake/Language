package edu.lclark.language.gui.professorPage;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import edu.lclark.language.questions.FillInTheBlankQuestion;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

/**
 * The Panel that handles entering and editing fill in the blank questions
 */
public class FillInTheBlankViewEditPanel extends AbstractViewEditPanel{
	
	private EditExamContent previousPage;
	
	public FillInTheBlankViewEditPanel(EditExamContent previousPage) {
		super(previousPage);
		this.previousPage = previousPage;
		
		setBackground(Color.WHITE);
		
		 this.previousPage = previousPage;
	        question = new FillInTheBlankQuestion();
	        numberOfAnswers = 1;
	        createAll();
	        drawAll();
	}

	
	public FillInTheBlankViewEditPanel(EditExamContent previousPage, FillInTheBlankQuestion question) {
		super(previousPage, question);
		numberOfAnswers = question.getNumberOfCorrectAnswers(); 
		createAll();
		setAll();
		drawAll();
	}

	@Override
	protected void setSpecific() {
		for (int i = 0; i < numberOfAnswers; i++) {
			answerFields[i].setText(question.getCorrectAnswerAtIndex(i));
		}
	}

	protected void createSpecific() {
		title = new JLabel();
		title.setText("Fill in the Blank Question");
		
		String[] numOfAnswers = {"1", "2", "3", "4", "5", "6"};
		numberOfAnswersDropDown = new JComboBox(numOfAnswers);
		numberOfAnswersDropDown.setSelectedItem("" + numberOfAnswers);
		numberOfAnswersDropDown.addActionListener(EventHandler.create(
				ActionListener.class, this, "numberOfAnswersAction"));
	}
	
	@Override
	protected void drawSpecific() {
		// nothing specific to draw
		
	}

	@Override
	protected void saveSpecificContent() {
        String[] temp = new String[numberOfAnswers];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = answerFields[i].getText();
        }
        question.setCorrectAnswers(temp);
	}

	@Override
	public boolean isSpecificFilledOut() {
		String s = questionField.getText();
		if (s.contains("_")) {
			return true;
		}
		return false;
	}
	
	/**
	 * The action performed when changing the numberOfAnswersDropDown, changes number of shown answer fields
	 */
	@Override
	public void numberOfAnswersAction() {
		int n = numberOfAnswersDropDown.getSelectedIndex() + 1;
		numberOfAnswers = n;
		updatePage();
	}


	
	
}