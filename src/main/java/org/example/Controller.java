package org.example;

import com.google.gson.Gson;
import io.javalin.http.Context;

public class Controller {

    private final Service service;
    private final Gson gson = new Gson().newBuilder().setPrettyPrinting().create();

    public Controller(Service service) {
        this.service = service;
    }
    public void add(Context context){
    }

    public void delete(Context context) {
    }

    public void getQuestion(Context context){}

    public void getAllQuestions(Context context){}
}
