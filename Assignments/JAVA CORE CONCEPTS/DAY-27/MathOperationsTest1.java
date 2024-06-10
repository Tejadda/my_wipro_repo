package com.DAY_27;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class MathOperationsTest1 {
    private MathOperations mathOperations;

    @BeforeAll
    public static void setupClass() {
        System.out.println("Setting up test class");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Tearing down test class");
    }

    @BeforeEach
    public void setup() {
        mathOperations = new MathOperations();
        System.out.println("Setting up test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tearing down test");
    }

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