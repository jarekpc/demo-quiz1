package com.example.demoquiz1;

import com.example.demoquiz1.model.Answer;
import com.example.demoquiz1.model.Question;
import com.example.demoquiz1.model.Response;
import com.example.demoquiz1.model.User;
import com.example.demoquiz1.repo.AnswerRepository;
import com.example.demoquiz1.repo.QuestionRepository;
import com.example.demoquiz1.repo.ResponseRepository;
import com.example.demoquiz1.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DemoQuiz1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoQuiz1Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository, QuestionRepository questionRepository, ResponseRepository responseRepository, AnswerRepository answerRepository) {
        return args -> {
            log.info("Save to database");
            userRepository.save(new User(1L, "Jarek", "Zyzak"));
            userRepository.save(new User(2L, "Adam", "Nowak"));

            questionRepository.save(new Question(1L, "Ile jest planet w układzie słonecznym"));
            questionRepository.save(new Question(2L, "Jaka jest liczba ludnosci w Polsce"));
            //
            responseRepository.save(new Response(1L, questionRepository.findById(1L).get(), "8"));
            responseRepository.save(new Response(2L, questionRepository.findById(2L).get(), "40"));
            //
            answerRepository.save(new Answer(1L, userRepository.findById(1L).get(), questionRepository.findById(1L).get(), "7"));
            answerRepository.save(new Answer(2L, userRepository.findById(2L).get(), questionRepository.findById(2L).get(), "50 0000 000"));

        };

    }

}
