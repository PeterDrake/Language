package edu.lclark.language.gui.professorPage;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import edu.lclark.language.gui.GBC;
import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.QuestionInfo;

public abstract class AbstractViewEditPanel extends JPanel {

	public static final int MAX_ANSWERS = 6;
	public static final int GBL_QUESTION_INDEX_START = 3;

	protected EditExamContent previousPage;
	protected AbstractQuestion question;
	protected int numberOfAnswers;
	protected int levelIndex;
	protected JComboBox numberOfAnswersDropDown;
	protected JComboBox levelDropDown;
	protected JTextArea[] answerFields;
	protected JLabel[] answerLabels;
	protected JLabel title;
	protected JLabel questionLabel;
	protected JTextArea questionField;
	protected JLabel chooseNumber;
	protected JLabel levelType;
	protected JButton saveChangesButton;
	protected JButton deleteQuestionButton;
	protected boolean isEditing;

	public AbstractViewEditPanel(EditExamContent previousPage) {
		this.previousPage = previousPage;
		levelIndex = 0;
		isEditing = false;
	}

	public AbstractViewEditPanel(EditExamContent previousPage,
			AbstractQuestion question) {
		this.previousPage = previousPage;
		this.question = question;
		isEditing = true;

	}

	protected void setAll() {
		questionField.setText(question.getText());
		switch (question.getLevel()) {
		case LEVEL_101:
			levelIndex = 0;
			break;
		case LEVEL_102:
			levelIndex = 1;
			break;
		case LEVEL_201:
			levelIndex = 2;
			break;
		case LEVEL_202:
			levelIndex = 3;
			break;
		case LEVEL_301:
			levelIndex = 4;
			break;
		default:
			break;
		}
		levelDropDown.setSelectedIndex(levelIndex);
		setSpecific();
	}

	protected void createAll() {
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());

		questionLabel = new JLabel();
		questionLabel.setText("Question: ");

