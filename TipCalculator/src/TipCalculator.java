import java.util.Scanner;

public class TipCalculator {

    //I changed the project and method name :)


    //This method calculates the tip based on a given percentage.
    // If the percentage is between 10 and 80, it returns the calculated tip amount.
    // If the percentage is invalid, it returns -1./

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);     //I call a scanner here!

        //Cash or Card?
        selectPaymentMethod(scanner);

        int[] prices = {2000, 250, 300, 50, 250};

        System.out.println(calculateTip(prices, 20));     //Expected output: 570 (valid)
        System.out.println(calculateTip(prices, 5));      //Expected output: -1 (too low)
        System.out.println(calculateTip(prices, 90));     //Expected output: -1 (tpp high)

        /** So many options for upgrade :)
         * Survey!!!!
         **/

        System.out.println("Dear Customer!Thank you very much for visiting our restaurant! We hope you had a pleasant experience.");
        System.out.println("If you have just one more minute, we would greatly appreciate your feedback on our service.");
        System.out.println("Please rate the service from 1 to 5, where 1 means poor and 5 means excellent.");
        System.out.println("Your opinion matters to us, and it helps us improve! ");

        System.out.println("Please enter your rating for the meal (1-5) :) ");
        int mealRating = getValidRating(scanner);

        System.out.println("Please enter your rating for the service (1-5) :) ");
        int serviceRating = getValidRating(scanner);

        System.out.println("Thank you very much and have a nice day! Your meal rating: " + mealRating + " and service rating: " + serviceRating);
    }

    public static int getValidRating(Scanner scanner) {
        int rating;

        while (true) {         //I add a "while" for wrong inputs!
            if (scanner.hasNextInt()) {
                rating = scanner.nextInt();
                if (rating >= 1 && rating <= 5) {   //If the vote is success we quit from while!
                    break;
                } else {
                    System.out.println("Your rating is out of range , please enter a number between 1 and 5");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5");
                scanner.nextLine();
            }
        }
        return rating;
    }

    /**
     * The main entry point of the program where we validate input percentages
     * and calculate the tip based on the prices of purchased items.
     * <p>
     * Note: Testing is done separately in TipCalculatorTest.
     */

    //Testing the calculateTip method with different percentage values.

    public static int calculateTip(int[] prices, int percentage) {

        //We used the isValidPercentage() method to check if the percentage is within the allowed range.

        if (!isValidPercentage(percentage)) {
            System.out.println("Invalid percentage");
            return -1;
        }
        //Calculate the bill amount using the sumPrices method
        int total = sumPrices(prices);

        //Calculate the tip: total amount * percentage / 100
        return (total * percentage) / 100;
    }

    //We called a boolean method to check whether the given percentage is valid.

    public static boolean isValidPercentage(int percentage) {
        return percentage >= 10 && percentage <= 80;
    }

    public static int sumPrices(int[] prices) {
        int sum = 0;                                            //Initialize sum to zero
        for (int price : prices) {                              //Iterate through all elements in the array
            sum += price;                                       //Add each price to the total sum
        }
        return sum;                                             //Return the final total amount
    }

    public static void selectPaymentMethod(Scanner scanner) {
        while (true) {
            System.out.println("Please enter your payment method: (1) Cash , (2) Credit Card");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("You have chosen to pay with cash");
                    break;
                } else if (choice == 2) {
                    System.out.println("You have chosen to pay with credit card");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 for Cash or 2 for Credit Card");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 or 2");
                scanner.next();
            }
        }
    }
}
