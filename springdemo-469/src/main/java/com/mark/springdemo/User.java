package com.mark.springdemo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class User {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 0, message = "Age cannot be negative")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}