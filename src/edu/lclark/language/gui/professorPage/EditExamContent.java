package edu.lclark.language.gui.professorPage;

import edu.lclark.language.LanguagePlacementExam;
import edu.lclark.language.questions.AbstractQuestion;
import edu.lclark.language.questions.FillInTheBlankQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.ProfessorDatabaseInterface;
import edu.lclark.language.questions.QuestionInfo.QuestionLevel;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.ArrayList;

/**
 * The content panel for editing test questions from the professor page
 */
public class EditExamContent extends AbstractContent {


	private static final long serialVersionUID = 1L;
	
	private JTree tree;
    private DefaultTreeModel model;
	private JComboBox<String> addNewQuestionButton;
	private JSplitPane splitPane;
	private JScrollPane viewEditScrollPane;
	private JPanel viewEditPanel;
	
	private ArrayList<AbstractQuestion> level101;
	private ArrayList<AbstractQuestion> level102;
	private ArrayList<AbstractQuestion> level201;
	private ArrayList<AbstractQuestion> level202;
	private ArrayList<AbstractQuestion> level301;
	
	private ProfessorDatabaseInterface database; 
	private DefaultMutableTreeNode root; 
	private DefaultMutableTreeNode tree101;
	private DefaultMutableTreeNode tree102;
	private DefaultMutableTreeNode tree201;
	private DefaultMutableTreeNode tree202;
	private DefaultMutableTreeNode tree301;
	
