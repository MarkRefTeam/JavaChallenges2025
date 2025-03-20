import java.util.Scanner;

public class ConvertNumberToWord {

    /**
     * Well we're starting the Convert Number to the word!
     * Well it's absolutely a new lessen , so ...How should we start?
     * In a first step we re-watched the last lesson for instruction!
     * Well I create the triple static array with numbers(words)!
     * After I need use the TDD(Test Driven Development) build, it will be so interest because
     * that the first time when I'm doing this!
     * <p>
     * How its work and what is this? After if im finish the static field the next step is open a new src
     * with Test phase! In a first try it will be False ,because I couldn't call a method for it!
     * So I must! Let's go and we will see what's happen!
     */


    //static basement:
    //Final = Final means that the variable can be assigned a value only once. After that, it cannot be modified!(override)
    //I don't knew that! Thanks Csongi!

    //1.Step!

    private static final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Nineteen" };
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "FifTY", "SixTY", "Seventy", "EightTY", "Ninety" };
    private static final String[] thousands = {"", "Thousand", "Million", "Billion" };

    //3.Step!

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number (One-Billion Number): ):");
        int number = sc.nextInt();
        System.out.println("In words: " + ConvertNumberToWord.convert(number));
        //System.out.println("DEBUG: '" + ConvertNumberToWord.convert(99) + "-");
        //System.out.println("DEBUG: " + convert(12345) + "-");
        //Well my Test isn't worked, so I upgrade with a " - " signal in output!
        //Debug success so don't need it anymore!
    }

    /**
     * I'm calling a new method for Test Phase!
     * So calling a String method with int number and return "" just for running!
     */

    //4.Step
    public static String convert(int num) {
        if (num < 20) {
            return ones[num];
        } else if (num < 100) {
            return tens[num / 10] + (num % 10 == 0 ? "" : " " + ones[num % 10]);
        } else if (num < 1000) {
            return ones[num / 100] + " Hundred" + (num % 100 == 0 ? "" : " " + convert(num % 100));
        } else {
            return (convert(num / 1000) + " " + thousands[(int) (Math.log10(num) / 3)] +
                    (num % 1000 == 0 ? "" : " " + convert(num % 1000))).trim();
        }

        /** Okay that homework was so crazy! Well I think im understand but need more practice!
         * let's talk about something's!
         *
         * 1. Convert : The convert(int num) method is responsible for transforming a number into words.
         * For example: convert(99) → Ninety-Nine.
         * It is the main logic of your program that executes the entire conversion.
         * It also uses recursive calls (calls itself) to handle larger numbers efficiently.
         * - We used it because our goal was to convert numbers into words.
         * - It makes the code cleaner and reusable.
         * I think I can understand it !!! Thank you!!!
         * <p>
         * 2.The trim() method is a String function that removes unnecessary spaces from the beginning and end of a text.
         * We used it because during number conversion, extra spaces can appear.
         * It ensures that the output is formatted correctly and clean.
         * I don't understand clearly , we should talk about them!
         * <p>
         * 3. The Math.log10(num) method calculates the base-10 logarithm of a number.
         * It tells us how many tens make up the number.
         * Examples :
         * Math.log10(10) = 1 → 10 is 10¹
         * Math.log10(100) = 2 → 100 is 10²
         * Math.log10(1000) = 3 → 1000 is 10³
         * We used it to determine how many digits the number has.
         * The expression thousands[(int) Math.log10(num) / 3] helps us decide if we should use "A Thousand", "A Million", or "A Billion".
         * That was the most confused part to me! I can learn it but need more task for this!
         * <p>
         * I did alone the static field,test phase and called the method for 1-999, after I used the AI for last step!
         */
    }

}