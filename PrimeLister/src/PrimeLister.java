import java.util.Scanner;

public class PrimeLister {

    /**
     * Write an application called PrimeLister. The application has the following specification:
     * The app asks a number from the user. If the number is valid ->
     * (it is an integer between 2 and 2_000_000_000), then list all the primes between 1 and the given number.
     * Handle all types of invalid inputs - if the user has given an invalid input more than 5 times, exit the
     * application.
     */

    //We call a boolean for check the number!(1.Step)

    public static boolean isValidNumber(int number) {
        return number >= 2 && number <= 2_000_000_000;
    }

    //We must check it's a Prime number!(3.Step)

    public static boolean isPrime(int n) {
        if (n < 2) return false;       //if the number is smaller than 2 we will return with false!
        if (n == 2) return true;       //if the number is equal with 2 we will return with true!
        if (n % 2 == 0) return false;  //If the number is even and not 2, it cannot be a prime.

        //if the number is divisible by something , its cannot be a prime!

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int attempts = 0;  //That's how many call was fail!
        int number = 0;    //That's will save the correct number!

        //Okay , we call a number and it must be valid!
        //How should we do this? Well in a first step im doing a boolean "isValidNumber"
        // and return to the Main with a true! How I mean ?
        //I use a simple while cycle with if-else build!

        while (true) {            //(2.Step)
            System.out.println("Please enter your number between 2 and 2.000.000.000");

            if (scanner.hasNextInt()) {
                number = scanner.nextInt();

                if (isValidNumber(number)) {
                    break;       //If the number is correct , it's leave from cycle!
                } else {
                    System.out.println("That was invalid number and it must be an integer between 2 and 2.000.000.000");
                }
            } else {             // Okay we give more one chance for pull a correct number!
                System.out.println("Invalid input! Please enter an integer between 2 and 2.000.000.000");
                scanner.nextLine();
            }

            attempts++;
            if (attempts >= 5) {
                System.out.println("Too many invalid attempts! Exiting...");   //Okay ,it's never mind!
                System.exit(0);
            }
        }

        //And for last things we need an output! (4.Step)

        System.out.println("Prime numbers between 1 and " + number + ":");

        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
