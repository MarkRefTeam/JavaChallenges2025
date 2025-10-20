package org.example.Task3;

public class Employee {
    private final String name;
    private final String department;
    private final double salary;

    private Employee(Builder builder) {
        this.name = builder.name;
        this.department = builder.department;
        this.salary = builder.salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }


    public static class Builder {
        private String name;
        private String department;
        private double salary;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}