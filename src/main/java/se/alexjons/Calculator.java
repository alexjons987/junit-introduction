package se.alexjons;

import java.util.List;

public class Calculator {

    public static int add(int x, int y) {

        long result = (long) x + (long) y;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Integer overflow");
        }

        return x + y;
    }

    public static int subtract(int x, int y) {

        long result = (long) x - (long) y;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Integer overflow");
        }

        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static int divide(int x, int y) {
        return x / y;
    }

    public static int abs(int x) {

        if (x == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Integer overflow");
        }

        return Math.abs(x);
    }

    public static boolean isEven(int x) {
        return x % 2 == 0;
    }

    public static boolean isOdd(int x) {
        return x % 2 == 1;
    }

    public static int max(List<Integer> n) {

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
