package org.example.Task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;

public class EmployeeCsvWriter {

    private final String delimiter;

    public EmployeeCsvWriter(String delimiter) {
        this.delimiter = delimiter;
    }

    private String formatSalary(double salary) {
        return BigDecimal.valueOf(salary)
                .stripTrailingZeros()
                .toPlainString();
    }

    public void write(Collection<Employee> employees, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            employees.stream()
                    .sorted(Comparator.comparing(Employee::getName))
                    .forEach(emp -> {
                        try {
                            writer.write(emp.getName() + delimiter
                                    + emp.getDepartment() + delimiter
                                    + formatSalary(emp.getSalary())); // <-- itt használd
                            writer.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
}