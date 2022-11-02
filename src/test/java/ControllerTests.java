import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.example.Controller;
import org.example.Questions;
import org.example.Service;
import org.example.exceptions.AlreadyExistsException;
import org.example.exceptions.DoesNotExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ControllerTests {

    Context context;
    Service service;
    Controller controller;
    Gson gson;

    @BeforeEach
    void setup() {
        gson = new Gson();
        context = Mockito.mock(Context.class);
        service = Mockito.mock(Service.class);
        controller = new Controller(service);
    }

    @Test
    @DisplayName("Controller should create question without fail")
    void controllerAddQuestionDoesNotThrow() throws DoesNotExistException, AlreadyExistsException {
        //Given
        Questions question = new Questions(5, "What is love?", new String[]{"Baby", "Dont", "Hurt"}, "Me");
        String output = gson.toJson(question);
        String json = "{\"id\":5,\"question\":\"What is love?\",\"answer\":[\"Baby\",\"Dont\",\"Hurt\"],\"correctAnswer\":\"Me\"}";
        //When
        Mockito.when(context.body()).thenReturn(json);
        Mockito.when(service.addQuestion(question.getId(), question.getQuestion(), question.getAnswer(), question.getCorrectAnswer())).thenReturn(question);
        controller.add(context);
        //Then
        Mockito.verify(context).status(HttpStatus.CREATED);
        Mockito.verify(context).json(output);
    }

    @Test
    @DisplayName("Controller should return Bad Request if invalid data")
    void ifRequestDataNull() throws DoesNotExistException, AlreadyExistsException {
        //Given
        //When
        Mockito.when(context.body()).thenReturn(null);
        controller.add(context);
        //Then
        Mockito.verify(context).status(HttpStatus.BAD_REQUEST);
        Mockito.verify(context).result("Bad Request");
    }

}
