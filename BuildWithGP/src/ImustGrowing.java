import java.util.Scanner;

public class ImustGrowing {

    static int a = 10;
    static int b = 5;
    static int c = 3;
    static int d = 2;
    static int e = 6;
    static int f = 4;
    static int j = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter five numbers: ");
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        int g = scanner.nextInt();
        int h = scanner.nextInt();
        int i = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        double result = mathTask2(e, f, g, h, i);
        System.out.println("result: " + result);

        double result3 = mathTask4();
        System.out.println("result3: " + result3);

        double result5 = mathTask5(x,y,z);
        System.out.println("result5: " + result5);

        mathTask3(j, d, a, b, c);

        boolean resultBL = isTwoEqualNumber(num1,num2);
        System.out.println("resultBL: " + resultBL);

        scanner.close();

        //Math Task :
        //(10 + 5 * 3) / 2
        //int sum = (a + b * c / d);   //Ha egész szám!

        double sum = (a + b * (double) c / d);  //Ha tízedes szám eredménye kell!
        System.out.println(sum);

    }

    public static double mathTask2(int e, int f, int g, int h, int i) {

        //12 % 5 + 4 * (6 / 2)

        return (e % f + g * ((double) h / i)) / f;

    }

    public static void mathTask3(int j, int d, int a, int b, int c) {

        //(8 + 2) * (10 / 5) - 3

        double result2 = (j + d) * ((double) a / b) - c;
        System.out.println("Result: " + result2);
    }

    public static double mathTask4() {

        //((a + b) * (c - d)) / (e % f + 1)
        return ((a + b) * (c - d)) / ((double) e % f + 1);

    }

    public static double mathTask5(int x,int y,int z) {

        //((x + y ) / z) * (a - b + c) % d
        return ((x + y) / (double) z) * (a - b + c) % d;
    }

    //W call two number from user!
    //If the two number is equal the result is "equal or true" too.
    //If this two number isn't equal the result is "false".

    public static boolean isTwoEqualNumber(int num1, int num2) {
        if (num1 == num2) {
            return true;
        } else {
            return false;
        }




    }
}











