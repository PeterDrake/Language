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

	public MultipleChoiceViewEditPanel() {
		drawAll(4);
	}

	public void drawAll(int n) {

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
		chooseCorrect.setText("Choose the Corrct Answer: ");
		add(chooseCorrect, new GBC(0, 9).setAnchor(GBC.EAST));

		String[] numOfAnswers = { "2", "3", "4", "5", "6" };
		String[] correctAnswer = { "1", "2", "3", "4", "5", "6" };

		numberOfAnswersDropDown = new JComboBox(numOfAnswers);
		numberOfAnswersDropDown.setSelectedItem(""+ n);
		numberOfAnswersDropDown.addActionListener(new NumberOfAnswersAction());
		add(numberOfAnswersDropDown, new GBC(1, 2));
		correctAnswerDropDown = new JComboBox(correctAnswer);
		add(correctAnswerDropDown, new GBC(1, 9));

		correctAnswerDropDown.addActionListener(EventHandler.create(ActionListener.class, this, "highlightCorrect"));
		createAnswerFields(n);

		revalidate();
		repaint();

	}
	

	public void createAnswerFields(int n) {
		// i = 3 because the grid bag layout is empty 3-8
		if (n > 6) {
			n = 6;
		}
		for (int i = 3, j = 1; i < n + 3; i++, j++) {
			JLabel answer = new JLabel();
			answer.setText("Answer " + j + ":");
			JTextArea questionField = new JTextArea(2, 50);
			questionField.setLineWrap(true);
			questionField.setWrapStyleWord(true);
			JScrollPane questionPane = new JScrollPane(questionField);
			questionPane.setBorder(BorderFactory.createLineBorder(Color.black));
			add(answer, new GBC(0, i).setAnchor(GBC.EAST));
			add(questionPane, new GBC(1, i, 2, 1));
		}
	}
	
	public void highlightCorrect(){
		System.out.println("This is Correct!!!!! YAY!" + correctAnswerDropDown.getSelectedItem());
	}

	private class NumberOfAnswersAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (numberOfAnswersDropDown.getSelectedIndex()) {
		
			case 0:
				removeAll();
				drawAll(2);
				break;
			case 1:
				removeAll();
				drawAll(3);
				break;
			case 2:
				removeAll();
				drawAll(4);
				break;
			case 3:
				removeAll();
				drawAll(5);
				break;
			case 4:
				removeAll();
				drawAll(6);
				break;
			default:
				break;
			}
		}
	}

}
