package com.example;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
    private String department;
    
    public Employee(int employeeId, String firstName, String lastName, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public double getAnnualSalary() {
        return salary * 12;
    }
    
    public void raiseSalary(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Percentage cannot be negative");
        }
        salary = salary * (1 + percentage / 100);
    }
    
    public boolean isHighEarner() {
        return salary > 5000;
    }
    
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }
    
    // Getters and setters
    public int getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getSalary() { return salary; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
