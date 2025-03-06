import java.util.Scanner;

public class Number_Check {

    //Write a method that…

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = sc.nextInt();

        returnIfNumberIsPrime(number);              //returnIfNumberIsPrime
        sc.close();


        int testNumber = 10;
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        boolean result = isGreaterThan50(testNumber); //isGreaterThan50

        int firstNumber = 42;
        int secondNumber = 88;
        int thirdNumber = 75;
        int greatestNumber2 = Math.max(firstNumber, secondNumber);

        int first = 10;              //Numbers for firstNumIsDivisibleBySecond boolean!
        int second = 5;              //Numbers for firstNumIsDivisibleBySecond boolean!

        boolean isDivisible = firstNumIsDivisibleBySecond(first, second);   //firstNumIsDivisibleBySecond
        if (isDivisible) {
            System.out.println("First number" + first + "is divisible by" + second);
        } else {
            System.out.println("First number" + first + "is not divisible by " + second);
        }

        int a = 5;
        int b = 6;
        int c = 31;

        boolean result2 = isProductEqualToThird(a, b, c);                   //isProductEqualToThird
        if (result2) {
            System.out.println(a + " * " + b + " = " + c);
        } else {
            System.out.println(a + " * " + b + " ≠ " + c);                  // (≠) windows + R (Charmap)
        }

