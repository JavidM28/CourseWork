package com.example.exam.service;

import com.example.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public Question addQuestion(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        Question q = new Question(question, answer);
        if (questions.remove(q)) {
            return q;
        }
        throw new IllegalArgumentException("Question not found");
    }

    @Override
    public Collection<Question> findAll() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException("No questions available");
        }
        return questions.get(random.nextInt(questions.size()));
    }
}
