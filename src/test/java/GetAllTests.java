import org.example.InMemory;
import org.example.QuestionRepo;
import org.example.Questions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class GetAllTests {
    QuestionRepo repo;

    @BeforeEach
    void setup() {
        repo = new InMemory();
    }

    @Test
    @DisplayName("Get all questions")
    void getAllQuestions() {
        Questions question1 = new Questions(1, "What is life?", new String[] {"Coffee", "Coding", "Pizza"}, "Studiegrupp 7" );
        Questions question2 = new Questions(2, "What is life?", new String[] {"Coffee", "Coding", "Pizza"}, "Studiegrupp 7" );
        Questions question3 = new Questions(3, "What is life?", new String[] {"Coffee", "Coding", "Pizza"}, "Studiegrupp 7" );
        Questions question4 = new Questions(4, "What is life?", new String[] {"Coffee", "Coding", "Pizza"}, "Studiegrupp 7" );
        Questions question5 = new Questions(5, "What is life?", new String[] {"Coffee", "Coding", "Pizza"}, "Studiegrupp 7" );

        repo.add(question1);
        repo.add(question2);
        repo.add(question3);
        repo.add(question4);
        repo.add(question5);

        Collection<Questions> result = repo.getAllQuestions();

        Assertions.assertEquals(5, result.size());
    }
}
