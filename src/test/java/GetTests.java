import org.example.InMemory;
import org.example.QuestionRepo;
import org.example.Questions;
import org.example.exceptions.DoesNotExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetTests {

    QuestionRepo repo;

    @BeforeEach
    void setup() {
        repo = new InMemory();
    }

    @Test
    @DisplayName("Get specific question by ID")
    void getQuestion() throws DoesNotExistException {
        Questions question = new Questions(1, "What is life?", new String[] {"Coffee", "Coding", "Pizza"}, "Studiegrupp 7" );

        repo.add(question);

        Assertions.assertEquals(question, repo.getQuestion(question.getId()));
    }

   /* @Test
    @DisplayName("Get specific question don't exist")
    void getSpecificQuestionDontExist(){
        Questions question = new Questions(1, "What is life?", new String[] {"Coffee", "Coding", "Pizza"}, "Studiegrupp 7" );

        repo.add(question);

        Assertions.assertThrows(DoesNotExistException.class, () -> repo.getQuestion(45));
    }

    @Test
    @DisplayName("Get specific question ID is not null")
    void getSpecificQuestionIdIsNotNull() {
        Questions question = new Questions(1, "What is life?", new String[] {"Coffee", "Coding", "Pizza"}, "Studiegrupp 7" );

        repo.add(question);

        Assertions.assertThrows(NullPointerException.class, () -> repo.getQuestion(null));
    }*/
}
