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
        gson = new Gson().newBuilder().setPrettyPrinting().create();
        context = Mockito.mock(Context.class);
        service = Mockito.mock(Service.class);
        controller = new Controller(service);
    }

    @Test
    @DisplayName("Service should create question without fail")
    void serviceAddQuestionDoesNotThrow() throws DoesNotExistException, AlreadyExistsException {
        Questions question = new Questions(5, "What is love?", new String[]{"Baby", "Don't", "Hurt"}, "Me");
        String output = gson.toJson(question);
        String json = "{\"id\":\"5\", \"question\":\"What is love?\", \"answer\":[\"Baby\", \"Don't\", \"Hurt\"], \"correctAnswer\":\"Me\"}";
        Mockito.when(context.body()).thenReturn(json);
        controller.add(context);
        Mockito.verify(context).status(HttpStatus.CREATED);
        Mockito.verify(context).json(output);
    }

}
