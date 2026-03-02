package hu.markrefteam.crud.ui;

import hu.markrefteam.crud.entity.Person;
import hu.markrefteam.crud.service.PersonService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleApp {

    private final PersonService service;
    private final Input in;
    private final PersonConsoleMapper mapper;
    private int failedAttempts = 0;

    public ConsoleApp(PersonService service) {
        this.service = service;
        Scanner sc = new Scanner(System.in);
        this.in = new Input(sc);
        this.mapper = new PersonConsoleMapper(in);
    }

    public void run() {
        while (true) {
            try {
                printMenu();
                int choice = in.readInt("Choose: ");

                switch (choice) {
                    case 1 -> create();
                    case 2 -> listAll();
                    case 3 -> findById();
                    case 4 -> update();
                    case 5 -> delete();
                    case 6 -> search();
                    case 7 -> listDeleted();
                    case 8 -> restoreById();
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Invalid option");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Validation error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("==== PEOPLE CRUD ====");
        System.out.println("1) Create person");
        System.out.println("2) List all");
        System.out.println("3) Find by id");
        System.out.println("4) Update by id");
        System.out.println("5) Delete by id");
        System.out.println("6) Search by name");
        System.out.println("7) Recycle bin (deleted)");
        System.out.println("8) Restore by id");
        System.out.println("0) Exit");
    }

    private void create() {
        try {
            Person p = mapper.createPersonFromInput();
            Person saved = service.create(p);
            System.out.println("Saved with id: " + saved.getId());
        } catch (Exception e) {
            System.out.println("Create failed: " + e.getMessage());
        }
    }

    private void listAll() {
        List<Person> all = service.getAll();
        if (all.isEmpty()) {
            System.out.println("not allowed record.");
            return;
        }
        all.forEach(p -> System.out.println(formatPerson(p)));
    }

    private void findById() {

        if (failedAttempts >= 3) {
            System.out.println("Too many invalid attempts. Cooldown.");
            return;
        }

        int id = in.readInt("Id: ");
        Optional<Person> p = service.getById(id);

        if (p.isEmpty()) {
            failedAttempts++;
            System.out.println("doesn't exist id.");
        } else {
            failedAttempts = 0;
            System.out.println(formatPerson(p.get()));
        }
    }

    private void update() {
        int id = in.readInt("Id: ");
        Optional<Person> opt = service.getById(id);
        if (opt.isEmpty()) {
            System.out.println("not allowed id.");
            return;
        }

        Person p = opt.get();
        System.out.println("Current: " + formatPerson(p));

        try {
            mapper.updatePersonFromInput(p);
            Person updated = service.update(p);
            System.out.println("Updated: " + formatPerson(updated));
        } catch (Exception e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    private void delete() {
        int id = in.readInt("Id: ");
        boolean ok = service.delete(id);
        System.out.println(ok ? "Deleted." : "not allowed id.");
    }

    private void search() {
        String q = in.readLine("Search: ");
        List<Person> results = service.search(q);

        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private void listDeleted() {
        try {
            List<Person> deleted = service.getDeleted();

            if (deleted.isEmpty()) {
                System.out.println("Recycle bin is empty.");
                return;
            }

            deleted.forEach(p -> System.out.println(formatPerson(p)));
        } catch (Exception e) {
            System.out.println("List deleted failed: " + e.getMessage());
        }
    }

    private void restoreById() {
        try {
            int id = in.readInt("Restore id: ");

            boolean ok = service.restore(id);
            if (ok) {
                System.out.println("Restored.");
            } else {
                System.out.println("Nothing to restore (not found or not deleted).");
            }
        } catch (Exception e) {
            System.out.println("Restore failed: " + e.getMessage());
        }
    }

    private String formatPerson(Person p) {
        return String.format(
                "#%d %s %s | gender=%s | edu=%s | children=%d | birth=%s",
                p.getId(),
                p.getFirstName(),
                p.getLastName(),
                p.getGender(),
                p.getHighestEducation(),
                p.getNumberOfChildren(),
                p.getBirthDate()
        );
    }
}