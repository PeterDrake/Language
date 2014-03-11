package testPage;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.lclark.language.gui.AbstractUserPage;
import edu.lclark.language.gui.GBC;
import edu.lclark.language.gui.MainWindow;
import edu.lclark.language.questions.MultipleChoiceQuestion;
import edu.lclark.language.questions.MultipleChoiceQuestionInterface;

public class TestPage extends AbstractUserPage{

	private JButton submitButton;
	
	public TestPage(MainWindow main) {
		super(main);
		
		
		submitButton = new JButton("Submit");
		JPanel testPagePanel = new JPanel();
		JPanel test1 = new MultipleChoiceQuestionInterface(null, "name");
		GridBagLayout layout = new GridBagLayout(); 
		testPagePanel.setLayout(layout);
		testPagePanel.setBackground(Color.WHITE);
		testPagePanel.setSize(1500, 1500);
		testPagePanel.add(submitButton,new GBC(750, 1500).setAnchor(GBC.SOUTH));
		
		title.setText("Language Placement Test");
		testPagePanel.add(test1);
		//testPagePanel.add(new MultipleChoiceQuestion(null, "name"));
		add(testPagePanel);
		setVisible(true);
	}


}
