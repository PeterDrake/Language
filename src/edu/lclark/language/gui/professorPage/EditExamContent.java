package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import edu.lclark.language.questions.*;

/**
 * The content panel for editing test questions from the professor page
 */
public class EditExamContent extends AbstractContent {

	private MultipleChoiceQuestion[] exampleQuestionsArray;
	private JTree tree;
	private JComboBox addNewQuestionButton;
	private JSplitPane splitPane;
	private JScrollPane viewEditScrollPane;
	private JPanel viewEditPanel;

	public EditExamContent() {
		exampleQuestionsArray = createExampleQuestions();

		setLayout(new BorderLayout());

		String[] questionTypes = { "Add New Question", "Multiple Choice",
				"Fill in the blank" };

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPanel.setBackground(Color.WHITE);

		addNewQuestionButton = new JComboBox(questionTypes);
		addNewQuestionButton.addActionListener(new AddNewQuestionAction());

		// JButton editQuestionButton = new JButton("Edit Question");
		// editQuestionButton.addActionListener(new EditQuestionAction());

		// TODO need to change to level order instead of question type
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode multipleChoice = new DefaultMutableTreeNode(
				"Multiple Choice");
		DefaultMutableTreeNode exampleQuestions = new DefaultMutableTreeNode(
				"Example Questions");

		root.add(multipleChoice);
		multipleChoice.add(exampleQuestions);

		for (int i = 0; i < exampleQuestionsArray.length; i++) {
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
			temp.setUserObject(exampleQuestionsArray[i]);
			exampleQuestions.add(temp);
		}

		tree = new JTree(root);

		ImageIcon questionIcon = new ImageIcon(
				ClassLoader
						.getSystemResource("edu/lclark/language/resources/question-mark.jpg"));
		// ImageIcon questionIcon = new
		// ImageIcon(EditExamContent.class.getResource("/edu/lclark/language/resources/question-mark.jpg"));
		Image resizedQuestionImage = questionIcon.getImage().getScaledInstance(
				16, 16, Image.SCALE_DEFAULT);
		questionIcon = new ImageIcon(resizedQuestionImage);

		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(questionIcon);

		tree.setCellRenderer(renderer);
		tree.addTreeSelectionListener(new SelectionListener());
		tree.setShowsRootHandles(true);
		tree.setRootVisible(false);

		JScrollPane treePane = new JScrollPane(tree);
		treePane.getVerticalScrollBar().setUnitIncrement(16);

		viewEditPanel = new JPanel();

		viewEditScrollPane = new JScrollPane(viewEditPanel);

		buttonPanel.add(addNewQuestionButton);
		// buttonPanel.add(editQuestionButton);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(treePane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setResizeWeight(0.5);

		add(buttonPanel, BorderLayout.NORTH);
		add(splitPane, BorderLayout.CENTER);
	}

	public MultipleChoiceQuestion[] createExampleQuestions() {
		MultipleChoiceQuestion[] qs = new MultipleChoiceQuestion[4];
		qs[0] = new MultipleChoiceQuestion();
		qs[0].setText("What is your name?");
		qs[0].setAnswers(new String[] { "Andi", "Srey", "Maggie" });
		qs[0].setCorrectAnswers(new String[] {"Maggie"});
		qs[1] = new MultipleChoiceQuestion();
		qs[1].setText("What is your favorite color?");
		qs[1].setAnswers(new String[] { "Blue", "Yellow", "Green", "Red" });
		qs[1].setCorrectAnswers(new String[] {"Red"});
		qs[2] = new MultipleChoiceQuestion();
		qs[2].setText("What is your quest?");
		qs[2].setAnswers(new String[] { "Grail", "Food" });
		qs[2].setCorrectAnswers(new String[] {"Food"});
		qs[3] = new MultipleChoiceQuestion();
		qs[3].setText("What is the avg speed of a swallow?");
		qs[3].setAnswers(new String[] { "45", "57", "20" });
		qs[3].setCorrectAnswers(new String[] {"20"});
		return qs;
	}

	private class AddNewQuestionAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (addNewQuestionButton.getSelectedIndex()) {
			case 0:
				if (splitPane.getRightComponent() != null) {
					splitPane.remove(splitPane.getRightComponent());
				}
				break;
			case 1:
				viewEditPanel = new MultipleChoiceViewEditPanel();
				viewEditScrollPane.setViewportView(viewEditPanel);
				splitPane.setRightComponent(viewEditScrollPane);
				break;
			case 2:
				viewEditPanel = new FillInTheBlankViewEditPanel();
				viewEditScrollPane.setViewportView(viewEditPanel);
				splitPane.setRightComponent(viewEditScrollPane);
				break;
			default:
				break;
			}
		}
	}

	private class SelectionListener implements TreeSelectionListener {

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
					.getLastSelectedPathComponent();
			if (selectedNode != null && selectedNode.isLeaf()) {
				// System.out.println(selectedNode.getUserObject());
				// TODO selection on tree when node is closed results in errors
			}
		}
	}
}
