package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import org.example.AnalyticsService;

/**
 * Same Data – 3 Ways project!
 * Simply call from resources (Part 1):
 * Platform Free (Part 2):
 * Classpath loading (Part 3):
 */

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("You can Choose option");
        System.out.println("1.Basic Way");
        System.out.println("2.Nio Path");
        System.out.println("3.ClassPath");

        int choice = scanner.nextInt();
        List<Employee> employee = new ArrayList<>();

        switch (choice) {
            case 1:
                CsvReader.readEmployees("src/main/resources/employee_hours.csv");
                break;
            case 2:
                CsvReader.readWithNio(Paths.get("src", "main", "resources", "employee_hours.csv"));
                break;
            case 3:
                CsvReader.readFromClasspath("employee_hours.csv");
                break;
            default:
                System.out.println("Invalid choice, try again Please");
        }

        //Part 1:
        String filePath = "src/main/resources/employee_hours.csv";
        List<Employee> employees = CsvReader.readEmployees(filePath);

        //Part 2:
        Path path = Paths.get("src", "main", "resources", "employee_hours.csv");
        BufferedReader reader = Files.newBufferedReader(path);

        Map<String, Integer> totalHours = AnalyticsService.calculateTotalWeeklyHours(employees);
        Map<String, Double> avgDailyHours = AnalyticsService.calculateAverageDailyHours(employees);
        Map<String, Double> weeklyAvgByDept = AnalyticsService.calculateAverageWeeklyHoursByDepartment(employees);
        weeklyAvgByDept.forEach((dep, avg) -> System.out.printf("%s: %.2f weekly hours%n", dep, avg));
        Map<String, Employee> topByDept = AnalyticsService.findTopEmployeeByDepartment(employees);
        Optional<Employee> topEmployee = AnalyticsService.findTopEmployeeOverall(employees);

        topEmployee.ifPresent(emp -> {
            int hours = emp.getDailyHours().stream().mapToInt(Integer::intValue).sum();
            System.out.printf("TOP EMPLOYEE OVERALL: %s (%d hours)%n", emp.getName(), hours);
        });


        System.out.println("\n--- Total Weekly Hours ---");
        totalHours.forEach((name, total) -> System.out.println(name + ": " + total + " hours"));

        System.out.println("\n--- Average Daily Hours ---");
        avgDailyHours.forEach((name, avg) -> System.out.printf("%s: %.2f hours/day%n", name, avg));

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
