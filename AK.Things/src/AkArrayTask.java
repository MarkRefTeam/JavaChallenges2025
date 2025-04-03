import java.util.Arrays;
import java.util.Scanner;

public class AkArrayTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        doubleTypeArray(scanner);
        scanner.close();

        System.out.println("Dear User , actually i'm making the Array here for practice");
        System.out.println("how its work?");
        System.out.println("we learning now how can we build up! ");

        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Original Array: ");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + " : " + numbers[i]);
        }
        numbers[2] = 99;

        System.out.println("Modified Array: ");
        for (int num : numbers) {
            System.out.println(num);
        }
        System.out.println("Content" + Arrays.toString(numbers));
    }

    public static void doubleTypeArray(Scanner scanner) {

        double[] element = {1.1, 2.2, 3.3, 4.4, 5.5};
        char[] character = {'A', 'B', 'C', 'D', 'E', 'F'};

        System.out.println(Arrays.toString(element));
        System.out.println(Arrays.toString(character));

        for (int i = 0; i < element.length && i < character.length; i++) {
            System.out.println("Index" + i + " -> Number: " + element[i] + " Character: " + character[i]);
        }
    }
}


