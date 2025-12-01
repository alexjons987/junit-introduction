package se.alexjons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CalculatorWithLoggerTest {

    @Test
    void add() {
        Logger logger = mock(Logger.class);
        CalculatorWithLogger calculator = new CalculatorWithLogger(logger);

        int result = calculator.add(6, 7);

        assertEquals(13, result);

        verify(logger).log("Performing addition");
        verify(logger).log("x: 6");
        verify(logger).log("y: 7");
    }

    @Test
    void divide() {
        Logger logger = mock(Logger.class);
        CalculatorWithLogger calculator = new CalculatorWithLogger(logger);

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });

        verify(logger).log("Performing division");
        verify(logger).log("x: 10");
        verify(logger).log("y: 0");
        verify(logger).log("Attempted division by zero");
    }
}
