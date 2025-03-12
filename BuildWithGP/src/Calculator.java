import java.util.Scanner;

public class Calculator {

    //ctrl+r you can rename all with it!

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("We build calculator , so good luck");

        //int number = scanner.nextInt();
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        //int third = scanner.nextInt();
        //int fourth = scanner.nextInt();

        //System.out.println(number);

        int result = multiply(first, second);
        System.out.println(result);
        int result2 = sum(first, second);
        System.out.println(result2);

    }

    public static int sum(int first, int second) {
        return first + second;
    }

    public static int multiply(int first, int second) {
        return first * second;
    }
}
