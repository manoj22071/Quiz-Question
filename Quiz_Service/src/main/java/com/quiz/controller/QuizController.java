package com.quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entity.Quiz;
import com.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	private QuizService quizServ;

	public QuizController(QuizService quizServ) {
		
		this.quizServ = quizServ;
	}
	
	@PostMapping()
	public Quiz create(@RequestBody Quiz quiz) {
		return quizServ.add(quiz);
		
	}
	@GetMapping
	public List<Quiz> getAll(){
		return quizServ.getAll();
	}
	@GetMapping("/{id}")
	public Quiz getById(@PathVariable Long id){
		return quizServ.getById(id);
	}
}
