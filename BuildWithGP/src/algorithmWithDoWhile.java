import java.util.Scanner;

public class algorithmWithDoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter number between 1 and 10");
        int number = sc.nextInt();
        int wrongInputCounter = 0;

        do {
            if (number < 1 || number > 10) {
                System.out.println("Enter number between 1 and 10");
                wrongInputCounter++;

                if (wrongInputCounter > 5) {
                    System.out.println("Invalid choice! Too many wrong attempts. Exiting...");
                    return;
                }

                number = sc.nextInt();
            }
        } while (number < 1 || number > 10);

        System.out.println("Valid input received: " + number);

        sc.close();
    }


}





