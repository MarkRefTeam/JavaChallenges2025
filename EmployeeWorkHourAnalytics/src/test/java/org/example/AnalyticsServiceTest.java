package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnalyticsServiceTest {

    private List<Employee> sampleEmployees() {
        return List.of(
                new Employee("Alice", "Sales", List.of(8, 8, 8, 8, 8)),
                new Employee("Bob", "Sales", List.of(7, 7, 7, 7, 7)),
                new Employee("Charlie", "IT", List.of(9, 9, 9, 9, 9)),
                new Employee("Dana", "IT", List.of(6, 6, 6, 6, 6))
        );
    }

    @Test
    void testCalculatorTotalWeeklyHours() {
        List<Employee> employees = sampleEmployees();
        Map<String, Integer> totals = AnalyticsService.calculateTotalWeeklyHours(employees);

        assertEquals(40, totals.get("Alice"));
        assertEquals(35, totals.get("Bob"));
        assertEquals(45, totals.get("Charlie"));
        assertEquals(30, totals.get("Dana"));
    }

    @Test
    void testCalculateAverageDailyHours() {
        List<Employee> employees = sampleEmployees();
        Map<String, Double> averages = AnalyticsService.calculateAverageDailyHours(employees);

        assertEquals(8.0, averages.get("Alice"));
        assertEquals(7.0, averages.get("Bob"));
        assertEquals(9.0, averages.get("Charlie"));
        assertEquals(6.0, averages.get("Dana"));
    }

    @Test
    void testCalculateAverageWeeklyHoursByDepartment() {
        List<Employee> employees = sampleEmployees();
        Map<String, Double> avgByDept = AnalyticsService.calculateAverageWeeklyHoursByDepartment(employees);

        assertEquals(37.5, avgByDept.get("Sales"));
        assertEquals(37.5, avgByDept.get("IT"));
    }

    @Test
    void testFindTopEmployeeByDepartment() {
        List<Employee> employees = sampleEmployees();
        Map<String, Employee> topByDept = AnalyticsService.findTopEmployeeByDepartment(employees);

        assertEquals("Alice", topByDept.get("Sales").getName());
        assertEquals("Charlie", topByDept.get("IT").getName());
    }

    @Test
    void testFindTopEmployeeOverall() {
        List<Employee> employees = sampleEmployees();
        Optional<Employee> topEmployee = AnalyticsService.findTopEmployeeOverall(employees);

        assertTrue(topEmployee.isPresent());
        assertEquals("Charlie", topEmployee.get().getName());
    }
}
