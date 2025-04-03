import java.util.Scanner;

public class AKTask {

    static int staticFieldExample;
    int instanceFieldExample;

    public static void main(String[] args) { //args:Parameter
        int localVariableExample = 0; // local variable

        System.out.println("Welcome to Java");

        //Scanner - Scanner osztály
        //scanner - egy konkrét példány

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt(); //Usertől be kérek egy számót!
        System.out.println(number); //Console-ra kiíratom a számót!

        System.out.println("Please enter your name");
        String name = scanner.next();

        System.out.println("Please enter your age");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter your email");
        String email = scanner.next();

        System.out.println("--------------------------------");
        System.out.println(name);
        System.out.println("--------------------------------");
        System.out.println(age);
        System.out.println("--------------------------------");
        System.out.println(email);
        System.out.println("--------------------------------");


        String text = " - ";  //A szöveg meghívása!
        System.out.println(text.repeat(number)); //Esetleges ismétlődés!


        System.out.printf("%-30s This is the free place for your name %30s%n", "", "Márk");

        System.out.println("The lenght of the name is " + name.length());
        System.out.printf("The lenght of the name is %d%n", +name.length()); // egész szám megadása+új sor!
        System.out.printf("The lenght of the email address is" + email.length()); //email hosszát adom meg!

        //if statement

        if (true) {
            System.out.println("This allways gets written to the concole");
        }

        if (false) {
            System.out.println("This never gets written to the concole");
        }

        boolean isNameLong = name.length() > 9; //A név hossza itt megadható!

        if (isNameLong) {
            System.out.println("This name is too long"); //9 karakter alatt túl hosszú
        } else {
            System.out.println("This name is too short"); //9 karakter felett túl rövid!
        }

        boolean isAgeLong = age >= 125;
        if (isAgeLong) {
            System.out.println("This age incorrect");
        } else {
            System.out.println("This age is " + age);
        }

        //Amennyiben a nev hosszabb
        //Ismételje " - " karaktert annyiszor mint a név hossza!
        //Ha az email hoszabb
        //Ismételje " - " karaktert annyiszor mint a email hossza!

        if (name.length() > email.length()) {
            System.out.println(text.repeat(name.length()));
        }
        if (email.length() > name.length()) {
            System.out.println(text.repeat(email.length()));
        }

        System.out.println(text.repeat(name.length())); //Név hossza!
        System.out.println(text.repeat(email.length())); //Email hossza!

    }
}

