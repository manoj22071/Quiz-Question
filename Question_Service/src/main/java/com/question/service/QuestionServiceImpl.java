package com.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepository quesRepo;
	

	public QuestionServiceImpl(QuestionRepository quesRepo) {
		this.quesRepo = quesRepo;
	}

	@Override
	public Question add(Question question) {
		return quesRepo.save(question);
	}

	@Override
	public List<Question> getAll() {
		return  quesRepo.findAll();
	}

	@Override
	public Question getByID(Long Id) {
		
		return quesRepo.findById(Id).orElseThrow(()-> new RuntimeException("Question not found"));
	}

	@Override
	public List<Question> getQuestionsByQuiz(Long quiz) {
		
		return quesRepo.findByQuizId(quiz);
	}

}
