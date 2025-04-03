import java.util.Arrays;
import java.util.Scanner;

public class ImustGrowing2 {

    static int[] arr = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //We call two number from User!
        //if number is even return true to the main.
        //if number is odd return false to the main.

        System.out.println("Enter a number: ");

        int number = scanner.nextInt();
        int year = scanner.nextInt();

        boolean result = isEvenNumber(number);
        if (result) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }

        boolean resultYear = isLeapYear(year);
        if (resultYear) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not Leap year");
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        System.out.println("Numbers of elements: " + Arrays.toString(arr));
        System.out.println("-");


        scanner.close();

    }

    public static boolean isEvenNumber(int number) {

        return number % 2 == 0;
    }

    public static boolean isLeapYear(int year) {

        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}



