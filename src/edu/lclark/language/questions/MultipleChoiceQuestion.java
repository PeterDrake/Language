package edu.lclark.language.questions;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.*;

import edu.lclark.language.gui.GBC;

import java.awt.*;


public class MultipleChoiceQuestion extends AbstractQuestion {

	private static final int NUMBER_OF_ANSWERS = 4;
	private String[] answers;
	private String question;
	private int correctAnswerIndex;
	

	public MultipleChoiceQuestion(String question, String[] answers, int correctAnswerIndex)
	{
//		answers = new String[NUMBER_OF_ANSWERS];
		this.answers = answers;
		this.question = question;
		this.correctAnswerIndex = correctAnswerIndex;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}

	public void setCorrectAnswerIndex(int correctAnswerIndex) {
		this.correctAnswerIndex = correctAnswerIndex;
	}
	
	@Override
	public String toString(){
		return question;
	}

}
