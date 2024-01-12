package com.quiz.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entity.Quiz;
import com.quiz.repository.Quizrepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private Quizrepository quizRepo;
	private QuestionClient questionClient;
	
	

	public QuizServiceImpl(Quizrepository quizRepo, QuestionClient questionClient) {
		this.quizRepo = quizRepo;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		
		return quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> getAll() {
		List<Quiz> quizzes=quizRepo.findAll();
		List<Quiz> newListQuiz=quizzes.stream().map(quiz ->{quiz.setQuestion(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
		}).collect(Collectors.toList());
		
		
		return newListQuiz;
	}

	@Override
	public Quiz getById(Long id) {
		Quiz quiz=quizRepo.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
		quiz.setQuestion(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
		}

}
