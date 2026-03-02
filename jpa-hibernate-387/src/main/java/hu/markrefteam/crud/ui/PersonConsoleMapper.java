package hu.markrefteam.crud.ui;

import hu.markrefteam.crud.entity.Gender;
import hu.markrefteam.crud.entity.HighestEducation;
import hu.markrefteam.crud.entity.Person;

import java.time.LocalDate;

public class PersonConsoleMapper {

    private final Input in;

    public PersonConsoleMapper(Input in) {
        this.in = in;
    }

    public Person createPersonFromInput() {
        Person p = new Person();

        p.setFirstName(requireNonBlank("First name: "));
        p.setLastName(requireNonBlank("Last name: "));

        p.setMotherName(optionalText("Mother name (Enter = üres): "));
        p.setFatherName(optionalText("Father name (Enter = üres): "));

        p.setBirthDate(readNullableDate("Birth date (YYYY-MM-DD, Enter=üres): "));

        p.setGender(readGender());
        p.setHighestEducation(readEducation());

        int children = in.readInt("Number of children (>=0): ");
        if (children < 0) children = 0;
        p.setNumberOfChildren(children);

        return p;
    }

    public void updatePersonFromInput(Person p) {
        String fn = in.readLine("First name (Enter=marad): ");
        if (!fn.isBlank()) p.setFirstName(fn);

        String ln = in.readLine("Last name (Enter=marad): ");
        if (!ln.isBlank()) p.setLastName(ln);

        String mn = in.readLine("Mother name (Enter=marad / '-' = null): ");
        if (mn.equals("-")) p.setMotherName(null);
        else if (!mn.isBlank()) p.setMotherName(mn);

        String fan = in.readLine("Father name (Enter=marad / '-' = null): ");
        if (fan.equals("-")) p.setFatherName(null);
        else if (!fan.isBlank()) p.setFatherName(fan);

        String bd = in.readLine("Birth date (YYYY-MM-DD, Enter=marad / '-' = null): ");
        if (bd.equals("-")) p.setBirthDate(null);
        else if (!bd.isBlank()) p.setBirthDate(LocalDate.parse(bd));

        String g = in.readLine("Change gender? (y/n): ");
        if (g.equalsIgnoreCase("y")) p.setGender(readGender());

        String e = in.readLine("Change education? (y/n): ");
        if (e.equalsIgnoreCase("y")) p.setHighestEducation(readEducation());

        String ch = in.readLine("Number of children (Enter=marad): ");
        if (!ch.isBlank()) {
            try {
                int val = Integer.parseInt(ch);
                if (val < 0) val = 0;
                p.setNumberOfChildren(val);
            } catch (NumberFormatException ignored) {}
        }
    }

    private String requireNonBlank(String prompt) {
        while (true) {
            String s = in.readLine(prompt);
            if (!s.isBlank()) return s;
            System.out.println("Mandatory field.");
        }
    }

    private String optionalText(String prompt) {
        String s = in.readLine(prompt);
        return s.isBlank() ? null : s;
    }

    private LocalDate readNullableDate(String prompt) {
        String s = in.readLine(prompt);
        if (s.isBlank()) return null;
        try {
            return LocalDate.parse(s);
        } catch (Exception e) {
            System.out.println("Wrong Date, it will be empty.");
            return null;
        }
    }

    private Gender readGender() {
        System.out.println("Gender:");
        EnumPicker.printOptions(Gender.class);
        while (true) {
            int c = in.readInt("Choose (1..): ");
            Gender g = EnumPicker.pick(Gender.class, c);
            if (g != null) return g;
            System.out.println("Wrong choose.");
        }
    }

    private HighestEducation readEducation() {
        System.out.println("Highest education:");
        EnumPicker.printOptions(HighestEducation.class);
        while (true) {
            int c = in.readInt("Choose (1..): ");
            HighestEducation e = EnumPicker.pick(HighestEducation.class, c);
            if (e != null) return e;
            System.out.println("Wrong choose.");
        }
    }
}