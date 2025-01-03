import org.example.StringCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class StringCalculatorTest {
        @Test
        public void testEmptyString() {
            assertEquals(0, StringCalculator.add(""));
        }

    }
