package edu.lclark.language.gui.professorPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import edu.lclark.language.questions.*;



/**
 * The content panel for editing test questions from the professor page
 */
public class EditExamContent extends AbstractContent{
	
	private MultipleChoiceQuestion[] exampleQuestions;
	
	public EditExamContent(){
		
//		JLabel message = new JLabel("This will be a page for editing test questions.");
//		add(message);
		
		exampleQuestions = createExampleQuestions();

		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.setBackground(Color.WHITE);
		
		JScrollPane sPane = new JScrollPane(content);
        sPane.getVerticalScrollBar().setUnitIncrement(16);
        add(sPane, BorderLayout.CENTER);
        
        JButton addNewQuestionButton = new JButton("Add New Question");
		addNewQuestionButton.addActionListener(new AddNewQuestionAction());
        
      //create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        //create the child nodes
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Vegetables");
        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Fruits");
 
        //add the child nodes to the root node
        root.add(vegetableNode);
        root.add(fruitNode);
         
        //create the tree by passing in the root node
        JTree tree = new JTree(root);
        sPane.add(tree);
        
		content.add(addNewQuestionButton, BorderLayout.NORTH);
		content.add(sPane, BorderLayout.CENTER);
	}
	
	public MultipleChoiceQuestion[] createExampleQuestions(){
		MultipleChoiceQuestion[] qs = new MultipleChoiceQuestion[4];
		qs[0] = new MultipleChoiceQuestion("What is your name?", new String[] {"Andi", "Srey", "Maggie"}, 2);
		qs[1] = new MultipleChoiceQuestion("What is your favorite color?", new String[] {"Blue", "Yellow", "Green", "Red"}, 0);
		qs[2] = new MultipleChoiceQuestion("What is your quest?", new String[] {"Grail", "Food"}, 1);
		qs[3] = new MultipleChoiceQuestion("What is the avg speed of swallow?", new String[] {"45", "57", "20"}, 1);
		return qs;
	}
	
	private class AddNewQuestionAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			
		}
	}
}
