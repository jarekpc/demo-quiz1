package com.example.demoquiz1.repo;

import com.example.demoquiz1.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
