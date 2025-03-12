import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        algo(scanner);
        algoTask(scanner);
        switchCaseUpgrade(scanner);
        arraysList(scanner);

        System.out.println("Please enter the number between 1 and 30");
        int number = scanner.nextInt();

        while (number < 1 || number > 30) {
            System.out.println("Incorrect,Please enter a number between 1 and 30");
            number = scanner.nextInt();
        }
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Fizzbuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
            scanner.close();
        }
    }


    public static void algo(Scanner scanner) {
        System.out.println("Basic sum task");

        int a = 5;
        int b = 3;
        int sum = a + b;
        System.out.println(sum);

    }

    public static void algoTask(Scanner scanner) {
        System.out.println("Basic algo task");

        int a = 11;
        int b = 2;
        int sum = a + b;
        System.out.println(sum);

        int c = 22;
        int d = 8;
        int sum2 = c - d;
        System.out.println(sum2);

        System.out.println("Enter your number");
        int number = scanner.nextInt();

        while (number < 1 || number > 30) {
            System.out.println("Incorrect,Please enter a number between 1 and 30");
            number = scanner.nextInt();
        }

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Summation");
                break;
            case 2:
                System.out.println("Subtraction");
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void switchCaseUpgrade(Scanner scanner) {
        System.out.println("You can choose a mathematical sign / operator");

        String choice = scanner.next();
        System.out.println(choice);
        switch (choice) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                System.out.println("You can choose a mathematical sign / operator");
                break;
            default:
                System.out.println("Invalid choice");
                break;

        }
        System.out.println("enter your first number");
        int firstNumber = scanner.nextInt();
        System.out.println("enter your second number");
        int secondNumber = scanner.nextInt();

        switch (choice) {
            case "+":
                System.out.println(firstNumber + secondNumber + " = " + (firstNumber + secondNumber));
                break;
            case "-":
                System.out.println(firstNumber - secondNumber + " = " + (firstNumber - secondNumber));
                break;
            case "*":
                System.out.println(firstNumber * secondNumber + " = " + (firstNumber * secondNumber));
                break;
            case "/":
                System.out.println(firstNumber / secondNumber + " = " + (firstNumber / secondNumber));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void arraysList(Scanner scanner) {
        System.out.println("You can choose an array list");
        System.out.println("1-Numbers");
        System.out.println("2-Decimals");
        System.out.println("3-Letters");
        System.out.println("4-Words");

        int[] numbers = {10, 20, 30, 40, 50};
        double[] decimals = {1.5, 2.75, 3.9, 4.6};
        char[] letters = {'A', 'B', 'C', 'D'};
        String[] words = {"Apple", "Banana", "Cherry", "Date"};

        System.out.println("Enter your choice (1-4)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("numbers: " + Arrays.toString(numbers));
                break;
            case 2:
                System.out.println("decimals: " + Arrays.toString(decimals));
                break;
            case 3:
                System.out.println("letters: " + Arrays.toString(letters));
                break;
            case 4:
                System.out.println("words: " + Arrays.toString(words));
                break;
            default:
                System.out.println("Invalid choice");
        }

        switch (choice) {

            case 1:
                System.out.println("Min/Max Calculated Started");
                System.out.println("numbers: " + Arrays.toString(numbers));

                int min = numbers[0];
                int max = numbers[0];

                for (int i = 1; i < numbers.length; i++) {
                    if (numbers[i] < min) {
                        min = numbers[i];
                        System.out.println("Checking number:" + numbers[i]);
                    }
                    if (numbers[i] > max) {
                        max = numbers[i];
                    }
                }
                System.out.println("Minimum: " + min);
                System.out.println("Maximum: " + max);
                break;
        }
    }
}













