package org.example;

import io.javalin.http.Context;

public class Controller {

    private final QuestionRepo repo;

    public Controller(QuestionRepo repo) {
        this.repo = repo;
    }

    public String add(Context context){
        return null;
    }
}
