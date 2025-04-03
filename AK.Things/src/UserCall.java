import java.util.Scanner;

public class UserCall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Call a number from user!
        //if number is higher than 5 ,write it!
        //if the number is smaller than 5 , write it!

        System.out.println("Please enter your number: ");
        int number = scanner.nextInt();

        if (number >= 5) {
            System.out.println("Your number is greater than 5");
        } else {
            System.out.println("Your number is less than 5");
        }
        scanner.close();
    }


}

