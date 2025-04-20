package org.example;

import java.util.Scanner;

import static org.example.Assistant.getMotivationalQuote;

/**
 * Ladies and Gentlemen,
 * Let me proudly introduce it, together with my partner GP, our very first AI project!
 * We aim to complete and publish it within 3 to 5 years.
 * At the moment, we’re learning everything we need to build fully functional artificial intelligence from
 * the ground up.
 * <p>
 * Our goal is to create the first online meeting assistant AI.
 * Our motivation is to build an artificial intelligence that can actively participate in a real-time project
 * development – not just as a passive tool, but as a true virtual teammate.
 * <p>
 * Together with AI, we shape what’s next.
 */
public class App {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Hello, I'm your Assistant AI. How can i help you today?");

        sparkAssistantMenu();

        scanner.close();
    }

    public static void sparkAssistantMenu() {
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("Welcome in Spark Assistant");
            System.out.println();
            System.out.println("1. Introduce yourself");
            System.out.println();
            System.out.println("2. Tell your age");
            System.out.println();
            System.out.println("3. Ask a random question");
            System.out.println();
            System.out.println("4. Get a motivational quote");
            System.out.println();
            System.out.println("5. Todo List");
            System.out.println();
            System.out.println("6. Exit the program");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Assistant.introduceYourself();
                    break;
                case 2:
                    Assistant.askAge();
                    break;
                case 3:
                    Assistant.askRandomQuestion();
                    break;
                case 4:
                    Assistant.getMotivationalQuote();
                    break;
                case 5:
                    Assistant.todoListMenu();
                    break;
                case 6:
                    System.out.println("Exiting Game, Goodbye");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.Please try again!");
            }
        }
    }
}
