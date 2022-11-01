import org.example.QuestionRepo;
import org.example.Questions;
import org.example.Service;
import org.example.exceptions.AlreadyExistsException;
import org.example.exceptions.DoesNotExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

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

    @Test
    @DisplayName("Add question no duplicates")
    void addQuestionUsingServiceClassNoDuplicates() throws DoesNotExistException {
        Questions question = new Questions(1, "vad heter jag", new String[]{"David", "Dennis", "Douglas"}, "Konstantin");
        Mockito.when(repo.getQuestion(1)).thenReturn(question);
        Assertions.assertThrows(AlreadyExistsException.class, () -> service.addQuestion(1, "vad heter jag", new String[]{"David", "Dennis", "Douglas"}, "Konstantin"));
        Mockito.verify(repo, Mockito.never()).add(Mockito.any(Questions.class));
    }

    @Test
    @DisplayName("Add question not null")
    void addQuestionUsingServiceClassNotNull() {
        Assertions.assertThrows(NullPointerException.class, () -> service.addQuestion(1, null, new String[]{"David", "Dennis", "Douglas"}, "Konstantin"));
        Mockito.verify(repo, Mockito.never()).add(Mockito.any(Questions.class));
    }
    @Test
    @DisplayName("Get question using service class")
    void getQuestionUsingServiceClass() throws DoesNotExistException {
        Questions questions = Assertions.assertDoesNotThrow(() -> service.addQuestion(1, "vad heter jag", new String[]{"David", "Dennis", "Douglas"}, "Konstantin"));
       Mockito.when(repo.getQuestion(questions.getId())).thenReturn(questions);
    Assertions.assertEquals(questions,service.getQuestion(1));
    }
    @Test
    @DisplayName("Question does not exist")
    void getQuestionUsingServiceClassDoesNotExist() throws DoesNotExistException {
        Mockito.when(repo.getQuestion(1)).thenReturn(null);
        Assertions.assertThrows(DoesNotExistException.class,() -> service.getQuestion(1));

    }
}
