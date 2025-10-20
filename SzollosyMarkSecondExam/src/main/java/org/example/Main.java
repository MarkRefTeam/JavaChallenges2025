package org.example;

import org.example.Task3.Employee;
import org.example.Task3.EmployeeCsvWriter;
import org.example.common.TextUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = "Hello World, this is my Exam!";

        String vowelsReplaced = TextUtils.replaceVowels(input);
        System.out.println("Vowels replaced: " + vowelsReplaced);

        String replacedAll = TextUtils.replaceAll(input, "Exam", "Test");
        System.out.println("Custom replace: " + replacedAll);

        List<Employee> employees = Arrays.asList(
                new Employee.Builder().name("John").department("HR").salary(50000).build(),
                new Employee.Builder().name("Alice").department("IT").salary(60000).build(),
                new Employee.Builder().name("Bob").department("Marketing").salary(55000).build()
        );

        EmployeeCsvWriter writer = new EmployeeCsvWriter(",");
        try {
            writer.write(employees, "employees.csv");
            System.out.println("CSV file created: employees.csv");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }
}