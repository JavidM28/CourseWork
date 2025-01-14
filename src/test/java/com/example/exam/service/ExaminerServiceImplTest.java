package com.example.exam.service;

import com.example.exam.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExaminerServiceImplTest {
    private JavaQuestionService javaQuestionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        javaQuestionService = mock(JavaQuestionService.class);
        examinerService = new ExaminerServiceImpl(javaQuestionService);
    }

    @Test
    void getQuestions() {
        when(javaQuestionService.findAll()).thenReturn(List.of(
                new Question("What is Java?", "A programming language"),
                new Question("What is OOP?", "Object-Oriented Programming")
        ));
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(new Question("What is Java?", "A programming language"));

        Set<Question> questions = examinerService.getQuestions(1);

        assertEquals(1, questions.size());
        verify(javaQuestionService, times(1)).getRandomQuestion();
    }

    @Test
    void getQuestionsThrowsException() {
        when(javaQuestionService.findAll()).thenReturn(List.of());

        assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(10));
    }
}
