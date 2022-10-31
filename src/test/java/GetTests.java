import org.example.InMemory;
import org.example.QuestionRepo;
import org.example.Questions;
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
    void getQuestion() {
        Questions question = new Questions(1, "What is life?", new String[] {"Coffee", "Coding", "Pizza"}, "Studiegrupp 7" );

        repo.add(question);

        Assertions.assertEquals(question, repo.getQuestion(question.getId()));
    }
}
