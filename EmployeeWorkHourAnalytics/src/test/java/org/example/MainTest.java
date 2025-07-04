package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    void testCalculateTotalWeeklyHours() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Dev", Arrays.asList(8, 8, 8, 8, 8)),
                new Employee("Bob", "QA", Arrays.asList(6, 6, 6, 6, 6))
        );

        Map<String, Integer> result = AnalyticsService.calculateTotalWeeklyHours(employees);
        assertEquals(40, result.get("Alice"));
        assertEquals(30, result.get("Bob"));
    }

    @Test
    void testCalculateAverageDailyHours() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Dev", Arrays.asList(8, 8, 8, 8, 8)),
                new Employee("Bob", "QA", Arrays.asList(6, 6, 6, 6, 6))
        );

        Map<String, Double> result = AnalyticsService.calculateAverageDailyHours(employees);
        assertEquals(8.0, result.get("Alice"));
        assertEquals(6.0, result.get("Bob"));
    }

    @Test
    void testCalculateAverageWeeklyHoursByDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Dev", Arrays.asList(8, 8, 8, 8, 8)),
                new Employee("Bob", "QA", Arrays.asList(6, 6, 6, 6, 6)),
                new Employee("Carol", "Dev", Arrays.asList(8, 8, 8, 8, 8))
        );

        Map<String, Double> result = AnalyticsService.calculateAverageDailyHours(employees);
        assertEquals(8.0, result.get("Alice"));
        assertEquals(6.0, result.get("Bob"));

    }

    @Test
    void testFindTopEmployeeByDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Dev", Arrays.asList(8, 8, 8, 8, 8)),
                new Employee("Carol", "Dev", Arrays.asList(6, 6, 6, 6, 6)),
                new Employee("Bob", "QA", Arrays.asList(6, 6, 6, 6, 6)),
                new Employee("Dave", "QA", Arrays.asList(7, 7, 7, 7, 7))
        );

        Map<String, Employee> result = AnalyticsService.findTopEmployeeByDepartment(employees);

        assertEquals("Alice", result.get("Dev").getName());
        assertEquals("Dave", result.get("QA").getName());
    }

    @Test
    void testFindTopEmployeeOverall() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Dev", Arrays.asList(8, 8, 8, 8, 8)),
                new Employee("Bob", "QA", Arrays.asList(6, 6, 6, 6, 6)),
                new Employee("Carol", "Dev", Arrays.asList(7, 7, 7, 7, 7)),
                new Employee("Dave", "QA", Arrays.asList(9, 9, 9, 9, 9))
        );

        Optional<Employee> result = AnalyticsService.findTopEmployeeOverall(employees);

        assertTrue(result.isPresent());
        assertEquals("Dave", result.get().getName());
    }

}
