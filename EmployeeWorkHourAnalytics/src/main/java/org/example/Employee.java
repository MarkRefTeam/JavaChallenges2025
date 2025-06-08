package org.example;

import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private String name;
    private String department;
    private List<Integer> dailyHours;
}
