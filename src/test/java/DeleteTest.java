import org.example.InMemory;
import org.example.QuestionRepo;
import org.example.Questions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteTest {

    QuestionRepo repo;

    @BeforeEach
    void setup(){
        repo = new InMemory();
    }

    @Test
    @DisplayName("Delete question by id")
    void deleteQuestionById(){
        Questions question = new Questions(1, "What is life?", new String[] {"Coffee", "Coding", "Pizza"}, "Studiegrupp 7" );

        repo.add(question);
        Assertions.assertDoesNotThrow(() -> repo.delete(question.getId()));

        Assertions.assertEquals(0,repo.count());
    }
}
