package com.cognizant.junit.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setup completed");
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("Cleanup completed");
    }

    @Test
    void testAddition() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result);
    }

    @Test
    void testSubtraction() {
        assertEquals(15, calculator.subtract(20, 5));
    }

    @Test
    void testMultiplication() {
        assertEquals(50, calculator.multiply(10, 5));
    }

    @Test
    void testDivision() {
        assertEquals(5, calculator.divide(20, 4));
    }

    @Test
    void testTrueAssertion() {
        assertTrue(calculator.add(2, 3) == 5);
    }

    @Test
    void testFalseAssertion() {
        assertFalse(calculator.subtract(5, 3) == 5);
    }

    @Test
    void testNotNull() {
        assertNotNull(calculator.getMessage());
    }

    @Test
    void testNull() {
        assertNull(calculator.getNullValue());
    }

    @Test
    void testException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(10, 0));
    }
}