package com.example.demoquiz1.controller;

import com.example.demoquiz1.model.Answer;
import com.example.demoquiz1.repo.AnswerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class HomeController {

    private final AnswerRepository answerRepository;

    public HomeController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/search/{username}")
    public List<Answer> search(@PathVariable(name = "username") String username) {
        log.info("Search " + username);
        Instant start = Instant.now();
        List<Answer> answerList = answerRepository.findAllByUser_lastName(username);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("diffirent between run method " + timeElapsed + " miliseconds");
        return answerList;
    }
}
