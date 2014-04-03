package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.*;

import edu.lclark.language.gui.GBC;
import edu.lclark.language.questions.MultipleChoiceQuestion;

public class MultipleChoiceViewEditPanel extends JPanel {

	private JPanel mcPanel;
	private JComboBox numberOfAnswersDropDown;
	private JComboBox correctAnswerDropDown;
	private int correctAnswer;
	public static final int MAX_ANSWERS = 6;
	public static final int GBL_QUESTION_INDEX_START = 3;
	private int numberOfQuestions;
	private JButton saveChangesButton;
	private JButton deleteQuestionButton;
	private EditExamContent previousPage;
	private MultipleChoiceQuestion question;
	private JTextArea[] answers;
	private JTextArea questionField;
	private int levelIndex; 
	private JComboBox levelDropDown; 


	public MultipleChoiceViewEditPanel(EditExamContent previousPage) {
		correctAnswer = 1;
		numberOfQuestions = 4;
		this.previousPage = previousPage;
		question = new MultipleChoiceQuestion();
		levelIndex = 0; 
		drawAll();
	}

	private void drawAll() {

		setBackground(Color.WHITE);
		

		mcPanel = new JPanel();
		mcPanel.setLayout(new GridBagLayout());
		mcPanel.setBackground(Color.WHITE);
		setLayout(new GridBagLayout());

		JLabel title = new JLabel();
		title.setText("Multiple Choice Question");
		add(title, new GBC(0, 0, 3, 1));

		JLabel question = new JLabel();
		question.setText("Question: ");
		questionField = new JTextArea(5, 50);
		questionField.setLineWrap(true);
		questionField.setWrapStyleWord(true);
		JScrollPane questionPane = new JScrollPane(questionField);
		questionPane.setBorder(BorderFactory.createLineBorder(Color.black));
		add(question, new GBC(0, 1).setAnchor(GBC.EAST));
		add(questionPane, new GBC(1, 1, 2, 1));

		JLabel chooseNumber = new JLabel();
		chooseNumber.setText("Choose Number of Answers: ");
		add(chooseNumber, new GBC(0, 2).setAnchor(GBC.EAST));

		JLabel chooseCorrect = new JLabel();
		chooseCorrect.setText("Choose the Correct Answer: ");
		add(chooseCorrect, new GBC(0, 9).setAnchor(GBC.EAST));

		JLabel levelType = new JLabel();
		levelType.setText("Choose Level: ");
		add(levelType, new GBC(0, 10).setAnchor(GBC.EAST));

		String[] numOfAnswers = { "2", "3", "4", "5", "6" };
		String[] correctAnswerArray = new String[numberOfQuestions];
		for (int i = 0; i < correctAnswerArray.length; i++) {
			correctAnswerArray[i] = "" + (i + 1);
		}

		numberOfAnswersDropDown = new JComboBox(numOfAnswers);
		numberOfAnswersDropDown.setSelectedItem("" + numberOfQuestions);
		numberOfAnswersDropDown.addActionListener(EventHandler.create(
				ActionListener.class, this, "numberOfAnswersAction"));
		add(numberOfAnswersDropDown, new GBC(1, 2));
		
		correctAnswerDropDown = new JComboBox(correctAnswerArray);
		correctAnswerDropDown.setSelectedIndex(correctAnswer - 1);
		add(correctAnswerDropDown, new GBC(1, 9));
		correctAnswerDropDown.addActionListener(EventHandler.create(
				ActionListener.class, this, "highlightCorrect"));
		
		createAnswerFields(numberOfQuestions);
		
		String[] levelArray = {"101", "102", "201", "202", "301"};
		
		levelDropDown = new JComboBox(levelArray);
		add(levelDropDown, new GBC(1, 10));
		levelDropDown.setSelectedIndex(levelIndex);
		levelDropDown.addActionListener(EventHandler.create(
				ActionListener.class, this, "levelListener"));

		saveChangesButton = new JButton();
		saveChangesButton.setText("Save Changes");
		saveChangesButton.addActionListener(EventHandler.create(
				ActionListener.class, this, "saveQuestion"));
		add(saveChangesButton, new GBC(2, 11).setAnchor(GBC.CENTER));

		deleteQuestionButton = new JButton();
		deleteQuestionButton.setText("Delete Question");
		deleteQuestionButton.addActionListener(EventHandler.create(
				ActionListener.class, this, "deleteQuestion"));
		add(deleteQuestionButton, new GBC(2, 11).setAnchor(GBC.WEST));

		
		
		revalidate();
		repaint();

	}

	public void createAnswerFields(int n) {
		if (n > MAX_ANSWERS) {
			n = MAX_ANSWERS;
		}
		answers = new JTextArea[n];
		for (int i = GBL_QUESTION_INDEX_START, k = 0, j = 1; i < n
				+ GBL_QUESTION_INDEX_START; i++, j++, k++) {
			JLabel answer = new JLabel();
			answer.setText("Answer " + j + ":");
			JTextArea questionField = new JTextArea(2, 50);
			answers[k] = questionField; 
			questionField.setLineWrap(true);
			questionField.setWrapStyleWord(true);
			if (j == correctAnswer) {
				questionField.setBackground(Color.GREEN);
			}
			JScrollPane questionPane = new JScrollPane(questionField);
			questionPane.setBorder(BorderFactory.createLineBorder(Color.black));
			add(answer, new GBC(0, i).setAnchor(GBC.EAST));
			add(questionPane, new GBC(1, i, 2, 1));
		}
	}

	public void highlightCorrect() {
		correctAnswer = correctAnswerDropDown.getSelectedIndex() + 1;
		updatePage();
	}

	public void levelListener(){
		levelIndex = levelDropDown.getSelectedIndex();
	}
	
	public void saveQuestion() {
		if (!isFilledOut()) {
			JOptionPane.showMessageDialog(this,
					"You need to fill out all fields before you can save.", "Not Done yet!", JOptionPane.PLAIN_MESSAGE);
		} else {
			int n = JOptionPane.showConfirmDialog(this,
					"Are you sure you want to save this question?",
					"Save Question?", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null);
			if (n == 0) {
				previousPage.endEdit(question);
			}
		}
	}

	public void deleteQuestion() {
		int n = JOptionPane.showConfirmDialog(this,
				"Are you sure you want to delete question?",
				"Delete Question?", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null);
		if (n == 0) {
			previousPage.endEdit(null);
		}
	}

	private void updatePage() {
		saveContent();
		removeAll();
		drawAll();
	}
	
	private void saveContent() {
		question.setQuestion(questionField.getText());
		String[] temp = new String[answers.length];
		for (int i = 0; i < answers.length; i++) {
			temp[i] = answers[i].getText();
		}
		question.setAnswers(temp);
		question.setCorrectAnswerIndex(correctAnswer - 1);
		question.setNumberOfAnswers(answers.length);
		switch(levelIndex){
		case 0:
			//TODO
		}
	}

	public void numberOfAnswersAction() {
		int n = numberOfAnswersDropDown.getSelectedIndex() + 2;
		numberOfQuestions = n;
		if (correctAnswer > n) {
			correctAnswer = n;
		}
		updatePage();
	}

	public boolean isFilledOut() {
		return false;
	}

}
