package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockingStubbing {

    @Test
    @DisplayName("Exercise 1: Basic Mocking and Stubbing")
    public void testBasicMockingAndStubbing() {
        System.out.println("=== Exercise 1: Mocking and Stubbing ===");

        // Step 1: Create a mock object for the external API
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        System.out.println("✓ Mock object created for ExternalApi");

        // Step 2: Stub the methods to return predefined values
        when(mockApi.getData()).thenReturn("Mock Data");
        System.out.println("✓ Method stubbed to return: 'Mock Data'");

        // Step 3: Write a test case that uses the mock object
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Verify the result
        assertEquals("Mock Data", result);
        System.out.println("✓ Test passed! Result: " + result);
        System.out.println("✓ Assertion successful: Expected 'Mock Data', Got '" + result + "'");
    }

    @Test
    @DisplayName("Exercise 1 Extended: Stubbing with Parameters")
    public void testStubbingWithParameters() {
        System.out.println("\n=== Exercise 1 Extended: Stubbing with Parameters ===");

        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub method with specific parameter
        when(mockApi.getData("test")).thenReturn("Test Data");
        when(mockApi.getData("prod")).thenReturn("Production Data");

        MyService service = new MyService(mockApi);

        String testResult = service.fetchDataWithParameter("test");
        String prodResult = service.fetchDataWithParameter("prod");

        assertEquals("Test Data", testResult);
        assertEquals("Production Data", prodResult);

        System.out.println("✓ Parameter-based stubbing successful");
        System.out.println("✓ Test environment result: " + testResult);
        System.out.println("✓ Production environment result: " + prodResult);
    }
}
// This class demonstrates how to use Mockito for mocking and stubbing in unit
// tests.
// It includes methods to create mock objects, stub method responses, and verify
// interactions.
// The tests ensure that the mocked methods return expected values and that the
// service behaves correctly with these mocks.
// The use of assertions confirms that the expected outcomes match the actual
// results from the service methods.