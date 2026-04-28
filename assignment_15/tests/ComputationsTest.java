import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ComputationsTest {
    @Test
    void testFibonacci() {
        int x = Computations.fibonacci(4);

        assertEquals(x, 3);
    }

    @Test
    void testFibonacciError() {
        assertThrows(IllegalArgumentException.class, () -> Computations.fibonacci(-1));
    }

    @Test
    void testIsPrime() {
        int x = 3;

        assertTrue(Computations.isPrime(x));
    }

    @Test
    void testIsEven() {
        int x = 2;

        assertTrue(Computations.isEven(x));
    }

    @Test
    void testIsOdd() {
        int x = 3;

        assertTrue(Computations.isOdd(x));
    }

    @Test
    void testToCelcius() {
        int f = 32;

        assertEquals(Computations.toCelsius(f), 0);
    }

    @Test
    void testToFahrenheit() {
        int c = 0;

        assertEquals(Computations.toFahrenheit(c), 32);
    }
}