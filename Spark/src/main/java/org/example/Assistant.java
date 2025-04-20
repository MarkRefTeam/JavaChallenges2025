package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.App.scanner;

public class Assistant {

    public static void introduceYourself() {

        System.out.println("Lets get to know you!");

        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("Where are you from?");
        String location = scanner.nextLine();

        System.out.println("What is your favorite hobby?");
        String hobby = scanner.nextLine();

        System.out.println();
        System.out.println("Nice to meet you, " + name + " from " + location + "!");
        System.out.println("It's cool that you enjoy: " + hobby + "!");


    }

    public static void askAge() {

        System.out.println("Enter you age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Got it! You are " + age + "years old");
    }

    public static void askRandomQuestion() {
        String[] questions = {
                "What is your favorite hobby?",
                "If you could travel anywhere, where would you go?",
                "What motivates you the most?",
                "Do you prefer coffee or tea?"
        };
        int index = new Random().nextInt(questions.length);
        System.out.println("Here's a question for you: " + questions[index]);

    }

    public static void getMotivationalQuote() {
        String[] quotes = {
                "Believe in yourself and all that you are.",
                "Success is not final, failure is not fatal: it is the courage to continue that counts.",
                "The only way to do great work is to love what you do.",
                "You are capable of amazing things!"
        };
        int index = new Random().nextInt(quotes.length);
        System.out.println("Motivational quote: " + quotes[index]);
    }

    public static void todoListMenu() {
        List<String> tasks = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n--- ToDo Menu ---");
            System.out.println();
            System.out.println("1. Add a new task");
            System.out.println();
            System.out.println("2. Show all tasks");
            System.out.println();
            System.out.println("3. Exit ToDo menu");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Enter your task:");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println();
                    System.out.println("Task added!");
                    break;
                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println();
                        System.out.println("No tasks yet.");
                    } else {
                        System.out.println();
                        System.out.println("Your task:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));

                        }
                    }
                    break;
                case 3:
                    running = false;
                    System.out.println("Returning to Spark Assistant menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }
    }
}

