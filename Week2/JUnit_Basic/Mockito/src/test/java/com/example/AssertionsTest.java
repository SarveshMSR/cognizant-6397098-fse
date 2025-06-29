package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssertionsTest {
    
    @Test
    public void testBasicAssertions() {
        System.out.println("=== Testing Basic Assertions ===");
        
        // Assert equals - compares expected and actual values
        assertEquals("Testing integer equality", 5, 2 + 3);
        assertEquals("Testing string equality", "Hello", "Hello");
        assertEquals("Testing double equality with delta", 5.0, 2.5 + 2.5, 0.001);
        System.out.println("✓ assertEquals tests passed");
        
        // Assert true - verifies condition is true
        assertTrue("5 should be greater than 3", 5 > 3);
        assertTrue("String should contain substring", "Hello World".contains("World"));
        assertTrue("List should not be empty", !java.util.Arrays.asList(1, 2, 3).isEmpty());
        System.out.println("✓ assertTrue tests passed");
        
        // Assert false - verifies condition is false
        assertFalse("5 should not be less than 3", 5 < 3);
        assertFalse("String should not be empty", "Hello".isEmpty());
        assertFalse("Number should not be negative", 10 < 0);
        System.out.println("✓ assertFalse tests passed");
        
        // Assert null - verifies object is null
        String nullString = null;
        assertNull("Object should be null", nullString);
        System.out.println("✓ assertNull test passed");
        
        // Assert not null - verifies object is not null
        String nonNullString = "Hello";
        assertNotNull("Object should not be null", nonNullString);
        assertNotNull("New object should not be null", new Object());
        System.out.println("✓ assertNotNull tests passed");
    }
    
    @Test
    public void testAdvancedAssertions() {
        System.out.println("=== Testing Advanced Assertions ===");
        
        // Assert same - verifies two references point to same object
        String str1 = "Hello";
        String str2 = str1;
        assertSame("References should point to same object", str1, str2);
        System.out.println("✓ assertSame test passed");
        
        // Assert not same - verifies two references don't point to same object
        String str3 = new String("Hello");
        String str4 = new String("Hello");
        assertNotSame("References should not point to same object", str3, str4);
        System.out.println("✓ assertNotSame test passed");
        
        // Assert array equals - compares arrays
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = {1, 2, 3, 4, 5};
        assertArrayEquals("Arrays should be equal", expected, actual);
        
        String[] stringArrayExpected = {"Java", "Python", "JavaScript"};
        String[] stringArrayActual = {"Java", "Python", "JavaScript"};
        assertArrayEquals("String arrays should be equal", stringArrayExpected, stringArrayActual);
        System.out.println("✓ assertArrayEquals tests passed");
    }
    
    @Test
    public void testStringAssertions() {
        System.out.println("=== Testing String-Specific Assertions ===");
        
        String text = "JUnit Testing Framework";
        
        // String operations testing
        assertTrue("String should start with 'JUnit'", text.startsWith("JUnit"));
        assertTrue("String should end with 'Framework'", text.endsWith("Framework"));
        assertTrue("String should contain 'Testing'", text.contains("Testing"));
        assertEquals("String length should be correct", 23, text.length());
        assertFalse("String should not be empty", text.isEmpty());
        
        // Case sensitivity
        assertEquals("Lowercase conversion", "junit testing framework", text.toLowerCase());
        assertEquals("Uppercase conversion", "JUNIT TESTING FRAMEWORK", text.toUpperCase());
        
        System.out.println("✓ String assertion tests passed");
    }
    
    @Test
    public void testNumericAssertions() {
        System.out.println("=== Testing Numeric Assertions ===");
        
        // Integer assertions
        int a = 10;
        int b = 20;
        assertEquals("Addition should be correct", 30, a + b);
        assertEquals("Subtraction should be correct", 10, b - a);
        assertEquals("Multiplication should be correct", 200, a * b);
        assertEquals("Division should be correct", 2, b / a);
        
        // Double assertions with delta
        double pi = 3.14159;
        double approximatePi = 3.14;
        assertEquals("Pi approximation should be close", pi, approximatePi, 0.01);
        
        // Comparison assertions
        assertTrue("20 should be greater than 10", b > a);
        assertFalse("10 should not be greater than 20", a > b);
        
        System.out.println("✓ Numeric assertion tests passed");
    }
    
    @Test
    public void testCollectionAssertions() {
        System.out.println("=== Testing Collection Assertions ===");
        
        java.util.List<String> list = java.util.Arrays.asList("Apple", "Banana", "Cherry");
        
        // Collection size and content
        assertEquals("List size should be 3", 3, list.size());
        assertTrue("List should contain Apple", list.contains("Apple"));
        assertTrue("List should contain Banana", list.contains("Banana"));
        assertFalse("List should not contain Orange", list.contains("Orange"));
        assertFalse("List should not be empty", list.isEmpty());
        
        // Array from list
        String[] array = list.toArray(new String[0]);
        String[] expectedArray = {"Apple", "Banana", "Cherry"};
        assertArrayEquals("Array should match expected", expectedArray, array);
        
        System.out.println("✓ Collection assertion tests passed");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionAssertion() {
        System.out.println("=== Testing Exception Assertion ===");
        
        // This test expects an IllegalArgumentException to be thrown
        throw new IllegalArgumentException("This is a test exception");
    }
    
    @Test
    public void testExceptionWithTryCatch() {
        System.out.println("=== Testing Exception with Try-Catch ===");
        
        try {
            // Code that should throw an exception
            Integer.parseInt("not-a-number");
            fail("Should have thrown NumberFormatException");
        } catch (NumberFormatException e) {
            // Expected exception caught
            assertNotNull("Exception should not be null", e);
            assertTrue("Exception message should contain input", 
                      e.getMessage().contains("not-a-number"));
            System.out.println("✓ Exception handling test passed");
        }
    }
    
    @Test
    public void testObjectAssertions() {
        System.out.println("=== Testing Object Assertions ===");
        
        // Object creation and comparison
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");
        StringBuilder sb3 = sb1;
        
        // Content equality vs reference equality
        assertEquals("String content should be equal", sb1.toString(), sb2.toString());
        assertNotSame("Different StringBuilder objects", sb1, sb2);
        assertSame("Same StringBuilder reference", sb1, sb3);
        
        // Object state
        assertNotNull("StringBuilder should not be null", sb1);
        assertTrue("StringBuilder should have content", sb1.length() > 0);
        assertEquals("StringBuilder length should be 5", 5, sb1.length());
        
        System.out.println("✓ Object assertion tests passed");
    }
    
    @Test
    public void testBoundaryConditions() {
        System.out.println("=== Testing Boundary Conditions ===");
        
        // Testing edge cases
        assertEquals("Empty string length", 0, "".length());
        assertEquals("Single character string", 1, "a".length());
        
        // Number boundaries
        assertEquals("Integer max value", Integer.MAX_VALUE, 2147483647);
        assertEquals("Integer min value", Integer.MIN_VALUE, -2147483648);
        
        // Floating point boundaries
        assertTrue("Positive infinity", Double.isInfinite(Double.POSITIVE_INFINITY));
        assertTrue("Negative infinity", Double.isInfinite(Double.NEGATIVE_INFINITY));
        assertTrue("Not a number", Double.isNaN(Double.NaN));
        
        System.out.println("✓ Boundary condition tests passed");
    }
}