        if (isPrime(number)) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }

        String[] outputs = {
                thirdNumber + "is greater than 50?" + (thirdNumber > 50),   //We can change for "true"
                "First number : " + firstNumber,
                "Second number : " + secondNumber,
                "Third number : " + thirdNumber,
                "Greatest number : " + greatestNumber2
        };

        int greatestNumber = findGreaterNumber(firstNumber, secondNumber);   //findGreaterNumber

        System.out.println(testNumber + " is greater than 50? " + result);
        System.out.println("First number : " + firstNumber);
        System.out.println("Second number : " + secondNumber);
        System.out.println("Greatest number : " + greatestNumber);
        System.out.println(whichOneNumberIsGreater(10, 20));                //whichOneNumberIsGreater
        System.out.println(hasTwoNumbersWithSum(numbers, target));          //hasTwoNumbersWithSum
        System.out.println(repeatString("Hello", 3));                //repeatString
        System.out.println(repeatString("Java", 5));                 //repeatString
        System.out.println(repeatString("GP", 1));                   //repeatString

        String[] words1 = {"Hello", " ", "GP", "!"};
        String[] words2 = {"Java", " ", "is", " ", "fun!"};
        String[] words3 = {"I", " ", "love", " ", "coding!"};

        System.out.println(concatenateStrings(words1));                     //repeatString
        System.out.println(concatenateStrings(words2));                     //repeatString
        System.out.println(concatenateStrings(words3));                     //repeatString

        printNumbers();                          //printNumbers
        printWithBorders(outputs);               //printWithBorders
        printDivisibleByFive(50);        //printDivisibleByFive
        printCubicNumbers(4);                 //printCubicNumbers
        printCubicNumbersUpToN(64);           //printCubicNumbersUpToN

    }

    //Decides whether a number is greater than 50.
    //This method checks whether a given is greater than 50. It returns true if the number is greater
    //than 50 and false otherwise.

    public static boolean isGreaterThan50(int num) {

        return num > 50;
    }

    //Takes in two numbers and returns the greater one.
    //This method takes two number as input and returns the greater one. It uses a ternary operator to
    //compare the two values and returns the larger one!

    public static int findGreaterNumber(int num1, int num2) {

        return (num1 > num2) ? num1 : num2;
    }

    //Takes in two numbers and returns a String. Possible values:
    //1.The first number is greater.
    //2.The second number is greater.
    //3.The two numbers are equal.

    //This method compares two numbers and returns a string indicating which number is greater.
    //If they are equal , it returns a message starting that they are the same.

    public static String whichOneNumberIsGreater(int num1, int num2) {

        if (num1 > num2) {
            return "The first number is greater than the second number";
        } else if (num1 < num2) {
            return "The second number is greater than the first number";
        } else {
            return "The numbers are equal";
        }
    }

    //Writes all the numbers from 1 to 100 to the console.
    //This method prints all numbers from 1 to 100 to the console. It uses a simple for loop to iterate
    //from 1 to 100 and prints each number on a new line.

    public static void printNumbers() {

        for (int i = 0; i <= 100; i++) {
            System.out.print(i);
            if (i < 100) {
                System.out.print(", ");
            }
        }

        //That's variation is logical, but we kill the console...i would like call a "While"

        //int i = 1;
        //while (i <= 100) {
        //System.out.print(i);
        //i++;
    }

    //Extra Task: I just try something...actually it isn't finish yet but i will continue soon!
    //We should talk about this later! Thank you.
    //This method prints an array of Strings with a border around it.
    //It first determines the longest string in the array to ensure the border is correctly sized.
    //Then, it prints a top border, followed by each string with padding,
    //and finally, a bottom border to complete the frame.

    public static void printWithBorders(String[] outputs) {

        String text = "-*-";
        int maxLength = 0;

        for (String output : outputs) {
            if (output.length() > maxLength) {
                maxLength = output.length();
            }
        }

        int borderLength = maxLength + 6;
        String border = text.repeat(borderLength);
        System.out.println(border);

        for (String output : outputs) {
            System.out.println(text + "-*-" + output + "-*-" + text);
        }
        System.out.println(border);
    }

    //Gets in a number as an input parameter and writes all numbers that are divisible by 5 from 1 up to that number.
    //This method takes a number as an input parameter and prints all numbers from 1
    //up to that number that are divisible by 5.
    //It iterates through the numbers using a loop and checks
    //if each number is evenly divisible by 5 using the modulus operator %.
    //If the remainder is 0, the number is printed.

    public static void printDivisibleByFive(int number) {

        System.out.println("Numbers divisible by 5 : " + number + " : ");
        for (int i = 1; i <= number; i++) {
            if (i % 5 == 0) {
                System.out.print(i + "  ");
            }
        }
        System.out.println();
    }

    //Gets in a number and returns whether that number is a prime number.
    //This method takes a number as an input and checks whether it is a prime number.
    //A prime number is a number greater than 1 that has only two divisors: 1 and itself.
    //The method iterates from 2 up to the square root of the number and checks
    //if it is divisible by any of these numbers using the modulus operator %.
    //If it finds a divisor, it returns false; otherwise, it returns true.
    //I added a scanner in main for call a number from user.

    public static void returnIfNumberIsPrime(int number) {

        if (number < 2) {
            System.out.println(number + " is not a prime number");
            return;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.println(number + " is not a prime number");
                return;
            }
        }
        System.out.println(number + " is a prime number");
    }

    //Extra Task :
    // Checks whether a given number is a prime number.
    // A prime number is a number greater than 1 that has no divisors other than 1 and itself.
    // The method iterates from 2 up to the square root of the number (Math.sqrt(number)),
    // since any larger factor would have a corresponding smaller factor that has already been checked.
    // If a divisor is found, the method returns false; otherwise, it returns true.

    public static boolean isPrime(int number) {
        if (number < 2) return false;                       // Numbers less than 2 are not prime
        for (int i = 2; i <= Math.sqrt(number); i++) {      // Loop from 2 to √number
            if (number % i == 0) return false;              // If divisible, it's not prime
        }
        return true;                                        // If no divisors found, it's a prime number
    }

    //Gets in two numbers and returns whether the first is divisible by the second one.
    // Checks whether the first number is divisible by the second number.
    // A number is divisible by another if the remainder of their division is 0.
    // The method returns true if the first number is evenly divisible by the second, otherwise, it returns false.

    public static boolean firstNumIsDivisibleBySecond(int first, int second) {

        return first % second == 0;    // If remainder is 0, the first number is divisible by the second
    }

    //Gets in three numbers and returns whether the product of the first and second numbers is equal to the third one.
    // Checks whether the product of the first and second numbers equals the third one.
    // The method multiplies num1 and num2 and compares the result with num3.
    // If they are equal, it returns true; otherwise, it returns false.

    public static boolean isProductEqualToThird(int num1, int num2, int num3) {

        return num1 * num2 == num3;
    }

    //Gets in a number (n) and writes the first n cubic numbers to the console. Example: n=3 → Output: 1, 8, 27
    // Writes the first n cubic numbers to the console.
    // It iterates from 1 to n and prints the cube of each number.
    // Example: n=3 → Output: 1, 8, 27

    public static void printCubicNumbers(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println((i * i * i) + " ");
        }
        System.out.println();
    }

    //Gets in a number (n) and writes the cubic numbers to the console up to that number. n=64 → Output: 1, 8, 27, 64
    // Writes all cubic numbers up to the given number n.
    // It iterates from 1 upwards, calculating the cube of each number,
    // until the cube exceeds n. Only valid cubic numbers are printed.
    // Example: n=64 → Output: 1, 8, 27, 64

    public static void printCubicNumbersUpToN(int n) {
        for (int i = 1; i * i <= n; i++) {
            System.out.println((i * i * i) + " ");
        }
        System.out.println();
    }

    //Gets in an array and a number and returns whether the sum of any two numbers
    //at different indexes can add up to that number.
    // Checks whether the sum of any two different numbers in the array equals the given number.
    // The method iterates through the array and checks every possible pair of elements.
    // If a pair sums up to the given number, it returns true. Otherwise, it returns false.

    public static boolean hasTwoNumbersWithSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //Gets in a String and a positive number and returns the String repeated n times.
    //If the number is smaller than 1, return an empty String. Don’t use the string’s in-built repeat method!
    // Repeats a given String n times and returns the result.
    // If n is less than 1, the method returns an empty String.
    // Instead of using the built-in repeat() method, it concatenates the String manually.

    public static String repeatString(String str, int n) {
        if (n < 1) {
            return "";
        }

        String result = "";
        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }

    //Gets in an array of Strings and concatenates them into one String.
    // Concatenates all Strings in an array into a single String.
    // The method iterates through the array and appends each String to a StringBuilder.
    // Finally, it returns the concatenated result as a String.

    public static String concatenateStrings(String[] words) {
        String result = "";

        for (String word : words) {
            result += word;
        }
        return result;
    }
}


























