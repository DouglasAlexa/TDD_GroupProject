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
        if (question == null || answers == null || correctAnswer == null) {
            throw new NullPointerException("Inputs can not be null");
        }
        else if (existing.isPresent()) {
            throw new AlreadyExistsException();
        }
        Questions newQuestion = new Questions(id, question, answers, correctAnswer);
        repo.add(newQuestion);
        return newQuestion;
    }
    public  Questions getQuestion(Integer id) throws DoesNotExistException {
        if (repo.getQuestion(id) == null) {
            throw new  DoesNotExistException("Question does not exist");
        }
        return repo.getQuestion(id);
    }
    public Questions delete(Integer id) throws DoesNotExistException {
        if (repo.getQuestion(id) == null) {
            throw new  DoesNotExistException("Question does not exist");
        }
        Questions removed = repo.getQuestion(id);
        repo.delete(id);
        return removed;
    }
}


