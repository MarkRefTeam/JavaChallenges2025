import java.util.Scanner;

public class SquareNumberLister {

    /**
     * I call a new src for clean and readable coding!
     * That's will be the square with choose options!
     * Just call a normal switch statement, nothing special!
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 2 and 2_000_000_000");
        int number = scanner.nextInt();

        System.out.println("Choose an option:");
        System.out.println("1 . - List Prime Numbers");
        System.out.println("2 . - List Square Numbers");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                listPrimes(number);
                break;
            case 2:
                listSquareNumbers(number);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void listPrimes(int number) {
        System.out.println("Prime numbers:");
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                System.out.println(i + " ");
            }
        }
        System.out.println();
    }

    public static void listSquareNumbers(int number) {
        System.out.println("Square numbers:");
        for (int i = 1; i * i <= number; i++) {
            System.out.println((i * i) + " ");
        }
        System.out.println();
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
