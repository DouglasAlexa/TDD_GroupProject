package org.example;

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
    public String delete(Integer id) {
        return null;
    }

    @Override
    public Questions getQuestion(Integer id) {
        return null;
    }

    @Override
    public Collection<Questions> getAllQuestions() {
        return null;
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
