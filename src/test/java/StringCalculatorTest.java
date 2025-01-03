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

        @Test
        public void testAddWithCustomDelimiterAndNegativeNumber() {
            try {
                StringCalculator.add("//;\n1;2;-3");
                fail("Exception was not thrown for negative numbers");
            } catch (RuntimeException e) {
                assertEquals("Negative numbers not allowed: [-3]", e.getMessage());
            }
        }
    }