		questionField = new JTextArea(5, 50);
		questionField.setLineWrap(true);
		questionField.setWrapStyleWord(true);
		questionField
				.setFocusTraversalKeys(
						KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
						getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));

		chooseNumber = new JLabel();
		chooseNumber.setText("Number of Answers: ");

		levelType = new JLabel();
		levelType.setText("Choose Level: ");

		String[] levelArray = { "101", "102", "201", "202", "301" };
		levelDropDown = new JComboBox(levelArray);
		levelDropDown.setSelectedIndex(levelIndex);
		levelDropDown.addActionListener(EventHandler.create(
				ActionListener.class, this, "levelAction"));

		createAnswerFields();

		saveChangesButton = new JButton();
		saveChangesButton.setText("Save Question");
		saveChangesButton.addActionListener(EventHandler.create(
				ActionListener.class, this, "saveAction"));

		deleteQuestionButton = new JButton();
		deleteQuestionButton.setText("Delete Question");
		deleteQuestionButton.addActionListener(EventHandler.create(
				ActionListener.class, this, "deleteAction"));
		createSpecific();
	}

	/**
	 * Adds all components to the grid bag layout after each interface update
	 */
	protected void drawAll() {

		add(title, new GBC(0, 0, 3, 1).setIpad(25, 25));
		add(questionLabel, new GBC(0, 1).setAnchor(GBC.EAST));

		JScrollPane questionPane = new JScrollPane(questionField);
		questionPane.setBorder(BorderFactory.createLineBorder(Color.black));
		add(questionPane, new GBC(1, 1, 2, 1));

		add(chooseNumber, new GBC(0, 2).setAnchor(GBC.EAST));
		add(levelType, new GBC(0, 10).setAnchor(GBC.EAST));
		add(numberOfAnswersDropDown, new GBC(1, 2));

		add(levelDropDown, new GBC(1, 10));

		showAnswerFields(numberOfAnswers);

		add(saveChangesButton, new GBC(2, 11).setAnchor(GBC.CENTER));
		add(deleteQuestionButton, new GBC(2, 11).setAnchor(GBC.WEST));

		drawSpecific();

		revalidate();
		repaint();
	}

	/**
	 * Creates the correct number of answer fields based on MAX_ANSWERS
	 */
	protected void createAnswerFields() {
		answerFields = new JTextArea[MAX_ANSWERS];
		answerLabels = new JLabel[MAX_ANSWERS];

		for (int i = 0; i < MAX_ANSWERS; i++) {
			answerLabels[i] = new JLabel();
			answerLabels[i].setText("Answer " + (i + 1) + ":");

			answerFields[i] = new JTextArea(2, 50);
			answerFields[i].setLineWrap(true);
			answerFields[i].setWrapStyleWord(true);
			answerFields[i]
					.setFocusTraversalKeys(
							KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
							getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
		}
	}

	/**
	 * Shows the correct number of answer fields after each interface update
	 * 
	 * @param n
	 *            number of fields to show
	 */
	protected void showAnswerFields(int n) {
		for (int i = 0, j = GBL_QUESTION_INDEX_START; i < n; i++, j++) {

			JScrollPane sp = new JScrollPane(answerFields[i]);
			sp.setBorder(BorderFactory.createLineBorder(Color.black));

			add(answerLabels[i], new GBC(0, j).setAnchor(GBC.EAST));
			add(sp, new GBC(1, j, 2, 1));
		}
	}

	/**
	 * Updates the panel after changing the number of answers or correct answer
	 */
	protected void updatePage() {
		removeAll();
		drawAll();
	}

	/**
	 * Indicates whether or not the question is complete and can be saved.
	 * 
	 * @return true if done, false if incomplete
	 */
	public boolean isFilledOut() {
		if (questionField.getText().equals("")) {
			return false;
		}

		for (int i = 0; i < numberOfAnswers; i++) {
			if (answerFields[i].getText().equals("")) {
				return false;
			}
		}
		if (isSpecificFilledOut()) {
			return true;
		}
		return false;
	}

	/**
	 * Saves the entered information in a new MultipleChoiceQuestion object,
	 * ready to be saved to the master list.
	 */
	protected void saveContent() {
		question.setText(questionField.getText());

		switch (levelIndex) {
		case 0:
			question.setLevel(QuestionInfo.QuestionLevel.LEVEL_101);
			break;
		case 1:
			question.setLevel(QuestionInfo.QuestionLevel.LEVEL_102);
			break;
		case 2:
			question.setLevel(QuestionInfo.QuestionLevel.LEVEL_201);
			break;
		case 3:
			question.setLevel(QuestionInfo.QuestionLevel.LEVEL_202);
			break;
		case 4:
			question.setLevel(QuestionInfo.QuestionLevel.LEVEL_301);
			break;
		default:
			break;
		}
		saveSpecificContent();
	}

	/**
	 * Changes the level when levelDropDown is changed
	 */
	public void levelAction() {
		levelIndex = levelDropDown.getSelectedIndex();
	}

	/**
	 * The action performed when "Save" is pressed, checks if everything is
	 * filled out and saves the entered info. Will show a dialog if there is an
	 * error
	 */
	public void saveAction() {
		if (!isFilledOut()) {
			JOptionPane.showMessageDialog(this,
					"You need to complete everything before you can save.",
					"Not Done yet!", JOptionPane.PLAIN_MESSAGE);
		} else {
			int n = JOptionPane.showConfirmDialog(this,
					"Are you sure you want to save this question?",
					"Save Question?", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null);
			if (n == 0) {
				saveContent();
				if (isEditing) {
					previousPage.saveEdit();
				} else {
					previousPage.saveEdit(question);
				}
			}
		}
	}

	/**
	 * The action performed when "Delete" is pressed, shows dialog
	 */
	public void deleteAction() {
		int n = JOptionPane.showConfirmDialog(this,
				"Are you sure you want to delete question?",
				"Delete Question?", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null);
		if (n == 0) {
			if (isEditing) {
				previousPage.deleteEdit(question);
			} else {
				previousPage.endEdit();
			}
		}
	}

	/**
	 * Adds specific components to the grid bag layout after each interface
	 * update
	 */
	protected abstract void drawSpecific();

	protected abstract void saveSpecificContent();

	public abstract void numberOfAnswersAction();

	public abstract boolean isSpecificFilledOut();

	protected abstract void createSpecific();

	protected abstract void setSpecific();

}
