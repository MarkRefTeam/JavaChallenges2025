package hu.markrefteam.people;

import hu.markrefteam.people.dao.PersonDao;
import hu.markrefteam.people.model.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final PersonDao personDao = new PersonDao();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Choice: ");

            switch (choice) {
                case 1 -> listAll();
                case 2 -> findById();
                case 3 -> insertPerson();
                case 4 -> updatePerson();
                case 5 -> deletePerson();
                case 0 -> {
                    System.out.println("Exit, bye!");
                    return;
                }
                default -> System.err.println("Wrong menu point.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                
                ===== PEOPLE MENU =====
                1) List all
                2) Find by id
                3) Insert
                4) Update
                5) Delete
                0) Exit
                """);
    }

    private static void listAll() {
        personDao.findAll().forEach(System.out::println);
    }

    private static void findById() {
        int id = readInt("ID: ");
        Optional<Person> p = personDao.findById(id);
        System.out.println(p.map(Object::toString).orElse("Wrong ID."));
    }

    private static void insertPerson() {
        Person p = readPersonData(null);
        Person saved = personDao.insert(p);
        System.out.println("Inserted: " + saved);
    }

    private static void updatePerson() {
        int id = readInt("Which one id should update? ");
        Person p = readPersonData(id);
        Person updated = personDao.update(p);
        System.out.println("Updated: " + updated);
    }

    private static void deletePerson() {
        int id = readInt("Which id should delete? ");
        boolean ok = personDao.deleteById(id);
        System.out.println(ok ? "Delete." : "Don't had this ID.");
    }

    // --- input helpers ---

    private static Person readPersonData(Integer id) {
        String firstName = readString("first_name: ");
        String lastName = readString("last_name: ");
        String motherName = readString("mother_name (enter=skip): ");
        String fatherName = readString("father_name (enter=skip): ");

        LocalDate birthDate = readDateOrNull("birth_date (YYYY-MM-DD, enter=skip): ");
        Gender gender = readEnum("gender (MALE/FEMALE/OTHER): ", Gender.class);
        HighestEducation edu = readEnum("highest_education (ELEMENTARY_SCHOOL/HIGH_SCHOOL/VOCATIONAL_TRAINING/BSC_DEGREE/MSC_DEGREE/PHD): ", HighestEducation.class);
        int children = readInt("number_of_children (>=0): ");

        if (children < 0) {
            throw new IllegalArgumentException("number_of_children must be >= 0");
        }

        return Person.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .motherName(motherName.isBlank() ? null : motherName)
                .fatherName(fatherName.isBlank() ? null : fatherName)
                .birthDate(birthDate)
                .gender(gender)
                .highestEducation(edu)
                .numberOfChildren(children)
                .build();
    }

    private static int readInt(String label) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.err.println("You need a number.");
            }
        }
    }

    private static String readString(String label) {
        System.out.print(label);
        return sc.nextLine();
    }

    private static LocalDate readDateOrNull(String label) {
        System.out.print(label);
        String s = sc.nextLine().trim();
        if (s.isBlank()) return null;
        return LocalDate.parse(s);
    }

    private static <E extends Enum<E>> E readEnum(String label, Class<E> enumClass) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim().toUpperCase();
            try {
                return Enum.valueOf(enumClass, s);
            } catch (IllegalArgumentException e) {
                System.err.println("Wrong result!.");
            }
        }
    }
}
