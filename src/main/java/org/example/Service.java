package org.example;

import org.example.exceptions.AlreadyExistsException;
import org.example.exceptions.DoesNotExistException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Service  {

    private QuestionRepo repo;

    public Service(QuestionRepo repo) {
        this.repo = repo;
    }

    public Questions addQuestion(int id, String question, String[] answers, String correctAnswer) throws DoesNotExistException, AlreadyExistsException {
        Optional<Questions> existing = Optional.ofNullable(repo.getQuestion(id));
        if (existing.isPresent()) {
            throw new AlreadyExistsException();
        }
        Questions newQuestion = new Questions(id, question, answers, correctAnswer);
        repo.add(newQuestion);
        return newQuestion;
    }
}


