package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<Employee> readEmployees(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<Employee> readWithNio(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<Employee> readFromClasspath(String fileName) {
        try (InputStream is = CsvReader.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return parse(reader);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static List<Employee> parse(BufferedReader reader) throws IOException {
        List<Employee> employees = new ArrayList<>();
        String line;

        reader.readLine();
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] parts = line.split(",");

            String name = parts[0];
            String department = parts[1];
            List<Integer> hours = new ArrayList<>();
            for (int i = 2; i < parts.length; i++) {
                hours.add(Integer.parseInt(parts[i]));
            }

            Employee employee = Employee.builder()
                    .name(name)
                    .department(department)
                    .dailyHours(hours)
                    .build();

            employees.add(employee);
        }
        return employees;
    }
}
