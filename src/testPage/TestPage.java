package testPage;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.MainWindow;
import edu.lclark.language.gui.professorPage.ProfessorPage;
import edu.lclark.language.gui.studentPage.StudentInstructionPage;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestionPanel;
import edu.lclark.language.questions.ShortAnswerQuestionPanel;

public class TestPage extends AbstractUserPage{

	private JButton submitButton;
	private MultipleChoiceQuestionPanel multipleChoiceQuestionPanel;
	private ShortAnswerQuestionPanel shortAnswerQuestionPanel;
	public TestPage(MainWindow main) {
		super(main);
		
		
		submitButton = new JButton("Submit");
		JPanel testPagePanel = new JPanel();
		
		//shortAnswerQuestionPanel = new ShortAnswerQuestion("Donde está su casa?");
		
		
		GridBagLayout layout = new GridBagLayout(); 
		testPagePanel.setLayout(layout);
		testPagePanel.setBackground(Color.WHITE);
		testPagePanel.setSize(1500, 1500);
		testPagePanel.add(submitButton,new GBC(750, 1500).setAnchor(GBC.SOUTH));
		
		title.setText("Language Placement Test");
		testPagePanel.add(multipleChoiceQuestionPanel);
		
		//testPagePanel.add(shortAnswerQuestionPanel);
		
		add(testPagePanel);
		submitButton.addActionListener(new SubmitAction());
		
	}
		private class SubmitAction implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(multipleChoiceQuestionPanel.getPressed());
				//System.out.println(shortAnswerQuestionPanel.getStudentResponse());
				
			}
			
		}
	}
// Add arguments and a second overloaded constructor to take in the type of question, and create the Jpanel for it accordingly

