package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        for (Employee emp : employees) {
            System.out.println(emp);
        }

    }
}
