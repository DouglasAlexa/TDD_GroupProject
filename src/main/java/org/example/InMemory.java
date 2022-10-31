package org.example;

import org.example.exceptions.DoesNotExistException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemory implements QuestionRepo{

    private Map<Integer,Questions> data = new HashMap<>();

    @Override
    public Optional<Questions> add(Questions questions) {
        if(questions == null){
            throw new NullPointerException("question can not be null");
        }
        data.put(questions.getId(), questions);
        return Optional.ofNullable(questions);
    }

    @Override
    public Questions delete(Integer id) {
        //commit already solve this problem before test
        Questions toRemove = data.get(id);
        data.remove(id);
        return toRemove;
    }

    @Override
    public Questions getQuestion(Integer id) throws DoesNotExistException {
        if (id == null) {
            throw new NullPointerException("Can't get question with ID NULL");
        } else if (!data.containsKey(id)) {
            throw new DoesNotExistException("Question with id " + id + " does not exist.");
        }
        Questions value = data.get(id);
        return value;
    }

    @Override
    public Collection<Questions> getAllQuestions() {
        /* No implementation for empty list is needed */
        return this.data.values();
    }

    @Override
    public String update(Integer id) {
        return null;
    }

    @Override
    public int count() {
        return data.size();
    }
}
