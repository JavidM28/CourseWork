package com.example.exam.service;

import com.example.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.findAll().size()) {
            throw new IllegalArgumentException("Requested more questions than available");
        }

        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(javaQuestionService.getRandomQuestion());
        }
        return questions;
    }
}
