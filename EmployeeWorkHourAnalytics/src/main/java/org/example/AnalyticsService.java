package org.example;

import java.util.*;

public class AnalyticsService {

    public static Map<String, Integer> calculateTotalWeeklyHours(List<Employee> employees) {
        Map<String, Integer> result = new HashMap<>();

        for (Employee employee : employees) {
            int total = employee.getDailyHours()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            result.put(employee.getName(), total);
        }
        return result;
    }

    public static Map<String, Double> calculateAverageDailyHours(List<Employee> employees) {
        Map<String, Double> result = new HashMap<>();

        for (Employee employee : employees) {
            List<Integer> hours = employee.getDailyHours();
            double avarage = hours.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
            result.put(employee.getName(), avarage);
        }
        return result;
    }

    public static Map<String, Double> calculateAverageWeeklyHoursByDepartment(List<Employee> employees) {
        Map<String, List<Integer>> departmentHours = new HashMap<>();

        for (Employee employee : employees) {
            String department = employee.getDepartment().trim();
            int totalHours = employee.getDailyHours()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            departmentHours.computeIfAbsent(department, k -> new ArrayList<>());
            departmentHours.get(department).add(totalHours);
        }

        Map<String, Double> result = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : departmentHours.entrySet()) {
            double average = entry.getValue()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
            result.put(entry.getKey(), average);
            System.out.println("=== Final weekly averages ===");
            result.forEach((dept, avg) -> System.out.println(dept + ": " + avg));
        }
        return result;

    }

    public static Map<String, Employee> findTopEmployeeByDepartment(List<Employee> employees) {
        Map<String, Employee> topByDept = new HashMap<>();

        for (Employee emp : employees) {
            String dept = emp.getDepartment();
            int empTotal = emp.getDailyHours().stream().mapToInt(Integer::intValue).sum();

            topByDept.merge(dept, emp, (currentTop, newEmp) -> {
                int currentTotal = currentTop.getDailyHours().stream().mapToInt(Integer::intValue).sum();
                return empTotal > currentTotal ? newEmp : currentTop;
            });
        }

        return topByDept;
    }

    public static Optional<Employee> findTopEmployeeOverall(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingInt(emp -> emp.getDailyHours()
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum()));
    }
}

