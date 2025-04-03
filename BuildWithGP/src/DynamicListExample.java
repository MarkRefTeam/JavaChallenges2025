import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int contains = scanner.nextInt();
        System.out.println(contains);

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Elements of list: " + numbers);
        numbers.removeFirst();
        System.out.println("Elements of list after delete: " + numbers);

        for (int number : numbers) {
            System.out.println(number);
        }

        if (numbers.contains(20)) {
            System.out.println("Elements of list contains 20");
        } else {
            System.out.println("Elements of list does not contain 20");
        }

        scanner.close();
    }
}
