package edu.lclark.language.gui.professorPage;

import edu.lclark.language.gui.GBC;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.QuestionInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

/**
 * The Panel that handles entering and editing multiple choice questions
 */
public class MultipleChoiceViewEditPanel extends JPanel {

    public static final int MAX_ANSWERS = 6;
    public static final int GBL_QUESTION_INDEX_START = 3;

    private EditExamContent previousPage;
    private MultipleChoiceQuestion question;

    private int correctAnswerIndex;
    private int numberOfAnswers;
    private int levelIndex;

    private JComboBox numberOfAnswersDropDown;
    private JComboBox correctAnswerDropDown;
    private JComboBox levelDropDown;
    private JTextArea[] answerFields;
    private JLabel[] answerLabels;
    private JLabel title;

    private JLabel questionLabel;
    private JTextArea questionField;
    private JLabel chooseNumber;
    private JLabel chooseCorrect;
    private JLabel levelType;
    private JButton saveChangesButton;
    private JButton deleteQuestionButton;


    public MultipleChoiceViewEditPanel(EditExamContent previousPage) {
        this.previousPage = previousPage;
        question = new MultipleChoiceQuestion();
        numberOfAnswers = 4;
        correctAnswerIndex = 0;
        levelIndex = 0;

        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        title = new JLabel();
        title.setText("Multiple Choice Question");

        questionLabel = new JLabel();
        questionLabel.setText("Question: ");

        questionField = new JTextArea(5, 50);
        questionField.setLineWrap(true);
        questionField.setWrapStyleWord(true);
        questionField.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));

        chooseNumber = new JLabel();
        chooseNumber.setText("Number of Answers: ");

        chooseCorrect = new JLabel();
        chooseCorrect.setText("Correct Answer: ");

        levelType = new JLabel();
        levelType.setText("Choose Level: ");

        String[] numOfAnswers = {"2", "3", "4", "5", "6"};
        numberOfAnswersDropDown = new JComboBox(numOfAnswers);
        numberOfAnswersDropDown.setSelectedItem("" + numberOfAnswers);
        numberOfAnswersDropDown.addActionListener(EventHandler.create(
                ActionListener.class, this, "numberOfAnswersAction"));

        setCorrectAnswerDropDown();

        String[] levelArray = {"101", "102", "201", "202", "301"};
        levelDropDown = new JComboBox(levelArray);
        levelDropDown.setSelectedIndex(levelIndex);
        levelDropDown.addActionListener(EventHandler.create(
                ActionListener.class, this, "levelAction"));

        createAnswerFields();

        saveChangesButton = new JButton();
        saveChangesButton.setText("Save Changes");
        saveChangesButton.addActionListener(EventHandler.create(
                ActionListener.class, this, "saveAction"));

        deleteQuestionButton = new JButton();
        deleteQuestionButton.setText("Delete Question");
        deleteQuestionButton.addActionListener(EventHandler.create(
                ActionListener.class, this, "deleteAction"));

        drawAll();
    }

    /**
     * Adds all components to the grid bag layout after each interface update
     */
    private void drawAll() {

        add(title, new GBC(0, 0, 3, 1).setIpad(25,25));
        add(questionLabel, new GBC(0, 1).setAnchor(GBC.EAST));

        JScrollPane questionPane = new JScrollPane(questionField);
        questionPane.setBorder(BorderFactory.createLineBorder(Color.black));
        add(questionPane, new GBC(1, 1, 2, 1));

        add(chooseNumber, new GBC(0, 2).setAnchor(GBC.EAST));
        add(chooseCorrect, new GBC(0, 9).setAnchor(GBC.EAST));
        add(levelType, new GBC(0, 10).setAnchor(GBC.EAST));
        add(numberOfAnswersDropDown, new GBC(1, 2));

        setCorrectAnswerDropDown();
        add(correctAnswerDropDown, new GBC(1, 9));

        add(levelDropDown, new GBC(1, 10));

        showAnswerFields(numberOfAnswers);

        add(saveChangesButton, new GBC(2, 11).setAnchor(GBC.CENTER));
        add(deleteQuestionButton, new GBC(2, 11).setAnchor(GBC.WEST));

        revalidate();
        repaint();
    }

    /**
     * Creates the correct number of answer fields based on MAX_ANSWERS
     */
    public void createAnswerFields() {
        answerFields = new JTextArea[MAX_ANSWERS];
        answerLabels = new JLabel[MAX_ANSWERS];

        for (int i = 0; i < MAX_ANSWERS; i++) {
            answerLabels[i] = new JLabel();
            answerLabels[i].setText("Answer " + (i + 1) + ":");

            answerFields[i] = new JTextArea(2, 50);
            answerFields[i].setLineWrap(true);
            answerFields[i].setWrapStyleWord(true);
            answerFields[i].setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        }
    }

    /**
     * Shows the correct number of answer fields after each interface update
     *
     * @param n number of fields to show
     */
    public void showAnswerFields(int n) {
        if (n > MAX_ANSWERS) {
            n = MAX_ANSWERS;
        }
        for (int i = 0, j = GBL_QUESTION_INDEX_START; i < n; i++, j++) {
            if (i == correctAnswerIndex) {
                answerFields[i].setBackground(Color.GREEN);
            } else {
                answerFields[i].setBackground(Color.WHITE);
            }

            JScrollPane sp = new JScrollPane(answerFields[i]);
            sp.setBorder(BorderFactory.createLineBorder(Color.black));

            add(answerLabels[i], new GBC(0, j).setAnchor(GBC.EAST));
            add(sp, new GBC(1, j, 2, 1));
        }
    }

    /**
     * Creates a new correctAnswerDropDown based on how many answer fields are shown
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
     * Updates the panel after changing the number of answers or correct answer
     */
    private void updatePage() {
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

        return true;
    }

    /**
     * Saves the entered information in a new MultipleChoiceQuestion object, ready to be saved to the master list.
     */
    private void saveContent() {
        question.setText(questionField.getText());
        question.setCorrectAnswers(new String[]{answerFields[correctAnswerIndex].getText()});

        String[] temp = new String[answerFields.length];
        for (int i = 0; i < answerFields.length; i++) {
            temp[i] = answerFields[i].getText();
        }
        question.setAnswers(temp);

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
    }

    /**
     * The action performed when changing the numberOfAnswersDropDown, changes number of shown answer fields
     */
    public void numberOfAnswersAction() {
        int n = numberOfAnswersDropDown.getSelectedIndex() + 2;
        numberOfAnswers = n;
        if (correctAnswerIndex > n - 1) {
            correctAnswerIndex = n - 1;
        }
        updatePage();
    }

    /**
     * The action performed when correctAnswerDropDown is changed, highlights the correct answer field
     */
    public void highlightCorrectAction() {
        correctAnswerIndex = correctAnswerDropDown.getSelectedIndex();
        updatePage();
    }

    /**
     * Changes the level when levelDropDown is changed
     */
    public void levelAction() {
        levelIndex = levelDropDown.getSelectedIndex();
    }

    /**
     * The action performed when "Save" is pressed, checks if everything is filled out and saves the entered info.
     * Will show a dialog if there is an error
     */
    public void saveAction() {
        if (!isFilledOut()) {
            JOptionPane.showMessageDialog(this,
                    "You need to fill out all fields before you can save.", "Not Done yet!", JOptionPane.PLAIN_MESSAGE);
        } else {
            int n = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to save this question?",
                    "Save Question?", JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null);
            if (n == 0) {
                saveContent();
                previousPage.saveEdit(question);
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
            // TODO isNewQuestion is set to true if a question object is passed as well
//            if (isNewQuestion) {
            previousPage.endEdit();
//            } else {
//                previousPage.deleteEdit(question);
//            }
        }
    }

}
