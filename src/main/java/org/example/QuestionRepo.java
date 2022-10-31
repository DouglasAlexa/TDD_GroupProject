package org.example;

import org.example.exceptions.DoesNotExistException;

import java.util.Collection;
import java.util.Optional;

public interface QuestionRepo {

    Optional<Questions> add(Questions questions);
    Questions delete(Integer id) throws DoesNotExistException;
    Questions getQuestion(Integer id) throws DoesNotExistException;
    Collection<Questions> getAllQuestions();
    String update(Integer id);
    int count();


}
