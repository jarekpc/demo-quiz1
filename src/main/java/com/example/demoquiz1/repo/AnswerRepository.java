package com.example.demoquiz1.repo;

import com.example.demoquiz1.model.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    //find By lastName
    List<Answer> findAllByUser_lastName(String username);

}
