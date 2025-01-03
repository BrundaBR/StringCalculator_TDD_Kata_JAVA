import org.example.StringCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class StringCalculatorTest {
        @Test
        public void testEmptyString() {
            assertEquals(0, StringCalculator.add(""));
        }

        @Test
        public void testAddWithNewline() {
            assertEquals(6, StringCalculator.add("1\n2,3"));
        }
    }
