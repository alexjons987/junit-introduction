package se.alexjons;

import java.util.List;

public class CalculatorWithLogger {

    Logger logger;

    public CalculatorWithLogger(Logger logger) {
        this.logger = logger;
    }

    public int add(int x, int y) {
        logger.log("Performing addition");
        logger.log("x: " + x);
        logger.log("y: " + y);

        long result = (long) x + (long) y;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Integer overflow");
        }


        return x + y;
    }

    public int subtract(int x, int y) {

        long result = (long) x - (long) y;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Integer overflow");
        }

        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        logger.log("Performing division");
        logger.log("x: " + x);
        logger.log("y: " + y);

        if (y == 0) {
            logger.log("Attempted division by zero");
            throw new IllegalArgumentException();
        }

        return x / y;
    }

    public int abs(int x) {

        if (x == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Integer overflow");
        }

        return Math.abs(x);
    }

    public boolean isEven(int x) {
        return x % 2 == 0;
    }

    public boolean isOdd(int x) {
        return x % 2 == 1;
    }

    public int max(List<Integer> n) {

        if (n.isEmpty()) {
            throw new IllegalArgumentException("cannot get max of empty list");
        }

        int max = n.getFirst();

        for (int i = 1; i < n.toArray().length; i++) {
            if (n.get(i) > max) {
                max = n.get(i);
            }
        }

        return max;
    }
}
