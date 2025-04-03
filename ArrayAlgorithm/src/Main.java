import java.util.Arrays;

public class Main {

    //Create an array with predefined values
    //you don't need to get input from the user.
    //Then, perform the following operations:

    static int[] numbers = {23, 45, 78, -10, 150, 3, 7, 8, 100, 73, 22, -50, 200};

    public static void main(String[] args) {

        System.out.println("Welcome to reflection algorithm");

        boolean isSafe = isSafe(numbers);

        if (isSafe) {
            System.out.println("Proceeding with further operations");
            System.out.println("-");   //Extra line for better readability.
            System.out.println("No elements in array");
        } else {
            System.out.println("Halting execution due to unsafe array.");
            System.out.println("-");   //Extra line for better readability.
            System.out.println("The array is safe to use");
        }

        System.out.println("Number of elements in array: " + Arrays.toString(numbers));
        System.out.println("-");
        performArrayOperations();

        //Print the largest element of the array.
        //Print the smallest element of the array.

        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);

        //Count how many elements are greater than 100.
        //Count how many elements are between -50 and 78.
        //Count how many elements are divisible by 2.
        //Count how many elements are not divisible by 3.
        //Count how many times the number 73 can be found in that array.

        int countGreaterThan100 = 0;

        for (int num : numbers) {
            if (num > 100) {
                countGreaterThan100++;
            }
        }
        System.out.println("Number of elements greater than 100: " + countGreaterThan100);

        int countBetween = 0;
        for (int num : numbers) {
            if (num >= -50 && num <= 78) {
                countBetween++;
            }
        }
        System.out.println("Number of elements between 50 and 78: " + countBetween);

        int countDivisibleBy2 = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                countDivisibleBy2++;
            }
        }
        System.out.println("Number of elements divisible by 2: " + countDivisibleBy2);

        //I renamed the variable for better readability.

        int countNotDivisibleBy3 = 0;
        for (int num : numbers) {
            if (num % 3 != 0) {
                countNotDivisibleBy3++;
            }
        }
        System.out.println("Number of elements not divisible by 3: " + countNotDivisibleBy3);

        //I renamed the variable for better readability.

        int occurrences73 = 0;
        for (int num : numbers) {
            if (num == 73) {
                occurrences73++;
            }
        }
        System.out.println("Occurrences of 73:  " + occurrences73);

        //Check if the number 100 can be found in that array.
        //Check if any number greater than 100 can be found in that array.
        //Print the index of the first occurrence of 7 in the array - if 7 is not present, print -1.

        //I renamed the variable for better readability.

        boolean is100Found = false;
        for (int num : numbers) {
            if (num == 100) {
                is100Found = true;
                break;
            }
        }
        System.out.println("Is 100 in the array? " + is100Found);

        //I renamed the variable for better readability.

        int firstOccurrenceIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 7) {
                firstOccurrenceIndex = i;
                break;
            }
        }
        System.out.println("Index of first occurrance of 7: " + firstOccurrenceIndex);

        int num;
        for (int currentNum : numbers) {
            num = currentNum;

            System.out.println("Current num: " + num);

            int[] arrayForSum = new int[8];

            for (int i = 0; i < arrayForSum.length; i++) {
                arrayForSum[i] = num * 2;
            }
            System.out.println("Sum of array: " + Arrays.toString(arrayForSum));
        }

        System.out.print("Index: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();   //Extra line for better readability.

        int sum = 0;
        for (int currentNum : numbers) {
            sum += currentNum;
        }
        System.out.println("Sum: " + sum);
        System.out.println();   //Extra line for better readability.

        System.out.println();   //Extra line for better readability.
        System.out.println("Skipping every fourth element");


        //I renamed the variable for better readability.
        //I fixed the results in "for"

        System.out.print("Usage: ");
        int alternatingSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i % 4 == 3) {
                alternatingSum += numbers[i];
                System.out.print("+");
            } else {
                alternatingSum -= numbers[i];
                System.out.print("-");
            }
        }
        System.out.println("Special Sum: " + alternatingSum);
    }

    public static boolean isSafe(int[] array) {

        System.out.println("Protection and Safety");
        return array.length != 0;
    }

    public static void performArrayOperations() {

        int sum = 0;
        int product = 1;

        for (int num : numbers) {
            sum += num;
            product *= num;
        }
        System.out.println("Sum of array: " + sum);
        System.out.println("Product of array: " + product);
    }
}








































