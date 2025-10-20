package org.example.Task3;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeCsvWriterTest {

    @Test
    void testWriteEmployees_createsCsvSorted() throws IOException {
        List<Employee> employees = Arrays.asList(
                new Employee.Builder().name("John").department("HR").salary(50000).build(),
                new Employee.Builder().name("Alice").department("IT").salary(60000).build(),
                new Employee.Builder().name("Bob").department("Marketing").salary(55000).build()
        );

        Path tempFile = Files.createTempFile("employees", ".csv");

        EmployeeCsvWriter writer = new EmployeeCsvWriter(",");
        writer.write(employees, tempFile.toString());

        List<String> lines = Files.readAllLines(tempFile);

        assertEquals("Alice,IT,60000", lines.get(0));
        assertEquals("Bob,Marketing,55000", lines.get(1));
        assertEquals("John,HR,50000", lines.get(2));
    }
}