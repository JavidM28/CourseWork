package com.example.exam.service;

import com.example.exam.model.Question;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExaminerServiceImplTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();
    private final ExaminerServiceImpl examinerService = new ExaminerServiceImpl(javaQuestionService);

    @Test
    void getQuestions() {
        javaQuestionService.addQuestion("What is Java?", "A programming language");
        Set<Question> questions = examinerService.getQuestions(1);
        assertEquals(1, questions.size());
    }

    @Test
    void getQuestionsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(10));
    }
}
