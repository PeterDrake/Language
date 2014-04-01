package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.*;

import edu.lclark.language.gui.GBC;

public class MultipleChoiceViewEditPanel extends JPanel {

	private JPanel mcPanel;
	private JComboBox numberOfAnswersDropDown;
	private JComboBox correctAnswerDropDown;
	private int correctAnswer;
	public static final int MAX_QUESTIONS = 6;
	public static final int GBL_QUESTION_INDEX_START = 3;
	private int numberOfQuestions;
	private JButton saveChangesButton;
	private JButton deleteQuestionButton;

	public MultipleChoiceViewEditPanel() {
		correctAnswer = 1;
		numberOfQuestions = 4;
		drawAll();
	}

	public void drawAll() {

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
		JTextArea questionField = new JTextArea(5, 50);
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

		saveChangesButton = new JButton();
		saveChangesButton.setText("Save Changes");
		saveChangesButton.addActionListener(EventHandler.create(
				ActionListener.class, this, "saveQuestion"));
		add(saveChangesButton, new GBC(2, 10).setAnchor(GBC.CENTER));

		deleteQuestionButton = new JButton();
		deleteQuestionButton.setText("Delete Question");
		deleteQuestionButton.addActionListener(EventHandler.create(
				ActionListener.class, this, "deleteQuestion"));
		add(deleteQuestionButton, new GBC(2, 10).setAnchor(GBC.WEST));

		revalidate();
		repaint();

	}

	public void createAnswerFields(int n) {
		// i = 3 because the grid bag layout is empty 3-8
		if (n > MAX_QUESTIONS) {
			n = MAX_QUESTIONS;
		}
		for (int i = GBL_QUESTION_INDEX_START, j = 1; i < n
				+ GBL_QUESTION_INDEX_START; i++, j++) {
			JLabel answer = new JLabel();
			answer.setText("Answer " + j + ":");
			JTextArea questionField = new JTextArea(2, 50);
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

	public void saveQuestion() {
		// TODO 
		updatePage(); 
	}

	public void deleteQuestion() {
		updatePage();
		// TODO
	}

	private void updatePage() {
		// TODO Save stuff
		removeAll();
		drawAll();
	}

	public void numberOfAnswersAction() {
		int n = numberOfAnswersDropDown.getSelectedIndex() + 2;
		numberOfQuestions = n;
		if (correctAnswer > n) {
			correctAnswer = n;
		}
		updatePage();
	}
	
}
