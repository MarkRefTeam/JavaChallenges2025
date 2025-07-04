package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTest {

    @Test
    void testReadEmployeesWithValidFile() {
        String filePath = "src/main/resources/employee_hours.csv";

        List<Employee> employees = CsvReader.readEmployees(filePath);

        assertNotNull(employees);
        assertFalse(employees.isEmpty());

        Employee first = employees.get(0);
        assertEquals("Alice Johnson", first.getName());
        assertEquals("Engineering", first.getDepartment());
        assertEquals(List.of(8, 9, 8, 10, 7), first.getDailyHours());
    }

    @Test
    void testReadEmployeesWithEmptyFile() {
        String filePath = "src/main/resources/empty.csv";

        List<Employee> employees = CsvReader.readEmployees(filePath);

        assertNotNull(employees);
        assertTrue(employees.isEmpty());
    }

    @Test
    void testReadEmployees_withNonexistentFile() {
        String filePath = "src/main/resources/nonexistent.csv";

        List<Employee> employees = CsvReader.readEmployees(filePath);

        assertNotNull(employees);
        assertFalse(employees.isEmpty());
    }
}
