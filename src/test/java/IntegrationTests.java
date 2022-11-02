import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.example.*;
import org.example.exceptions.AlreadyExistsException;
import org.example.exceptions.DoesNotExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IntegrationTests {

    Context context;
    QuestionRepo repo;
    Service service;
    Controller controller;
    Gson gson;

    @BeforeEach
    void setup() {
        context = Mockito.mock(Context.class);
        repo = new InMemory();
        service = new Service(repo);
        controller = new Controller(service);
        gson = new Gson();
    }

    @Test
    @DisplayName("Add question integration test successfull")
    void addQuestionIntegrationTest() throws DoesNotExistException, AlreadyExistsException {
        //Given
        Questions question = new Questions(5, "What is love?", new String[]{"Baby", "Dont", "Hurt"}, "Me");
        String output = gson.toJson(question);
        String json = "{\"id\":5,\"question\":\"What is love?\",\"answer\":[\"Baby\",\"Dont\",\"Hurt\"],\"correctAnswer\":\"Me\"}";
        //When
        Mockito.when(context.body()).thenReturn(json);
        controller.add(context);
        //Then
        Mockito.verify(context).status(HttpStatus.CREATED);
        Mockito.verify(context).json(output);
        /*Assertions.assertEquals(context.json(), output);*/
    }
}
