package se.alexjons;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static List<Integer> largeList;

    @BeforeAll
    static void setUp() {
        largeList = new ArrayList<Integer>();

        for (int i = 0; i < 10000; i++) {
            largeList.add(i);
        }
    }

    @Test
    void add_returns_sum_of_two_integers() {
        // Arrange
        int x = 2;
        int y = 3;

        // Act
        int result = Calculator.add(x, y);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void add_throws_exception_on_overflow() {
        // Arrange
        int x = Integer.MAX_VALUE;
        int y = 1;

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.add(x, y);
        });
    }

    @Test
    void subtract_returns_difference_of_two_integers() {
        // Arrange
        int x = 10;
        int y = 3;

        // Act
        int resultA = Calculator.subtract(x, y);
        int resultB = Calculator.subtract(y, x);

        // Assert
        assertEquals(7, resultA);
        assertEquals(-7, resultB);
    }

    @Test
    void subtract_throws_exception_on_overflow() {
        // Arrange
        int x = Integer.MIN_VALUE;
        int y = 1;

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.subtract(x, y);
        });
    }

    @Test
    void multiply_returns_products_of_two_integers() {
        // Arrange
        int x = 0;
        int y = 10;
        int z = 5;

        // Act
        int resultA = Calculator.multiply(x, y);
        int resultB = Calculator.multiply(z, x);

        // Assert
        assertEquals(0, resultA);
        assertEquals(0, resultB);
    }

    @Test
    void multiply_returns_products_when_using_negative_integers() {
        // Arrange
        int x = -2;
        int y = 5;

        // Act
        int resultA = Calculator.multiply(x, y);
        int resultB = Calculator.multiply(x, x);

        // Assert
        assertEquals(-10, resultA);
        assertEquals(4, resultB);
    }

    @Test
    void divide_returns_quotient_of_two_integers() {
        // Arrange
        int x = 10;
        int y = 2;

        // Act
        int result = Calculator.divide(x, y);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void divide_returns_quotient_when_using_negative_integers() {
        // Arrange
        int x = -10;
        int y = 2;
        int z = -2;

        // Act
        int resultA = Calculator.divide(x, y);
        int resultB = Calculator.divide(x, z);

        // Assert
        assertEquals(-5, resultA);
        assertEquals(5, resultB);
    }

    @Test
    void divide_throws_exception_when_division_by_zero() {
        // Arrange
        int x = 10;
        int y = 0;

        // Act + Assert
        assertThrows(ArithmeticException.class, () -> {
           Calculator.divide(x ,y);
        });
    }

    @Test
    void abs_returns_magnitude_of_one_integer() {
        // Arrange
        int x = -5;

        // Act
        int result = Calculator.abs(x);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void abs_throws_exception_on_integer_min_value() {
        // Arrange
        int x = Integer.MIN_VALUE;

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.abs(x);
        });
    }

    @Test
    void isEven_returns_true_if_input_is_integer_four() {
        // Arrange
        int x = 4;

        // Act
        boolean xIsEven = Calculator.isEven(x);

        // Assert
        assertTrue(xIsEven);
    }

    @Test
    void isEven_returns_false_if_input_is_integer_five() {
        // Arrange
        int x = 5;

        // Act
        boolean xIsEven = Calculator.isEven(x);

        // Assert
        assertFalse(xIsEven);
    }

    @Test
    void isEven_is_compatible_with_large_numbers() {
        // Arrange
        int x = Integer.MAX_VALUE;

        // Act
        boolean xIsEven = Calculator.isEven(x);

        // Assert
        assertFalse(xIsEven);
    }

    @Test
    void isOdd_returns_false_if_input_is_integer_four() {
        // Arrange
        int x = 4;

        // Act
        boolean xIsOdd = Calculator.isOdd(x);

        // Assert
        assertFalse(xIsOdd);
    }

    @Test
    void isOdd_returns_true_if_input_is_integer_five() {
        // Arrange
        int x = 5;

        // Act
        boolean xIsOdd = Calculator.isOdd(x);

        // Assert
        assertTrue(xIsOdd);
    }

    @Test
    void max_returns_greatest_integer_of_given_list() {
        // Arrange
        List<Integer> n = List.of(1, 5, 3);

        // Act
        int max = Calculator.max(n);

        // Assert
        assertEquals(5, max);
    }

    @Test
    void max_returns_greatest_integer_of_given_list_of_duplicates() {
        // Arrange
        List<Integer> n = List.of(4, 4, 4, 4);

        // Act
        int max = Calculator.max(n);

        // Assert
        assertEquals(4, max);
    }

    @Test
    void max_returns_greatest_integer_of_given_list_of_negatives() {
        // Arrange
        List<Integer> n = List.of(-10, -3, -50);

        // Act
        int max = Calculator.max(n);

        // Assert
        assertEquals(-3, max);
    }

    @Test
    void max_returns_greatest_integer_without_performance_given_large_list() {
        // Act
        int max = Calculator.max(largeList);

        // Assert
        assertEquals(9999, max);
    }

    @Test
    void max_throws_exception_given_empty_list() {
        // Arrange
        List<Integer> n = List.of();

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.max(n);
        });
    }
}