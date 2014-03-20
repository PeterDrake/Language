package edu.lclark.language.questions;

import edu.lclark.language.questions.QuestionInfo.QuestionType;

public class ShortAnswerQuestion extends AbstractQuestion{
	
	public ShortAnswerQuestion(){
		setQuestionType(QuestionType.SHORT_ANSWER);
	}

	@Override
	public boolean isCorrectAnswer() {
		// TODO Auto-generated method stub
		return false;
	}

}
