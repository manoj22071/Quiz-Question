package com.question.service;

import java.util.List;

import com.question.entities.Question;

public interface QuestionService {
	Question add(Question question);
	
	List<Question> getAll();
	
	 Question getByID(Long Id);
	 
	 List<Question> getQuestionsByQuiz(Long quiz);	

}
