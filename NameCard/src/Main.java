import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        /** Well , I had a problem with special charters (Example : ű)
         * So the StandardCharsets.UTF_8 is really great here! Just import for the program and it's working!
         */


        System.out.print("Name");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Age: ");
            String ageInput = scanner.nextLine().trim();

            try {
                age = Integer.parseInt(ageInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid age! Do you want to enter again? (Y/N)");
                String choice = scanner.nextLine().trim();
                if (!choice.equalsIgnoreCase("Y")) {
                    System.out.println("Invalid age! Setting age to 0.");
                    age = 0;
                    break;
                }
            }
        }
        scanner.nextLine();
        System.out.print("Email");
        String email = scanner.nextLine();
        System.out.print("Phone number");
        String phone = scanner.nextLine();
        System.out.print("Social");
        String social = scanner.nextLine();
        System.out.print("Extra");
        String extra = scanner.nextLine();

        // If you don't sure in your personal information you can change here!

        while (true) {
            System.out.println("Actually your information's");
            System.out.println("1 - Name: " + name);
            System.out.println("2 - Age: " + age);
            System.out.println("3 - Email: " + email);
            System.out.println("4 - Phone: " + phone);
            System.out.println("5 - Social: " + social);
            System.out.println("6 - Extra: " + extra);
            System.out.println("7 - Sure, we can continue");

            System.out.println("Do you like modify something? Just choose an option");
            String option = scanner.nextLine().trim();

            String choice = "";

            switch (option) {
                case "1":
                    System.out.print("Name: ");
                    name = scanner.nextLine();
                    break;
                case "2":
                    while (true) {
                        System.out.print("Age: ");
                        String newAgeInput = scanner.nextLine().trim();
                        try {
                            age = Integer.parseInt(newAgeInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid age! Do you want to enter again? (Y/N)");
                            choice = scanner.nextLine().trim();
                            if (!choice.equalsIgnoreCase("Y")) {
                                System.out.println("Invalid age! Setting age to zero.");
                                break;
                            }
                        }
                    }
                    break;

                case "3":
                    System.out.print("New email: ");
                    email = scanner.nextLine();
                    break;
                case "4":
                    System.out.print("New Phone: ");
                    phone = scanner.nextLine();
                    break;
                case "5":
                    System.out.print("New Social: ");
                    social = scanner.nextLine();
                    break;
                case "6":
                    System.out.print("New Extra: ");
                    extra = scanner.nextLine();
                    break;
                case "7":
                    System.out.println("All Data is fine, continue");
                    break;
                default:
                    System.out.println("wrong option! Try again");
                    continue;
            }

            if ("7".equals(choice))
                break;

            scanner.close();

            int maxLabelLength = "E-mail".length();

            int maxValueLength = Math.max(name.length(),
                    Math.max(email.length(),
                            Math.max(phone.length(),
                                    Math.max(social.length(), extra.length()))));

            int frameWidth = maxLabelLength + maxValueLength + 5;


            String divider = "-".repeat(frameWidth + 4);

            System.out.println(divider);
            System.out.printf("| Name: %-" + (maxValueLength) + "s     |\n", name);
            System.out.println(divider);
            System.out.printf("| Age:  %-" + (maxValueLength) + "s     |\n", age);
            System.out.println(divider);
            System.out.printf("| E-mail: %-" + (maxValueLength) + "s   |\n", email);
            System.out.println(divider);
            System.out.printf("| Phone:  %-" + (maxValueLength) + "s   |\n", phone);
            System.out.println(divider);
            System.out.printf("| Social: %-" + (maxValueLength) + "s   |\n", social);
            System.out.println(divider);
            System.out.printf("| Extra:  %-" + (maxValueLength) + "s   |\n", extra);
            System.out.println(divider);


        }
    }
}

