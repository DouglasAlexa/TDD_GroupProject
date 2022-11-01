package org.example;

import java.util.HashMap;
import java.util.Map;

public class Service  {

    private QuestionRepo repo;

    public Service(QuestionRepo repo) {
        this.repo = repo;
    }

    public Questions addQuestion(int id, String question, String[] answers, String correctAnswer) {
        Questions newQuestion = new Questions(id, question, answers, correctAnswer);
        repo.add(newQuestion);
        return newQuestion;
    }
}


