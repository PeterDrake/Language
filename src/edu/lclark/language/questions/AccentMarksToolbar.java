package edu.lclark.language.questions;

//
//import javax.swing.JButton;
//import javax.swing.JToolBar;
//
//
//public class AccentMarksToolbar extends JToolBar {
//	
//		JButton button;
//
//	public AccentMarksToolbar (){
//		setFloatable(true);
//		button = new JButton();
//		add(button);
//	}
//	
//}

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/*
 * ToolBarDemo.java requires the following addditional files:
 * images/Back24.gif
 * images/Forward24.gif
 * images/Up24.gif
 */

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.net.URL;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccentMarksToolbar extends Component {

	
	public AccentMarksToolbar() {

		// Create the toolbar.
		JToolBar toolBar = new JToolBar("Still draggable");

		// first button
		JButton button = new JButton("hello");
		toolBar.add(button);
		toolBar.setFloatable(true);
	}

//	protected void addButtons(JToolBar toolBar) {
//
//
//	}

	// protected JButton makeNavigationButton(String imageName,
	// String actionCommand, String toolTipText, String altText) {
	//
	// // Create and initialize the button.
	// JButton button = new JButton();
	// button.setActionCommand(actionCommand);
	// button.setToolTipText(toolTipText);
	// button.addActionListener(this);
	//
	// button.setText(altText);
	//
	// return button;
	// }

//	public void actionPerformed(ActionEvent e) {
//		String cmd = e.getActionCommand();
//		String description = null;
//
//		// Handle each button.
//		if (PREVIOUS.equals(cmd)) { // first button clicked
//			description = "taken you to the previous <something>.";
//		} else if (UP.equals(cmd)) { // second button clicked
//			description = "taken you up one level to <something>.";
//		} else if (NEXT.equals(cmd)) { // third button clicked
//			description = "taken you to the next <something>.";
//		}
//
//		displayResult("If this were a real app, it would have " + description);
//	}

//	protected void displayResult(String actionDescription) {
//		textArea.append(actionDescription + newline);
//		textArea.setCaretPosition(textArea.getDocument().getLength());
//	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
//	private static void createAndShowGUI() {
//		// Create and set up the window.
//		JFrame frame = new JFrame("ToolBarDemo");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		// Add content to the window.
//		frame.add(new AccentMarksToolbar());
//
//		// Display the window.
//		frame.pack();
//		frame.setVisible(true);
//	}
//
//	public static void main(String[] args) {
//		// Schedule a job for the event dispatch thread:
//		// creating and showing this application's GUI.
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				// Turn off metal's use of bold fonts
//				UIManager.put("swing.boldMetal", Boolean.FALSE);
//				createAndShowGUI();
//			}
//		});
//	}
}