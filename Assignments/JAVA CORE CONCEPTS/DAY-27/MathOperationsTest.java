package com.DAY_27;
public class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }
}


package com.DAY_27;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathOperationsTest {
    private MathOperations mathOperations = new MathOperations();

    @Test
    void testAdd() {
        assertEquals(4, mathOperations.add(2, 2));
        assertEquals(0, mathOperations.add(0, 0));
        assertEquals(-2, mathOperations.add(-2, 0));
    }

    @Test
    void testSubtract() {
        assertEquals(0, mathOperations.subtract(2, 2));
        assertEquals(0, mathOperations.subtract(0, 0));
        assertEquals(-2, mathOperations.subtract(0, 2));
    }

    @Test
    void testMultiply() {
        assertEquals(4, mathOperations.multiply(2, 2));
        assertEquals(0, mathOperations.multiply(0, 0));
        assertEquals(-4, mathOperations.multiply(-2, 2));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, mathOperations.divide(4, 2));
        assertEquals(0.0, mathOperations.divide(0, 2));
        assertThrows(ArithmeticException.class, () -> mathOperations.divide(4, 0));
    }
}
