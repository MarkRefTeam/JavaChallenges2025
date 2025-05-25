package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person {

    protected int age;
    protected String name;
    protected Gender gender;
    protected boolean isRentable;

    public Person(int age, String name, Gender gender,boolean isRentable) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.isRentable = isRentable;
    }

    public void introduce() {
        String availability = isRentable ? "I am available for interview." : "I'm currently not available.";
        System.out.println("Hi, my name is " + name + ". I am " + age + ". I am a " + gender + ". " + availability);
    }


    private static final List<String> goals = new ArrayList<>();
    static {
        goals.add("I'd like to be a cybersecurity and AI-focused developer.");
        goals.add("I want to lead a team of innovative engineers.");
        goals.add("I plan to build my own tech startup.");
        goals.add("My goal is to become a Java architect.");
        goals.add("I’m aiming for a career in ethical hacking.");
    }

    private static final Random random = new Random();

    public void printGoal() {
        int index = random.nextInt(goals.size());
        System.out.println(goals.get(index));
    }

    public boolean isRentable() {
        return isRentable;
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + gender + ")";
    }
}
