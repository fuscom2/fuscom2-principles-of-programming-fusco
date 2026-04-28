import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {
    private Data data;

    @BeforeEach
    void setUp() {
        // Starts each test with a fresh account of 100.0
        data = new Data();
    }

    @AfterEach
    void clean() {
        // Starts each test with a fresh account of 100.0
        data = null;
    }

    @Test
    void testLessThan20() {
        boolean hasLessThan20 = false;

        for (int i = 0; i < data.arr1.length; i++) {
            if (data.arr1[i] < 20) hasLessThan20 = true;
        }

        assertFalse(hasLessThan20);
    }

    @Test
    void testIfStringsAreEqual() {
        boolean hasSameCharacters = true;

        for (int i = 0; i < data.str1.length(); i++) {
            if (!data.str2.contains(data.str1.substring(i, i + 1))) hasSameCharacters = false;
        }

        assertTrue(hasSameCharacters);
    }
}