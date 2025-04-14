package org.example;

public class Runner {

    public static void main(String[] args) {

        System.out.println("Dimensional Project + Todo List");
        System.out.println("----------------------------------");
        TodoList.TASKS.forEach(System.out::println);
        System.out.println("Are you ready? Let's go");
    }
}

