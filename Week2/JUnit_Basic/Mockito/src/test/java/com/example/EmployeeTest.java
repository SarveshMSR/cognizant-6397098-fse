package com.example;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
    
    private Employee employee;
    
    @Before
    public void setUp() {
        System.out.println("--- Setting up Employee test ---");
        employee = new Employee(1001, "Alice", "Johnson", 5000.0);
        employee.setDepartment("Engineering");
        employee.setEmail("alice.johnson@company.com");
    }
    
    @After
    public void tearDown() {
        System.out.println("--- Cleaning up Employee test ---");
        employee = null;
    }
    
    @Test
    public void givenEmployeeNames_whenGettingFullName_thenReturnConcatenatedName() {
        // Arrange
        String expectedFullName = "Alice Johnson";
        
        // Act
        String actualFullName = employee.getFullName();
        
        // Assert
        assertEquals("Full name should be first and last name combined", 
                    expectedFullName, actualFullName);
    }
    
    @Test
    public void givenMonthlySalary_whenCalculatingAnnualSalary_thenReturnCorrectAmount() {
        // Arrange
        double expectedAnnualSalary = 5000.0 * 12;
        
        // Act
        double actualAnnualSalary = employee.getAnnualSalary();
        
        // Assert
        assertEquals("Annual salary should be monthly salary times 12", 
                    expectedAnnualSalary, actualAnnualSalary, 0.01);
    }
    
    @Test
    public void givenPositivePercentage_whenRaisingSalary_thenSalaryIncreases() {
        // Arrange
        double initialSalary = employee.getSalary();
        double raisePercentage = 10.0; // 10% raise
        double expectedSalary = initialSalary * 1.10;
        
        // Act
        employee.raiseSalary(raisePercentage);
        double actualSalary = employee.getSalary();
        
        // Assert
        assertEquals("Salary should increase by the given percentage", 
                    expectedSalary, actualSalary, 0.01);
    }
    
    @Test
    public void givenHighSalaryEmployee_whenCheckingIfHighEarner_thenReturnTrue() {
        // Arrange
        Employee highEarner = new Employee(1002, "Bob", "Smith", 6000.0); // Above 5000
        
        // Act
        boolean isHighEarner = highEarner.isHighEarner();
        
        // Assert
        assertTrue("Employee with salary above 5000 should be high earner", isHighEarner);
    }
    
    @Test
    public void givenLowSalaryEmployee_whenCheckingIfHighEarner_thenReturnFalse() {
        // Arrange
        Employee lowEarner = new Employee(1003, "Carol", "Davis", 4000.0); // Below 5000
        
        // Act
        boolean isHighEarner = lowEarner.isHighEarner();
        
        // Assert
        assertFalse("Employee with salary below 5000 should not be high earner", isHighEarner);
    }
    
    @Test
    public void givenValidEmail_whenSettingEmail_thenEmailIsSet() {
        // Arrange
        String validEmail = "alice.new@company.com";
        
        // Act
        employee.setEmail(validEmail);
        String actualEmail = employee.getEmail();
        
        // Assert
        assertEquals("Valid email should be set correctly", validEmail, actualEmail);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidEmail_whenSettingEmail_thenThrowException() {
        // Arrange
        String invalidEmail = "invalid-email";
        
        // Act
        employee.setEmail(invalidEmail); // Should throw exception
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void givenNegativePercentage_whenRaisingSalary_thenThrowException() {
        // Arrange
        double negativePercentage = -5.0;
        
        // Act
        employee.raiseSalary(negativePercentage); // Should throw exception
    }
}
