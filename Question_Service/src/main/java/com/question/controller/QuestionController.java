package com.question.controller;

import java.util.List;		

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/question")
public class QuestionController {

	private QuestionService questionServ;

	public QuestionController(QuestionService questionServ) {
		this.questionServ = questionServ;
	}
	
	@PostMapping()
	public Question addAll(@RequestBody Question question) {
		return questionServ.add(question);
	}
	
	@GetMapping
	public List<Question> getAll() {
		return questionServ.getAll();
	}
	
	@GetMapping("/{questionId}")
	public Question getOneData(@PathVariable long questionId) {
		return questionServ.getByID(questionId);
	}
	
	@GetMapping("/quiz/{quizId}")
	
	public List<Question> getAllByQuiz(@PathVariable Long quizId){
		return questionServ.getQuestionsByQuiz(quizId);
	}

}
