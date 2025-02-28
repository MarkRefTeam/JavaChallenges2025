import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Write a short program that asks a number from the user.
        //If the user
        //enters an invalid number (smaller than 1), keep asking the number until the user enters a
        //valid input.
        //If the input is valid, print all the number from 1 to that number to the console.
        //For each multiple of 3, print "Fizz" instead of the number.
        //For each multiple of 5, print "Buzz" instead of the number.
        //For numbers which are multiples of both 3 and 5, print "FizzBuzz" instead of the number.
        //You can find a detailed explanation at the end.

        System.out.println("Please enter a number: ");

        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Incorrect number , you should restart the program ");
        } else {
            for (int i = 0; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        }
        scanner.close();
    }
}

//How its work?
//Well the program calling the user for enter a number and when it's happen two things are possible.
//First option : if the user enter a number lass than 1, the program displays: "Incorrect number ,
//you should restart the program"
//If the number is higher than 1 , the IF-ELSE combination will be workable!(Line 21-32)
//Printing numbers based on FizzBuzz rules! "if n" is valid ,the "for" loop iterates from 1 to n.
//For each number must follow this conditions:
//1:if the number is divisible by both 3 and 5;(it prints "FizzBuzz")
//2:if the number is only divisible by 3 (it prints "Fizz")
//3:if the number is only divisible by 5 (it prints "Buzz")
//4:if the number does not meet any condition (it simply prints the number itself.)

//After printing all numbers following the FizzBuzz logic, the scanner.close(); statement closes
//the Scanner object!

//Thank you very much && yes I used help ,but it will be completely possible on my own.

