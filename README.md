# JUnit5 Introduction
Write a class Calculator that can perform various mathematical operations on integers.
The class should have methods for addition, subtraction, multiplication, division, calculation
of absolute value, checking if a number is even, and calculation of the maximum value in a list.
## Requirements
### 1. Addition should return the correct sum
* `add(2, 3)` should give `5`.
### 2. Subtraction should work with both positive and negative numbers
* `subtract(10, 3)` should give `7`.
* `subtract(3, 10)` should give `-7`.
### 3. Multiplication should handle zero correctly
* `multiply(0, 10)` should give `0`.
* `multiply(5, 0)` should give `0`.
### 4. Division should return the correct result for integer division
* `divide(10, 2)` should give `5`.
### 5. Division by zero should throw ArithmeticException
* `divide(10, 0)` should throw an error.
* Consider how to use `assertThrows(...)` in JUnit to verify that a method throws a certain exception. The test should call `divide(10, 0)` and expect an ArithmeticException.
### 6. The absolute value method should always return a positive number
* `abs(-5)` should return `5`.
* `abs(5)` should still return `5`.
### 7. Evenness check should work
* `isEven(4)` should return true.
* `isEven(5)` should return false.
### 8. The max value method in a list should find the correct value
* For the list `[1, 5, 3]`, the result should be `5`.
### 9. The max value method should throw an exception for an empty list
* Submitting `[]` should throw an IllegalArgumentException.
* Consider how to use `assertThrows(...)` in JUnit to verify that a method throws a certain exception.
### 10. All methods should be deterministic
* Repeated calls with the same arguments should always give the same result.
### 11. Addition should handle integer overflow
* `add(Integer.MAX_VALUE, 1)` should throw an exception or be handled in a defined way.
### 12. Subtraction should handle integer underflow
* `subtract(Integer.MIN_VALUE, 1)` should detect overflow or be handled correctly.
### 13. Multiplication with negative numbers
* `multiply(-2, 5)` → -10
* `multiply(-2, -2)` → 4
### 14. Division with negative numbers
* `divide(-10, 2)` → -5
* `divide(-10, -2)` → 5
### 15. Absolute value of Integer.MIN_VALUE
* `abs(Integer.MIN_VALUE)` is a special case that does not fit in a positive int.
* Should either throw an exception or return `Integer.MAX_VALUE` depending on the design.
## More difficult test cases (Optional)
### 16. The max value method should work for lists with repeated values
* `[4, 4, 4, 4]` → `4`
### 17. The max value method should work for lists with negative numbers
* `[-10, -3, -50]` → `-3`
### 18. The max value method should work for very large lists
* Lists with e.g. 10,000 elements should be handled without performance errors.
### 19. isEven should return the correct value for very large numbers
* `isEven(Integer.MAX_VALUE)` → `false`
# Calculator with Logger (Mocking)
### Scenario:
Now you will mock a Logger and test that Calculator logs correctly without actually writing to
the console or file.
### Logger interface:
```java
public interface Logger {
    void log(String message);
}
```
### Task:
1. Create a class `CalculatorWithLogger` that takes a `Logger` in the constructor.
2. The methods `add(int a, int b)` and `divide(int a, int b)` should **log each operation**.
3. If division by zero is attempted, an `IllegalArgumentException` should be thrown and `"Attempted divide by zero"` should be logged.