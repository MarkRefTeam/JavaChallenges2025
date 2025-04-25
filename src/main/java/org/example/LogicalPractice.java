package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogicalPractice {

    public static void main(String[] args) {


    }

    public static int[] searchingNumbers(int[] numbers) {

        //Logic: we're searching numbers between 30 and 100!
        //and return with int[] numbers!
        //Let's go!

        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            if (number > 30 && number <= 100 && number % 2 == 0) {
                result.add(number);
            }
        }
        int[] filtered = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            filtered[i] = result.get(i);
        }
        return filtered;
    }

    public static int[] NumberHunting1(int[] numbers) {

        //Logic: return number when it's higher than 200 and Even!

        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            if (number > 200 && number % 2 == 0) {
                result.add(number);
            }
        }
        int[] filtered = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            filtered[i] = result.get(i);
        }
        return filtered;
    }

    public static int[] NumberHunting2(int[] numbers) {

        //Logic: searching numbers if higher than 100 and divisible by 5!

        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            if (number > 100 && number % 5 == 0) {
                result.add(number);
            }
        }
        int[] filtered = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            filtered[i] = result.get(i);
        }
        return filtered;
    }

    public static int[] NumberHunting3(int[] numbers) {

        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            if (number < 50 || number % 4 == 0) {
                result.add(number);
            }
        }
        int[] filtered = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            filtered[i] = result.get(i);
        }
        return filtered;
    }

    public static int forLoopPractice(int[] numbers) {

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 50 && numbers[i] % 3 == 0) {
                sum += numbers[i];
            }
        }
        return sum;
    }

    public static int divisibleBy3and5(int[] numbers) {

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 60 && numbers[i] > 150 &&
                    (numbers[i] % 4 != 0 && numbers[i] % 3 == 0 || numbers[i] % 5 == 0)) {
                sum += numbers[i];
            }
        }
        return sum;
    }

    public static int EvenNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 == 0 && number < 100) {
                sum += number;
            }
        }
        return sum;
    }

    //We are learning a new exams! That will be the MethodSource and Stream!
    //Here is just a program for Test Phase!

    public static int[] getOnlyPositive(int[] numbers) {

        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            if (number > 0) {
                result.add(number);
            }
        }
        //int[] positiveArray = new int[result.size()];
        //for (int i = 0; i < result.size(); i++) {
        //positiveArray[i] = result.get(i);  // autoboxing: Integer → int
        //}

        //return positiveArray;
        //}

        //That variation is all in one!

        return result.stream().mapToInt(i -> i).toArray();


    }

    public static int[] getOnlyNegative(int[] numbers) {

        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            if (number < 0) {
                result.add(number);
            }
        }
        int[] negativeArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            negativeArray[i] = result.get(i);
        }
        return negativeArray;
    }

    public static int[] numberIsDivisibleBy3(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 3 == 0)
                .toArray();
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static int[] getOnlyPrimes(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(LogicalPractice::isPrime)
                .toArray();
    }
}
