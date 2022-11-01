import org.example.QuestionRepo;
import org.example.Questions;
import org.example.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServiceTest {

    QuestionRepo repo;
    Service service;

    @BeforeEach
    void setup() {
        repo = Mockito.mock(QuestionRepo.class);
        service = new Service(repo);
    }

    @Test
    @DisplayName("Add question using service class")
    void addQuestionUsingServiceClass() {
        Questions questions = Assertions.assertDoesNotThrow(() -> service.addQuestion(1, "vad heter jag", new String[]{"David", "Dennis", "Douglas"}, "Konstantin"));
        Mockito.verify(repo).add(Mockito.any(Questions.class));
        Assertions.assertNotNull(questions);
    }
}
