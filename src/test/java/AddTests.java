import org.example.InMemory;
import org.example.QuestionRepo;
import org.example.Questions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddTests {
    QuestionRepo repo;

    @BeforeEach
    public void setup() {
        repo = new InMemory();
    }

    @Test
    @DisplayName("add question no fail")
    void addQuestion() {

        Questions questions = new Questions(1, "vad heter jag", new String[]{"David", "Dennis", "Douglas"}, "Konstantin");
        repo.add(questions);
        Assertions.assertEquals(1, repo.count());
    }
}

