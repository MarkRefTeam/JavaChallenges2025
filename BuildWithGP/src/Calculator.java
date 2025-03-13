import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Calculator {

    //ctrl+r you can rename all with it!

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("We build calculator , so good luck");

        while (true) {
            System.out.println("Choose an operation please: ");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulo");
            System.out.println("6. Exponentiation");
            System.out.println("7. Square Root");
            System.out.println("8. Square");
            System.out.println("9. Exit");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();


            if (choice == 9) {
                System.out.println("Exit");
                break;
            }

            System.out.println("Enter your first number: ");
            int first = scanner.nextInt();
            System.out.println("Enter your second number: ");
            int second = scanner.nextInt();

            int result;
            switch (choice) {
                case 1:
                    result = sum(first, second);
                    System.out.println("The result is: " + result);
                    break;
                case 2:
                    result = subtract(first, second);
                    System.out.println("The result is: " + result);
                    break;
                case 3:
                    result = multiply(first, second);
                    System.out.println("The result is: " + result);
                    break;
                case 4:
                    if (second == 0) {
                        System.out.println("Error : Division by zero is not allowed");
                    } else {
                        result = divide(first, second);
                        System.out.println("The result is: " + result);
                    }
                    break;
                case 5:
                    result = modulo(first, second);
                    System.out.println("The result is: " + result);
                    break;
                case 6:
                    double result2 = exponentiation(first, second);
                    System.out.println("The result is: " + result2);
                    break;
                case 7:
                    System.out.println("Enter a number: ");
                    int number = scanner.nextInt();
                    double sqrtResult = squareRoot(number);
                    System.out.println("The result is: " + sqrtResult);
                    break;
                case 8:
                    System.out.println("Enter a number: ");
                    int num = scanner.nextInt();
                    double squareResult = square(num);
                    System.out.println("The result is: " + squareResult);
                    break;
                    case 9:
                        System.out.println("Exit");
                        break;
                default:
                    System.out.println("Invalid operation");

            }
        }
        scanner.close();
    }


    public static int sum(int first, int second) {

        return first + second;
    }

    public static int multiply(int first, int second) {

        return first * second;
    }

    public static int subtract(int first, int second) {

        return first - second;
    }

    public static int divide(int first, int second) {

        return first / second;
    }

    public static int modulo(int first, int second) {

        return first % second;
    }

    public static double exponentiation(int base, int exponent) {

        return Math.pow(base, exponent);
    }

    public static double square(int number) {

        return Math.pow(number, 2);
    }

    public static double squareRoot(int number) {

        return Math.pow(number, 2);
    }
}


