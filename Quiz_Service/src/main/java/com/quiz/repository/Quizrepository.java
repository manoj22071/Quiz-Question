package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.Quiz;

public interface Quizrepository extends JpaRepository<Quiz, Long>{

}
