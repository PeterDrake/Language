package edu.lclark.language.questions;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.*;

import edu.lclark.language.gui.GBC;
import edu.lclark.language.questions.QuestionInfo.QuestionType;

import java.awt.*;


public class MultipleChoiceQuestion extends AbstractQuestion {
	
	public MultipleChoiceQuestion() {
		setQuestionType(QuestionType.MULTIPLE_CHOICE);
	}

	@Override
	public boolean isCorrectAnswer() {
		return true;
	}

}
