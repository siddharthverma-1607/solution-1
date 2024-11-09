package com.yourpackage;

import java.util.Scanner;

public class TimeTracker {

    // Array to store daily work hours for each day of the week
    private static double[] dailyHours = new double[7];
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input employee information
        System.out.print("Enter employee name: ");
        String employeeName = scanner.nextLine();
        
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();
        
        // Loop through each day of the week
        for (int i = 0; i < 7; i++) {
            dailyHours[i] = recordWorkTime(scanner, i);
        }
        
        // Display the weekly summary
        displayWeeklySummary(employeeName, employeeID);
        
        scanner.close();
    }

    // Method to record work start and end time for a given day
    public static double recordWorkTime(Scanner scanner, int dayIndex) {
        // Prompt user for start and end time
        System.out.print("Enter start time for day " + (dayIndex + 1) + " (in 24-hour format, e.g., 9.00): ");
        double startTime = scanner.nextDouble();
        
        System.out.print("Enter end time for day " + (dayIndex + 1) + " (in 24-hour format, e.g., 17.00): ");
        double endTime = scanner.nextDouble();
        
        // Calculate the total hours worked
        double hoursWorked = endTime - startTime;
        
        // Validate the input
        if (hoursWorked < 0) {
            System.out.println("Invalid input: End time cannot be before start time.");
            return 0; // Return 0 if invalid input
        }
        
        return hoursWorked;
    }

    // Method to display the summary of weekly hours worked
    public static void displayWeeklySummary(String employeeName, String employeeID) {
        // Display employee information
        System.out.println("\nWeekly Time Summary for " + employeeName + " (ID: " + employeeID + "):");
        
        // Calculate total hours worked in the week
        double totalHours = 0;
        for (int i = 0; i < 7; i++) {
            totalHours += dailyHours[i];
        }
        
        // Display daily hours worked
        for (int i = 0; i < 7; i++) {
            System.out.printf("Day %d: %.2f hours\n", i + 1, dailyHours[i]);
        }
        
        // Display total hours worked in the week
        System.out.printf("\nTotal hours worked this week: %.2f hours\n", totalHours);
    }
}
