package org.example;

import java.util.ArrayList;
import java.util.List;

public class OneDimensionalApp {

//Return the average of all even numbers in an array of integers.

    public static double getEvenAverage(int[] numbers) {
        int sum = 0;
        int count = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                sum += num;
                count++;
            }
        }

        if (count == 0) {
            return 0;
        } else {
            return (double) sum / count;
        }
    }

    //Return a new array with each number squared only
    //if the original number was odd. If the original.

    public static int[] evenTakeOddSkip(int[] numbers) {

        List<Integer> result = new ArrayList<>();

        for (int num : numbers) {
            if (num % 2 != 0) {
                result.add(num * num);
            }
        }

        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    //Return the number of strings that start with the letter 'a' or 'A'

    //word.toLowerCase() -> converts the whole word to lowercase
    //(e.g., "Apple" becomes "apple")!
    //.startsWith("a") -> checks if the word starts with the letter "a"!

    public static int countStartWithA(String[] words) {
        int count = 0;
        for(String word : words) {
            if(word.toLowerCase().startsWith("a")) {
                count++;
            }
        }
        return count;
    }

    //Return the concatenation of all strings
    //that are longer than 3 characters.

    public static String concatLongStrings(String[] words) {

        StringBuilder result = new StringBuilder();

        for(String word : words) {
            if(words.length > 3) {
                result.append(word);
            }
        }
        return result.toString();
    }

    //Return true if the array of integers contains any consecutive duplicates.

    public static boolean hasConsecutiveDuplicates(int[] numbers) {

        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] == numbers[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