	public EditExamContent() {
		database = LanguagePlacementExam.questionDatabase;

		setLayout(new BorderLayout());

		String[] questionTypes = { "Add New Question", "Multiple Choice",
				"Fill in the blank" };

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPanel.setBackground(Color.WHITE);

		addNewQuestionButton = new JComboBox<String>(questionTypes);
		addNewQuestionButton.addActionListener(EventHandler.create(
				ActionListener.class, this, "addNewQuestionAction"));

        root = new DefaultMutableTreeNode("Root");

        tree = new JTree(root);
        model = (DefaultTreeModel) tree.getModel();
        ImageIcon questionIcon = new ImageIcon(
				ClassLoader.getSystemResource("edu/lclark/language/resources/question-mark.jpg"));
		Image resizedQuestionImage = questionIcon.getImage().getScaledInstance(
				16, 16, Image.SCALE_DEFAULT);
		questionIcon = new ImageIcon(resizedQuestionImage);
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(questionIcon);
		tree.setCellRenderer(renderer);
		tree.addTreeSelectionListener(EventHandler.create(TreeSelectionListener.class, this, "selectionListener"));
		tree.setShowsRootHandles(true);
		tree.setRootVisible(false);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

        tree101 = new DefaultMutableTreeNode("Level 101");
        tree102 = new DefaultMutableTreeNode("Level 102");
        tree201 = new DefaultMutableTreeNode("Level 201");
        tree202 = new DefaultMutableTreeNode("Level 202");
        tree301 = new DefaultMutableTreeNode("Level 301");
        root.add(tree101);
        root.add(tree102);
        root.add(tree201);
        root.add(tree202);
        root.add(tree301);
        updateNodesFromDatabase();

		JScrollPane treePane = new JScrollPane(tree);
		treePane.getVerticalScrollBar().setUnitIncrement(16);

		viewEditPanel = new JPanel();

		viewEditScrollPane = new JScrollPane(viewEditPanel);

		buttonPanel.add(addNewQuestionButton);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(treePane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setResizeWeight(0.5);

		add(buttonPanel, BorderLayout.NORTH);
		add(splitPane, BorderLayout.CENTER);
	}

    /**
     * The method that adds all nodes to the tree from the fetched database, removing old nodes first
     */
	private void updateNodesFromDatabase() {
        level101 = database.getQuestionsOfLevel(QuestionLevel.LEVEL_101);
        level102 = database.getQuestionsOfLevel(QuestionLevel.LEVEL_102);
        level201 = database.getQuestionsOfLevel(QuestionLevel.LEVEL_201);
        level202 = database.getQuestionsOfLevel(QuestionLevel.LEVEL_202);
        level301 = database.getQuestionsOfLevel(QuestionLevel.LEVEL_301);

		tree101.removeAllChildren();
        tree102.removeAllChildren();
        tree201.removeAllChildren();
        tree202.removeAllChildren();
        tree301.removeAllChildren();

        for(AbstractQuestion q : level101){
            DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
            temp.setUserObject(q);
            tree101.add(temp);
        }
        for(AbstractQuestion q : level102){
            DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
            temp.setUserObject(q);
            tree102.add(temp);
        }
        for(AbstractQuestion q : level201){
            DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
            temp.setUserObject(q);
            tree201.add(temp);
        }
        for(AbstractQuestion q : level202){
            DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
            temp.setUserObject(q);
            tree202.add(temp);
        }
        for(AbstractQuestion q : level301){
            DefaultMutableTreeNode temp = new DefaultMutableTreeNode();
            temp.setUserObject(q);
            tree301.add(temp);
        }

        model.reload(root);
        //Might we use model.isertNodeInto() (or remove) down bellow or reload with ifs? Would we need compareTo?
    }

    /**
     * The method called by the question enter/edit panel when it is done and wants to save.
     *
     * @param q the question to be saved
     */
    public void saveEdit(AbstractQuestion q) {
        database.addQuestion(q);
        updateNodesFromDatabase();
        endEdit();
    }
    
    public void saveEdit() {
        database.updateQuestions();
        updateNodesFromDatabase();
        endEdit();
    }

    /**
     * The method called by the question enter/edit panel when it is done and wants to delete.
     *
     * @param q the question to be deleted
     */
    public void deleteEdit(AbstractQuestion q) {
        database.deleteQuestion(q);
        updateNodesFromDatabase();
        endEdit();
    }

    /**
     * The method called by the question enter/edit panel when it is done and has nothing to save or delete.
     */
    public void endEdit() {
        addNewQuestionButton.setSelectedIndex(0);
        addNewQuestionAction();
    }

    /**
     * The action listener that creates a new question editing panel based on the index of the JComboBox
     */
	public void addNewQuestionAction() {
		switch (addNewQuestionButton.getSelectedIndex()) {
		case 0:
			if (splitPane.getRightComponent() != null) {
				// TODO If text is entered, prompt for save
				splitPane.remove(splitPane.getRightComponent());
			}
			break;
		case 1:
			viewEditPanel = new MultipleChoiceViewEditPanel(this);
			viewEditScrollPane.setViewportView(viewEditPanel);
			splitPane.setRightComponent(viewEditScrollPane);
			break;
		case 2:
			viewEditPanel = new FillInTheBlankViewEditPanel(this);
			viewEditScrollPane.setViewportView(viewEditPanel);
			splitPane.setRightComponent(viewEditScrollPane);
			break;
		default:
			break;
		}
	}

    /**
     * The action listener for the tree that handles selections
     */
	public void selectionListener() {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();
		if (selectedNode != null && selectedNode.isLeaf()) {
			if(selectedNode.getUserObject() instanceof FillInTheBlankQuestion){
				viewEditPanel = new FillInTheBlankViewEditPanel(this, (FillInTheBlankQuestion)selectedNode.getUserObject());
				viewEditScrollPane.setViewportView(viewEditPanel);
				splitPane.setRightComponent(viewEditScrollPane);
			}
			if(selectedNode.getUserObject() instanceof MultipleChoiceQuestion){
				viewEditPanel = new MultipleChoiceViewEditPanel(this, (MultipleChoiceQuestion)selectedNode.getUserObject());
				viewEditScrollPane.setViewportView(viewEditPanel);
				splitPane.setRightComponent(viewEditScrollPane);
			}
		}
	}
}
