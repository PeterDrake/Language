package edu.lclark.language.gui.professorPage;

import edu.lclark.language.gui.GBC;
import edu.lclark.language.questions.MultipleChoiceQuestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

/**
 * The Panel that handles entering and editing multiple choice questions
 */
public class MultipleChoiceViewEditPanel extends AbstractViewEditPanel {

	private int correctAnswerIndex;
	private JComboBox correctAnswerDropDown;
	private JLabel chooseCorrect;

	public MultipleChoiceViewEditPanel(EditExamContent previousPage) {
		super(previousPage);
		question = new MultipleChoiceQuestion();
		numberOfAnswers = 4;
		correctAnswerIndex = 0;
		createAll(); 
		drawAll();
	}

	
	public MultipleChoiceViewEditPanel(EditExamContent previousPage, MultipleChoiceQuestion question) {
		super(previousPage, question);
		numberOfAnswers = question.getNumberOfAnswers();
		createAll(); 
		setAll(); 
		drawAll();
	}

	@Override
	protected void setSpecific() {
		for (int i = 0; i < numberOfAnswers; i++) {
			answerFields[i].setText(question.getAnswerAtIndex(i));
			if(question.getCorrectAnswerAtIndex(0).equals(question.getAnswerAtIndex(i))){
				correctAnswerIndex = i; 
			}
		}
	}

	protected void createSpecific() {
		title = new JLabel();
		title.setText("Multiple Choice Question");
		
		chooseCorrect = new JLabel();
		chooseCorrect.setText("Correct Answer: ");
		
		levelType = new JLabel();
		levelType.setText("Choose Level: ");
		
		String[] numOfAnswers = { "2", "3", "4", "5", "6" };
		numberOfAnswersDropDown = new JComboBox(numOfAnswers);
		numberOfAnswersDropDown.setSelectedItem("" + numberOfAnswers);
		numberOfAnswersDropDown.addActionListener(EventHandler.create(
				ActionListener.class, this, "numberOfAnswersAction"));
		
		setCorrectAnswerDropDown();
	}

	@Override
	protected void drawSpecific() {
		add(chooseCorrect, new GBC(0, 9).setAnchor(GBC.EAST));
		setCorrectAnswerDropDown();
		add(correctAnswerDropDown, new GBC(1, 9).setAnchor(GBC.WEST));

	}


	@Override
	public void showAnswerFields(int n) {
		super.showAnswerFields(n);
		for (int i = 0, j = GBL_QUESTION_INDEX_START; i < n; i++, j++) {
			if (i == correctAnswerIndex) {
				answerFields[i].setBackground(new Color(194, 255, 133));
			} else {
				answerFields[i].setBackground(Color.WHITE);
			}
		}
	}
	

    /**
     * Saves the specific entered information in a new MultipleChoiceQuestion object, ready to be saved to the master list.
     */
    protected void saveSpecificContent() {
        
        question.setCorrectAnswers(new String[]{answerFields[correctAnswerIndex].getText()});

        String[] temp = new String[numberOfAnswers];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = answerFields[i].getText();
        }
        question.setAnswers(temp);

    }

	/**
	 * Creates a new correctAnswerDropDown based on how many answer fields are
	 * shown
	 */
	private void setCorrectAnswerDropDown() {
		String[] correctAnswerArray = new String[numberOfAnswers];
		for (int i = 0; i < correctAnswerArray.length; i++) {
			correctAnswerArray[i] = "" + (i + 1);
		}
		correctAnswerDropDown = new JComboBox(correctAnswerArray);
		correctAnswerDropDown.setSelectedIndex(correctAnswerIndex);
		correctAnswerDropDown.addActionListener(EventHandler.create(
				ActionListener.class, this, "highlightCorrectAction"));
	}

	/**
	 * The action performed when correctAnswerDropDown is changed, highlights
	 * the correct answer field
	 */
	public void highlightCorrectAction() {
		correctAnswerIndex = correctAnswerDropDown.getSelectedIndex();
		updatePage();
	}
	
	/**
     * The action performed when changing the numberOfAnswersDropDown, changes number of shown answer fields
     */
	@Override
    public void numberOfAnswersAction() {
        int n = numberOfAnswersDropDown.getSelectedIndex() + 2;
        numberOfAnswers = n;
        if (correctAnswerIndex > n - 1) {
            correctAnswerIndex = n - 1;
        }
        updatePage();
    }

	@Override
	public boolean isSpecificFilledOut() {
		// Nothing specific to check
		return true;
	}

}
