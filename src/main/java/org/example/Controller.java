package org.example;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.example.exceptions.AlreadyExistsException;
import org.example.exceptions.DoesNotExistException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

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
            int id = questions.getId();
            String question = questions.getQuestion();
            String[] answers = questions.getAnswer();
            String correctAnswer = questions.getCorrectAnswer();
            Questions createdQuestion = service.addQuestion(id, question, answers, correctAnswer);
            String jsonString = gson.toJson(createdQuestion);
            context.status(HttpStatus.CREATED);
            context.json(jsonString);
        }
    }

    public void delete(Context context) throws DoesNotExistException {
        Integer id = Integer.valueOf(context.pathParam("id"));
        Questions questions = service.getQuestion(id);
        if(questions != null){
            context.status(HttpStatus.OK);
            service.delete(id);
            context.result("Question with id: " + id + " was removed");
        }
        else {
            context.status(HttpStatus.NOT_FOUND);
            context.result("Can't find question with id: " + id);
            System.out.println("Can't find question with id: " + id);
        }
    }

    public void getQuestion(Context context) throws DoesNotExistException {
        Integer id = Integer.valueOf(context.pathParam("id"));
        Questions questions = service.getQuestion(id);
        if(questions != null){
            String jsonString = gson.toJson(service.getQuestion(id));
            context.status(HttpStatus.OK);
            context.result(jsonString);
            System.out.println(jsonString);
        }
        else {
            context.status(HttpStatus.NOT_FOUND);
            context.result("Can't find question with id: " + id);
            System.out.println("Can't find question with id: " + id);
        }
    }

    public void getAllQuestions(Context context){
        Collection<Questions> questions = service.getAllQuestions();
        String jsonString = gson.toJson(questions);
        context.status(HttpStatus.OK);
        context.json(questions);
        System.out.println(jsonString);
    }
}
