package com.example;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VerifyingInteraction {

    @Test
    @DisplayName("Exercise 2: Basic Interaction Verification")
    public void testBasicVerifyInteraction() {
        System.out.println("=== Exercise 2: Verifying Interactions ===");

        // Step 1: Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        System.out.println("✓ Mock object created");

        MyService service = new MyService(mockApi);

        // Step 2: Call the method with specific arguments
        service.fetchData();
        System.out.println("✓ Service method called");

        // Step 3: Verify the interaction
        verify(mockApi).getData();
        System.out.println("✓ Interaction verified: getData() was called");

        // Additional verification examples
        verify(mockApi, times(1)).getData();
        System.out.println("✓ Verified: getData() was called exactly 1 time");
    }

    @Test
    @DisplayName("Exercise 2 Extended: Verifying Method Arguments")
    public void testVerifyWithArguments() {
        System.out.println("\n=== Exercise 2 Extended: Verifying with Arguments ===");

        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Call method with specific data
        service.processAndSaveData("Important Data");

        // Verify method was called with expected argument
        verify(mockApi).saveData("Processed: Important Data");
        System.out.println("✓ Verified: saveData() called with correct argument");

        // Verify method was called at least once
        verify(mockApi, atLeastOnce()).saveData(anyString());
        System.out.println("✓ Verified: saveData() called at least once with any string");
    }

    @Test
    @DisplayName("Exercise 2 Advanced: Multiple Interactions")
    public void testMultipleInteractions() {
        System.out.println("\n=== Exercise 2 Advanced: Multiple Interactions ===");

        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Multiple calls
        service.fetchData();
        service.fetchDataWithParameter("test");
        service.processAndSaveData("data1");
        service.processAndSaveData("data2");

        // Verify multiple interactions
        verify(mockApi, times(1)).getData();
        verify(mockApi, times(1)).getData("test");
        verify(mockApi, times(2)).saveData(startsWith("Processed:"));

        System.out.println("✓ All interactions verified successfully");
        System.out.println("  - getData() called 1 time");
        System.out.println("  - getData(String) called 1 time");
        System.out.println("  - saveData() called 2 times with processed data");
    }
}