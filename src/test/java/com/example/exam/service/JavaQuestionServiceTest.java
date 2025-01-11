package com.example.exam.service;

import com.example.exam.model.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService service = new JavaQuestionService();

    @Test
    void addQuestion() {
        Question q = service.addQuestion("What is Java?", "A programming language");
        assertTrue(service.findAll().contains(q));
    }

    @Test
    void removeQuestion() {
        Question q = service.addQuestion("What is Java?", "A programming language");
        service.removeQuestion("What is Java?", "A programming language");
        assertFalse(service.findAll().contains(q));
    }

    @Test
    void getRandomQuestion() {
        service.addQuestion("What is Java?", "A programming language");
        assertNotNull(service.getRandomQuestion());
    }
}
