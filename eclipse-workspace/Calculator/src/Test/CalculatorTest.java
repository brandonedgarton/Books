import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    void testInitialValue() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.getResult());
    }

    @Test
    void testChainingOperations() {
        Calculator calculator = new Calculator();
        calculator.add(2, 3);
        calculator.subtract(1);
        assertEquals(4, calculator.getResult());
    }

    @Test
    void testClearResult() {
        Calculator calculator = new Calculator();
        calculator.add(2, 3);
        calculator.clear();
        assertEquals(0, calculator.getResult());
    }

    @Test
    void testNegativeNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(-1, calculator.subtract(2, 3));
    }

    @Test
    void testLargeNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(1000000, calculator.add(500000, 500000));
    }

    @Test
    void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    void testInvalidInput() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0));
    }
}

