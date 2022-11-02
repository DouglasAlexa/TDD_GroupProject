package org.example;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.example.exceptions.AlreadyExistsException;
import org.example.exceptions.DoesNotExistException;

import java.util.Arrays;

public class Controller {

    private final Service service;
    private final Gson gson = new Gson();

    public Controller(Service service) {
        this.service = service;
    }

    public void add(Context context) throws DoesNotExistException, AlreadyExistsException {
        Questions questions = gson.fromJson(context.body(), Questions.class);
        if (questions == null) {
            context.status(HttpStatus.BAD_REQUEST);
            context.result("Bad Request");
        } else {
            Integer id = questions.getId();
            String question = questions.getQuestion();
            String[] answers = questions.getAnswer();
            String correctAnswer = questions.getCorrectAnswer();
            Questions createdQuestion = service.addQuestion(id, question, answers, correctAnswer);
            String jsonString = gson.toJson(createdQuestion);
            context.status(HttpStatus.CREATED);
            context.json(jsonString);
        }
    }

    public void delete(Context context) {
    }

    public void getQuestion(Context context){}

    public void getAllQuestions(Context context){}
}
